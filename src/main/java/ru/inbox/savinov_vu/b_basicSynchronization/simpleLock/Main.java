package main.java.ru.inbox.savinov_vu.b_basicSynchronization.simpleLock;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Running example with fair-mode = false");
        System.out.println();
        testPrintQueue(false);
        System.out.println();
        System.out.println("Running example with fair-mode = true");
        System.out.println();
        testPrintQueue(true);

    }

    private static void testPrintQueue(boolean fairMode) {
        PrintQueue printQueue = new PrintQueue(fairMode);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();

        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
