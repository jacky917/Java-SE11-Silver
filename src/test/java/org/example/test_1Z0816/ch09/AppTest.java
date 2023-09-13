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
     * 🌟🌟🌟🌟
     * 創建日期：2023/08/20
     * 最後一次查看：2023/08/20
     * 題目考點：try-with-resources
     * 需要補足知識：try-with-resources
     * 複習：1Z0815 ch13#q42，詳細看 Notion
     * 總結：
     * 1.AutoCloseable 和 Closeable 都可以用來實現 try-with-resources。
     * 2.AutoCloseable 是 java7 新加入的。
     * 3.AutoCloseable 拋出的異常更加自由（Exception的子類），Closeable 則是 IOException 的子類。
     */
    public void test_q05() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/20
     * 最後一次查看：2023/08/20
     * 題目考點：try-with-resources
     * 需要補足知識：try-with-resources
     * 複習：查看 q06
     * 總結：try-with-resources 的資源可以在外面聲明。
     */
    public void test_q06() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/20
     * 最後一次查看：2023/08/20
     * 題目考點：try-with-resources
     * 需要補足知識：資源關閉順序
     * 複習：查看 q07
     * 總結：try-with-resources 資源關閉的順序和初始化的順序相反（寫在後面的優先關閉）。
     */
    public void test_q07() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/08/20
     * 最後一次查看：2023/08/20
     * 題目考點：assert（アサーション）
     * 需要補足知識：assert 語法
     * 複習：查看總結
     * 總結：
     * Java 的斷言語句有兩種形式：
     * 1.assert Expression1;
     * 2.assert Expression1 : Expression2;
     * Expression1 應該是一個返回 boolean 類型的表達式。
     * Expression2 這個值用於生成詳細的錯誤信息。
     * Expression1 如果為 false 則拋出異常。
     */
    public void test_q10() {
        assert true;
        assert false : new Object();
        assert false : "發生錯誤";
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/20
     * 最後一次查看：2023/08/20
     * 題目考點：assert
     * 需要補足知識：啟用 assert
     * 複習：查看總結
     * 總結：默認情況下，斷言是禁用的。要在運行時啟用斷言，可以使用 -ea 或 –enableassertions 選項。
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/08/20
     * 最後一次查看：2023/08/20
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






