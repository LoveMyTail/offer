package DesignMode.ProducerAndConsumer.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread producer1 = new Thread(new Producer(queue));
        Thread producer2 = new Thread(new Producer(queue));
        Thread producer3 = new Thread(new Producer(queue));
        Thread producer4 = new Thread(new Producer(queue));
        Thread producer5 = new Thread(new Producer(queue));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();

        Thread consumer1 = new Thread(new Consumer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));
        Thread consumer3 = new Thread(new Consumer(queue));

        consumer1.start();
        consumer2.start();
        consumer3.start();

        try {
            producer1.join();
            producer2.join();
            producer3.join();
            producer4.join();
            producer5.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
