package org.example.test_1Z0816.ch03.o02;

/**
 * 第二種開啟多線程的方式，實現Runnable
 */
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
