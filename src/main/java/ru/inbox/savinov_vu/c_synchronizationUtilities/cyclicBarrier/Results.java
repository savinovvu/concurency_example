package main.java.ru.inbox.savinov_vu.c_synchronizationUtilities.cyclicBarrier;

public class Results {
    private final int data[];

    public Results(int size) {
        this.data = new int[size];
    }

    public int[] getData() {
        return data;
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

}
