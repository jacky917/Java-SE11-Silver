package org.example.test_1Z0815.ch04;

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

    private void myPrint() {
        System.out.println(",");
    }

    /**
     * 🌟
     * 創建日期：2023/09/11
     * 最後一次查看：2023/09/11
     * 題目考點：for 語法
     * 需要補足知識：
     * 複習：查看總結
     * 總結：
     * 1.for文內不能同時聲明兩種數據類型
     * 2.for文聲明的變量是局部變量，出了for以後無法使用
     * 3.for文最後接的可以是運算式子，可以不只有一個，且按照順序執行(q08)
     */

    private void q04_1(){
        System.out.print("s");
    }

    private void q04_2(){
        System.out.print("e");
    }

    public void test_q04() {
//        for (int i = 0, long l = 10; i < 5; i++) {
//            System.out.println(i);
//        }
        for (int i = 0; i < 5; q04_1(), i++, q04_2()) {
            System.out.println(i);
        }
    }

    /**
     * 🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：for語法
     * 需要補足知識：-
     * 複習：查看q04總結
     * 總結：-
     */
    public void test_q05() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/09/11
     * 題目考點：for
     * 需要補足知識：for 語法
     * 複習：查看以下代碼
     * 總結：
     * 1.for 每次循環可以執行多個操作，使用,隔開
     * 2.Java 一開始就支持此語法
     * －－－－－－－－－－－－－－－－
     * for文の動作順は、次のとおりです。
     * 1.変数 i が宣言され、0で初期化される
     * 2.条件文（0 < 10）が判定される
     * 3.コンソールに変数 i の値が表示される
     * 4.変数 i がインクリメントされる（increment）
     * 5.myPrintメソッドが呼び出される
     * 6.②に戻る
     */
    public void test_q08() {
        for (int i = 0; i < 10; i++, myPrint(), myPrint()) {
            System.out.print(i);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/27
     * 題目考點：for 語法
     * 需要補足知識：死循環
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q10() {
        for (int i = 0; true; i++) {
            System.out.println(i);
            if (i == 10) break;
        }

        for (int i = 0; ; i++) {
            System.out.println(i);
            if (i == 10) break;
        }

        for (int i = 0; i < 5; ) {
            System.out.println(i);
            if (i == 10) break;
            i++;
        }
    }

    /**
     * 🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：while
     * 需要補足知識：while
     * 複習：查看以下代碼
     * 總結：while 判斷的兩次（粗心）
     */
    public void test_q13() {
        int num = 10;
        while (num++ <= 10) {
            num++;
        }
        System.out.println(num); // 13
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/09/11
     * 題目考點： labelラベル 的使用
     * 需要補足知識：label 可使用的地方
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q16() {
        sample1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                if (3 < j)
                    break sample1;
        }

        a:
        {
            int i = 10;
        }

        sample2:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                if (3 < j)
                    break sample2;
        }

        sample3:
        if (true) {
            System.out.println("test");
        }

        int x = 0;
        d:
        x = 2;
        e:
        System.out.println(x);

        g:
        try {
            System.out.println("try test");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            h:
            throw new RuntimeException();
        }

        // f:return;

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






