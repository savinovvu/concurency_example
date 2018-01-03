package main.java.ru.inbox.savinov_vu.threadLocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

    private static ThreadLocal<Date> startDate =new ThreadLocal<>(){
        @Override
        protected Date initialValue(){
            return new Date();
        }
    };

    @Override
    public void run() {

        System.out.printf("Thread Started: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
            startDate.remove();
    }
}
