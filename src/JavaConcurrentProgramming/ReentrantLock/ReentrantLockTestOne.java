package JavaConcurrentProgramming.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTestOne {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();
        }
    }
    static class ThreadDemo implements Runnable{
        Integer id;
        public ThreadDemo(Integer id){
            this.id = id;
        }
        @Override
        public void run() {
            try{
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁的线程："+id);
                lock.unlock();
            }
        }
    }
}
