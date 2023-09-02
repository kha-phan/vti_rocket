package org.example.lesson_10_testing_system.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.lesson_10_testing_system.ultis.JdbcUtils;

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
public class Transaction {

	private JdbcUtils jdbcUtils;

	public Transaction() throws ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();
	}

	// Transaction
	public void deleteDepartmentUsingTransaction(int idDepartment) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// turn off auto commit
		connection.setAutoCommit(false);

		// delete employees
		String sql1 = "	DELETE FROM `Account` WHERE DepartmentID = ?";
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);

		// set parameter
		preparedStatement1.setInt(1, idDepartment);

		// delete department
		String sql2 = "	DELETE FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

		// set parameter
		preparedStatement2.setInt(1, idDepartment);

		// excute query
		try {
			preparedStatement1.executeUpdate();
			System.out.println("delete Account success!");

			preparedStatement2.executeUpdate();
			System.out.println("delete Department success!");

			// commit transaction
			connection.commit();
			System.out.println("Transaction Commit!");

		} catch (Exception e) {
			System.out.println(e.getMessage());

			connection.rollback();
			System.out.println("Transaction Rollback!");
		}

		// turn on auto commit
		connection.setAutoCommit(true);

		jdbcUtils.disconnect();
	}
}
