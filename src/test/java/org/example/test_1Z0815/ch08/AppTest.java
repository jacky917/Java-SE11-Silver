package org.example.test_1Z0815.ch08;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.concurrent.atomic.AtomicInteger;

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
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/09/13
     * 題目考點：lambda 表達式語法
     * 需要補足知識：語法
     * 複習：查看 q02
     * 總結：
     * 1.有大括號必須有 return（非void的情況）
     *   如果lambda表達式的主體被大括號包圍（表示它包含了多條語句）並且它有一個非void的返回類型，則必須明確地使用return關鍵字來返回一個值。
     * 2.沒大括號不能有 return
     *   lambda表達式的主體沒有被大括號包圍（表示它是一個表達式而不是一個語句塊），則不能使用return關鍵字。表達式的結果將自動被返回。
     * 3.單個參數的lambda表達式可以省略小括號，但多個參數時必須使用小括號
     * 4.入參的類型都是可省略的
     */
    public void test_q02() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：lambda
     * 需要補足知識：lambda 類似於匿名內部類，可以訪問其外部作用域的 final 或者事實上的 final 變量
     * 複習：查看 q03
     * 總結：-
     */
    public void test_q03() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：lambda
     * 需要補足知識：續 q03
     * 複習：查看以下代碼
     * 總結：
     * 1.lambda 類似於匿名內部類，可以訪問其外部作用域的 final 或者事實上的 final 變量
     * 2.但因爲被隱式的宣告成了 final 所以無法再變更
     */
    public void test_q04() {
//        int cnt = 0;
//        Runnable r = () -> {
//            for (cnt = 0; cnt < 10; cnt++) {
//                System.out.println(cnt++);
//            }
//        };

        // 繞過限制
        final AtomicInteger cnt = new AtomicInteger(0);
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(cnt.getAndIncrement());
            }
        };
        new Thread(r).start();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：Function API 的使用
     * 需要補足知識：Function API 的使用
     * 複習：查看 q05
     * 總結：查看 ch12#q04
     */
    public void test_q05() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






