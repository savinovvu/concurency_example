package main.java.ru.inbox.savinov_vu.d_executorFramework.rejectingTask;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        System.out.printf("Main: Starting.\n");
        for (int i = 0; i < 100; i++) {
            server.executeTask(new Task("Task "+i));
        }
        System.out.println("Main: shuting down the executor");
        server.endServer();
        System.out.println("_______________________________________________");
        System.out.printf("Main: Sending another Task.\n");
        Task task=new Task("Rejected task");
        server.executeTask(task);
        System.out.printf("Main: End.\n");
    }
}
