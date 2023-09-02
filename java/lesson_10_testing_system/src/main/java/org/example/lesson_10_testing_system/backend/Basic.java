package org.example.lesson_10_testing_system.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 26, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 26, 2020
 */
public class Basic {

	private Properties properties;
	private Connection connection;

	public Basic() throws FileNotFoundException, IOException {
		properties = new Properties();

		properties.load(new FileInputStream(
				"/Users/rainee/Project/vti_rocket/java/lesson_10_testing_system/src/main/resources/database.properties"));

		properties.load(new FileInputStream(
				"/Users/rainee/Project/vti_rocket/java/lesson_10_testing_system/src/main/resources/message.properties"));
	}

	// Question 1: (Sử dụng Database Testing System đã xây dựng ở SQL)
	// Tạo connection tới database Testing System
	// In ra "Connect success!" khi kết nối thành công.
	public void connect() throws IOException, ClassNotFoundException, SQLException {

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		// Register the drive class with DriveManager
		Class.forName(properties.getProperty("driver"));

		// Step 2: Get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		System.out.println(properties.getProperty("connect.success"));
	}

	// Question 2:
	// Tạo method để in ra các thông tin của position gồm có id, name
	public void readDataPosition() throws SQLException, ClassNotFoundException, IOException {

		// Step 3: Create a statement object
		Statement statement = connection.createStatement();

		// Step 4: Execute SQL Query
		String sql = "SELECT * FROM `Position`";
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: Handing Result Set
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("PositionID"));
			System.out.println(resultSet.getString("PositionName"));
		}
	}

	// Question 3:
	// Tạo method để tạo position, user sẽ nhập vào name và id.
	public void createPosition(String name) throws SQLException {
		// Create a statement object

		String sql = "	INSERT INTO `Position` (	PositionName	) "
				+ "	VALUE 					(		?			)";
		PreparedStatement statement = connection.prepareStatement(sql);

		// set parameter
		statement.setString(1, name);

		// Execute SQL Query with executeUpdate
		int effectedRecordAmount = statement.executeUpdate();

		// Handing result set
		if (effectedRecordAmount == 1) {
			System.out.println(properties.getProperty("position.insert.complete"));
		} else {
			System.out.println(properties.getProperty("position.insert.false"));
		}
	}

	// Question 4:
	// Tạo method để update tên của position gồm có id = 5 thành "Developer".
	public void updatePositionName() throws SQLException {

		// Create a statement object
		Statement statement = connection.createStatement();

		// Execute SQL Query with executeUpdate
		String sql = "UPDATE `Position` SET PositionName = 'Dev' WHERE PositionID = 5";
		int effectedRecordAmount = statement.executeUpdate(sql);

		// Handing result set
		if (effectedRecordAmount == 1) {
			System.out.println(properties.getProperty("position.update.complete"));
		} else {
			System.out.println(properties.getProperty("position.update.false"));
		}
	}

	// Question 5:
	// Tạo method để delete của Department theo id và user sẽ nhập vào id
	public void deleteDepartmentByID(int id) throws SQLException {

		// Create a statement object
		String sql = " DELETE FROM `Position` WHERE PositionID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		// set parameter
		statement.setInt(1, id);

		// Execute SQL Query with executeUpdate
		int effectedRecordAmount = statement.executeUpdate();

		// Handing result set
		if (effectedRecordAmount > 0) {
			System.out.println(properties.getProperty("position.delete.complete"));
		} else {
			System.out.println(properties.getProperty("position.delete.false"));
		}
	}

	public void closeConnection() throws SQLException {
		// Close connection
		connection.close();
	}

}
