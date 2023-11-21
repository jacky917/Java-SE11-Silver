package org.example.test_1Z0816.ch06;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.test_1Z0816.ch06.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
     * 🌟🌟🌟
     * 創建日期：2023/11/21
     * 最後一次查看：2023/11/21
     * 題目考點：
     * 需要補足知識：
     * 複習：
     * 總結：
     */
    public void test_sample() {
    }

}






