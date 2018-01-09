package main.java.ru.inbox.savinov_vu.d_executorFramework.sheduledThreadPoolExecutor_periodicly;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        System.out.printf("Main: Starting at: %s\n", new Date());
        Task task = new Task("Task");
        ScheduledFuture<?> result = scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main: Delay: %d\n",result.getDelay(TimeUnit.MILLISECONDS));
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.printf("Main: finished at:", new Date());
    }
}
