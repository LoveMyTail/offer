package JavaConcurrentProgramming.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreTestTwo {
    static Semaphore semaphore = new Semaphore(1);
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {
        final Semaphore sa = new Semaphore(1);
        final Semaphore sb = new Semaphore(0);
        final Semaphore sc = new Semaphore(0);

        final Random random = new Random(System.currentTimeMillis());

        new Thread(new Runnable() {
            public void run() {
                try {
                    while(true){
                        Thread.sleep(random.nextInt(3000));
                        sa.acquire();
                        doing("A");
                        sb.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程a").start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    while(true){
                        Thread.sleep(random.nextInt(3000));
                        sb.acquire();
                        doing("B");
                        sc.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程b").start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    while(true){
                        Thread.sleep(random.nextInt(3000));
                        sc.acquire();
                        doing("C");
                        sa.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程c").start();
    }

    public static void doing(String msg){
        System.out.println(Thread.currentThread().getName()+":"+msg);
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            while (i.get() < 10) {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ":" + i.get());
                    i.getAndIncrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
