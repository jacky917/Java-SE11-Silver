package org.example.test_1Z0816.ch05.o02;

import org.example.test_1Z0816.ch05.util.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * 修改默認的系統打印流，打印到控制台，並且寫到文件裡
 * public static final PrintStream err
 * public static final InputStream in
 * public static final PrintStream out
 */
public class ChangeDefaultSystemOutput {

    public static void main(String[] args) {

        Path filePath = Utils.getPathWithDir("o02");

        System.out.println("filePath = " + filePath);

        try (FileOutputStream fos = new FileOutputStream(filePath + File.separator + "ChangeDefaultSystemOutput.txt", false)) {

            System.setOut(new MyPrintStream(System.err, System.err));
            System.out.println("Test");
            System.out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
