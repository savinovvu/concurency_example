package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
    private final CountDownLatch controller;

    public Videoconference(int number) {
        this.controller = new CountDownLatch(number);
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.println("VideoConference: All the participants have come");
            System.out.println("VideoConference: Let's start....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.", name);
        controller.countDown();
        System.out.printf("VideoConference: waiting for %d participants.\n", controller.getCount());
    }
}
