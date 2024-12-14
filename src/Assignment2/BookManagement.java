package Assignment2;

import java.util.Comparator;
import java.util.Scanner;

class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        elements = new Object[10]; // Default initial capacity
    }

    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T element = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Avoid memory leak
        return element;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    public void sort(Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }

        // Bubble Sort implementation
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T element1 = (T) elements[j];
                T element2 = (T) elements[j + 1];
                if (comparator.compare(element1, element2) > 0) {
                    // Swap elements
                    T temp = element1;
                    elements[j] = element2;
                    elements[j + 1] = temp;
                }
            }
        }
    }
}


public class BookManagement {

    public static void main(String[] args) {
        MyArrayList<Book> books = new MyArrayList<>();
        QueueADT<Order> orderQueue = new QueueADT<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Book Management Application");
        System.out.println("----------------------------");

        // Initialize books and orders
        initializeBooks(books);
        initializeOrders(orderQueue, books);

        int choice = 0;

        while (choice != 9) {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Adding a new book");
                    measure("Add Book", () -> addBook(books, scanner));
                    break;
                case 2:
                    System.out.println("Displaying all books");
                    measure("Display Books", () -> displayBooks(books));
                    break;
                case 3:
                    System.out.println("Searching for a book");
                    measure("Search Book", () -> searchBook(books, scanner));
                    break;
                case 4:
                    System.out.println("Sort books");
                    measure("Sort Books", () -> sortBook(books, scanner));
                    break;
                case 5:
                    System.out.println("Place an order");
                    measure("Place Order", () -> placeOrder(books, orderQueue, scanner));
                    break;
                case 6:
                    System.out.println("Display all orders");
                    measure("Display Orders", () -> displayOrders(orderQueue));
                    break;
                case 7:
                    System.out.println("Search order");
                    measure("Search Order", () -> searchOrder(orderQueue, scanner));
                    break;
                case 8:
                    System.out.println("Process next order");
                    measure("Process Order", () -> processOrder(orderQueue));
                    break;
                case 9:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("1. Add a book");
        System.out.println("2. Display all books");
        System.out.println("3. Search for a book");
        System.out.println("4. Sort books");
        System.out.println("5. Place an order");
        System.out.println("6. Display all orders");
        System.out.println("7. Search order");
        System.out.println("8. Process next order");
        System.out.println("9. Exit");
        System.out.print("Please enter a choice: ");
    }

    private static void addBook(MyArrayList<Book> books, Scanner scanner) {
        try {
            System.out.print("Please enter the book's name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter the book's genre: ");
            String genre = scanner.nextLine();

            System.out.print("Please enter the author's name: ");
            String author = scanner.nextLine();

            System.out.print("Please enter the price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Please enter the quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            books.add(new Book(name, genre, author, price, quantity));
            System.out.println("Book added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for price and quantity.");
        }
    }

    private static void displayBooks(MyArrayList<Book> books) {
        System.out.println("Books in the library:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println("\t" + (i + 1) + ": " + book.info());
        }
    }

    private static void searchBook(MyArrayList<Book> books, Scanner scanner) {
        System.out.print("Enter the name, genre, or author of the book to search: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().toLowerCase().contains(searchTerm) ||
                    book.getGenre().toLowerCase().contains(searchTerm) ||
                    book.getAuthor().toLowerCase().contains(searchTerm)) {
                System.out.println("\t" + (i + 1) + ": " + book.info());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with the given search term.");
        }
    }

    private static void sortBook(MyArrayList<Book> books, Scanner scanner) {
        System.out.println("Select sorting criteria:");
        System.out.println("1. By Name");
        System.out.println("2. By Genre");
        System.out.println("3. By Author");
        System.out.println("4. By Price");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                books.sort((b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName()));
                break;
            case 2:
                books.sort((b1, b2) -> b1.getGenre().compareToIgnoreCase(b2.getGenre()));
                break;
            case 3:
                books.sort((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
                break;
            case 4:
                books.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Books sorted successfully.");
        displayBooks(books);
    }

    private static void placeOrder(MyArrayList<Book> books, QueueADT<Order> orderQueue, Scanner scanner) {
        // Step 1: Input customer information
        System.out.print("Please enter the customer's name: ");
        String customerName = scanner.nextLine();

        System.out.print("Please enter the shipping address: ");
        String shippingAddress = scanner.nextLine();

        // Step 2: Search for a book
        System.out.print("Enter the name, genre, or author of the book to search: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        MyArrayList<Book> searchResults = new MyArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().toLowerCase().contains(searchTerm) ||
                    book.getGenre().toLowerCase().contains(searchTerm) ||
                    book.getAuthor().toLowerCase().contains(searchTerm)) {
                searchResults.add(book);
            }
        }

        // Step 3: Display search results
        if (searchResults.size() > 0) {
            System.out.println("Search results:");
            for (int i = 0; i < searchResults.size(); i++) {
                Book book = searchResults.get(i);
                System.out.println("\t" + (i + 1) + ": " + book.info());
            }

            // Step 4: Select a book from search results
            System.out.print("Please enter the number of the book you want to order: ");
            int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (bookIndex >= 0 && bookIndex < searchResults.size()) {
                Book selectedBook = searchResults.get(bookIndex);

                // Check if the quantity is sufficient
                System.out.print("Please enter the quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                if (quantity <= selectedBook.getQuantity()) {
                    Order newOrder = new Order(selectedBook, quantity, customerName, shippingAddress);
                    orderQueue.offer(newOrder);
                    // Update book quantity
                    selectedBook.setQuantity(selectedBook.getQuantity() - quantity);

                    System.out.println("Order placed successfully: \n" + newOrder);
                } else {
                    System.out.println("Not enough stock available for this order.");
                }
            } else {
                System.out.println("Invalid book selection.");
            }
        } else {
            System.out.println("No books found matching the search criteria.");
        }
    }

    private static void displayOrders(QueueADT<Order> orderQueue) {
        System.out.println("List of Orders:");
        for (int i = 0; i < orderQueue.size(); i++) {
            Order order = orderQueue.getOrder(i);
            System.out.println(order);
            System.out.println();
        }
    }

    private static void searchOrder(QueueADT<Order> orderQueue, Scanner scanner) {
        System.out.println("Search by:");
        System.out.println("1. Book Name");
        System.out.println("2. Customer Name");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        if (choice == 1) {
            // Search by Book Name
            System.out.print("Enter book name to search: ");
            String bookName = scanner.nextLine();

            for (int i = 0; i < orderQueue.size(); i++) {
                Order order = orderQueue.getOrder(i);
                if (order.getBookName().equalsIgnoreCase(bookName)) {
                    System.out.println("Order found: \n" + order);
                    found = true;
                }
            }
        } else if (choice == 2) {
            System.out.print("Enter customer name to search: ");
            String customerName = scanner.nextLine();

            for (int i = 0; i < orderQueue.size(); i++) {
                Order order = orderQueue.getOrder(i);
                if (order.getCustomerName().equalsIgnoreCase(customerName)) {
                    System.out.println("Order found: \n" + order);
                    found = true;
                    break;
                }
            }
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }

        if (!found) {
            System.out.println("Order not found.");
        }
    }

    private static void processOrder(QueueADT<Order> orderQueue) {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to process.");
        } else {
            Order processedOrder = orderQueue.poll();
            System.out.println("Processed Order: " + processedOrder);
        }
    }

    // Measure the time for execution of a task
    private static void measure(String taskName, Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println(taskName + " took " + duration + " milliseconds.");
    }

    // Initialize books and orders with mock data
    private static void initializeBooks(MyArrayList<Book> books) {
        books.add(new Book("The Great Gatsby", "Fiction", "F. Scott Fitzgerald", 9.99, 10));
        books.add(new Book("1984", "Dystopian", "George Orwell", 8.99, 10));
        books.add(new Book("To Kill a Mockingbird", "Fiction", "Harper Lee", 7.99, 20));
        books.add(new Book("Sherlock Holmes", "Detective", "Arthur Conan Doyle", 10.5, 25));
        books.add(new Book("Titanic", "Romantic", "James Cameron", 12.5, 15));
    }

    private static void initializeOrders(QueueADT<Order> orderQueue, MyArrayList<Book> books) {
        orderQueue.offer(new Order(books.get(4), 2, "Alice Nguyen", "123 Main St, Hanoi"));
        orderQueue.offer(new Order(books.get(2), 1, "Bob Tran", "456 Oak St, Ho Chi Minh City"));
        orderQueue.offer(new Order(books.get(1), 3, "Charlie Le", "789 Pine St, Da Nang"));
        orderQueue.offer(new Order(books.get(3), 4, "David Pham", "321 Elm St, Hai Phong"));
        orderQueue.offer(new Order(books.get(2), 1, "David Phan", "31 Elm St, Hai Phong"));
    }
}
