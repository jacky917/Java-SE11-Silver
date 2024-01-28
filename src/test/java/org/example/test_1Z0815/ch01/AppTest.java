package org.example.test_1Z0815.ch01;

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
     * 創建日期：2024/01/17
     * 最後一次查看：2024/01/17
     * 題目考點：パッケージ
     * 需要補足知識：命名空間
     * 複習：查看以下總結
     * 總結：
     * パッケージの目的は、次の３つです。
     * 1.名前空間を提供し、名前の衝突を避ける。
     * 2.アクセス修飾子と組み合わせてアクセス制御機能を提供する。
     * 3.クラスの分類を可能にする。
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/17
     * 最後一次查看：2024/01/17
     * 題目考點：查看 q04
     * 需要補足知識：成員變量
     * 複習：查看以下總結
     * 總結：
     * 1.非靜態成員變量需要有實例才可以調用
     * 2.如果子類別沒有同名的靜態成員變量，那麼可以直接存取繼承自父類別的靜態成員變量，無需寫明父類名
     *   然而，如果為了程式碼的可讀性和避免混淆，最佳實踐是在存取靜態成員時明確指出類別名，特別是在繼承關係中。
     */
    public void test_q04() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/08/02
     * 題目考點：main 入口
     * 需要補足知識：main 入口參數可以用 String[] 和 String... 表示
     * 複習：查看總結 q05
     * 總結：
     * 1.main 入口參數可以用 String[] 和 String... 表示
     * 2.一つのソースファイルに複数記述できる　❌
     * 　一個源碼文件可以有多個 main 入口　❌
     * 3.創建實例並調用入口類的其他非靜態方法是完全合法且可行的。
     *   入口類並不僅僅限制於具有main方法。它可以像任何其他Java類一樣具有屬性、構造函數和其他非靜態方法。
     */
    public void test_q05() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/09/10
     * 最後一次查看：2023/09/10
     * 題目考點：Java 命令
     * 需要補足知識：
     * 複習：查看總結
     * 總結：
     * 傳統運行Java必須先編譯後才能運行
     *  1. javac 編譯後 java xxx 運行(不帶副檔名，會去尋找對應的.class文件)
     *  2. java xxx.java（從 java 11 開始可以免除編譯）
     *  3. 雖然可以直接使用 java 運行，但其實底層原理還是先編譯了
     */
    public void test_q07() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/09/10
     * 最後一次查看：2024/01/17
     * 題目考點：命令行參數問題
     * 需要補足知識：特殊符號
     * 複習：查看總結和q08
     * 總結：
     * java ClassName a \" a\" "a "b c
     * 1.\(日文環境的話是¥符號，考試需注意)
     * 2.\後面的"符號將會被轉意，變為普通字符
     * 3.參數使用空白鍵作為區隔
     *   スペースが区切り記号として扱われる
     * 4.""可以用來括住包含空白鍵的長字符，使其成為一個參數
     * 5.被""括住的字符還可以和其他字符合在一起，如："a "b
     * 　スペースを含む文字列はダブルクォーテーションで括ることで１つとして扱われる
     * 6."" 屬於特殊字符，不算在獲取的字符裡
     * 　ダブルクォーテーションその文字として扱われない
     */
    public void test_q08() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2024/01/17
     * 最後一次查看：2024/01/17
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }
}