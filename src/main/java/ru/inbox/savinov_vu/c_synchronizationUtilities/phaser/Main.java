package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("./", "txt", phaser);
        FileSearch apps = new FileSearch("./", "txt", phaser);
        FileSearch documents = new FileSearch("./",
                "log", phaser);

        Thread systemThread = new Thread(system, "System");
        Thread appsThread = new Thread(apps, "Apps");
        Thread documentsThread = new Thread(documents, "documents");
        systemThread.start();
        appsThread.start();
        documentsThread.start();
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated: "+ phaser.isTerminated());
    }
}
