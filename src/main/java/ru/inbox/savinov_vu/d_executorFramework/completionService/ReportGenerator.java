package main.java.ru.inbox.savinov_vu.d_executorFramework.completionService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {
    private final String sender;
    private final String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        long duration = (long) (Math.random() * 10);
        System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n", sender, title, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = sender + ": " + title;
        return result;
    }

}
