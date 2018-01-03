package main.java.ru.inbox.savinov_vu.a_managing.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSouceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("Beginning data source loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data souce loading has finished: %s\n", new Date());
    }
}
