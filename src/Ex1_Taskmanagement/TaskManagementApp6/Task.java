package Ex1_Taskmanagement.TaskManagementApp6;

class Task implements Comparable<Task>{
    // attributes
    private String name;
    private String priority;

    // constructor
    public Task(String name, String priority){
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
    public int compareTo(Task other) {
        return this.priority.compareTo(other.priority);
    }
}