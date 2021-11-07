package DesignMode.ProducerAndConsumer.WaitAndNotify;

import java.util.LinkedList;

public class Container {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int capacity = 10;

    public void put(int value) {
        while (true) {
            try {
                //sleep不能放在同步代码块里面，因为sleep不会释放锁，
                // 当前线程会一直占有produce线程，直到达到容量，调用wait()方法主动释放锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                //当容器满的时候，producer处于等待状态
                while (list.size() == capacity) {
                    System.out.println("container is full,waiting ....");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("producer--" + Thread.currentThread().getName() + "--put:" + value);
                list.add(value++);
                //唤醒其他所有处于wait()的线程，包括消费者和生产者
                notifyAll();
            }
        }
    }

    public Integer take() {
        Integer val = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                //如果容器中没有数据，consumer处于等待状态
                while (list.size() == 0) {
                    System.out.println("container is empty,waiting ...");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果有数据，继续consume
                val = list.removeFirst();
                System.out.println("consumer--" + Thread.currentThread().getName() + "--take:" + val);
                //唤醒其他所有处于wait()的线程，包括消费者和生产者
                //notify必须放在同步代码块里面
                notifyAll();
            }
        }
    }
}
