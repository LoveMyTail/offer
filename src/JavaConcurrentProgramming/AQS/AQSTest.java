package JavaConcurrentProgramming.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();   // (1)
        Condition condition = lock.newCondition();  // (2)
        lock.lock();    // (3)
        try{
            System.out.println("begin wait");
            condition.await();  // (4)
            System.out.println("end wait");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();  // (5)
        }
        lock.lock();    // (6)
        try{
            System.out.println("begin signal");
            condition.signal();// (7)
            System.out.println("end signal");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();// (8)
        }
    }
}
