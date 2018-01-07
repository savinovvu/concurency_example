package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.countDownLatch;

public class Main {
    public static void main(String[] args) {
        Videoconference videoconference = new Videoconference(10);
        Thread thread = new Thread(videoconference);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(videoconference, "Participant " + i);
            Thread thread1 = new Thread(participant);
            thread1.start();

        }
    }
}
