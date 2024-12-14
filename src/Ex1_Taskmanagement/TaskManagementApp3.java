package Ex1_Taskmanagement;

import java.util.ArrayList;
import java.util.Scanner;

class Task{
    private String name;
    private String priority;

    public Task(String name, String priority){
        this.name = name;
        this.priority = priority;
    }

    public String getName(){
        return this.name;
    }

    public String getPriority(){
        return this.priority;
    }

    public String info(){
        return "Task: " + this.name + " Priority: " + this.priority;
    }
}

public class TaskManagementApp3 {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println( "Task Management Application" );
        System.out.println( "--------------------------" );

        tasks.add(new Task("Buy a coffee", "A"));
        tasks.add(new Task("Hangout with friends", "B"));
        tasks.add(new Task("Watch movie", "C"));

        removeTask(tasks, scanner);
        displayTasks(tasks);


        //removeTask();
//        while (choice != 4){
//            displayMenu();
//            choice = Integer.parseInt(scanner.nextLine());
//            switch (choice){
//                case 1:
//                    addTask(tasks, scanner);
//                    break;
//                case 2:
//                    removeTask(tasks, scanner);
//                    break;
//                case 3:
//                    displayTasks(tasks);
//                    break;
//                case 4:
//                    System.out.println( "Exiting the program..." );
//                    break;
//                default:
//                    System.out.println( "Invalid choice. Please try again." );
//            }
//        }
    }



    private static void displayMenu( ) {
        System.out.println( "1. Add a task" );
        System.out.println( "2. Remove a task" );
        System.out.println( "3. Display all tasks" );
        System.out.println( "4. Exit" );
    }

    private static void addTask( ArrayList<Task> tasks, Scanner scanner ) {
        //System.out.println("Please enter a new task: ");
        //String newTask = scanner.nextLine();
        //tasks.add(newTask);
        //System.out.println("Task added successfully!");
    }
    private static void removeTask( ArrayList<Task> tasks, Scanner scanner ) {
        displayTasks(tasks);
        System.out.println("Enter the index of the task to remove: ");
        int index = Integer.parseInt(scanner.nextLine());
        tasks.remove(index - 1);
        System.out.println("Task" + tasks + " remove successfully!");
    }
    private static void displayTasks( ArrayList<Task> tasks ) {
        System.out.println("Tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            //System.out.println("\tTask " + (i+1) + ":" + tasks.get(i));
            System.out.println("\t" + (i + 1) + ": " + task.info());
        }
    }
}



