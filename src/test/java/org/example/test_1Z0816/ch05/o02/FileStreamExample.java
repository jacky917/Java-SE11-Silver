package org.example.test_1Z0816.ch05.o02;

import org.example.test_1Z0816.ch05.util.Utils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 操作數據單位：
 *    字節流（8bit）字符流（16bit）
 *    字符流 -> 更適合處理文本數據
 * 數據流向：
 *    輸出流、輸入流
 * 流的角色：
 *    節點流（文件流）、處理流
 *    節點流 -> 直接作用於文件上的
 *    處理流 -> 包在節點流上的流
 */
public class FileStreamExample {
    public static void main(String[] args) {

        // 字節（8bit）  抽象類 InputStream OutputStream
        // 字符（16bit） 抽象類 Reader Writer
        Path filePath = Utils.getPathWithDir("o02");

        // FileInputStream 和 FileOutputStream 是用於讀取和寫入文件數據的基本字節流。
        File fileStream = new File(filePath + File.separator + "FileStream.txt");

        try (FileOutputStream fos = new FileOutputStream(fileStream)) {
            String text = "Hello, World!";
            byte[] textBytes = text.getBytes();
            fos.write(textBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(fileStream.exists()) {
            try (FileInputStream fis = new FileInputStream(fileStream)) {
                int content;
                while ((content = fis.read()) != -1) {
                    // 將字節轉換為字符，並顯示
                    System.out.print((char) content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // FileReader 和 FileWriter 是用於讀取和寫入文件數據的字符流。
        File file = new File(filePath + File.separator + "File.txt");

        try (FileWriter fw = new FileWriter(file)) {
            String text = "Hello, World!";
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader(file)) {
            int content;
            while ((content = fr.read()) != -1) {
                // 將整數轉換為字符並顯示
                // fr.read() 讀入一個字符（整數）
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BufferedReader 和 BufferedWriter 是裝飾了其他讀取器和寫入器的高級字符流，它們使用緩衝區來提高讀寫效率。
        File buffered = new File(filePath + File.separator + "Buffered.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(buffered))) {
            String text = "Hello, World!";
            bw.write(text);
            bw.newLine(); // 寫入一個新行
            bw.write("Another line.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(buffered))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DataInputStream 和 DataOutputStream 允許你讀取和寫入基本數據類型（如 int, float, long 等）的原始二進制數據。
        File data = new File(filePath + File.separator + "Data.bin");

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(data))) {
            dos.writeInt(123);
            dos.writeFloat(3.14f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(data))) {
            int intValue = dis.readInt();
            float floatValue = dis.readFloat();

            System.out.println("讀取的整數：" + intValue);
            System.out.println("讀取的浮點數：" + floatValue);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
