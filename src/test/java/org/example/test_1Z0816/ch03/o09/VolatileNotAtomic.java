package org.example.test_1Z0816.ch03.o09;

/**
 * Volatile不能保證原子性
 * 有概率無法打印出 count = 100000
 */
public class VolatileNotAtomic {

    private static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for(int i = 0 ; i < 1000; i++ )
                System.out.println(Thread.currentThread().getName() + " 線程，當前計數 " + ++ count);
        };

        for(int i = 0 ; i < 100; i++ ) {
            new Thread(runnable,"Thread-" + i).start();
        }

        Thread.sleep(3000);

        System.out.println("==================");
        System.out.println("count = " + count);
    }
}
