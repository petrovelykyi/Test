package com.velykyi.test3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class incrementSynchronize1 {
    private volatile int value = 0;
    public int getNextValue(){
        synchronized (this){
            return value++;
        }
    }
}

class incrementSynchronize2 {
    private AtomicInteger value = new AtomicInteger();
    public int getNextValue(){
        synchronized (this){
            value.incrementAndGet();
            return value.get();
        }
    }
}
class incrementSynchronize3 {
    private int value = 0;
    Lock lock = new ReentrantLock();
    public int getNextValue(){
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
        return value;
    }
}