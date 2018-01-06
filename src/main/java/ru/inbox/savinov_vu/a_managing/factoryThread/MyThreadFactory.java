package main.java.ru.inbox.savinov_vu.a_managing.factoryThread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        counter = 0;
        stats = new ArrayList<>();
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread_" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n", thread.getId(),
                thread.getName(), new Date()));
        return thread;
    }

    public String getStats(){
        StringBuffer stringBuffer = new StringBuffer();
        for (String s :stats) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();

    }
}
