package main.java.ru.inbox.savinov_vu.d_executorFramework.sheduledThreadPoolExecutor_periodicly;

import java.util.Date;

public class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Executed at : %s\n",name,new Date());
    }
}
