package org.example.lesson1;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class GetPropertiesExample {

    public static void main(String args[]) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(
                    "/Users/rainee/Project/JAVA/lesson1/src/main/resources/database.properties"));

            String DB_URL = properties.getProperty("url");
            String USER_NAME = properties.getProperty("username");
            String PASSWORD = properties.getProperty("password");

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);

            String sql = "{CALL sp_maxContentWithTypeID(?)}";
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, "Essay");
            int effectedRecordCount = callableStatement.executeUpdate();
            System.out.println("Effected Record Count: " + effectedRecordCount);

            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}

