package main.java.ru.inbox.savinov_vu.a_managing.interruptionWithFiles;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("./", "file1.2a");
        Thread thread = new Thread(searcher);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
