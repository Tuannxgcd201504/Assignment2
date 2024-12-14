package L02_QueueADT;

import java.util.ArrayDeque;
import java.util.Queue;

public class BuiltInQueueExample {
    public static void main(String[] args){
        Queue<Integer> myQueue = new ArrayDeque<>();
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(40);
        myQueue.add(50);

        System.out.println(myQueue); // [10, 20, 30, 40, 50]

        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());

        System.out.println(myQueue.poll()); // 10

        System.out.println(myQueue); // [20, 30, 40, 50]
        myQueue.offer(60);
        System.out.println(myQueue); // [20, 30, 40, 50, 60]

    }
}
