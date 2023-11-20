package org.example.test_1Z0816.ch05.o02;

import org.example.test_1Z0816.ch05.util.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextCopy {
    public static void main(String[] args) throws IOException {
        Path filePath = Utils.getPathWithDir("o02");

        // FileInputStream 和 FileOutputStream 是用於讀取和寫入文件數據的基本字節流。
        try (FileReader srcReader = new FileReader(filePath + File.separator + "text.txt")) {
            try (FileWriter dstWriter = new FileWriter(filePath + File.separator + "text_copy.txt")) {
                int len;
                char[] buffer = new char[5];
                while ((len = srcReader.read(buffer)) != -1) {
                    dstWriter.write(String.valueOf(buffer),0,len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
