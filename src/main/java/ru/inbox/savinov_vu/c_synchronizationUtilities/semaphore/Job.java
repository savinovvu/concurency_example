package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.semaphore;

public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job \n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
    }
}
