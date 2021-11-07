package JavaConcurrentProgramming.TestArea.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class client {
    public static void main(String[] args) {
        LinkedList<Object> storage = new LinkedList<>();
        int max = 20;
        Producer producer1 = new Producer(2, storage,max);
        Producer producer2 = new Producer(2, storage,max);
        Producer producer3 = new Producer(2, storage,max);
        Producer producer4 = new Producer(2, storage,max);
        Consumer consumer1 = new Consumer(3, storage,max);
        Consumer consumer2 = new Consumer(3, storage,max);
        Consumer consumer3 = new Consumer(3, storage,max);
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(producer4).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
    }
}

class Producer implements Runnable {
    LinkedList<Object> storage;
    int size;   // 一次生产多少个
    int max;

    public Producer(int size, LinkedList storage,int max) {
        this.size = size;
        this.storage = storage;
        this.max = max;
    }

    @Override
    public void run() {
        synchronized (storage) {
            while (size > max-storage.size()){
                System.out.println("库存空间不足，无法生产，当前库存空间还剩："+ (max-storage.size()));
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < size; i++) {
                storage.add(new Object());
            }
            System.out.println("生产者生产了"+size+"个产品，当前库存为:"+storage.size());
            storage.notifyAll();
        }
    }
}

class Consumer implements Runnable {
    int size;   // 一次消费多少个
    LinkedList<Object> storage;
    int max;

    public Consumer(int size, LinkedList storage,int max) {
        this.size = size;
        this.storage = storage;
        this.max = max;
    }

    @Override
    public void run() {
        synchronized (storage) {
            while (size > storage.size()){
                //System.out.println(size+" - "+storage.size());
                System.out.println("仓库库存不足，消费者无法消费，当前库存剩余为："+storage.size());
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < size; i++) {
                storage.remove();
            }
            System.out.println("消费者消费了"+size+"个产品，当前库存剩余为："+storage.size());
            storage.notifyAll();
        }
    }
}
