package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();
        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);
        new Thread(producer,"producerThread").start();
        new Thread(consumer, "consumerThread").start();
    }
}
