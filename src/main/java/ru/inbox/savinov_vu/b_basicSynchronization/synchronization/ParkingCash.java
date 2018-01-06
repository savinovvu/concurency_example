package main.java.ru.inbox.savinov_vu.b_basicSynchronization.synchronization;

public class ParkingCash {
    private static final int cost = 2;
    private long cash;

    public ParkingCash() {
        this.cash = 0;
    }

    public synchronized void vehiclePay(){
        cash += cost;
    }

    public void close(){
        System.out.println("clossing accounting");
        long totalAmount;

        synchronized (this) {
            totalAmount = cash;
            cash = 0;
        }
        System.out.println("The total amount is : " + totalAmount);
    }
}
