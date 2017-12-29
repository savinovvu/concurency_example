package ru.inbox.savinov_vu;

public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1;
        long max = 20000;
        long numPrimes = 0;
        System.out.printf("Thread '%s': Start\n", Thread.currentThread().getName());
        while (current <= max) {
            if (isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': END. Number of Primes: %d\n", Thread.currentThread().getName(), numPrimes);

    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }

        for (int i = 0; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
