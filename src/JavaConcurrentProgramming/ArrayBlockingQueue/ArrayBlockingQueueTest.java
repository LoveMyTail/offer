package JavaConcurrentProgramming.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        queue.offer(10);
        queue.put(12);
        System.out.println(queue.poll());
        System.out.println(queue.take());

    }
}
