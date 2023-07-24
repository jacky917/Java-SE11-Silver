package org.example.ch05;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.ch05.q10.People;

import java.util.ArrayList;
import java.util.Arrays;

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
     * 最後一次查看：2023/07/19
     * 題目考點：list 空打印
     * 需要補足知識：list 沒有重寫，打印出來是地址
     * 複習：查看以下代碼
     * 總結：-
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
     * 題目考點：list
     * 需要補足知識：list 宣告
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
     * 最後一次查看：2023/07/19
     * 題目考點：list
     * 需要補足知識：list 宣告
     * 複習：查看以下代碼
     * 總結：在 Java 中，當我們宣告一個陣列時，陣列大小（或維度）不應該出現在變數型別的旁邊，
     *      而應該出現在變數名稱的旁邊。此外，在宣告階段，我們不能直接指定陣列的大小。
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
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：list
     * 需要補足知識：list 初始化
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
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：list
     * 需要補足知識：list 類型
     * 複習：查看 q09
     * 總結：A[] 是 Object[] 的子類，因此這是向上轉型（upcasting），是允許的。
     */
    public void test_q09() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：list clone
     * 需要補足知識：list clone 是淺拷貝
     * 複習：查看以下代碼
     * 總結：-
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






