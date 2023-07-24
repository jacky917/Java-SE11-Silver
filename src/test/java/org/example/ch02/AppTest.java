package org.example.ch02;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

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
     * 題目考點：基本數據類型
     * 需要補足知識：Java
     * 複習：查看代碼
     * 總結：Java 中的布林宣告是 boolean 不是 bool
     */
    public void test_q01() {
        int val = 7;
        boolean flg = true;
        // bool flg = true; <- 報錯
        if (flg == true) {
            do {
                System.out.println(val);
            } while (val > 10);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：int 宣告
     * 需要補足知識：int 宣告
     * 複習：查看以下代碼
     * 總結：0開頭代表八進制
     */
    public void test_q02() {
        int a = 267;
        int b = 0413; // 八進制
        int c = 0x10B;
        int d = 0b100001011;
        // int e = 0827; <- 報錯
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     * 在Java 7及其之後的版本中，可以在數字字面量中使用下劃線（_）來增加可讀性。這被稱為"數字字面量的下劃線"。您可以在整數、浮點數、二進制、八進制和十六進制數據類型中使用這種語法。
     * 1.數字之間的下劃線只能出現在數字之間，不能直接出現在數字的開頭或結尾。
     * 2.在浮點數中，下劃線不能出現在小數點的旁邊。
     * 3.在長整型（L或l）和浮點型（F或f、D或d）的後綴之前。
     * 4.在二進制（0b或0B）、八進制（0）、十六進制（0x或0X）的前綴和第一個數字之間。
     * 5.byte數據類型和 int short 只是範圍的區別
     * －－－－－－－－－－－－－－－－
     * byte: byte數據類型是8位、有符號的，以二進制補數形式表示的整數。最小值為-128（-2^7），最大值為127（2^7-1）。
     * short: short數據類型是16位、有符號的，以二進制補數形式表示的整數。最小值為-32768（-2^15），最大值為32767（2^15-1）。
     * int: int數據類型是32位、有符號的，以二進制補數形式表示的整數。最小值為 -2,147,483,648（-2^31），最大值為 2,147,483,647（2^31-1）（大約為21億）。
     */
    public void test_q03() {
        int a = 123_456_789;
        int b = 5________2;
        // int c = _123_456_789; <- 報錯
        // int d = 123_456_789_; <- 報錯
        // float e= 3_.1415F; <- 報錯
        long f = 999_99_999L;
        byte g = 0b0_1;
        byte g2 = 0_52;
        int h = 0_52;
        // int i = 0x_52; <- 報錯

        int a1 = 50_000;
        long l1 = 1_234_567_890L;
        float f1 = 2.10_001F;
        double d1 = 2.10_001;
        byte b1 = 0b0010_1010;
        long l2 = 0xFF_EC_DE_5E;
        short s1 = 07_7;

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：變量宣告
     * 需要補足知識：Java不允許在識別符中使用大括號（{}）
     * 複習：查看代碼
     * 總結：在Java中，變量的名稱（即識別符）必須以字母（a-z或A-Z）、美元符號（$）或者下劃線（_）開始，後面可以跟字母、數字、美元符號或下劃線。但是，Java不允許在識別符中使用大括號（{}）。
     */
    public void test_q05() {
        int $a = 100;
        int b_ = 200;
        int _0 = 300;
        // int ${d} = 400;
        // int g.a = 700;
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：var 的使用
     * 需要補足知識：var 是Java 10中引入的一種新的局部變量類型推斷機制。它可以讓你在局部變量的情況下不需要明確寫出變量的類型。然而，var 只能在初始化變量的時候使用，也就是說，你必須在聲明變量的同時賦予它一個值。
     * 複習：查看代碼
     * 總結：無法推斷類型的情況都無法使用 var 關鍵字
     */
    public void test_q06() {
        // var a; <- 報錯（無法推斷變量的類型）
        // var b = null; <- 報錯（無法推斷變量的類型）
        // var c = () -> {};//  <- 報錯（無法推斷變量的類型）
        var c = (Runnable)() -> {}; // 明確指定
        // var d1 = {1,2,3}; <- 報錯
        var d1 = new int[]{1,2,3};
        int[] d2 = new int[]{1,2,3};
        var e = new ArrayList<>();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：var 的使用
     * 需要補足知識：var 可使用的範圍
     * 複習：查看 q07
     * 總結：
     * 1.在Java中，var關鍵字不能用於類的成員變量（即字段）或者方法參數。它只能用於方法內部的局部變量。
     *   這是因為局部變量的生命周期和作用域都比較短，可以很容易地從周圍的程式碼推斷出其類型。
     *   但對於成員變量和方法參數，他們的生命周期和作用域都比較長，可能在許多不同的地方被使用，因此必須明確指定他們的類型。
     * 2.在Java中，使用 var 宣告的變量類型是在編譯時期進行類型推斷的，這被稱為靜態類型推斷。
     *   一旦類型被確定，就不能再改變了。例如，你不能將一個數字賦值給 test_q07 中的 x，因為這會在編譯時報錯。
     */
    public void test_q07() {
        var x = "hello";
    }

    /**
     * 🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：charAt 的使用
     * 需要補足知識：charAt StringIndexOutOfBoundsException 不是編譯異常
     * 複習：查看代碼
     * 總結：-
     */
    public void test_q11() {
        String str = "abcde";
        // java.lang.StringIndexOutOfBoundsException: String index out of range: 5
        System.out.println(str.charAt(5));
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：replace API 使用
     * 需要補足知識：replace() 方法會替換目標字符串中所有匹配的子串。
     * 複習：查看代碼
     * 總結：在Java中，String的 replace() 方法會替換目標字符串中所有匹配的子串。如果你希望只替換第一個匹配的子串，你可以使用 replaceFirst() 方法
     */
    public void test_q14() {
        String str = "aaaa";
        System.out.println(str.replace("aa","b"));
        System.out.println(str.replaceFirst("aa","b"));
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：String
     * 需要補足知識：String null 的情況
     * 複習：查看代碼
     * 總結：String null 如果拼接會當成字串 "null" 處理
     */
    public void test_q19() {
        String str = null;
        System.out.println(str + "null");
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/18
     * 最後一次查看：2023/07/18
     * 題目考點：StringBuilder
     * 需要補足知識：API
     * 複習：查看 Notion
     * 總結：
     * 1.初始容量是傳入的字串長度 + 16
     * 2.擴容是(原容量 * 2) + 2
     */
    public void test_q20() {
        StringBuilder builder = new StringBuilder("abcde");
        System.out.println(builder.capacity());
        builder.append("aaaaaaaaaaaaaaaaaaaa"); // + 20
        System.out.println(builder.capacity());
        builder.append("aaaaaaaaaaaaaaaaaaaa"); // + 20
        builder.append("aaaaaaaaaaaaaaaaaaaa"); // + 20
        System.out.println(builder.capacity());
        builder.trimToSize();
        System.out.println(builder.capacity()); // 將內部緩衝區大小調整為和字符串長度一樣
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