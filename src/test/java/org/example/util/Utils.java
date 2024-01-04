package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    private static final Connection connection;

    static {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/oracle_certified", "root", "123456");

            PreparedStatement preparedStatement = conn.prepareStatement("SHOW VARIABLES LIKE \"%version%\";");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("========================================================");
            while(resultSet.next()) {
                System.out.printf("%25s | ",resultSet.getObject(1));
                System.out.println(resultSet.getObject(2));
            }
            System.out.println("========================================================");

            System.out.println("Connect Success");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection = conn;
        }
    }

    public static Connection getConnect() {
        return connection;
    }
}
