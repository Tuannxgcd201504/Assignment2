package Ex1_Taskmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Task05 implements Comparable<Task05>{
    // attributes
    private String name;
    private String priority;

    // constructor
    public Task05(String name, String priority){
        this.name = name;
        this.priority = priority;
    }

    // methods
    public String getName(){
        return this.name;
    }

    public String getPriority(){
        return this.priority;
    }

    public String info(){
        return "Task: " + this.name + ", Priority: " + this.priority;
    }

    @Override
    public int compareTo(Task05 other) {
        return this.priority.compareTo(other.priority);
    }
}

public class TaskManagementApp5 {
    public static void main(String[] args) {
        ArrayList<Task05> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task Management Application");
        System.out.println("--------------------------");
        int choice = 0;

        // mockup data
        tasks.add(new Task05("Task 1", "A"));
        tasks.add(new Task05("Task 2", "C"));
        tasks.add(new Task05("Task 3", "B"));
        tasks.add(new Task05("Task 4", "A"));
        tasks.add(new Task05("Task 5", "C"));
        tasks.add(new Task05("Task 6", "A"));

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

    private static void addTask( ArrayList<Task05> tasks, Scanner scanner ) {
        System.out.print("Please enter a new task: ");
        String newTaskName = scanner.nextLine();

        System.out.print("Please enter a task's priority: ");
        String newTaskPriority = scanner.nextLine();

        tasks.add(new Task05(newTaskName, newTaskPriority));

        System.out.println("Task added successfully!");
    }

    private static void removeTask( ArrayList<Task05> tasks, Scanner scanner ) {
        displayTasks(tasks);
        System.out.println("Please enter task you want to remove: ");
        int removedTaskIdx = Integer.parseInt(scanner.nextLine());
        tasks.remove(removedTaskIdx-1);
        System.out.println("Task removed successfully!");
    }

    private static void displayTasks( ArrayList<Task05> tasks ) {

        Collections.sort(tasks);

        System.out.println("Tasks running: ");
        // System.out.println(tasks);

        for (int i = 0; i < tasks.size(); i++) {
            Task05 task = tasks.get(i);

            //System.out.println("\tTask " + (i+1) + ": " + task.getName() + ", Priority: " + task.getPriority());
            System.out.println("\t" + (i+1) + ": " + task.info());
        }
    }

}

