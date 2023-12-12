package org.example.test_1Z0816.ch03.o04;


import java.util.concurrent.*;

/**
 * 第四種開啟多線程的方式，使用線程池
 */
public class ExecutorServiceTest {


    public static void main(String[] args) {


        // 創建固定線程數量的線程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        // 創建單線程線程池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        // 創建可緩存線程池
        ExecutorService executorService3 = Executors.newCachedThreadPool();


        // 創建可延遲執行命令或定時執行的線程
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(5);
        // public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
        // command: 要執行的任務，是一個實現 Runnable 接個的類的實例。
        // initialDelay: 首次執行任務前的延遲時間。
        // period: 連續任務執行之間的時間間隔。
        // unit: initialDelay 和 period 的時間單位，是 TimeUnit 枚舉類型的實例，例如 TimeUnit.SECONDS 或 TimeUnit.MILLISECONDS。
        // 每隔秒鐘打印一次 xxx （開發時應該關閉資源）

        long now = System.currentTimeMillis();

        scheduledExecutorService1.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(System.currentTimeMillis() - now + " xxx");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },0, 3, TimeUnit.SECONDS);
        // 20秒後關閉資源
        scheduledExecutorService1.schedule(scheduledExecutorService1::shutdown,20, TimeUnit.SECONDS);


        // scheduleWithFixedDelay 和 scheduleAtFixedRate 的差別
        // scheduleWithFixedDelay 用於固定的頻率執行任務。 即無論任務執行需要多長時間，都會嘗試在指定的時間間隔後啟動下一次任務執行。
        // scheduleAtFixedRate 用於固定的頻率執行任務（當執行時間超過間隔時間，則會直接執行下次而不等待）
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(5);

        scheduledExecutorService2.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(System.currentTimeMillis() - now + " yyy");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },0, 3, TimeUnit.SECONDS);
        // 20秒後關閉資源
        scheduledExecutorService2.schedule(scheduledExecutorService2::shutdown,20, TimeUnit.SECONDS);
    }
}
