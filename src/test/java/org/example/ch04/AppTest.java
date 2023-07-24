package org.example.ch04;

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

    private void myPrint(){
        System.out.println(",");
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：for
     * 需要補足知識：for 語法
     * 複習：查看以下代碼
     * 總結：
     * 1.for 每次循環可以執行多個操作，使用,隔開
     * 2.Java 一開始就支持此語法
     */
    public void test_q08() {
        for(int i = 0; i < 10 ; i++, myPrint(), myPrint()){
            System.out.print(i);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/07/19
     * 題目考點：for 語法
     * 需要補足知識：死循環
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q10() {
        for(int i = 0; true; i++) {
            System.out.println(i);
            if(i == 10) break;
        }

        for(int i = 0; ; i++) {
            System.out.println(i);
            if(i == 10) break;
        }

        for(int i = 0; i < 5;) {
            System.out.println(i);
            if(i == 10) break;
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
     * 最後一次查看：2023/07/19
     * 題目考點：label ラベル 的使用
     * 需要補足知識：label 可使用的地方
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q16() {
        sample1:
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                if (3 < j)
                    break sample1;
        }

        a: {
            int i = 10;
        }

        sample2:for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                if (3 < j)
                    break sample2;
        }

        sample3:if(true){
            System.out.println("test");
        }

        int x = 0;
        d: x = 2;
        e:System.out.println(x);

        g:try{
            System.out.println("try test");
            throw new RuntimeException();
        }catch (RuntimeException e){
            System.out.println(e);
        }finally{
            h:throw new RuntimeException();
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






