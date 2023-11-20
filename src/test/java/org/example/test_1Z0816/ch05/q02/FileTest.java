package org.example.test_1Z0816.ch05.q02;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        Path filePath = Paths.get(userDir + "/src/test/java/org/example/test_1Z0816/ch05");
        File file = new File(filePath.toString());
        // 返回 File[]
        System.out.println(Arrays.toString(file.listFiles()));
        // 返回 String[]
        System.out.println(Arrays.toString(file.list()));
    }
}
