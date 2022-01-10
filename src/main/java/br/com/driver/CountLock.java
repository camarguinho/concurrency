package br.com.driver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class CountLock {

    public static int counter;
    public static Lock lock = new ReentrantLock();

    public static void incrementCounter() {
        if(lock.tryLock()){
            try {
                int current = counter;
                System.out.println("Before: " + current + " Current thread: " + Thread.currentThread().getId());
                counter = current + 1;
                System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("You try...");
        }
    }

    public static void incrementCounterWaiting() throws InterruptedException {
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
            try {
                int current = counter;
                System.out.println("Before: " + current + " Current thread: " + Thread.currentThread().getId());
                counter = current + 1;
                System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("You try...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread( ()-> incrementCounter());
            t.start();
        }
    }
}
