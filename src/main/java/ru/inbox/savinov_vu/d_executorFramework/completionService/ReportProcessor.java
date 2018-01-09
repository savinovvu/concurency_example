package main.java.ru.inbox.savinov_vu.d_executorFramework.completionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.nonNull;

public class ReportProcessor implements Runnable {
    private final CompletionService<String> service;
    private volatile boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
        while (!end) {
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if (nonNull(result)) {
                    String report = result.get();
                    System.out.printf("Reporterreceiver: Report Received: %s\n",report);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ReportSender: End");
    }

    public void stopProcessing() {
        end = true;
    }
}
