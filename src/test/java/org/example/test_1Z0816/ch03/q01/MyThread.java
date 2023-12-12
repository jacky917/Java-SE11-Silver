package org.example.test_1Z0816.ch03.q01;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName() + " run Start");
        super.run();
        System.out.println("Thread : " + Thread.currentThread().getName() + " run Finish");
    }
    @Override
    public synchronized void start() {
        System.out.println("Thread : " + Thread.currentThread().getName() + " start Start");
        super.start();
        System.out.println("Thread : " + Thread.currentThread().getName() + " start Finish");
    }
}
