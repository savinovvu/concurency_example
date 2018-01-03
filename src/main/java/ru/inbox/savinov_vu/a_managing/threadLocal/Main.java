package main.java.ru.inbox.savinov_vu.a_managing.threadLocal;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
