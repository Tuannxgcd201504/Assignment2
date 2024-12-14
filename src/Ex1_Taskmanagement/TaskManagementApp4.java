package Ex1_Taskmanagement;

import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListADT<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListADT() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            previous.next = previous.next.next;
            if (previous.next == null) {
                tail = previous;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class TaskManagementApp4 {
    public static void main(String[] args) {
        LinkedListADT<String> tasks = new LinkedListADT<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task Management Application");
        System.out.println("--------------------------");
        int choice = 0;

        // mockup data
        tasks.add("Buy a cup of coffee");
        tasks.add("Watch a movie");
        tasks.add("Hangout with friends");

        while (choice != 4) {
            displayMenu();

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Adding a task");
                    addTask(tasks, scanner);
                    break;
                case 2:
                    System.out.println("Removing a task");
                    removeTask(tasks, scanner);
                    break;
                case 3:
                    System.out.println("Displaying all tasks");
                    displayTasks(tasks);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. Display all tasks");
        System.out.println("4. Exit");
        System.out.print("Please enter a choice: ");
    }

    private static void addTask(LinkedListADT<String> tasks, Scanner scanner) {
        System.out.print("Please enter a new task: ");
        String newTask = scanner.nextLine();
        tasks.add(newTask);
        System.out.println("Task added successfully!");
    }

    private static void removeTask(LinkedListADT<String> tasks, Scanner scanner) {
        displayTasks(tasks);
        System.out.println("Please enter the number of the task you want to remove: ");
        int removedTaskIdx = Integer.parseInt(scanner.nextLine());
        if (removedTaskIdx > 0 && removedTaskIdx <= tasks.size()) {
            tasks.remove(removedTaskIdx - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void displayTasks(LinkedListADT<String> tasks) {
        System.out.println("Tasks running: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\tTask " + (i + 1) + ": " + tasks.get(i));
        }
    }
}



