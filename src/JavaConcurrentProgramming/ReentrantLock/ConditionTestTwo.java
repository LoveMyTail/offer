package JavaConcurrentProgramming.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTestTwo {
    public static void main(String[] args) {
        char[] a = "1234567".toCharArray();
        char[] b = "abcdefg".toCharArray();
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : a) {
                    System.out.print(c);
                    conditionA.signal();
                    conditionB.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : b) {
                    System.out.print(c);
                    conditionB.signal();
                    conditionA.await();
                }
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2").start();

    }
}
