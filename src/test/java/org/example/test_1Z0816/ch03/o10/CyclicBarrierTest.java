package org.example.test_1Z0816.ch03.o10;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 5個小夥伴一起出遊，路線 A--B--C
 * 於某個時間在A地點集合然後自由活動
 * 自由活動結束後集合，所有人到達後發車
 * 直到到達最後一個地點結束
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
         String[] A = {"A1","A2","A3","A4"};
         String[] B = {"B1","B2","B3","B4","B5"};
         String[] C = {"C1","C2","C3"};

         String[][] viewpoint =  {A,B,C};

        AtomicInteger atomicInteger = new AtomicInteger(15);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            if(atomicInteger.get() == 0)
                System.out.println(atomicInteger.get() + " 旅遊結束");
            else
                System.out.println(atomicInteger.get() + " 所有隊員抵達，發車前往下個目的地！");
        });

        Random random = new Random();

        Runnable runnable = () -> {
            try {
                for(int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " 在 " + viewpoint[i][random.nextInt(viewpoint[i].length)] + " 景點");
                    System.out.println(Thread.currentThread().getName() + " 在等待其他隊員");
                    Thread.sleep(random.nextInt(5) * 1000);
                    atomicInteger.decrementAndGet();
                    cyclicBarrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        for(int i = 0; i < 5; i++) {
            new Thread(runnable,"Thread-" + i).start();
        }
    }

}
