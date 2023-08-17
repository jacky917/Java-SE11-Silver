package org.example.test_1Z0815.ch10;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：Main
     * 需要補足知識：Main 方法的 args 參數
     * 複習：查看 q02
     * 總結：args.length 不會導致空指針
     */
    public void test_q02() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：try catch 語法
     * 需要補足知識：try catch 語法
     * 複習：查看以下代碼
     * 總結：finally 不能放在 catch 前面
     */
    public void test_q04() {

        try {
            System.out.println("try");
        }finally {
            System.out.println("finally");
        }

        try {
            System.out.println("try");
        }catch (Exception e) {
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }

//        try {
//            System.out.println("try");
//        }finally {
//            System.out.println("finally");
//        }catch (Exception e) {
//            System.out.println("catch");
//        }

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：obj.toString()
     * 需要補足知識：obj.toString()
     * 複習：查看 q05
     * 總結：
     * 1.System.out.println(obj) 有對 null 處理，不會空指針
     *   如果 obj 為 null，obj.toString() 會直接拋出異常
     * －－－－－－－－－－－－－－－－
     * TODO 補充 深入瞭解 System.out.println(obj) 和 System.out.println(obj.toString()) 的差別
     * PrintStream 了解
     */
    public void test_q05() {

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：finally
     * 需要補足知識：finally return
     * 複習：查看 q06
     * 總結：finally 區塊的特性是：無論 try 或 catch 區塊中是否有異常發生，甚至其中有 return 語句，都會在跳出 try-catch 結構之前被執行。
     */
    public void test_q06() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：finally
     * 需要補足知識：finally 處理
     * 複習：查看 q07
     * 總結：
     * 1.finally 永遠都是最後執行的
     * 2.如果在 finally 中操作 catch 中返回的參數，
     *   -> 引用數據類型會有影響
     *   -> 基本數據類型不會有影響
     * 3.一個 try 最多只能有一個 finally（#08）
     * 4.finally 中如果有返回，將會覆蓋返回值
     */
    public void test_q07() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：try-with-resources
     * 需要補足知識：try-with-resources
     * 複習：查看以下代碼
     * 總結：try-with-resources 結構中，資源是在try括號內部聲明並初始化的，當try區塊結束時，這些資源將自動關閉。
     *      這意味著，這些資源在catch和finally塊中不再可用，因為它們已經被關閉了。（Java 7）
     * TODO 流的部分要再多複習
     */
    public void test_q10() {
        try (FileInputStream is = new FileInputStream("q10.txt")) {
            int read = is.read();
            System.out.println(read);
        } catch (Exception e) {
            System.out.println("A");
        } finally {
            // 題目報錯的位置
            // if (is != null) {
            //     is.close();
            // }
            System.out.println("B");
        }

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);
        String separator = System.getProperty("file.separator");

        // 拼接絕對路徑
        String path = currentDirectory + separator + "src" + separator + "test" + separator + "java" +
                separator + "org" + separator + "example" + separator + "ch10" + separator + "q10.txt";


        // BufferedReader + FileReader 實現逐行讀取
        // try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }


        // 不使用 try-with-resources
        System.out.println("－－－－－－－－－－－－－－－－");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("finally");
        }

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/28
     * 題目考點：Exception 的繼承關係
     * 需要補足知識：Exception 的繼承關係
     * 複習：查看 q11
     * 總結：
     * 1.Throwable 下有兩個子類 Error 和 Exception
     * 2.RuntimeException 是繼承 Exception 的
     * 3.RuntimeException 不會在編譯時報錯
     * 4.除了 RuntimeException 以外的 Exception 子類都稱為受檢異常（編譯器會要求要拋出或處理錯誤）
     * －－－－－－－－－－－－－－－－
     * 補充：為何要設計受檢異常和非受檢異常
     * 1.主要是為了區分“程式員錯誤”和其他類型的問題。RuntimeExceptions常常用於指示編程錯誤，
     *   例如空指針異常（NullPointerException），索引超出邊界（IndexOutOfBoundsException）等等。
     *   這些都是編程時應當避免的問題，如果出現了這些問題，那基本上就是程式碼寫的有問題。
     * 2.另一方面，對於那些不可預測的，或者即使編程無誤也可能發生的錯誤，例如文件找不到（FileNotFoundException），
     *   網路連線失敗（IOException）等等，Java則規定必須進行捕獲處理或者聲明拋出，這類異常被稱為“受檢異常”（checked exceptions）。
     *   這就強制程式員在編寫程式碼的時候就考慮到這些可能出現的問題，並進行處理。
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：Error 錯誤
     * 需要補足知識：Error 錯誤，日文
     * 複習：查看總結
     * 總結：
     * 1.當程式的執行環境出現異常時，將拋出 Error
     * 　エラーは、プログラムの実行環境に例外が発生したときにスローされる
     * 2.錯誤必須繼承 Error 類
     * 　エラーは、Errorクラスを継承しなければいけない
     * 3.錯誤無需在throws子句中宣告。
     *   エラーはthrows句に宣言する必要はない
     * 4.錯誤可以撰寫例外處理（但無法保證一定能被執行到）
     *   エラーは例外処理を記述できる
     * －－－－－－－－－－－－－－－－
     *   TODO 了解 DefaultUncaughtExceptionHandler
     *   Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
     *     public void uncaughtException(Thread t, Throwable e) {
     *         System.out.println("Uncaught Exception in thread '" + t.getName() + "': " + e.getMessage());
     *         // Here, you can add code to log the exception, or perform other clean-up tasks.
     *     }
     * });
     */
    public void test_q12() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/28
     * 題目考點：各種越界異常
     * 需要補足知識：各種越界異常
     * 複習：查看以下代碼
     * 總結：
     * 1.IndexOutOfBoundsException（集合類越界，例如ArrayList或LinkedList等）
     * 2.ArrayIndexOutOfBoundsException（陣列越界）
     * 3.StringIndexOutOfBoundsException（字符串越界）
     * 4.ArrayIndexOutOfBoundsException 和 StringIndexOutOfBoundsException 是 IndexOutOfBoundsException 的子類
     */
    public void test_q14() {

        // IndexOutOfBoundsException（集合類越界，例如ArrayList或LinkedList等）
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("test");
        try {
            String element = arrayList2.get(10);  // 超出索引範圍
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        List<String> linkedList = new LinkedList<>();
        linkedList.add("test");
        try {
            String element = linkedList.get(10);  // 超出索引範圍
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // ArrayIndexOutOfBoundsException（陣列越界）
        int[] array = new int[5];
        try {
            int num = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // StringIndexOutOfBoundsException（字符串越界）
        String str = "OpenAI";
        try {
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/07/24
     * 最後一次查看：2023/07/24
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






