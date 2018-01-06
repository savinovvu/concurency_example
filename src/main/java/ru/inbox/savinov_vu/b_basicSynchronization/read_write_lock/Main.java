package main.java.ru.inbox.savinov_vu.b_basicSynchronization.read_write_lock;

public class Main {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[]=new Reader[5];
        Thread threadsReader[]=new Thread[5];
        for (int i=0; i<5; i++){
            readers[i]=new Reader(pricesInfo);
            threadsReader[i]=new Thread(readers[i]);
        }
        Thread threadWriter = new Thread(new Writer(pricesInfo));
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();

    }
}
