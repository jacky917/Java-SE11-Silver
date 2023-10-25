package org.example.test_1Z0815.ch06;

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
     * 🌟
     * 創建日期：2023/09/12
     * 最後一次查看：2023/09/12
     * 題目考點：打印 null
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：打印出來的 null 是全小寫的
     */
    public void test_q03() {
        Object o = null;
        System.out.println(o);
    }

    /**
     * 🌟
     * 創建日期：2023/09/12
     * 最後一次查看：2023/09/12
     * 題目考點：數組入參的兩種寫法
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：
     * 1.int[] array
     * 2.int... array
     */
    public void test_q14_1(int[] array) {
    }
    public void test_q14_2(int... array) {
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
     * 🌟🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/09/12
     * 題目考點：方法重載
     * 需要補足知識：方法重載
     * 複習：查看總結
     * 總結：
     * 1.方法名稱必須相同：重載的方法應該要有相同的名稱。
     * 2.參數列表必須不同：這可以是參數數量的不同，參數類型的不同，或者參數順序的不同。
     * 3.只有返回類型的不同並不能構成方法的重載：如果兩個方法除了返回類型不同其他都相同，那麼Java會認為這兩個方法是相同的，這樣是不允許的。
     *      Covariant協變是重載的特性，重載返回值必須相同。
     * 4.在同一個類中：兩個方法必須在同一個類中才能構成重載。
     * 5.方法重載與權限修飾符沒有直接關係，會被視為同一個方法，如果滿足以上四點條件，不管權限如何都可以
     */
    public void test_q16() {
        return;
        // Unreachable statement
        // System.out.println();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/28
     * 最後一次查看：2023/09/12
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
     * 創建日期：2023/09/12
     * 最後一次查看：2023/09/12
     * 題目考點：構造方法的權限修飾符
     * 需要補足知識：適用場景
     * 複習：查看總結
     * 總結：
     1. public
     概述：
         此修飾符表示該類別或構造方法可以被任何其他類別訪問。
         當你想要允許任何外部類別創建該類別的實例時。
         標準庫類別的主要構造方法通常是public，以允許廣泛的使用。
     適用場景：
         當你正在建立一個API或庫，並且希望使得其他開發者能夠輕易地創建你的類的實例時。
         例如，你可以創建一個public的DatabaseConnection類的構造方法，使得其他開發者可以方便地連接到數據庫。
     2. protected
     概述：
        此修飾符表示該類別或構造方法可以被同一個包中的任何類別或任何子類訪問。
     適用場景：
         在一個更大的軟件架構中，你想保護某些構造方法只能被其子類調用，以保證某種程度的封裝和安全性。
         例如，你可能有一個基礎的Vehicle類，並且有一個protected的構造方法，然後有多個子類（如Car，Truck等）使用這個構造方法來初始化它們的共享屬性。
     3. 無（package-private）
     概述：
         如果沒有使用任何訪問修飾符，則該類別或構造方法將有包私有（package-private）的訪問級別，只能被同一包中的類別訪問。
     適用場景：
         當你正在開發一個包含多個緊密協作類的包時，你可以使用包私有構造方法來限制只有包內的類可以創建這些類的實例。
         例如，在一個服務器應用中，你可能有一個包含多個類的包，這些類共同工作來處理HTTP請求，而你不希望這些類能夠被包外的類直接訪問或實例化。
     4. private
     概述：
         此修飾符表示該類別或構造方法只能被該類別本身訪問。
     適用場景：
         當你想要限制類的實例化，並且只通過靜態工廠方法來控制對象的創建時。
         例如，在單例設計模式中，你會使用一個private的構造方法來保證只有一個類的實例存在，並提供一個公共的靜態方法來獲取這個實例。
     */
    public void test_q19() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/21
     * 最後一次查看：2023/09/12
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
     * 需要補足知識：靜態（main）調用非靜態參數
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






