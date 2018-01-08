package main.java.ru.inbox.savinov_vu.d_executorFramework.callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(10);
            FactorialCalculator factorialCalculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(factorialCalculator);
            resultList.add(result);
        }
        System.out.println("_______________________________________________________________-");
        do {
            System.out.println();
            System.out.printf("Main: Number of completed Tasks: %d\n", executor.getCompletedTaskCount());
            int i = 0;
            for (Future<Integer> integerFuture : resultList) {
                System.out.printf("Main: Task %d: %s\n", i++, integerFuture.isDone());
            }
            System.out.println();
        } while (executor.getCompletedTaskCount() < resultList.size());
        System.out.println("_______________________________________________________________-");

        System.out.printf("================ Main: Results =================");
        int i = 0;
        for (Future<Integer> intergerFuture : resultList) {
            Integer futureResult = intergerFuture.get();
            System.out.printf("Main: Task %d: %d\n",i,futureResult);
        }
        executor.shutdown();


    }
}
