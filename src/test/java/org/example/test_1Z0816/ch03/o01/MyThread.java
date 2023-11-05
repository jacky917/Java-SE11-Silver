package org.example.test_1Z0816.ch03.o01;

import java.sql.Time;

public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
