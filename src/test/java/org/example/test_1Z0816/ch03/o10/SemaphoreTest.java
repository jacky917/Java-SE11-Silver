package org.example.test_1Z0816.ch03.o10;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 假設停車場有三個車位，且都沒有停車
 * 停車場同時最多僅允許三輛車進入
 * 當有車離開其他車才能被允許進入
 * 現在先後來了五輛車，實現五輛車排隊停車代碼
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        Random random = new Random();

        Runnable runnable = () -> {
            try {

                int r = random.nextInt(10);

                semaphore.acquire();

                System.out.println(Thread.currentThread().getName() + " 線程進入停車場");

                System.out.println(Thread.currentThread().getName() + " 線程停車 " + r + " 秒");

                Thread.sleep(r * 1000);

                System.out.println(Thread.currentThread().getName() + " 線程離開停車場");

                semaphore.release();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        for(int i = 0; i < 5; i++) {
            new Thread(runnable, "Thread-" + i).start();
        }
    }
}
