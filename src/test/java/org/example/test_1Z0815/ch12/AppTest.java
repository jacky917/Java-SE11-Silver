package org.example.test_1Z0815.ch12;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.test_1Z0815.ch12.q24.IB;
import org.example.test_1Z0815.ch12.q27.Q27;
import org.example.test_1Z0815.ch12.q43.B;
import org.example.test_1Z0815.ch12.q49.Sample;
import org.example.test_1Z0815.ch12.q10.test1.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

/**
 * 🌟
 * 🌟🌟
 * 🌟🌟🌟    有疑問，且問題已經解決之後只需查看筆記複習即可
 * 🌟🌟🌟🌟🌟重要的核心概念不清楚，無論有無錯誤，重點複習
 * 需要複習但還沒整理的概念
 * 1.Java的執行順序
 *   1.靜態 Main 方法優先執行
 *   2.靜態成員變量和靜態代碼塊，依照代碼順序執行
 *   3.父類優先於子類初始化
 *   4.非靜態成員變量和非靜態代碼塊優先於構造函數
 *   ----------------------- ch13#78
 *   1.靜態變量初始化：當Main類被加載時，靜態變量會被初始化為其對應類型的默認值（在這種情況下是int的默認值0）。
 *   2.靜態初始化塊執行：靜態初始化塊會按照它們在代碼中的順序被執行。在這個例子中，靜態初始化塊將num的值設置為30。
 *   3.顯式靜態變量初始化：靜態變量在聲明時的初始化會按照它們在代碼中的順序執行。所以num會被重新賦值為10。
 *   4.main方法執行：當main方法被調用時，它會調用sample方法，該方法會打印num的當前值，也就是10。

 * 2.文件流
 * 3.jlink jmod jdeps 等相關指令的熟悉（#9）
 *   java -cp build ，javac -d 等相關指令參數意義（#15），jlink（#29）
 *   java --describe-module（#18）
 *   java --module-path mods（#70）
 *   java --add-exports（ch11#7）
 *   javac --add-exports（ch11#7）
 * 4.權限修飾符的複習，重寫，拋異常（#41）
 *   （#78）繼承的情況權限修飾符的範圍
 * 5.各關鍵字的可修飾內容（#17）（#28）如權限修飾符，static，final
 * 6.關於 this 深度了解一下
 * 7.Math 的基本使用（#47）（#53）
 * 8.compare 深度了解一下
 * 9.Java Stream（#4）（#66）Notion已經有筆記，但還沒有實際實操
 * 10.Exception Error 的繼承關係（#69）
 * 11.深入了解泛型 extends
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
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：命令行編譯
     * 需要補足知識：包的概念
     * 複習：不借助IDE的情況下，編譯並執行q1內容
     * 總結：
     * 1.包名路徑要寫完整
     * 2.編譯不帶上包名，會導致使用默認的無包模式，有可能會因此找不到目標class
     */
    public void test_q1() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：包的導入
     * 需要補足知識：import com.sample.*; 並不能導入子包中的類
     * 複習：查看總結即可
     * 總結：
     * －－－－－－－－－－－－－－－－
     * import com.sample.*;
     * 無法取代
     * import com.sample.Sample;
     * import com.sample.test.*;
     * －－－－－－－－－－－－－－－－
     * 以上這種情況Java無法靠著一條import完成需求
     * 只能導入指定的一個類或是一個包下的所有類（不含子包）
     */
    public void test_q3() {

    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：java.util.function
     * 需要補足知識：java.util.function
     * 複習：查看 q4
     * 總結：
     */
    public void test_q4() {
        // －－－－－－－－－－－－－－－－－－題目－－－－－－－－－－－－－－－－－－
        // Supplier不接收參數，但返回一個結果
        // 常量
        final int i1 = 0;
        Supplier<Integer> foo1 = () -> i1;
        System.out.println(foo1.get());

        // 事實上的 final 變量
        int i2 = 0;
        Supplier<Integer> foo2 = () -> i2;
        System.out.println(foo2.get());

        // 編譯錯誤 Variable used in lambda expression should be final or effectively final
        //int i3 = 0;
        //i3 ++;
        //Supplier<Integer> foo3 = () -> i3;
        //System.out.println(foo3.get());
        // －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：模塊 module-info.java
     * 需要補足知識：如下
     * 複習：查看總結
     * 總結：
     * 1.模塊系統(Project Jigsaw)是 java9 引入的新特性
     * 2.模塊文件名為 module-info.java
     * 3.java.base 是所有 java 模塊的隱式依賴，無需顯示引入
     * 4.transitive 可以讓 module 具有傳遞特性，如下
     * module com.moduleB {
     * requires transitive com.moduleC; // B 模塊需要 C 模塊，並將此依賴關係對 B 模塊的使用者傳遞
     * exports com.moduleB.packageB; // 將 packageB 包對外公開
     * }
     * 使用 B 模塊的模塊可以直接訪問 C 模塊
     */
    public void test_q6() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：switch 用法
     * 需要補足知識：default 不一定要擺最後
     * 複習：查看以下代碼
     * 總結：
     * 1.沒有 break 的話會繼續執行下面的 case 並且不判斷，直到跑完所有 case 或遇到 break
     * 2.default 不一定要擺最後
     */
    public void test_q7() {
        Random rand = new Random();
        int num = rand.nextInt(11);
        System.out.println("num = " + num);
        switch (num) {
            case 0:
                System.out.print("A");
                break;
            case 10:
                System.out.print("B");
                break;
            default:
                System.out.print("C");
        }

        System.out.println("\n----------------");

        switch (num) {
            default:
                System.out.print("C");
            case 0:
                System.out.print("A");
                break;
            case 10:
                System.out.print("B");
                break;
        }
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：Character 常用方法的使用
     * 需要補足知識：Character 常用方法 + 自己擴展了一點其他知識
     * 複習：查看以下代碼
     * 總結：
     * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
     * Character 常用方法
     * 1.charValue() 實例方法
     * 即拆箱操作
     * 2.isDigit(char ch) 靜態方法
     * 如果指定的字符是一個數字（'0'-'9'），則返回 true，否則返回 false。
     * 3.isLetter(char ch) 靜態方法
     * 如果指定的字符是一個字母（無論大小寫，也包括 Unicode 字母），則返回 true，否則返回 false。
     * 4.isLowerCase(char ch) 靜態方法
     * 如果指定的字符是小寫字母，則返回 true，否則返回 false。
     * 5.isUpperCase(char ch) 靜態方法
     * 如果指定的字符是大寫字母，則返回 true，否則返回 false。
     * 6.toLowerCase(char ch) 靜態方法
     * 返回指定字符轉換為小寫的結果。
     * 7.toUpperCase(char ch) 靜態方法
     * 返回指定字符轉換為大寫的結果。
     * 8.isWhitespace(char ch) 靜態方法
     * 如果指定的字符是一個空格、製表符或其他類似的字符，則返回 true，否則返回 false。
     * 9.isAlphabetic(int codePoint) 靜態方法
     * 如果指定的字符（Unicode 碼點）是字母，則返回 true，否則返回 false。
     * 10.compare(char x, char y) 靜態方法
     * 按字典順序比較兩個 char 值，根據 x 是否小於、等於或大於 y 來分別返回負整數、零或正整數。
     * 11.對比 Character.isLetter 和 Character.isAlphabetic
     * 1.接收參數類型不同
     * 2.Character.isAlphabetic 的範圍比 Character.isLetter 更廣
     * 3.Character.isAlphabetic 多出了字母數，詳細看代碼演示
     * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
     * String 常用方法
     * 1.length()
     * 返回字串的長度。
     * 2.charAt(int index)
     * 返回指定位置的字符。
     * 3.substring(int beginIndex)
     * 從 beginIndex 開始截取字串，返回新的字串。
     * 4.substring(int beginIndex, int endIndex)
     * 從 beginIndex 開始，到 endIndex（不包含）結束截取字串，返回新的字串。
     * 5.contains(CharSequence sequence)
     * 檢查字串是否包含指定的字符序列。
     * 6.indexOf(String str)
     * 返回指定子字串在此字串中第一次出現處的索引。
     * 7.lastIndexOf(String str)
     * 返回指定子字串在此字串中最右邊出現處的索引。
     * 8.startsWith(String prefix)
     * 檢查字串是否以指定的前綴開始。
     * 9.endsWith(String suffix)
     * 檢查字串是否以指定的後綴結束。
     * 10.toLowerCase()
     * 將字串轉換為小寫。
     * 11.toUpperCase()
     * 將字串轉換為大寫。
     * 12.trim()
     * 去除字串兩端的空白字符。
     * 13.replace(CharSequence target, CharSequence replacement)
     * 替換字串中的某個字符序列。
     * 14.split(String regex)
     * 根據給定的正則表達式的匹配拆分此字串。
     * 15.equals(Object obj)
     * 比較此字串與指定的物件是否相等。
     * 16.intern()
     * 返回字串對象的規範化表示（canonical representation）。主要用於節省記憶體
     * －－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
     * 擴展知識：
     * 1.Character 有 0~127 的緩存（Unicode編碼）範圍是 ASCII
     * 2.Character 要使用緩存必須使用自動裝箱，不能使用 new 關鍵字
     *   Character ch = 'a'
     * 3.Character 沒有類似 String intern 的方法
     */
    public void test_q8() {
        System.out.println("-----總結1-----");
        Character character = new Character('1');
        System.out.println(character.charValue());

        System.out.println("-----總結2-----");
        System.out.println(Character.isDigit('0')); // true
        System.out.println(Character.isDigit('A')); // false

        System.out.println("-----總結3-----");
        System.out.println(Character.isLetter('0')); // false
        System.out.println(Character.isLetter('A')); // true
        System.out.println(Character.isLetter('測')); // true
        System.out.println(Character.isLetter('Ω')); // true

        System.out.println("-----總結3-----");
        System.out.println(Character.isLetter('0')); // false
        System.out.println(Character.isLetter('A')); // true
        System.out.println(Character.isLetter('測')); // true
        System.out.println(Character.isLetter('Ω')); // true

        System.out.println("-----總結11-----");
        System.out.println(Character.isAlphabetic('Ⅰ')); // true
        System.out.println(Character.isAlphabetic('l')); // true
        System.out.println(Character.isAlphabetic('Ⅱ')); // true
        System.out.println(Character.isAlphabetic('Ⅲ')); // true

        System.out.println(Character.isLetter('Ⅰ')); // false
        System.out.println(Character.isLetter('l')); // true
        System.out.println(Character.isLetter('Ⅱ')); // false
        System.out.println(Character.isLetter('Ⅲ')); // false

        System.out.println("-----擴展知識1-----");
        Character c1 = 'A';
        Character c2 = 'A';
        Character c3 = '測';
        Character c4 = '測';
        char c5 = '試';
        char c6 = '試';
        // 比較的是兩個物件，即是否指向同一個內存地址
        // 由於 0~127（Unicode編碼）存在緩存，所以 'A' 地址相等
        System.out.println(c1 == c2); // true
        // 漢字超出了緩存
        System.out.println(c3 == c4); // false
        // 比較的是Unicode碼
        System.out.println(c5 == c6); // true

        System.out.println("-----擴展知識2-----");
        Character ch = 'a';  // 自動裝箱
        char c = ch;  // 自動拆箱
        System.out.println(ch == c); // true

        System.out.println("-----擴展知識3-----");
        String s1 = new String("test");
        String s2 = new String("test");
        String s3 = "test";
        String s4 = "test";

        System.out.println(s1 == s2); // false
        System.out.println(s1.intern() == s2); // false
        System.out.println(s1.intern() == s2.intern()); // true
        System.out.println(s3 == s4); // true
        System.out.println(s1.intern() == s3); // true
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：指令相關
     * 需要補足知識：
     * 複習：要展開內容太多，先記答案
     * 總結：
     * 如何查看模塊依賴
     * 1.jdeps --list-deps
     * 2.java --show-module-resolution（Java 9引入）
     */
    public void test_q9() {

    }

    /**
     * 🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：繼承和實現
     * 需要補足知識：繼承和實現出現同函數會發生的問題
     * 複習：查看以下代碼
     * 總結：
     * 1.如果父類已經實現了和接口一樣的方法，子類不需要重寫（子類同時繼承和實現）
     * 2.當接口定義了默認函數（default），而父類定義了同樣的函數時，優先使用父類的重寫
     * 3.當接口定義了默認函數（default），而父類定義了抽象函數時，子類也必須重寫方法
     * 4.當實現了兩個接口包含相同默認函數時，子類也必須重寫方法
     */
    public void test_q10() {
        System.out.println("-----題目-----");
        C c1 = new C();
        c1.z();
        System.out.println("-----總結2.3-----");
        org.example.test_1Z0815.ch12.q10.test2.C c2 = new org.example.test_1Z0815.ch12.q10.test2.C();
        c2.x();
        System.out.println("-----總結4-----");
        org.example.test_1Z0815.ch12.q10.test3.C c3 = new org.example.test_1Z0815.ch12.q10.test3.C();
        c2.x();
    }

    static String str;

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：switch 使用，String 默認值
     * 需要補足知識：switch 可容許的值
     * 複習：查看以下代碼
     * 總結：
     * switch 可容許的值：
     * 1.byte 和 Byte
     * 2.short 和 Short
     * 3.char 和 Character
     * 4.int 和 Integer
     * 5.枚舉類型（自 JDK 1.5 開始）
     * 6.String 類型（自 JDK 1.7 開始）
     * 7.不允許 null 否則空指針異常
     * 8.String 的默認值是 null
     */
    public void test_q13() {
        switch (str) {
            case "10":
                str += "10";
            default:
                str += "def";
            case "20":
                str += "20";
        }
        System.out.println(str);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：localDate with
     * 需要補足知識：localDate 的使用
     * 複習：查看 Notion
     * 總結：-
     */
    public void test_q16() {

    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：關鍵字的使用
     * 需要補足知識：各關鍵字可使用的位置，日文
     * 複習：查看總結
     * 總結：
     * 1.ローカル変数（局部變量）
     * 2.インタフェース（接口）
     * 3.インスタンス（實例）
     * 4.メソッド（方法）
     * 5.インナークラス（內部類）
     * 6.フィールド（成員變量）
     * 7.堅牢性：系統的耐用度和可靠性。在電腦科學和信息技術中，它常常被用來描述一個系統或程序的能力，以持續正常運行，即使在遇到錯誤、異常或壓力情況（例如高負載或攻擊）下。
     * 8.プラットフォーム（platform）
     * 9.オペレーティングシステム（OS）
     * 10.デフォルト（default）
     * 11.スーパークラス（超類，父類）
     * 12.ラベル（label）
     * 13.ガベージコレクション（垃圾收集）
     * 13.オーバーロード：重載（Overloading）
     * 14.オーバーライド：重寫（Overriding）
     * 15.カプセル化：封裝（Encapsulation）
     * 16.コンストラクタ：構造器（Constructor）
     * 17.インクリメント：increment（ch04#q08）
     * 18.エントリーポイント：entry point（ch01#q05）
     * -----------------------
     * TODO 內容還需要補足
     */
    public void test_q17() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/06
     * 最後一次查看：2023/07/06
     * 題目考點：多維陣列的初期化
     * 需要補足知識：語法
     * 複習：查看以下代碼還有 Notion
     * 總結：
     */
    public void test_21() {
        int[][] staticArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] dynamicArray1 = new int[3][3];
        int[][] dynamicArray2 = new int[3][];
        dynamicArray2[0] = new int[3];
        dynamicArray2[1] = new int[2];
        dynamicArray2[2] = new int[1];
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/23
     * 題目考點：繼承，祖父成員變量問題
     * 需要補足知識：祖父成員變量訪問
     * 複習：查看q22
     * 總結：
     * 1.如果沒被覆蓋的情況下，子類（包含子孫類）都可以直接訪問祖父成員變量
     * 2.不直接使用 num，使用 super.num 也可以獲取到值（但沒必要）
     * 3.當想調用實現的接口的默認方法時，語法是
     *   B.super.sample(); <- B 是被實現的接口名（ch07#06）
     *   如果是抽象類或是普通類則是
     *   super.sample();
     * 4.子類無法直接調用祖父類方法（不管是類或是接口的默認方法）除非父類沒有重寫，
     *   如果有這個需求，需要在父類調用 super
     */
    public void test_q22() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：重載調用
     * 需要補足知識：A a = new B(); 首先看父類（A）的方法才去找重寫
     * 複習：查看q23
     * 總結：
     * A a = new B()
     * 1.在Java中，編譯器在編譯時期查看變量的聲明類型（這裡是A）來確定哪些方法可以被調用
     * 2.然而在運行時期，Java虛擬機（JVM）會查看實際的對象類型（這裡是B）來決定應該調用哪個方法。（重寫）
     * -----------補充-----------
     * 3.對於Java來說，沒有像指 "1000.0" 這樣明確定浮點數（double 或 float）類型的語法來直接指定整數（int，byte，short）的類型。
     *   必須顯示的指定如：(byte) byteValue = 10;
     */
    public void test_q23() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/28
     * 題目考點：多實現
     * 需要補足知識：多實現，且有擁有相同方法名時，需要指定使用的默認接口方法
     * 複習：查看q24
     * 總結：
     * super.sample(); -> IB.super.sample();
     * 1.super 關鍵字用於訪問父類（超類）的方法和屬性。但是在接口的情況下，Java不允許直接使用 super 關鍵字來訪問默認方法，
     *   因為一個類可能實現了多個接口，而這些接口可能有相同的默認方法，直接使用 super 將引發歧義。所以，Java語言的設計者們選擇禁止這種用法。
     * 2.哪怕接口中同樣的默認的方法只有一個，也不能直接透過 super 調用
     * -----------補充-----------
     * 1.接口中的 default 不能直接透過類調用，類只能直接調用 static 方法
     */
    public void test_q24() {
        IB.test();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：重載的優先調用
     * 需要補足知識：基本數據類型
     * 複習：查看 q27 和總結
     * 總結：
     * 1.沒有指定的情況下優先調用 int 和 double
     * -------------------------
     * 1.long: 你可以在整數後面加上 'L' 或 'l' 來創建一個 long 類型的字面量，例如 123L。但是，建議使用大寫的 'L'，因為小寫的 'l' 很容易被誤認為是數字 '1'。
     * 2.float: 你可以在數字後面加上 'F' 或 'f' 來創建一個 float 類型的字面量，例如 123.45F。
     * 3.double: 你可以在數字後面加上 'D' 或 'd' 來創建一個 double 類型的字面量，例如 123.45D。然而，如果你不添加任何後綴，那麼一個帶小數點的數字預設就是 double 類型的，例如 123.45。
     * 4.int、byte、short: 這些類型不需要也不支援後綴。如果一個整數字面量在byte或short類型的範圍內，那麼你可以直接將其賦值給一個byte或short變數。
     * 5.boolean: 對於布爾類型，其字面量只有 true 和 false。
     * 6.char: 字符字面量需要用單引號(' ')括起來，例如 'a'。
     * 除此之外，Java還支援十六進制（0x或0X前綴）、八進制（0前綴）和二進制（0b或0B前綴）的整數字面量，例如：0x1F, 017, 0b1010。
     * -----------補充-----------
     * 1.byte: 8位有符號整數。範圍從-128到127（含）。
     * 2.short: 16位有符號整數。範圍從-32768到32767（含）。
     * 3.int: 32位有符號整數。範圍從-2147483648到2147483647（含）。
     * 4.long: 64位有符號整數。範圍從-9223372036854775808到9223372036854775807（含）。
     * 5.float: 32位單精度浮點數。範圍大約從1.4E-45到3.4028235E38（正數或負數），精度約為6-7個十進制數字。
     * 6.double: 64位雙精度浮點數。範圍大約從4.9E-324到1.7976931348623157E308（正數或負數），精度約為15個十進制數字。
     * 7.Java 沒有直接提供無符號的正整數數據類型。
     */
    public void test_q27() {
        // 因為會產生歧意，編譯器不知道應該要裝箱還是拆箱
        // Q27.test(new Integer(1), 1);
        Q27.test(new Integer(1), new Integer(1));
        Q27.test(Integer.valueOf(1), Integer.valueOf(1));
        Q27.test(10, 20);
        Q27.test(10.0, 20.0);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：Java 模塊
     * 需要補足知識：Java 模塊
     * 複習：查看總結
     * 總結：
     * 1.有了模塊的概念後可以在沒有 JRE 環境的設備上運行 Java 程序，但在模塊概念出現之前也有其他方式，
     * 如Self-Contained Application（自包含應用程序）和Ahead-of-Time（將 Java 編譯為本地代碼）
     * 2.jlink（模塊） vs Self-Contained Application（自包含應用程序）
     * 　・尺寸和精簡度：使用jlink創建的自定義Java運行時環境只包含運行特定Java應用程序所需的模塊，這通常會比一個完整的JRE小很多。
     * 　　這是因為一個完整的JRE包含了所有的Java SE API，而一個具體的Java應用程序可能只使用其中的一部分。
     * 　　而一個Self-Contained Application會將完整的JRE打包進應用程序，因此可能會比使用jlink創建的自定義運行時環境大。
     * 　・跨平台性：使用jlink創建的自定義運行時環境是平台特定的，也就是說你需要為每個目標平台（例如Windows、Linux、macOS）分別創建一個運行時環境。
     * 　　而一個Self-Contained Application可以是跨平台的，這意味著你可以創建一個應用程序包，它可以在多個平台上運行。
     * 　・Java版本要求：jlink是在Java 9中引入的，所以只有Java 9及以上版本才支持創建自定義運行時環境。
     * 　　而Self-Contained Application功能在Java 7就已經提供，因此在舊版本的Java中可能是唯一的選擇。
     * -----------------------
     * TODO 內容還需要補足
     */
    public void test_q29() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：List.of，Arrays.asList，ArrayList
     * 需要補足知識：
     * 複習：查看 q33
     * 總結：
     * 1.Arrays.asList 返回的列表大小不可變
     * 2.List.of 更加嚴格不僅大小不可變，就連元素都是不可變的
     * 3.如果需要改變需要使用 ArrayList
     * 4.keys.clear() 用於清空列表
     */
    public void test_q33() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：重寫
     * 需要補足知識：private方法不可重寫
     * 複習：查看 q35
     * 總結：
     * 1.private方法不能被重寫，所以當調用private方法時不會去檢查子類重寫方法
     * 2.public會去檢查子類是否有重寫，有重寫則調用子類的重寫方法
     */
    public void test_q35() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/09/13
     * 題目考點：重寫
     * 需要補足知識：只有返回值不同的函數會報錯（因為編譯器會認為是同一個方法）
     * 複習：查看 q41 （因為編譯錯誤所以無法運行）
     * 總結：
     * 1.同時實現兩個相同方法名且相同參數的函數時，如果兩個返回值無法匹配，將會報錯，只能通過修改接口解決問題
     * -----------補充-----------
     * 重寫需要滿足的要件
     * 1.方法的名稱必須相同。
     * 2.方法的參數列表（包括參數的數量、順序和類型）必須完全相同。
     * 3.方法的返回類型必須相同或者是父類方法返回類型的子類（這是從Java 5開始支持的，被稱為協變返回類型）。
     * 4.方法的訪問修飾符不能縮小（例如，一個被 public 修飾的父類方法不能被子類以 private 或 protected 的方式重寫）。
     *   不過可以擴大，例如，一個 protected 的父類方法可以被子類以 public 的方式重寫。
     *   這種限制的目的是為了確保多態的實現。如果我們有一個指向子類對象的父類參考（對象地址），
     *   當調用父類方法時，需要去檢查是否有重寫，如果這些方法定義為更嚴格的訪問級別，那麼這種安全的調用將不再可能，這就破壞了多態的概念。
     * 5.如果父類方法拋出了異常，那麼子類重寫的方法可以選擇不拋異常，或者拋出部分或全部的父類方法的異常，但不能拋出父類方法沒有的異常。
     */
    public void test_q41() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：繼承
     * 需要補足知識：子類無法通過常規手段訪問父類 private 方法（反射可以）
     * 複習：查看 q43
     * 總結：-
     */
    public void test_q43() {
        B b = new B();
        System.out.println(b.test(10));
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：繼承時，構造器的調用
     * 需要補足知識：沒有明寫的話，默認會調用父類的空參構造器
     * 複習：查看 q44
     * 總結：
     * 1.構造器默認會調用父類的空參構造器
     * 2.構造器內 super 和 this 只能擇一（必須位於構造器的第一行）
     */
    public void test_q44() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：localDate（Java 8 引入）
     * 需要補足知識：localDate now 的使用
     * 複習：查看以下代碼，補充查看 Notion
     * 總結：-
     */
    public void test_q46() {
        LocalDate now = LocalDate.now();
        System.out.println(now); // 2023-07-10
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：運算式
     * 需要補足知識：運算式
     * 複習：查看 q49
     * 總結：
     * 1. a = b = c = d;
     *   這種運算式子是由右到左執行
     *   d 賦值給 c，c 賦值給 b，以此類推
     * 2.如果 = 的右邊是變量則取出那個變量的值賦值給左邊，如果是函數則是返回值（無返回值會編譯錯誤）
     */
    public void test_q49() {
        Sample sample = new Sample();
        sample.setAll(10);
        System.out.println(sample);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：基本數據類型的計算
     * 需要補足知識：基本數據類型
     * 複習：查看以下代碼
     * 總結：
     * 1.round 四捨五入，返回的是整數
     * 2.整數除整數，無條件捨去
     * 3.計算時如果有 float 將自動向上轉型
     */
    public void test_53() {
        // round 四捨五入
        long g1 = Math.round(10.4);
        long g2 = Math.round(10.5);
        System.out.println(g1 + ", " + g2);
        // 整數除整數，無條件捨去
        int result = 5 / 2;
        System.out.println(result);
        byte x = 5, y = 2;
        // 計算時如果有 float 將自動向上轉型
        float a1 = Math.round((float) x / y * 100) / (float) 100;
        System.out.println(a1);
        float a2 = (float) (Math.round((float) x / y * 100) / 100);
        System.out.println(a2);
//        float a3 = Math.round((int) (x / y), 2);
//        System.out.println(a3);
//        float a4 = Math.round((float) x / y, 2);
//        System.out.println(a4);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/10
     * 最後一次查看：2023/07/10
     * 題目考點：初始化，宣告
     * 需要補足知識：
     * 複習：查看以下總結和代碼
     * 總結：
     * 1.有小數點的情況，默認為 double，無小數點默認為 int，除此之外需要顯式指定
     * 2.Character 不能賦值給 String
     * 3.Java 7及以後版本引入了一種新的數字文字表示法，允許在數字中插入下劃線（_）以增強可讀性。這些下劃線在編譯時會被忽略。
     */
    public void test_q55() {
        float f = 1.99F;
        double d = 1.99;
        short c = (short) 'A';
        int i1 = 'A';
        int i2 = 12_3___4;
        // String s = 'A';
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(i1);
        System.out.println(i2);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點： + 運算符
     * 需要補足知識：表達式是由左至右運算
     * 複習：查看以下總結和代碼
     * 總結：
     * 1. + 運算符既可以作為算數運算符用於數字的加法，也可以作為字符串連接運算符用於連接兩個字符串。
     * 2.表達式運算由左至右進行
     */
    public void test_q59() {
        int a = 4;
        int b = 2;
        System.out.println(a + b + " = (a + b) = " + a + b);
        // 6 = (a + b) = 42
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：類型轉換
     * 需要補足知識：類型轉換
     * 複習：查看以下總結和代碼
     * 總結：
     * 1.不能直接將一個數字（無論是整數或是浮點數）強制轉換成一個字符串。
     */
    public void test_q60() {
        short s1 = 10;
        Integer s2 = 20;
        Long s3 = (long) s1 + s2;
        String s4 = (s3 + s2) + "";
        // String s4 = (String) (s3 + s2);
        System.out.println(s4);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：初始化
     * 需要補足知識：初始化
     * 複習：查看以下總結和代碼
     * 總結：要打印基本數據類型，需要確保變量有初始化
     */
    public void test_q63() {
        int x;
        int y = 3;
        if (y > 2) {
            x = ++y;
            y = x + 5;
        } else {
            x = 1; // <- 題目沒有此行
            y++;
        }
        // Variable 'x' might not have been initialized
        System.out.println(x + ", " + y);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：Java 主方法
     * 需要補足知識：Java 主方法
     * 複習：運行 q64
     * 總結：
     * 1.在Java中，當你從命令行啟動程序時，JVM（Java Virtual Machine）將查找並調用的主方法必須是 public static void main(String[] args)
     */
    public void test_q64() {
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：方法引用（Method Reference）
     * 需要補足知識：
     * 複習：查看 q66
     * 總結：詳細內容查看 Notion
     */
    public void test_q66() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：異常類繼承關係
     * 需要補足知識：異常類繼承關係
     * 複習：查看以下代碼和 Notion
     * 總結：
     * 1.Java中所有異常都是 Throwable 的子類
     * 2.內存溢出是屬於 Error 錯誤
     */
    public void test_q69() {
        ArrayList arrayList = new ArrayList();

        try {
            while(true) {
                // java.lang.OutOfMemoryError
                arrayList.add("hello");
            }
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println("Finish");
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：StringBuilder API 使用
     * 需要補足知識：replace，indexOf
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q72() {
        StringBuilder builder = new StringBuilder("ABCD");
        // start包含，end不包含
        builder.replace(1,2,"X");
        System.out.println(builder);
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：編譯錯誤，運行錯誤
     * 需要補足知識：明確的錯誤在編譯期間就會報告
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q77() {
        Object o = new Object();
        ArrayList<Integer> arr = new ArrayList<>();
        // 編譯器明確知道此處會轉換失敗，所以是編譯錯誤，不是運行異常
        // Incompatible types. Found: 'java.lang.Object', required: 'java.util.ArrayList<java.lang.Integer>'
        // arr = o;
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/11
     * 最後一次查看：2023/07/11
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }
}






