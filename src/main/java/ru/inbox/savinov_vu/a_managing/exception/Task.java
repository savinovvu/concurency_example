package main.java.ru.inbox.savinov_vu.a_managing.exception;

public class Task implements Runnable{
    @Override
    public void run() {
        Integer.parseInt("TTT");
    }
}
