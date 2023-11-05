package org.example.test_1Z0816.ch03.o05;

/**
 * 阻塞時的中斷
 */
public class InterruptedExceptionTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable3());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
