package org.example.ch01;

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
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：main 入口
     * 需要補足知識：main 入口參數可以用 String[] 和 String... 表示
     * 複習：查看總結 q05
     * 總結：
     * 1.main 入口參數可以用 String[] 和 String... 表示
     * 2.一つのソースファイルに複数記述できる　❌
     * 　一個源碼文件可以有多個 main 入口　❌
     */
    public void test_q05() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }
}