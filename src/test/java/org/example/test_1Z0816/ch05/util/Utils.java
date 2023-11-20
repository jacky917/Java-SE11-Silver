package org.example.test_1Z0816.ch05.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static Path getPath() {
        String userDir = System.getProperty("user.dir");
        System.out.println("當前工作目錄: " + userDir);
        Path path = Paths.get(userDir + "/src/test/java/org/example/test_1Z0816/ch05");
        System.out.println("Path: " + path);
        return path;
    }

    public static Path getPathWithDir(String folder) {
        String userDir = System.getProperty("user.dir");
        System.out.println("當前工作目錄: " + userDir);
        Path path = Paths.get(userDir + "/src/test/java/org/example/test_1Z0816/ch05/" + folder + "/data/");
        checkPath(path);
        System.out.println("Path: " + path);
        return path;
    }

    public static Path getPathWithDirAndFilename(String folder,String filename) {
        String userDir = System.getProperty("user.dir");
        System.out.println("當前工作目錄: " + userDir);
        Path path = Paths.get(userDir + "/src/test/java/org/example/test_1Z0816/ch05/" + folder + "/data/" + filename + "/");
        checkPath(path);
        System.out.println("Path: " + path);
        return path;
    }

    public static boolean checkPath(Path path) {
        // 檢查路徑是否存在
        if (!Files.exists(path)) {
            // 嘗試創建目錄，包含任何必要的但不存在的父目錄
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                e.printStackTrace();
                //處理無法創建目錄的情況，可能是權限或其他問題
            }
            return false;
        } else {
            // 路徑已經存在
            return true;
        }
    }
}
