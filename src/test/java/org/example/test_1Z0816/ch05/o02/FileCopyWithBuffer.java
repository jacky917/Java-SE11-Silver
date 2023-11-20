package org.example.test_1Z0816.ch05.o02;

import org.example.test_1Z0816.ch05.util.Utils;

import java.io.*;
import java.nio.file.Path;

public class FileCopyWithBuffer {
    public static void main(String[] args) {
        Path filePath = Utils.getPathWithDir("o02");

        // 創建源文件和目標文件的路徑
        File sourceFile = new File(filePath.toFile(), "pic.png");
        File targetFile = new File(filePath.toFile(), "pic_copy.png");

        // 使用單個try-with-resources語句打開所有的流
        try (
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            byte[] buffer = new byte[5];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
                // 刷新緩衝區（不等緩存滿直接寫入）
                //bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
