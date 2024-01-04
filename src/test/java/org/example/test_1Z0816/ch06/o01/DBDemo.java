package org.example.test_1Z0816.ch06.o01;


import org.example.util.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Statement
 *   │
 *   ├── PreparedStatement
 *         │
 *         └── CallableStatement
 *  繼承關係
 */
public class DBDemo {

    /**
     * Statement創建表，並插入測試資料
     * @return 是否有異常
     * Statement 物件用於執行靜態 SQL 語句，通常用於 DDL（資料定義語言）操作，
     * 例如建立、修改、刪除資料庫和表格結構，也可以用於執行簡單的 DML（資料操縱語言）操作。
     */
    public static boolean creatTable() {

        Connection connect = Utils.getConnect();
        try (Statement statement = connect.createStatement()) {
            // 創建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS people (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "age INT)";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");

            // 插入數據
            String insertDataSQL = "INSERT INTO people (name, age) VALUES " +
                    "('Alice', 30), " +
                    "('Bob', 25), " +
                    "('Charlie', 35)";
            statement.executeUpdate(insertDataSQL);
            System.out.println("Data inserted successfully.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * PreparedStatement 插入資料
     * @return 是否有異常
     * PreparedStatement 物件用於執行參數化的 SQL 語句。 它通常用於 DML 操作，例如插入、更新和刪除資料行。
     * PreparedStatement 可以預先編譯 SQL 語句，從而提高效能，並有助於防止 SQL 注入攻擊。
     */
    public static boolean insertData() {
        String sql = "INSERT INTO users (id, name) VALUES (?, ?)";
        Connection connect = Utils.getConnect();
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Jane Doe");
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * PreparedStatement 查詢資料 + 獲取別名創建 map
     * @return 查詢結果
     * executeQuery()：執行查詢資料庫的 SQL 語句，傳回單一 ResultSet 物件。
     * executeUpdate()：執行插入、更新或刪除操作的 SQL 語句，傳回一個整數，表示受影響的行數。
     * execute()：執行任何類型的 SQL 語句。 傳回 boolean 值表示是否回傳 ResultSet。
     * executeBatch()：對於 PreparedStatement，主要用於當需要多次執行相同的SQL語句，但每次使用不同的參數值時。
     *                 PreparedStatement 通常會預先編譯SQL語句，從而提高執行效率。
     */
    public static ResultSet selectData(int id) {
        String sql = "SELECT * FROM people WHERE id = (?)";
        Connection connect = Utils.getConnect();
        try (PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<Map> maps = new ArrayList<>();
            while (resultSet.next()) {
                Map map = new HashMap();
                for(int i = 1 ; i <= columnCount; i++) {
                    //System.out.println(metaData.getColumnLabel(i));
                    //System.out.println(resultSet.getObject(i));
                    // metaData.getColumnLabel 有別名拿別名，沒別名拿數據庫列名
                    // metaData.getColumnName 拿數據庫列名
                    map.put(metaData.getColumnLabel(i),resultSet.getObject(i));
                }
                maps.add(map);
            }
            System.out.println(maps);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



//    /**
//     * PreparedStatement 插入資料
//     * @return 是否有異常
//     * PreparedStatement 物件用於執行參數化的 SQL 語句。 它通常用於 DML 操作，例如插入、更新和刪除資料行。
//     * PreparedStatement 可以預先編譯 SQL 語句，從而提高效能，並有助於防止 SQL 注入攻擊。
//     */
//    public static boolean updateData() {
//
//    }


    /**
     *
     * 數據庫中定義的儲存過程
     * CREATE PROCEDURE execute
     *     @x INT,
     *     @y INT
     * AS
     * BEGIN
     *     -- 儲存過程的實現邏輯
     * END
     * --------------------------
     * CallableStatement 範例
     */
    public static void executeFunc() {

        try {
            Connection connect = Utils.getConnect();

            // 創建CallableStatement對象
            CallableStatement stmt = connect.prepareCall("{CALL execute(?, ?)}");

            // 設定輸入參數
            stmt.setInt(1, 10);  // 假設x的值為10
            stmt.setInt(2, 20);  // 假設y的值為20

            // 執行儲存過程
            stmt.execute();

            // 清理資源
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        selectData(1);
        creatTable();
    }
}
