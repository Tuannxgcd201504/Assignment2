package Ex1_Taskmanagement;

import java.util.ArrayList;
import java.util.Scanner;


public class TaskManagementApp2 {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println( "Task Management Application" );
        System.out.println( "--------------------------" );

        while (choice != 4){
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addTask(tasks, scanner);
                    break;
                case 2:
                    removeTask(tasks, scanner);
                    break;
                case 3:
                    displayTasks(tasks);
                    break;
                case 4:
                    System.out.println( "Exiting the program..." );
                    break;
                default:
                    System.out.println( "Invalid choice. Please try again." );
            }
        }
    }

    private static void displayMenu( ) {
        System.out.println( "1. Add a task" );
        System.out.println( "2. Remove a task" );
        System.out.println( "3. Display all tasks" );
        System.out.println( "4. Exit" );
    }

    private static void addTask( ArrayList<String> tasks, Scanner scanner ) {
        System.out.println("Please enter a new task: ");
        String newTask = scanner.nextLine();
        tasks.add(newTask);
        System.out.println("Task added successfully!");
    }
    private static void removeTask( ArrayList<String> tasks, Scanner scanner ) {
        displayTasks(tasks);
        System.out.println("Enter the index of the task to remove: ");
        int index = Integer.parseInt(scanner.nextLine());
        tasks.remove(index - 1);
        System.out.println("Task" + tasks + " remove successfully!");
    }
    private static void displayTasks( ArrayList<String> tasks ) {
        System.out.println("Tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\tTask " + (i+1) + ":" + tasks.get(i));
        }
    }
}



