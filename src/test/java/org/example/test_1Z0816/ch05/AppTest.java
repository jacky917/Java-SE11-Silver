package org.example.test_1Z0816.ch05;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.test_1Z0816.ch05.util.Utils;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

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
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/15
     * 最後一次查看：2023/11/15
     * 題目考點：File
     * 需要補足知識：列出所有檔案
     * 複習：查看q02
     * 總結：-
     */
    public void test_q02() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/11/17
     * 題目考點：BufferedInputStream
     * 需要補足知識：API
     * 複習：
     * 總結：
     */
    public void test_q07() {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""))) {
            // 這個方法從輸入流中讀取最多 len 位元組的資料並將其儲存到位元組數組 b 中，從數組的 off 位置開始存放。
            byte[] bytes1 = new byte[1024];
            bufferedInputStream.read(bytes1);
            // 這個方法讀取輸入流的所有剩餘字節，並將它們作為一個位元組數組傳回。 這個方法在 Java 9 中被加入到 InputStream 類別。
            byte[] bytes2 = bufferedInputStream.readAllBytes();
            // readNBytes() 試圖從這個流中讀取 len 個位元組的數據，並將其作為一個位元組數組傳回。
            byte[] bytes3 = bufferedInputStream.readNBytes(1024);
        }catch (IOException e) {
            e.printStackTrace();
        };
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/11/17
     * 題目考點：BufferedWriter
     * 需要補足知識：API newLine
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q06() {
        // newLine() 方法用於寫入一個系統相關的換行符。
        // 不同操作系統的換行符可能不同（比如 Windows 是 \r\n，而 UNIX/Linux 是 \n）。
        // 使用此方法可以讓你無需關注特定平台的細節，而是根據執行程式的系統自動寫入正確的新行。
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("這是第一行。");
            writer.newLine();
            writer.write("這是第二行。");
            writer.write(65); // 寫入字符 'A'
            // flush()
            // flush() 方法用於刷新緩衝區，將所有緩衝的輸出字符實際寫入到底層流中。
            // 這是一個很重要的操作，因為在緩衝區未滿之前，數據可能不會真正寫入到目標（如文件或網絡連接）。
            // 當你完成了數據寫入後，調用 flush() 來確保所有數據都已經寫入。
            writer.flush();
        } catch (IOException e)  {
            throw new RuntimeException(e);
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/11/17
     * 題目考點：Console
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：java.io.Console 類別是 Java 6 引入的實用工具，用於存取與目前 Java 虛擬機器相關聯的控制台裝置。
     *      如果你的程式是從命令列啟動的，而輸入輸出沒有被重新導向到另一個來源或目的地，你就可以使用 Console 類別來與使用者互動。
     */
    public void test_q08() {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        // 讀取用戶輸入的一行文本
        String line = console.readLine("Enter your text: ");

        // 讀取密碼（不顯示）
        char[] password = console.readPassword("Enter your password: ");
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/11/17
     * 題目考點：Scanner
     * 需要補足知識：API
     * 複習：
     * 總結：
     */
    public void test_q09() {
        Scanner scanner1 = new Scanner("A,B,C,D,E");
        scanner1.useDelimiter(",");
        System.out.println(scanner1.next()); // A

        Scanner scanner2 = new Scanner(System.in);
        scanner2.useDelimiter(",");
        System.out.println(scanner2.next());
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/11/17
     * 題目考點：Path
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q12() {
        Path path1 = Paths.get("111.txt");
        Path path2 = Paths.get("dir", "111.txt");
        Path path3 = new File("111.txt").toPath();
        // Path path4 = Files.get("111.txt"); 錯誤
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2023/11/19
     * 題目考點：NIO
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_q13() throws IOException {
        Path q13 = Utils.getPathWithDirAndFilename("", "q13.txt");
        // 如果檔案存在會報 java.nio.file.FileAlreadyExistsException 錯誤
        try {
            Files.createFile(q13);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2023/11/19
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_q14() {
        Path dir = Paths.get("a","b"); // 拼接兩個目錄
        System.out.println(dir); // a/b
        // 這行代碼展示了如何使用 resolve 方法將一個相對路徑添加到現有的 Path 對象。
        Path resolve = dir.resolve(Paths.get("data.txt"));
        System.out.println(resolve); // a/b/data.txt
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2023/11/19
     * 題目考點：Files
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q16() throws IOException {
        Path path = Paths.get("text_copy.txt");
        // 追加寫入
        FileWriter dstWriter = new FileWriter(path.toString(),true);
        // Files JDK 1.7
        // newBufferedWriter JDK 1.8
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path,StandardOpenOption.APPEND);

    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2023/11/19
     * 題目考點：FileVisitor
     * 需要補足知識：API
     * 複習：查看o03
     * 總結：-
     */
    public void test_q18() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2023/11/19
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }
}






