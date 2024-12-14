package Assignment2;

public class ExecutionTimeMeasurement {
    public static void measure(String operation, Runnable task) {
        long startTime = System.nanoTime(); // Get timestamps
        task.run(); // Execute the algorithm
        long endTime = System.nanoTime(); // Get timestamps
        long elapsedTime = endTime - startTime; // Nanoseconds
        System.out.println(operation + " execution time: " + elapsedTime + " (ns).");
    }

    public static void main(String[] args) {
        QueueADT<String> queue = new QueueADT<>();

        // Measure offer method
        measure("Offer", () -> {
            for (int i = 0; i < 1000; i++) {
                queue.offer("Element " + i);
            }
        });

        // Measure poll method
        measure("Poll", () -> {
            while (!queue.isEmpty()) {
                queue.poll();
            }
        });

        // Re-add elements for further testing
        for (int i = 0; i < 1000; i++) {
            queue.offer("Element " + i);
        }

        // Measure getOrder method
        measure("GetOrder", () -> {
            for (int i = 0; i < 1000; i++) {
                queue.getOrder(i);
            }
        });

        // Measure peek method
        measure("Peek", () -> {
            queue.peek();
        });

        // Measure toString method
        measure("ToString", () -> {
            queue.toString();
        });
    }
}
