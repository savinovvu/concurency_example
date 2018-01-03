package main.java.ru.inbox.savinov_vu.exception;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler()) ;
//        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
        int a = 6;
        int c = 0;
//        int b = a/c;
    }
}
