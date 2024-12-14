package Ex1_Taskmanagement.TaskManagementApp6;

//import java.util.ArrayList;
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

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (((Comparable<T>) elements[i]).compareTo((T) elements[j]) > 0) {
                    T temp = (T) elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }
}


public class TaskManagementApp  {
    public static void main(String[] args) {
        MyArrayList<Task> tasks = new MyArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task Management Application");
        System.out.println("--------------------------");
        int choice = 0;

        // mockup data
        tasks.add(new Task("Task 1", "A"));
        tasks.add(new Task("Task 2", "C"));
        tasks.add(new Task("Task 3", "B"));
        tasks.add(new Task("Task 4", "A"));
        tasks.add(new Task("Task 5", "C"));
        tasks.add(new Task("Task 6", "A"));

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
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println( "1. Add a task" );
        System.out.println( "2. Remove a task" );
        System.out.println( "3. Display all tasks" );
        System.out.println( "4. Exit" );
        System.out.print("Please enter a choice: ");
    }

    private static void addTask( MyArrayList<Task> tasks, Scanner scanner ) {
        System.out.print("Please enter a new task: ");
        String newTaskName = scanner.nextLine();

        System.out.print("Please enter a task's priority: ");
        String newTaskPriority = scanner.nextLine();

        tasks.add(new Task(newTaskName, newTaskPriority));

        System.out.println("Task added successfully!");
    }

    private static void removeTask( MyArrayList<Task> tasks, Scanner scanner ) {
        displayTasks(tasks);
        System.out.println("Please enter task you want to remove: ");
        int removedTaskIdx = Integer.parseInt(scanner.nextLine());
        tasks.remove(removedTaskIdx-1);
        System.out.println("Task removed successfully!");
    }

    private static void displayTasks( MyArrayList<Task> tasks ) {

        //Collections.sort();
        tasks.sort();

        System.out.println("Tasks running: ");
        // System.out.println(tasks);

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);

            //System.out.println("\tTask " + (i+1) + ": " + task.getName() + ", Priority: " + task.getPriority());
            System.out.println("\t" + (i+1) + ": " + task.info());
        }
    }

}