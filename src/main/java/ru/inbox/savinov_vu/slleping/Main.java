package ru.inbox.savinov_vu.slleping;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ConsoleClock consoleClock = new ConsoleClock();
        Thread thread = new Thread(consoleClock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
