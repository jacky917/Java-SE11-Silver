package org.example.ch07;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.ch07.q04.A;
import org.example.ch07.q04.B;

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
     * 最後一次查看：2023/07/23
     * 題目考點：接口
     * 需要補足知識：static default
     * 複習：查看 q04
     * 總結：
     * 1.接口如果想寫方法體的話，必須被明確地標記為 static 或是 default
     * 2.static 是通過接口直接調用的
     * 3.default 是通過實現類的實力對象調用的
     */
    public void test_q04() {
        A a = new B();
        a.sample1();

        A.sample2();
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/07/23
     * 題目考點：繼承
     * 需要補足知識：調用的就近原則
     * 複習：查看 q19
     * 總結：
     * 1.父類無法直接調用子類的成員變量，除非透過重寫調用
     * 2.在父類調用的 this 會使用父類的成員變量
     */
    public void test_q19() {

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






