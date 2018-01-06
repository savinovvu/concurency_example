package main.java.ru.inbox.savinov_vu.a_managing.factoryThread;

public class Main {
    public static void main(String[] args) {
        MyThreadFactory myFactory = new MyThreadFactory("MyFactory");
        Task task = new Task();
        System.out.println("Starting the threads");
        for (int i = 0; i < 10; i++) {
            Thread thread = myFactory.newThread(task);
            thread.start();
        }
        System.out.println("Factory stats");
        System.out.println(myFactory.getStats());

    }
}
