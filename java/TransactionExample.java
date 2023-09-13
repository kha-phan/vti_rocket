package org.example.lesson1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TransactionExample {

    public static void main(String args[]) {
        try {
            Connection conn = getConnection();
            // turn off auto commit
            conn.setAutoCommit(false);

            try {
                createQuestion(conn);
                createAnswer(conn);
                conn.commit();
                System.out.println("Transaction Commit");

            } catch (Exception e) {
                e.printStackTrace();
                conn.rollback();
                System.out.println("Transaction Rollback");
            }
            // turn on auto commit
            conn.setAutoCommit(true);
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(
                "/Users/rainee/Project/JAVA/lesson1/src/main/resources/database.properties"));
        String dbURL = properties.getProperty("url");
        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");
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

    public static void createQuestion(Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO Question VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sqlInsert);
        stmt.setInt(1, 21);
        stmt.setString(2, "Hỏi về Java 1234");
        stmt.setInt(3, 2);
        stmt.setInt(4, 2);
        stmt.setInt(5, 2);
        stmt.setString(6, "2023-03-03");
        int effectedRecordAmount = stmt.executeUpdate();
        System.out.println("Affected Record Amount: " + effectedRecordAmount);
    }

    public static void createAnswer(Connection conn) throws SQLException {
        String sqlInsert = "INSERT INTO Answer VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sqlInsert);
        stmt.setInt(1, 21);
        stmt.setString(2, "Trả lời về Java 123");
        stmt.setInt(3, 21);
        stmt.setInt(4, 1);
        int effectedRecordAmount = stmt.executeUpdate();
        System.out.println("Affected Record Amount: " + effectedRecordAmount);
    }
}

