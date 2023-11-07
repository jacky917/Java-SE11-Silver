package org.example.test_1Z0816.ch03.o10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 15個線程併發運行共享變量的自增運算、每個線程自增1000次
 * 最後主線程打印最終結果
 */
public class CountDownLatchTest {

    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(15);

        Runnable runnable = () -> {
            for(int i = 0; i < 1000; i++) {
                count.incrementAndGet();
                countDownLatch.countDown();
            }
        };

        for(int i = 0; i < 15; i++) {
            new Thread(runnable).start();
        }

        countDownLatch.await();

        System.out.println("最終結果：" + count);

    }
}
