package org.example.test_1Z0816.ch06.util;

import java.sql.*;

public class Utils {


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
