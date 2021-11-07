package JavaConcurrentProgramming.LinkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTestOne {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.put(5);
        queue.put(4);
        queue.put(3);
        queue.put(2);
        queue.put(1);
        queue.offer(0);
        Integer poll = queue.poll();
        Integer i = queue.take();
        queue.peek();
        queue.remove(1);
        System.out.println(i);
        System.out.println(queue);
    }
}
