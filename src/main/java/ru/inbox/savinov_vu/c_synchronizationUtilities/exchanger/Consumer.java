package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        for (int cycle = 1; cycle <= 10; cycle++) {
            System.out.printf("consumer: Cycle %d\n",cycle);
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("consumer buffer size: " + buffer.size());
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("consumer " + message);
                buffer.remove(0);

            }


        }

    }
}
