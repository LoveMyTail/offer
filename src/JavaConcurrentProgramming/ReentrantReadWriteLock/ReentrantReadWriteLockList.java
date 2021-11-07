package JavaConcurrentProgramming.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockList {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private ArrayList<String> array = new ArrayList<>();
    //private volatile ReentrantLock lock = new ReentrantLock();

    public void add(String e){
        writeLock.lock();
        try{
            array.add(e);
        }finally {
            writeLock.unlock();
        }
    }

    public void remove(String e){
        writeLock.lock();
        try {
            array.remove(e);
        }finally {
            writeLock.unlock();
        }
    }

    public String get(int index){
        readLock.lock();
        try {
            return array.get(index);
        }finally {
            readLock.unlock();
        }
    }
}


