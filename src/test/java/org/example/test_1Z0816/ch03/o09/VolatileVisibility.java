package org.example.test_1Z0816.ch03.o09;

/**
 * Volatile的可見性
 */
public class VolatileVisibility {

    private volatile static int num = 100;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while(num == 100) {
                // 不加volatile會造成死循環
            }
            System.out.println("num 被修改");
        }).start();

        Thread.sleep(2000);

        new Thread(() -> {
            num = 50;
            System.out.println("num 被修改2");
        }).start();

    }
}