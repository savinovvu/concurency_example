package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.phaser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.nonNull;

public class FileSearch implements Runnable {
    private final String initPath;
    private final String fileExtension;
    private List<String> results;
    private Phaser phaser;

    public FileSearch(String initPath, String fileExtension, Phaser phaser) {
        this.initPath = initPath;
        this.fileExtension = fileExtension;
        this.phaser = phaser;
        results = new ArrayList<>();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Starting.\n", Thread.currentThread().getName());
        File file = new File(initPath);
        if (file.isDirectory()) {
            directoryProcess(file);
        } else {
            fileProcess(file);
        }
        if (!checkResults()) {
            return;
        }
        filterResults();

        if (!checkResults()) {
            return;
        }
        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
    }

    private void directoryProcess(File file) {
        File[] files = file.listFiles();
        if (nonNull(files)) {
            for (File subFile : files) {
                if (subFile.isDirectory()) {
                    directoryProcess(subFile);
                } else {
                    fileProcess(subFile);
                }
            }
        }
    }

    private void fileProcess(File file) {
        if (file.getName().endsWith(fileExtension)) {
            results.add(file.getAbsolutePath());
        }
    }

    private void filterResults() {
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (String path : results) {
            File file = new File(path);
            long fileDate = file.lastModified();
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(path);
            }
        }
        results = newResults;
    }

    private boolean checkResults() {
        if (results.isEmpty()) {
            System.out.printf("%s: Phase %d: 0 results.\n",
                    Thread.currentThread().getName(),
                    phaser.getPhase());
            System.out.printf("%s: Phase %d: End.\n",
                    Thread.currentThread().getName(),
                    phaser.getPhase());
            phaser.arriveAndDeregister();
            return false;
        } else {
            System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(),
                    results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    private void showInfo() {
        for (String path : results) {
            File file = new File(path);
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance();
    }
}