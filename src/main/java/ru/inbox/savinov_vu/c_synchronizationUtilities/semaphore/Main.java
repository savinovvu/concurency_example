package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.semaphore;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[12];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread((new Job(printQueue)), "Thread-" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
