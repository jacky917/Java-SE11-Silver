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
     * 創建日期：2024/01/10
     * 最後一次查看：2024/01/10
     * 題目考點：FileWriter
     * 需要補足知識：追加和覆蓋
     * 複習：查看以下代碼
     * 總結：第二個參數為 false，則會重頭開始寫入
     */
    public void test_q05() throws IOException {
        // append – boolean if true, then data will be written to the end of the file rather than the beginning.
        FileWriter out = new FileWriter("output.txt", false);
    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2024/01/10
     * 題目考點：BufferedWriter
     * 需要補足知識：API newLine
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q06() {
        // newLine() 方法用於寫入一個系統相關的換行符。キャリッジリターン（\r） 或是 ラインフィード（\n）
        // 不同操作系統的換行符可能不同（比如 Windows 是 \r\n，而 UNIX/Linux 是 \n）。
        // 使用此方法可以讓你無需關注特定平台的細節，而是根據執行程式的系統自動寫入正確的新行。
        Path pathWithDirAndFilename = Utils.getPathWithDirAndFilename("", "output.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathWithDirAndFilename.toString()))) {
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
     * 最後一次查看：2023/12/14
     * 題目考點：BufferedInputStream
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q07() {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""))) {

            // 讀取單一位元組的資料。 如果沒有可讀的字節，因為到達流的末尾，則返回 -1。
            bufferedInputStream.read();

            // 從輸入流讀取一些位元組數，並將它們儲存到緩衝區數組 b。 傳回實際讀取的位元組數，如果因為到達流的末尾而沒有更多數據，則傳回 -1。
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
     * 🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/12/26
     * 題目考點：Console
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：
     * 1.java.io.Console 類別是 Java 6 引入的實用工具，用於存取與目前 Java 虛擬機器相關聯的控制台裝置。
     *   如果你的程式是從命令列啟動的，而輸入輸出沒有被重新導向到另一個來源或目的地，你就可以使用 Console 類別來與使用者互動。
     * 2.（誤導選項）CharSequence 是一個通用接口，代表一個可讀的字元序列。這個介面提供了一種統一的方式來存取和操作不同類型的字元序列。
     *   它被多個類別實現，包括 String、StringBuilder 和 StringBuffer 等。
     * 3.（ch13#q18）獲取到的密碼可以正常打印出來。（readPassword）
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

        System.out.println(password);
    }

    /**
     * 🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/12/14
     * 題目考點：Scanner
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：一開始就需要調用 next()
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
     * 創建日期：2023/11/19
     * 最後一次查看：2023/11/19
     * 題目考點：序列化與反序列化
     * 需要補足知識：調用的API
     * 複習：查看ch12
     * 總結：-
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/11/17
     * 最後一次查看：2023/12/14
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
     * 最後一次查看：2023/12/14
     * 題目考點：NIO
     * 需要補足知識：-
     * 複習：查看以下代碼
     * 總結：-
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
     * 最後一次查看：2023/12/14
     * 題目考點：API使用
     * 需要補足知識：
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q14() {
        Path dir = Paths.get("a","b"); // 拼接兩個目錄
        System.out.println(dir); // a/b
        // 這行代碼展示了如何使用 resolve(解決) 方法將一個相對路徑添加到現有的 Path 對象。
        Path resolve = dir.resolve(Paths.get("data.txt"));
        System.out.println(resolve); // a/b/data.txt
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2024/01/10
     * 題目考點：Files
     * 需要補足知識：API
     * 複習：查看以下代碼
     * 總結：NIO 新增的 Files.newBufferedWriter 所需要的第二個參數不是 boolean
     */
    public void test_q16() throws IOException {
        Path path = Paths.get("text_copy.txt");
        // 追加寫入
        FileWriter dstWriter = new FileWriter(path.toString(),true);
        // Files JDK 1.7
        // newBufferedWriter JDK 1.8
        // 續寫文件
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path,StandardOpenOption.APPEND);

        // 這裡，Files.newBufferedWriter(path) 將建立一個 BufferedWriter 實例，
        // 用於寫入指定路徑的檔案。 如果該檔案已經存在，它將被覆蓋；如果不存在，將建立一個新檔案。
        BufferedWriter bufferedWriter1 = Files.newBufferedWriter(path);

        // 明確指定
        BufferedWriter bufferedWriter2 = Files.newBufferedWriter(Paths.get("your-file-path.txt"),
                // StandardOpenOption.WRITE 表示我們打算寫入文件，而 StandardOpenOption.CREATE 表示如果文件不存在，則建立它。
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

    }

    /**
     * 🌟🌟🌟🌟🌟
     * 創建日期：2023/11/19
     * 最後一次查看：2024/01/10
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






