package org.example.test_1Z0816.ch13;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.util.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
     * 🌟🌟
     * 創建日期：2023/12/22
     * 最後一次查看：2023/12/22
     * 題目考點：InputStreamReader(System.in)
     * 需要補足知識：查看
     * 複習：查看 #ch05 o02 KeyBoardInputTest
     * 總結：和 Scanner（next） 一樣，需要先讀取（readLine）
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/22
     * 最後一次查看：2023/12/22
     * 題目考點：Files
     * 需要補足知識：Files.lines
     * 複習：查看以下代碼
     * 總結：Files.lines 接收一個 Path，並返回一個流
     */
    public void test_q02() {
        try {
            Path path = Utils.getPath("test_1Z0816/ch13/data/test.txt");
            // public static Stream<String> lines(Path path) throws IOException
            try (Stream<String> lines = Files.lines(path)) {
                lines.forEach(x -> {
                    System.out.println("-----");
                    System.out.println(x);
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/22
     * 最後一次查看：2023/12/22
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






