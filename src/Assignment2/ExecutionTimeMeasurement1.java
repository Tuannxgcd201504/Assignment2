package Assignment2;

public class ExecutionTimeMeasurement1 {
    public static void measure(String operation, Runnable task) {
        long startTime = System.nanoTime(); // Get timestamps
        task.run(); // Execute the algorithm
        long endTime = System.nanoTime(); // Get timestamps
        long elapsedTime = endTime - startTime; // Nanoseconds
        System.out.println(operation + " execution time: " + elapsedTime + " (ns).");
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Measure add method
        measure("Add", () -> {
            for (int i = 0; i < 1000; i++) {
                myList.add(i);
            }
        });

        // Measure get method
        measure("Get", () -> {
            for (int i = 0; i < 1000; i++) {
                myList.get(i);
            }
        });

        // Measure remove method
        measure("Remove", () -> {
            for (int i = 999; i >= 0; i--) {
                myList.remove(i);
            }
        });

        // Re-add elements for sorting test
        for (int i = 0; i < 1000; i++) {
            myList.add(i);
        }

        // Measure sort method
        measure("Sort", () -> {
            myList.sort(Integer::compareTo); // Using natural ordering for Integer
        });
    }
}
