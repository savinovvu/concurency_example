package main.java.ru.inbox.savinov_vu.threadGroup;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
        MyThreadGroup threadGroup = new MyThreadGroup("MyGroup");
        Task task = new Task();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }
        System.out.printf("Number of Threads: %d\n",
                threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        System.out.println("______________________________________________");
        threadGroup.list();
        System.out.println("______________________________________________");
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        try {
            threads[3].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
    }
}
