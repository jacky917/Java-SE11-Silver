package org.example.ch06;

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
     * 🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/07/21
     * 題目考點：Unreachable statement
     * 需要補足知識：Unreachable statement
     * 複習：查看以下代碼
     * 總結：存在不可到達的代碼，會引發編譯錯誤
     */
    public void test_q15() {
        return;
        // Unreachable statement
        // System.out.println();
    }

    /**
     * 🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/07/28
     * 題目考點：方法重載
     * 需要補足知識：方法重載
     * 複習：查看總結
     * 總結：
     * 1.方法名稱必須相同：重載的方法應該要有相同的名稱。
     * 2.參數列表必須不同：這可以是參數數量的不同，參數類型的不同，或者參數順序的不同。
     * 3.只有返回類型的不同並不能構成方法的重載：如果兩個方法除了返回類型不同其他都相同，那麼Java會認為這兩個方法是相同的，這樣是不允許的。
     * 4.在同一個類中：兩個方法必須在同一個類中才能構成重載。
     */
    public void test_q16() {
        return;
        // Unreachable statement
        // System.out.println();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/28
     * 最後一次查看：2023/07/28
     * 題目考點：方法重載
     * 需要補足知識：方法重載的權限修飾符
     * 複習：查看 q18
     * 總結：方法重載與權限修飾符沒有直接關係，會被視為同一個方法，
     *      重載主要關注的是方法名和參數列表
     */
    public void test_q18() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/07/28
     * 題目考點：構造器
     * 需要補足知識：構造器語法，包含 q21,q24 內容
     * 複習：查看 q20
     * 總結：
     * 1.構造器只需要有權限修飾符和入參，不能有返回值
     * 2.代碼塊（非靜態）執行順序優先於構造器
     * 3.多構造器互相調用的情況，使用 this(); 調用
     */
    public void test_q20() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/07/21
     * 題目考點：main入口
     * 需要補足知識：靜態調用（main）非靜態參數
     * 複習：查看 q26
     * 總結：
     */
    public void test_q26() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/07/21
     * 題目考點：protected
     * 需要補足知識：protected
     * 複習：查看 q27
     * 總結：子類繼承來的 protected 方法，實例化後也不能在包外調用
     */
    public void test_q27() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/07/21
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }
}






