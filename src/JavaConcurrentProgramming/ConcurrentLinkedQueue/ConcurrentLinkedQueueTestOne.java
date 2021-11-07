package JavaConcurrentProgramming.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTestOne {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.add(2);
        queue.poll();
        queue.peek();
        queue.remove(1);
    }
}
