package org.example.test_1Z0815.ch03;

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
     * 創建日期：2023/07/27
     * 最後一次查看：2023/07/27
     * 題目考點：運算式子的先後順序
     * 需要補足知識：等號賦值式子是由右至左
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q01() {
        int a = 3;
        int b = a += 5;
        // 等價，然後由右至左
        // int b = a = a + 5;
        // -> a = a + 5;
        // -> b = a;

        System.out.println(a);
        System.out.println(b);
        System.out.println(a + b);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/09/10
     * 題目考點：基本數據類型
     * 需要補足知識：基本數據類型的向上轉型，取值範圍
     * 複習：查看以下代碼
     * 總結：
     * 1.byte的取值範圍是-128到127（含）。而 0b10000000 轉換為十進位數值是128，超出了byte的最大取值範圍，因此會出現錯誤。
     *   (byte)可以強制將整數轉換為 byte 處理，因爲溢出所以值變為 -128
     * 2.int 和 long 做運算將向上轉型成 long，但 long 無法賦值給 int
     * 3.在Java中，浮點數常量（如 10.0）默認為雙精度（double）類型，並且雙精度的範圍比單精度（float）的範圍大，因此直接將一個雙精度數據賦值給一個單精度變量是不允許的。
     */
    public void test_q03() {
        byte a1 = (byte) 0b10000000; // 溢出，127 -> -128
        byte a2= (byte) 0b01111111;
        byte a3 = 0b1000000; // 64
        short b = 128 + 128;
        System.out.println(a1);
        System.out.println(a2);
        a2 = (byte)(a2 + 1);
        System.out.println(a2); // 溢出，127 -> -128
        System.out.println((byte)(a2 - 1)); // 溢出，-128 -> 127
        System.out.println(a3);
        System.out.println(b);
        // int c = 2 * 3L;
        // float d = 10.0;
        //int i;
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/19
     * 最後一次查看：2023/09/10
     * 題目考點：switch
     * 需要補足知識：switch的使用
     * 複習：查看總結
     * 總結：
     * switch語句可以接受以下類型的表達式作為參數
     * 1.整型（byte, short, int, char）或其對應的包裝類型（Byte, Short, Integer, Character）
     * 2.列舉（enum）
     * 3.字符串（String）Java 7
     * 4.不能接收null（直接報錯）
     * －－－－－－－－－－－－－－－－
     * 1.switch語句不能接受長整型（long）或其對應的包裝類型（Long）作為參數。
     * 2.switch語句不能接受浮點型（float, double）或其對應的包裝類型（Float, Double）作為參數。
     * 3.switch語句不能接受布爾型（boolean）或其對應的包裝類型（Boolean）作為參數。
     * 4.case標籤必須為常量表達式，並且所有的case標籤值都必須是唯一的，不能有重複的值。
     *   必須為常量的原因：
     *   1.編譯器優化：當使用常量作為 case 標籤時，編譯器可以在編譯時期就生成對應的跳轉表，從而實現 O(1) 的時間複雜度，這對於大量數據的處理具有顯著的效率優勢。
     *   2.確定性：如果允許使用變量作為 case 標籤，則可能導致在運行時期由於變量值的改變而改變程序的執行流程，這對於程序的穩定性和可讀性都是不利的。
     * 5.從Java 7開始，switch語句可以接受String類型的參數。不過，與使用整型或枚舉類型的case語句相比，使用String類型的case語句在效率上可能會稍微低一些。
     * 6.switch類型以後面接收的參數為準，比如以下例子，編譯報錯的是 case "1"
     */
    public void test_q20() {
        int a = 10;
        String s = "111";
        switch (a) {
            case 1:
                break;
//            case "1":
//                break;
        }
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






