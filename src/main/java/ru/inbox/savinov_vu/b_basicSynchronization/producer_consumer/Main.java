package main.java.ru.inbox.savinov_vu.b_basicSynchronization.producer_consumer;

public class Main {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        Thread thread = new Thread(producer);
        Thread thread1 = new Thread(consumer);
        thread1.start();
        thread.start();
    }
}
