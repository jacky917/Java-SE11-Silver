package org.example.test_1Z0816.ch06;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.test_1Z0816.ch06.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * 🌟
     * 創建日期：2023/12/15
     * 最後一次查看：2023/12/15
     * 題目考點：JDBC
     * 需要補足知識：-
     * 複習：-
     * 總結：DBMS 的全寫是 "Database Management System"，即“數據庫管理系統”。
     */
    public void test_q01() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/21
     * 最後一次查看：2023/11/21
     * 題目考點：prepareStatement
     * 需要補足知識：數據庫的下標都是從1開始的
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q07() {
        Connection connect = Utils.getConnect();
        try(PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM people WHERE id = (?)")) {
            preparedStatement.setInt(0,5); // 報錯
            System.out.println(preparedStatement.executeUpdate());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/11/21
     * 最後一次查看：2023/11/21
     * 題目考點：prepareStatement
     * 需要補足知識：executeUpdate
     * 複習：查看以下代碼
     * 總結：-
     */
    public void test_q10() {
        Connection connect = Utils.getConnect();
        try(PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM people WHERE id = (?)")) {
            preparedStatement.setInt(0,5); // 報錯
            // 這是提供給 Statement（靜態sql） 使用的
            System.out.println(preparedStatement.executeUpdate("DELETE FROM people WHERE id = (?)"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/15
     * 最後一次查看：2023/12/15
     * 題目考點：PreparedStatement
     * 需要補足知識：PreparedStatement
     * 複習：查看 o01
     * 總結：ResultSet 的指針最初位於第一條數據之前，需要通過 next() 方法來遍歷結果集中的數據。
     */
    public void test_q11() {
    }

    /**
     * 🌟🌟🌟🌟
     * 創建日期：2023/12/15
     * 最後一次查看：2023/12/15
     * 題目考點：PreparedStatement
     * 需要補足知識：execute
     * 複習：查看 o01
     * 總結：execute()：執行任何類型的 SQL 語句。 傳回 boolean 值表示是否回傳 ResultSet。
     */
    public void test_q12() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/15
     * 最後一次查看：2023/12/15
     * 題目考點：Statement
     * 需要補足知識：executeBatch
     * 複習：查看以下代碼
     * 總結：
     * 1.Statement,PreparedStatement 和 CallableStatement 都有 executeBatch 方法。
     * 2.用於提高數據庫操作效率。
     */
    public void test_q13() throws SQLException {
        Connection connect = Utils.getConnect();
        Statement stmt = connect.createStatement();
        stmt.addBatch("INSERT INTO table_name VALUES (1, 'A')");
        stmt.addBatch("INSERT INTO table_name VALUES (2, 'B')");
        stmt.addBatch("UPDATE table_name SET column='C' WHERE id=1");
        int[] updateCounts = stmt.executeBatch();
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/15
     * 最後一次查看：2023/12/15
     * 題目考點：CallableStatement
     * 需要補足知識：儲存過程
     * 複習：查看 o01
     * 總結：
     * 1.調用儲存過程要有 CALL 關鍵字。
     * 2.ストアドプロシージャ stored procedure 儲存過程。
     */
    public void test_q14() {
    }

    /**
     * 🌟🌟🌟
     * 創建日期：2023/12/15
     * 最後一次查看：2023/12/15
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






