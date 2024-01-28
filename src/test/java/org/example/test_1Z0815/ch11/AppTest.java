package org.example.test_1Z0815.ch11;

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
     * 創建日期：2023/07/24
     * 最後一次查看：2024/01/19
     * 題目考點：模塊
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：
     * 1.モジュールの設定は、module-info.java に記述する ⭕
     *   模塊的設定，寫在 module-info.java 裡
     * 2.モジュールの設定では、どのパッケージを公開するかを記述する
     * 　在模塊的設定中，需要描述哪些包將被公開。
     * 3.ほかのどのモジュールを使うのか ⭕
     * 　モジュールの設定では、どのパッケージを利用するかを記述する ❌
     * 　正確是寫會用到哪些外部的模塊，而不是會用到模塊內的哪些包
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/09/14
     * 最後一次查看：2023/09/14
     * 題目考點：命令行的參數
     * 需要補足知識：
     * 複習：查看 Notion
     * 總結：
     */
    public void test_q02() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：module-info.java
     * 需要補足知識：語法
     * 複習：查看總結
     * 總結：
     * 1.requires：使用到的模塊
     * 2.exports：公開的包
     * 3.requires transitive：這是一種廣義的依賴。如果模塊 A requires transitive 模塊 B，那麼所有依賴模塊 A 的其他模塊都能訪問模塊 B 中公開的 API。
     * 4.opens：這個指令用於開放包對於深度反射的訪問。這意味著即使某個類別或介面沒有被公開，通過反射的方式也能訪問到。
     */
    public void test_q03() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/09/14
     * 最後一次查看：2023/09/14
     * 題目考點：查看模塊信息的方法
     * 需要補足知識：命令行
     * 複習：查看總結
     * 總結：
     * 1.java --describe-module
     * 2.jmod describe
     */
    public void test_q06() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/09/14
     * 最後一次查看：2023/09/14
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






