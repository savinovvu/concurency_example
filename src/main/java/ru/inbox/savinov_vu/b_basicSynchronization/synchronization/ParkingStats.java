package main.java.ru.inbox.savinov_vu.b_basicSynchronization.synchronization;

public class ParkingStats {
    private long numberCars;
    private long numberMotorcycles;
    private ParkingCash cash;
    private Object controlCars;
    private Object controlMotorbikes;

    public ParkingStats(ParkingCash cash) {
        numberCars = 0;
        numberMotorcycles = 0;
        controlCars = new Object();
        controlMotorbikes = new Object();
        this.cash = cash;
    }

    public void carComeIn() {
        synchronized (controlCars) {
            numberCars++;
        }
    }

    public void carGoOut() {
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motoComeIn() {
        synchronized (controlMotorbikes) {
            numberMotorcycles++;
        }
    }

    public void motoGoOut() {
        synchronized (controlMotorbikes) {
            numberMotorcycles--;
        }
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }
}
