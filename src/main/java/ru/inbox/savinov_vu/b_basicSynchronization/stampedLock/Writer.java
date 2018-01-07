package main.java.ru.inbox.savinov_vu.b_basicSynchronization.stampedLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class Writer implements Runnable {
    private final Position position;
    private final StampedLock lock;

    public Writer(Position position, StampedLock lock) {
        this.position = position;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long stamp = lock.writeLock();
            try {
                System.out.println("Writer: Lock acquired " + stamp);
                position.setX(position.getX() + 1);
                position.setY(position.getY() + 1);
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
                System.out.println("Writer: Lock released " + stamp);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
