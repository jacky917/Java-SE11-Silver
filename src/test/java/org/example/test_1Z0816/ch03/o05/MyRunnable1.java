package org.example.test_1Z0816.ch03.o05;

public class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        try{
            // 不會清除中斷狀態
            while(!Thread.currentThread().isInterrupted())
                System.out.println("MyRunnable " + Thread.currentThread().getName());
        } finally {
            System.out.println("isInterrupted " + Thread.currentThread().isInterrupted());
            System.out.println("MyRunnable Finished");
        }
    }
}
