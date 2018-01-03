package main.java.ru.inbox.savinov_vu.a_managing.exception;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("An exception has been captured");
        System.out.println("Thread: " + t.getId());
        System.out.println(String.format("Exception: %s: %s", e.getClass().getName(), e.getMessage()));
        System.out.println("Stack Trace: ");
        e.printStackTrace(System.out);
        System.out.println("Thread status: "+ t.getState());
    }
}
