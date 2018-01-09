package main.java.ru.inbox.savinov_vu.d_executorFramework.allResults;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task" + i);
            tasks.add(task);
        }
        List<Future<Result>> futures = executorService.invokeAll(tasks);
        executorService.shutdown();
        System.out.println("===================Main:Printing the results======================");
        for (Future<Result> resultFuture : futures) {
            Result result = resultFuture.get();
            System.out.println(result.getName() + ": " + result.getValue());
        }
    }
}
