package br.com.driver;

public class Count {

    public static int counter = 0;
    public static Object lock = new Object();

    //synchronized method
    public synchronized static void incrementCounter() {
        int current = counter;
        System.out.println("Before: " + current + " Current thread: " + Thread.currentThread().getId());
        counter = current + 1;
        System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
    }

    //synchronized block (with object)
    public void incrementCounter2() {
        synchronized (lock) {
            int current = counter;
            System.out.println("Before: " + current + " Current thread: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
        }
    }

    //synchronized block (instance)
    public void incrementCounter3() {
        synchronized (this) {
            int current = counter;
            System.out.println("Before: " + current + " Current thread: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread( ()-> incrementCounter());
            t.start();
        }
    }
}
