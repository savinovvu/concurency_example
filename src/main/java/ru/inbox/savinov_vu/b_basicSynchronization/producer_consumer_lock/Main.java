package main.java.ru.inbox.savinov_vu.b_basicSynchronization.producer_consumer_lock;

public class Main {
    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        Thread producerThread = new Thread(new Producer(mock, buffer), "Producer");
        Consumer[] consumers = new Consumer[3];
        Thread[] consumerThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            consumerThreads[i] = new Thread(consumers[i], "Consumer - " + i);
        }
        for (int i = 0; i < 3; i++) {
            consumerThreads[i].start();
        }
    }
}
