package org.example.test_1Z0815.ch05;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.test_1Z0815.ch05.q10.People;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
     * 創建日期：2023/07/19
     * 最後一次查看：2023/09/11
     * 題目考點：數組 空打印
     * 需要補足知識：數組 沒有重寫，打印出來是地址
     * 複習：查看以下代碼
     * 總結：
     * 1.Java 中的基本數據類型和基本型別陣列都無法重寫 toString() 方法
     * 2.除了以上還有被宣告成 final 的對象也無法重寫，如 String
     */
    public void test_q01() {
        int[] array1 = new int[0];
        ArrayList<String> array2 = new ArrayList<>();
        System.out.println(array1);// [I@6ea12c19
        System.out.println(array2);// []
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：數組
     * 需要補足知識：數組 宣告
     * 複習：查看以下代碼
     * 總結：以下都是正確的，但推薦把[]寫在前面才是 java 的風格
     */
    public void test_q02() {
        int[] a;
        int b[];
        int[][] c;
        int d[][];
        int[] e[];
        int[][] f[];
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/28
     * 題目考點：數組
     * 需要補足知識：數組 宣告
     * 複習：查看以下代碼
     * 總結：要指定 list 大小只能寫在 new 的右邊
     */
    public void test_q03() {
        // int[3] a;
        int[] a = new int[3];
        // int b[2];
        // int[2] c[];
        // int d[3][];
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/28
     * 最後一次查看：2023/09/11
     * 題目考點：數組
     * 需要補足知識：數組 初始化
     * 複習：查看 q05
     * 總結：所有引用數據類型的默認值都是 null ，包含 String，基本數據類型的列表
     * －－－－－－－－－－－－－－－－
     * boolean: 預設值為 false
     * byte: 預設值為 0
     * short: 預設值為 0
     * int: 預設值為 0
     * long: 預設值為 0L
     * float: 預設值為 0.0f
     * double: 預設值為 0.0d
     * char: 預設值為 \u0000（也就是Unicode的空字符）
     * －－－－－－－－－－－－－－－－
     * 1.new了以後就有長度了
     */
    public void test_q05() {
        String[] strings1 = new String[4];
        String[] strings2 = {"1","2","3"};
        System.out.println(strings1.length);
        System.out.println(strings2.length);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：數組
     * 需要補足知識：數組 初始化
     * 複習：查看以下代碼
     * 總結：
     * 1.當你使用 new 關鍵字來創建陣列時，只能指定陣列的大小，不能同時提供初始值，指定大小和初始值只能擇一
     * 2.在Java中，當你使用花括號 {} 直接初始化陣列的時候，必須要在宣告的同時初始化。
     */
    public void test_q07() {
        // int[] a1 = new int[2]{ 2,3 }; <- 錯誤
        int[] a2 = new int[]{ 2,3 };
        int b[][] = {};
        int[][] c = new int[][]{};
        int[] d;
        d = new int[]{ 2,3 };
        int e[];
        // e = { 2,3 }; <- 錯誤
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/28
     * 最後一次查看：2023/07/28
     * 題目考點：數組 null 判斷
     * 需要補足知識：Stream
     * 複習：查看以下代碼
     * 總結：
     * 1.以這個例子來說 Stream 適合處理效能要求不是那麼敏感的場景，如果數據量大，使用傳統 for + null 判斷可能更好
     *   ・Stream API的操作有一定的開銷。每一個Stream操作，例如filter、map等，都會產生一個新的Stream。
     *   　雖然這種開銷一般來說不大，但是在處理大量數據時，這種開銷可能會顯著影響性能。
     *   ・Stream API的方法一般來說不能被JVM（Java虛擬機）優化得像for迴圈那麼好。例如，JVM可能會對for迴圈進行一些優化，
     *   　例如迴圈展開（unrolling），以提高性能。但是，對於Stream API的方法，JVM一般不能進行這樣的優化。
     */
    public void test_q08() {
//        String[][] array = {{"A","B"},null,{"E","F"}};
//        int total = 0;
//        for (String[] tmp : array) {
//            total += tmp.length;
//        }
//        System.out.println(total);

        // 優雅的改寫解決問題
        String[][] array = {{"A","B"},null,{"E","F"}};
        int total = Arrays.stream(array)
                .filter(Objects::nonNull)
                .mapToInt(subArray -> subArray.length)
                .sum();
        System.out.println(total);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：數組
     * 需要補足知識：數組 類型
     * 複習：查看 q09
     * 總結：A[] 是 Object[] 的子類，因此這是向上轉型（upcasting），是允許的。
     */
    public void test_q09() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/08/03
     * 題目考點：數組 clone
     * 需要補足知識：數組 clone 是淺拷貝
     * 複習：查看以下代碼
     * 總結：
     * 1.clone() 是淺拷貝，但如果數組存放的內容是基本數據類型，可以實現深拷貝的效果
     * 2.如果對象要重寫 clone() 則實現 Cloneable 接口重寫 clone() 方法
     */
    public void test_q10() {
        int[][] arrayA = {{1,2},{1,2},{1,2,3}};
        int[][] arrayB = arrayA.clone();
        int total = 0;
        for (int[] tmp : arrayB) {
            for (int val : tmp) {
                total += val;
            }
        }
        System.out.println(total);
        // 補充
        int[][][] list1 = new int[][][]{{{1},{2}},{{3},{4}},{{5},{6}}};
        int[][][] list2 = list1.clone();
        int[][][] list3 = list1;

        System.out.println(Arrays.deepToString(list1));
        // list1 沒改變
        list2[0] = new int[][]{{99},{99},{99}};
        System.out.println(Arrays.deepToString(list1));
        // list1 沒改變
        list2[0][0] = new int[]{99};
        System.out.println(Arrays.deepToString(list1));
        // list1 沒改變
        list2[0][0][0] = 999;
        System.out.println(Arrays.deepToString(list1));

        System.out.println(Arrays.deepToString(list1));
        // list1 值改變了
        list3[0] = new int[][]{{99},{99},{99}};
        System.out.println(Arrays.deepToString(list1));
        // list1 值改變了
        list3[0][0] = new int[]{88};
        System.out.println(Arrays.deepToString(list1));
        // list1 值改變了
        list3[0][0][0] = 999;
        System.out.println(Arrays.deepToString(list1));

        People[][][] p1 = new People[][][]{{{new People(1)},{new People(1)}},{{new People(1)},{new People(1)}},{{new People(1)},{new People(1)}}};
        People[][][] p2 = p1.clone();

        System.out.println(Arrays.deepToString(p1));
        // p1 值改變了
        p2[0][0][0] = new People(10);
        System.out.println(Arrays.deepToString(p1));
        // p1 值改變了
        p2[0][0][0].setAge(999);
        System.out.println(Arrays.deepToString(p1));
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }
}






