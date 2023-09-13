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
     * 🌟🌟🌟🌟
     * 創建日期：2023/09/10
     * 最後一次查看：2023/09/10
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
     * ダブルクォーテーションその文字として扱われない
     */
    public void test_q08() {
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