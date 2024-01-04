package org.example.test_1Z0816.ch03.o04;


import java.util.concurrent.*;

/**
 * 第四種開啟多線程的方式，使用線程池
 * ---------------------------
 * ExecutorService 中的 execute 和 submit 方法都用於提交任務以供線程池執行，但它們之間存在一些關鍵差異：
 *   execute(Runnable command)
 *   參數：execute 方法接受一個 Runnable 物件作為參數。
 *   傳回值：此方法沒有傳回值。
 *   異常處理：如果在任務執行過程中發生異常，這些異常將被傳遞給 UncaughtExceptionHandler，如果沒有設定異常處理器，則異常將被忽略。
 *   用途：當你不需要任務的結果時，可以使用 execute 方法。 它適用於那些只有副作用（例如，列印日誌、修改共享變數等）的任務。
 * submit(Callable<T> task) 和 submit(Runnable task)
 *   參數：submit 方法可以接受 Callable 或 Runnable 物件。 Callable 與 Runnable 不同，它可以傳回結果，並且能拋出檢查型異常。
 *   傳回值：submit 方法傳回一個 Future 物件。 對於 Callable 任務，Future 用來取得計算結果；對於 Runnable 任務，Future 用來檢查任務是否完成，或等待任務完成。
 *   例外處理：對於透過 submit 提交的任務，如果任務執行過程中發生異常，則異常將被封裝在傳回的 Future 中。 當呼叫 Future.get() 方法時，可以捕獲這些異常。
 *   用途：當你需要任務的結果，或需要更細緻地處理任務的完成狀態時，應該使用 submit 方法。
 * 總結
 *   使用 execute 當你不需要關心任務的結果，只想在背景執行一些操作。
 *   使用 submit 當你需要取得任務的結果，或是想要能夠捕捉任務執行過程中的異常。
 *
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
