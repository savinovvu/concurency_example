package main.java.ru.inbox.savinov_vu.interrupting;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread task = new PrimeGenerator();
        task.start();

        Thread.sleep(500);
        task.interrupt();
        System.out.println();
        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
        System.out.println();

    }
}
