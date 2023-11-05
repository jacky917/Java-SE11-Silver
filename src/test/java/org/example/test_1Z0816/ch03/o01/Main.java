package org.example.test_1Z0816.ch03.o01;

/**
 * 第一種開啟多線程的方式，繼承Thread
 */
public class Main {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();
        MyThread myThread3 = new MyThread();
        myThread3.start();
    }
}
