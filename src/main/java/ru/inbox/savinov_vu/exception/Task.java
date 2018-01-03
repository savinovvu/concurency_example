package main.java.ru.inbox.savinov_vu.exception;

public class Task implements Runnable{
    @Override
    public void run() {
        Integer.parseInt("TTT");
    }
}
