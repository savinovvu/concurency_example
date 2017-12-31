package main.java.ru.inbox.savinov_vu.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionLoader implements Runnable {
    @Override
    public void run() {

        System.out.printf(" Network Beginning data source loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network Data souce loading has finished: %s\n", new Date());
    }

}
