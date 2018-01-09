package main.java.ru.inbox.savinov_vu.d_executorFramework.finishingTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ResultTask[] resultTasks = new ResultTask[5];
        for (int i = 0; i < 5; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task " + i);
            resultTasks[i] = new ResultTask(executableTask);
            executorService.submit(resultTasks[i]);
        }
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < resultTasks.length; i++) {
            resultTasks[i].cancel(true);
        }

        for (int i = 0; i < resultTasks.length; i++) {
            try {
                if (!resultTasks[i].isCancelled()) {
                    System.out.printf("%s\n", resultTasks[i].get());
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}