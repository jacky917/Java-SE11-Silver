package org.example.test_1Z0816.ch03.o02;

public class MyRunnable implements Runnable {

    static int ticket = 10;

    @Override
    public void run() {
        synchronized (this) {
            while(ticket > 0)
                System.out.println("MyRunnable " + Thread.currentThread().getName() + " ticket : " + (--ticket));
        }
    }
}
