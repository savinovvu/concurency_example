package main.java.ru.inbox.savinov_vu.d_executorFramework.cancellingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.printf("Main: Executing the Task\n");
        Task task = new Task();
        Future<String> result = executor.submit(task);
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("Main: Canceling the Task\n");
        result.cancel(true);
        System.out.printf("Main: canceled: %s\n", result.isCancelled());
        System.out.printf("Main: done: %s\n", result.isDone());
        executor.shutdown();
        System.out.println("end");

    }
}
