package org.example.TestingSystem_Assignment_11_Exercise_2.ultis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.example.TestingSystem_Assignment_11_Exercise_2.ultis.properties.DatabaseProperties;

public class JdbcUtils {

	private Connection connection;

	private DatabaseProperties databaseproperties;

	/**
	 * Constructor for class JdbcUtils.
	 * 
	 * @Description: .
	 * @author: DangBlack
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: DangBlack
	 * @modifer_date: May 26, 2020
	 * @throws IOException
	 */
	public JdbcUtils() throws IOException {
		databaseproperties = new DatabaseProperties();
	}

	/**
	 * This method is used for connecting to database.
	 * 
	 * @Description: .
	 * @author: DangBlack
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: DangBlack
	 * @modifer_date: May 26, 2020
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws SQLException
	 */
	public void connectForTesting()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = databaseproperties.getProperty("url");
		String username = databaseproperties.getProperty("username");
		String password = databaseproperties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(databaseproperties.getProperty("driver"));

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connect success!");
	}

	/**
	 * This method is used for connecting to database.
	 * 
	 * @Description: .
	 * @author: DangBlack
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: DangBlack
	 * @modifer_date: May 26, 2020
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws SQLException
	 */
	public Connection connect()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = databaseproperties.getProperty("url");
		String username = databaseproperties.getProperty("username");
		String password = databaseproperties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(databaseproperties.getProperty("driver"));

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

	/**
	 * This method is used for closing database.
	 * 
	 * @Description: .
	 * @author: DangBlack
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: DangBlack
	 * @modifer_date: May 26, 2020
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		connection.close();
	}
}
