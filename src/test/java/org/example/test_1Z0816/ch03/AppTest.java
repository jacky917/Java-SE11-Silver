package org.example.test_1Z0816.ch03;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.*;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：線程的執行
     * 需要補足知識：run 和 start 的差別
     * 複習：查看q01
     * 總結：
     * 1.start 方法中有被 native 修飾的方法，讓底層新開一個線程。
     * 2.重寫 start 並且不調用父類的 start 將會導致無法開啟新的線程。
     * 3.重寫 start 並且調用父類 start 的情況，run 方法的內容會和 start 方法的剩餘內容交錯執行（因爲這是不同的線程）。
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/10
     * 最後一次查看：2024/01/10
     * 題目考點：ScheduledExecutorService
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q04() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        try {
            scheduledExecutorService.schedule(() -> System.out.println("schedule"), 1, TimeUnit.SECONDS);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scheduledExecutorService.shutdown();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：Future
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：提供給線程池 runnable 但又獲取值的情況，將會獲取到 null。
     */
    public void test_q08() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> runnable = executorService.submit(() -> System.out.println("Runnable"));
        System.out.println(runnable.get()); // null
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：Future
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：提供 runnable 給線程池也可以提供一個值
     */
    public void test_q09() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> runnable = executorService.submit(() -> {
            System.out.println("executorService.submit");
        }, 0);
        System.out.println(runnable.get()); // 0
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：線程池的異常
     * 需要補足知識：-
     * 複習：查看q11
     * 總結：
     * 1.Runnable如果發生異常，異常將被吞沒。
     * 2.Callable如果發生異常，將會封裝到Future裡。
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：死鎖
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 複数のステッドの間で、排他制御された複数のインスタンスを共有していて、それぞれのインスタンス同士が連携することで発生する待ち状態を意味する用語は？デッドロック
     * 在多個執行緒之間共享被排他控制的多個實例，並且這些實例彼此之間的協作導致的等待狀態，這種情況在程式設計中被稱作什麼？死鎖
     */
    public void test_q14() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：線程安全列表
     * 需要補足知識：線程安全的集合
     * 複習：查看q16
     * 總結：-
     */
    public void test_q16() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/11
     * 最後一次查看：2023/12/11
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






