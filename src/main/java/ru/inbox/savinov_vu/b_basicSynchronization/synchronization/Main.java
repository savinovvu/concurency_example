package main.java.ru.inbox.savinov_vu.b_basicSynchronization.synchronization;

public class Main {
    public static void main(String[] args) {
        ParkingCash parkingCash = new ParkingCash();
        ParkingStats parkingStats = new ParkingStats(parkingCash);
        System.out.println("Parking Simulator");
        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
        Sensor sensor = new Sensor(parkingStats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Number of cars: " + parkingStats.getNumberCars());
        System.out.println("Number of motorcicles: " + parkingStats.getNumberMotorcycles());
        parkingCash.close();
    }
}
