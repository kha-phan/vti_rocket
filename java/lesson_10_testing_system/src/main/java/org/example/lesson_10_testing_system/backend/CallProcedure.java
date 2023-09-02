package org.example.lesson_10_testing_system.backend;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.example.lesson_10_testing_system.ultis.JdbcUtils;
import org.example.lesson_10_testing_system.ultis.properties.MessageProperties;

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
public class CallProcedure {

	private JdbcUtils jdbcUtils;

	private MessageProperties messagePoperties;

	private DepartmentDao departmentDao;

	public CallProcedure() throws ClassNotFoundException, IOException, SQLException {
		jdbcUtils = new JdbcUtils();

		messagePoperties = new MessageProperties();

		departmentDao = new DepartmentDao();
	}

	// Call Procedure
	public void deleteDepartmentUsingProcedure(int id) throws Exception {
		// check department id exist
		if (!departmentDao.isDepartmentIdExists(id)) {
			throw new Exception(
					messagePoperties.getProperty("department.getDepartmentByID.cannotFindDepartmentById") + id);
		}

		// if department id not exist delete

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "{CALL sp_delete_department(?)}";
		CallableStatement callabeStatement = connection.prepareCall(sql);

		// set parameter
		callabeStatement.setInt(1, id);

		// execute query
		callabeStatement.executeUpdate();

		// disconnect
		jdbcUtils.disconnect();
	}
}
