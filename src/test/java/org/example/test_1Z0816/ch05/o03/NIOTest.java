package org.example.test_1Z0816.ch05.o03;

import org.example.test_1Z0816.ch05.util.Utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * 使用NIO對文件的基本讀寫操作
 */
public class NIOTest {

    private static final String input = "testtesttesttesttesttesttesttesttesttesttesttesttest";

    public static void readFromFile() {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        try (FileChannel fileChannel = FileChannel.open(Utils.getPathWithDirAndFilename("o03","example.txt"),
                StandardOpenOption.READ)) {
            while (fileChannel.read(buffer) != -1) {
                buffer.flip(); // 切換到讀模式
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // 清除緩衝區，準備下一次寫入
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 使用 try-with-resources 自動關閉資源
        try (FileChannel fileChannel = FileChannel.open(Utils.getPathWithDirAndFilename("o03","example.txt"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            // 將字符串轉為字節數組
            byte[] bytes = input.getBytes();

            // 寫入字節到文件
            for (byte b : bytes) {
                buffer.put(b);
                // 如果緩衝區滿了，就寫入文件
                if (!buffer.hasRemaining()) {
                    buffer.flip(); // 切換到讀模式
                    fileChannel.write(buffer);
                    buffer.clear(); // 清除緩衝區，準備下一次寫入
                }
            }

            // 如果循環結束後緩衝區還有剩餘的數據，再次寫入文件
            if (buffer.position() > 0) {
                buffer.flip();
                fileChannel.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        writeToFile();
        readFromFile();

    }
}
