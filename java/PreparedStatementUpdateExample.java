package org.example.lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementUpdateExample {
    private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/TestingSystem";
    private static String USER_NAME = "root";
    private static String PASSWORD = "rootroot";

    public static void main(String[] args) {
        String sqlUpdate = "UPDATE CategoryQuestion SET CategoryName = ? WHERE CategoryID = ?";
        String selectAll = "SELECT * FROM CategoryQuestion";
        try {
            // connect to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL,
                    USER_NAME, PASSWORD);

            // crate statement to insert CategoryQuestion
            PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
            stmt.setInt(2, 8);
            stmt.setString(1, "C++");
            int effectedRecordAmount = stmt.executeUpdate();
            System.out.println("Affected Record Amount: " + effectedRecordAmount);

            // select all CategoryQuestion
            stmt = conn.prepareStatement(selectAll);
            // get data from table 'CategoryQuestion'
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

