package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.customPhaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();
        Student[] students = new Student[5];

        for (int i=0; i<students.length; i++){
            students[i]=new Student(phaser);
            phaser.register();
        }

        Thread[] threads = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }

        for (Thread thread :threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());

    }
}
