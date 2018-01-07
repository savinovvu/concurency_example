package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.semaphore;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final Semaphore semaphore;
    private final boolean freePrinters[];
    private final Lock lockPrinters;
    private final ThreadLocal<Integer> selectedPrinter;

    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        this.freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        this.lockPrinters = new ReentrantLock();
        selectedPrinter = new ThreadLocal<>();
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assinedPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s - %s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", new Date(),
                    Thread.currentThread().getName(), assinedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            freePrinters[selectedPrinter.get()] = true;
            selectedPrinter.remove();
        }
    }

    private int getPrinter() {
        int ret = -1;
        try {

            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    selectedPrinter.set(i);
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
