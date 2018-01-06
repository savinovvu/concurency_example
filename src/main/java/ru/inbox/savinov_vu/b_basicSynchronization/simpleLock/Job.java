package main.java.ru.inbox.savinov_vu.b_basicSynchronization.simpleLock;

public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() +": The document has been printed");
    }
}
