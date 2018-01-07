package main.java.ru.inbox.savinov_vu.b_basicSynchronization.producer_consumer_lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);

        }
    }

    private void processLine(String line) {
        try {
            Random random = new Random();
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
