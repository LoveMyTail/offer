package JavaConcurrentProgramming.TestArea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程交替打印数字
 * 使用wait和notify
 */
public class MyStrangePrinter {
    private static volatile Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
    }

    static class ThreadOne implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i += 2) {
                synchronized (lock) {
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ThreadTwo implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i < 100; i += 2) {
                synchronized (lock) {
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+":"+i);
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
