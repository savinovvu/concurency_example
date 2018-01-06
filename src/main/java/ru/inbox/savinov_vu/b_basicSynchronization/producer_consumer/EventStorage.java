package main.java.ru.inbox.savinov_vu.b_basicSynchronization.producer_consumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {
    private int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        this.maxSize = 17;
        storage = new LinkedList<>();
    }

    public synchronized EventStorage set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.println("Set: " + storage.size());
        notify();
        return this;
    }

    public synchronized EventStorage get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String element = storage.poll().toString();
        System.out.printf("Get: %d: %s\n", storage.size(), element);
        notify();
        return this;
    }
}
