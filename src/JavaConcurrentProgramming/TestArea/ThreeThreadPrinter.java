package JavaConcurrentProgramming.TestArea;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadPrinter {
    public static void main(String[] args) {

        MyThread thread = new MyThread();
        Thread curThread0 = new Thread(thread, String.valueOf(0));
        curThread0.start();
        Thread curThread1 = new Thread(thread, String.valueOf(1));
        curThread1.start();
        Thread curThread2 = new Thread(thread, String.valueOf(2));
        curThread2.start();
        Thread curThread3 = new Thread(thread, String.valueOf(3));
        curThread3.start();
        Thread curThread4 = new Thread(thread, String.valueOf(4));
        curThread4.start();
    }

}

class MyThread implements Runnable {
    int cur = 0;
    Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            while (cur <= 100) {
                if (cur  % 5 == Integer.parseInt(Thread.currentThread().getName())) {
                    System.out.println(Thread.currentThread().getName() + ":" + cur++);
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
