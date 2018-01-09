package main.java.ru.inbox.savinov_vu.e_fork_joinFramework.exception;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        Task task = new Task(array, 0, 100);
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (task.isCompletedAbnormally()) {
            System.out.printf("Main: An exception has ocured\n");
            System.out.printf("Main: %s\n", task.getException());
        }
        System.out.println("Main: REsult:" + task.join());

    }
}
