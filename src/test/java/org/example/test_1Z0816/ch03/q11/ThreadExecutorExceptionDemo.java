package org.example.test_1Z0816.ch03.q11;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 在使用Java線程池（例如通過ExecutorService創建的線程池）時，處理異常是一個重要的方面。線程池中的異常處理與單個線程的異常處理略有不同，
 * 主要是因為線程池中的任務通常是異步執行的。以下是關於線程池異常的一些關鍵點：
 * 1. 異常在哪裡捕獲
 *    在Runnable任務中：如果在Runnable任務中發生異常，它通常會被線程池中的線程捕獲，並且這個異常不會傳遞到主線程。
 *    因此，如果你沒有在Runnable任務內部顯式處理異常，這些異常會被線程池“吞沒”，並且可能導致線程池中的線程終止。
 *    在Callable任務中：對於Callable任務，如果在任務中發生異常，這個異常會被封裝在返回的Future對象中。當你調用Future.get()時，
 *    如果有異常發生，它會被重新拋出為一個ExecutionException。
 * 2. 如何處理異常
 *    在任務內部處理：在Runnable或Callable任務內部加入try-catch塊，可以直接處理可能發生的異常。
 *    通過Future獲取異常：對於Callable任務，可以通過檢查Future.get()拋出的ExecutionException來間接獲取原始異常。
 * 3. 線程池的異常處理策略
 *    自定義拒絕執行處理器（RejectedExecutionHandler）：如果任務因為某種原因（如線程池關閉或達到最大容量）被拒絕執行，可以自定義處理器來處理這些情況。
 *    自定義線程工廠（ThreadFactory）：通過自定義線程工廠創建線程，你可以為線程設置一個UncaughtExceptionHandler，這樣未捕獲的異常可以被處理。
 * 4.Runnable任務中的異常處理
 *    雖然Runnable本身不支持拋出異常，但是當使用ExecutorService.submit(Runnable task)提交Runnable任務時，
 *    可以通過返回的Future對象來檢查是否有異常發生。如果在Runnable任務中發生了異常，當調用future.get()時，這個異常會被封裝在一個ExecutionException中。
 */
public class ThreadExecutorExceptionDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(() -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("出現異常");
            }
            return 42;
        });

        try {
            future1.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause(); // 獲取原始異常
            cause.printStackTrace();
        } catch (InterruptedException e) {
            // 處理中斷異常
            Thread.currentThread().interrupt();
        }


        Future<?> future2 = executorService.submit(() -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("出現異常");
            }
        });

        try {
            future2.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause(); // 獲取原始異常
            cause.printStackTrace();
        } catch (InterruptedException e) {
            // 處理中斷異常
            Thread.currentThread().interrupt();
        }
    }
}
