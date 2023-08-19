package org.example.test_1Z0816.ch09;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
     * 🌟🌟🌟
     * 創建日期：2023/08/19
     * 最後一次查看：2023/08/19
     * 題目考點：異常
     * 需要補足知識：異常抓取語法
     * 複習：查看以下代碼
     * 總結：抓取多個異常使用 | 而不是 ||
     */
    public void test_q01() {
        try{
            throw new RuntimeException();
        }catch (Exception | Error e) {
            System.out.println("test");
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/19
     * 最後一次查看：2023/08/19
     * 題目考點：異常
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 1.マルキャッチ 指的是同一個 catch 抓取多個異常。
     * 2.使用 マルキャッチ 的異常不能有繼承關係。
     */
    public void test_q02() {
        try{
            throw new RuntimeException();
        }catch (RuntimeException e) {
            System.out.println("RuntimeException");
        }catch (Exception e) {
            System.out.println("Exception");
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/19
     * 最後一次查看：2023/08/19
     * 題目考點：自定義異常類
     * 需要補足知識：自定義異常類
     * 複習：查看總結
     * 總結：
     * 1.自定義異常可以繼承 Error 也可以繼承 Exception 和 RuntimeException 等等作為父類。
     * 2.但一般只會繼承 Exception（自定義檢查異常） 或 RuntimeException（自定義非檢查異常）。
     */
    public void test_q03() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/19
     * 最後一次查看：2023/08/19
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






