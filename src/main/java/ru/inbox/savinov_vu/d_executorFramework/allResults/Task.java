package main.java.ru.inbox.savinov_vu.d_executorFramework.allResults;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting\n", name);
        long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Waiting %d seconds for results.\n", name, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int) (Math.random() * 100);
        }
        Result result = new Result();
        result.setName(name);
        result.setValue(value);
        System.out.println(name + ": Ends");
        return result;
    }
}
