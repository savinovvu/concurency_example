package main.java.ru.inbox.savinov_vu.join;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DataSouceLoader dataSouceLoader = new DataSouceLoader();
        Thread thread1 = new Thread(dataSouceLoader, "DataSourceThread");
        NetworkConnectionLoader networkConnectionLoader = new NetworkConnectionLoader();
        Thread thread2 = new Thread(networkConnectionLoader, "NetworkConnectionThread");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Configuration has been loaded; s\n", new Date());

    }
}
