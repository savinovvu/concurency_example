package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.cyclicBarrier;

public class Grouper implements Runnable {
    private final Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.println("Grouper: Processing results...\n");
        int[] data = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.println("Grouper: Total result: " + finalResult);


    }
}
