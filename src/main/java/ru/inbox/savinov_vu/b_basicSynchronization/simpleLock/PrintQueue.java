package main.java.ru.inbox.savinov_vu.b_basicSynchronization.simpleLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private Lock queueLock;

    public PrintQueue(boolean fairMode) {
        this.queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object document) {
        try {
            queueLock.lock();
            long duration = (long) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration/1000)+" seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }
}
