package org.example.test_1Z0816.ch03.o05;

/**
 * 中斷的第二種方法
 */
public class InterruptedExceptionTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable2());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
