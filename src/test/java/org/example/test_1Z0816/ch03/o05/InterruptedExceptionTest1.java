package org.example.test_1Z0816.ch03.o05;

/**
 * 中斷的第一種方法
 */
public class InterruptedExceptionTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable1());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
