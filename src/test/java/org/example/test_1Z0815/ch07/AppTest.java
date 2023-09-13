package org.example.test_1Z0815.ch07;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.test_1Z0815.ch07.q04.A;
import org.example.test_1Z0815.ch07.q04.B;

import java.io.File;

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
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：構造器繼承
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：サブクラスであっても、コンストラクタは引き継がない　⭕
     *      這邊說的引き継がない不包含調用父類的構造器
     */
    public void test_q02() {
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
     * 🌟
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：接口
     * 需要補足知識：-
     * 複習：查看總結
     * 總結：接口不繼承 Object，所以無法重寫 Object 方法
     */
    public void test_q05() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：接口
     * 需要補足知識：-
     * 複習：查看 ch01#q11
     * 總結：-
     */
    public void test_q06() {
    }

    /**
     * 🌟
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：抽象類
     * 需要補足知識：日文
     * 複習：查看總結
     * 總結：抽象メソッドは、すべてのサブクラスが実装しなければいけない。❌
     * 　　　這邊的サブクラス包含抽象類，因此正確應該說
     *   -> 抽象メソッドは、すべての具象サブクラスが実装しなければいけない。⭕
     */
    public void test_q08() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：重寫
     * 需要補足知識：-
     * 複習：查看 ch12#q41
     * 總結：-
     */
    public void test_q10() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：繼承訪問成員變量優先度的問題
     * 需要補足知識：-
     * 複習：查看 q12
     * 總結：
     * 1.當訪問一個對象的成員變量時，你會訪問到該引用變量的類型（或聲明類型）的變量，而不是該引用指向的實際對象的變量。（看左邊）
     * 2.調用一個對象的方法時，將會執行該對象類型的方法（即引用指向的實際對象的方法），而不是引用變量的聲明類型的方法。（看右邊）
     *   這是多態的一個核心特徵，它允許我們有更大的靈活性和可擴展性。
     * 3.父類方法無法直接調用子類的成員變量，如果要調用子類的成員變量只能透過子類重寫方法實現。
     * 4.父類不能直接調用子類中定義的方法（非重寫的方法）。這是因為在父類的上下文中，它是不知道子類特有方法的存在的。
     */
    public void test_q12() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：ClassCastException
     * 需要補足知識：ClassCastException 是非受檢異常
     * 複習：查看總結
     * 總結：
     * 1.強轉基本數據類型失敗不會發生 ClassCastException 異常（這是編譯錯誤）。
     * 2.會拋出 ClassCastException 異常的兩個對象一定具備繼承關係。
     * 3.不具備繼承關係的強轉，會直接報編譯錯誤。
     */
    public void test_q17() {
        // 編譯錯誤
//        int i = 10;
//        double d = 1.0;
//        i = d;
//        boolean b = false;
//        char c = (char)b;
        Object o = new Object();
        String s = (String) o; // ClassCastException
        // 編譯錯誤
//        String s2 = new String();
//        File file = (file) s2;

    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/23
     * 最後一次查看：2023/09/13
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
     * 創建日期：2023/09/13
     * 最後一次查看：2023/09/13
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






