package org.example.TestingSystem_Assignment_11_Exercise_2.backend.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_2.entiy.Account;
import org.example.TestingSystem_Assignment_11_Exercise_2.ultis.JdbcUtils;
import org.example.TestingSystem_Assignment_11_Exercise_2.ultis.properties.MessageProperties;

public class AccountRepository implements IAccountRepository {

	private JdbcUtils jdbcUtils;
	private MessageProperties messageProperties;

	public AccountRepository() throws IOException {

		jdbcUtils = new JdbcUtils();

		messageProperties = new MessageProperties();
	}

	@Override
	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {

		List<Account> accounts = new ArrayList<>();

		// get connection
		Connection connection = jdbcUtils.connect();

		// create a statement object
		String sql = "SELECT AccountId, Email, Username, FullName FROM `Account`";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// Handing result set
		while (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountId"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"));

			accounts.add(account);
		}

		// disconnect
		jdbcUtils.disconnect();
		return accounts;

	}

	@Override
	public Account getAccountByID(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT * FROM Account WHERE AccountId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			Account account = new Account(resultSet.getInt("AccountId"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("FullName"));

			// disconnect
			jdbcUtils.disconnect();
			return account;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			throw new Exception(messageProperties.getProperty("account.getAccountByID.cannotFindAccountById") + id);
		}
	}

	@Override
	public boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM `Account` WHERE Username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, username);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			// disconnect
			jdbcUtils.disconnect();
			return true;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			return false;
		}
	}

	@Override
	public boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM Account WHERE AccountId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			// disconnect
			jdbcUtils.disconnect();
			return true;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			return false;
		}
	}

	@Override
	public void createAccount(String email, String username, String fullName) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// if not exist
		// Create a statement object
		String sql = "INSERT INTO Account (Email, Username, Fullname)" + "VALUE              (   ? ,   ?   	,   ?	)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, username);
		preparedStatement.setString(3, fullName);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check create success or false
		System.out.println(check > 0 ? messageProperties.getProperty("account.insert.complete")
				: messageProperties.getProperty("account.insert.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

	@Override
	public void updateAccountByID(int id, String newFullName) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "UPDATE Account SET FullName = ? WHERE AccountId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, newFullName);
		preparedStatement.setInt(2, id);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check check success or false
		System.out.println(check > 0 ? messageProperties.getProperty("account.update.complete")
				: messageProperties.getProperty("account.update.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

	@Override
	public void deleteAccount(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "DELETE FROM Account WHERE AccountId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check check success or false
		System.out.println(check > 0 ? messageProperties.getProperty("account.delete.complete")
				: messageProperties.getProperty("account.delete.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

}
