package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    /**
     * @param path e.g. test_1Z0816/ch05/
     * @return Path
     */
    public static Path getPath(String path) {
        String userDir = System.getProperty("user.dir");
        System.out.println("當前工作目錄: " + userDir);
        Path fullPath = Paths.get(userDir + "/src/test/java/org/example/" + path + "/");
        System.out.println("Path: " + fullPath);
        return fullPath;
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
