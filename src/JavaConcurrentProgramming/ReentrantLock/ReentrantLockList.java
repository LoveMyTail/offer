package JavaConcurrentProgramming.ReentrantLock;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockList {
    private ArrayList<String> array = new ArrayList<>();
    private volatile ReentrantLock lock = new ReentrantLock();

    public void add(String e){
        lock.lock();
        try{
            array.add(e);
        }finally {
            lock.unlock();
        }
    }

    public void remove(String e){
        lock.lock();
        try {
            array.remove(e);
        }finally {
            lock.unlock();
        }
    }

    public String get(int index){
        lock.lock();
        try {
            return array.get(index);
        }finally {
            lock.unlock();
        }
    }
}
