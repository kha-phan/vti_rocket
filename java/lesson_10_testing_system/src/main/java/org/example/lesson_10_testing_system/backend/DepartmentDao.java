package org.example.lesson_10_testing_system.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.lesson_10_testing_system.entity.Department;
import org.example.lesson_10_testing_system.ultis.JdbcUtils;
import org.example.lesson_10_testing_system.ultis.properties.MessageProperties;

/**
 * This class is dao of department.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 26, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 26, 2020
 */
public class DepartmentDao {

	private JdbcUtils jdbcUtils;

	private MessageProperties messagePoperties;

	/**
	 * Constructor for class DepartmentDao.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DepartmentDao() throws IOException, SQLException, ClassNotFoundException {
		jdbcUtils = new JdbcUtils();

		messagePoperties = new MessageProperties();
	}

	/**
	 * This method is used for getting department.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @return List<Department>
	 * 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<Department> getDepartments()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		List<Department> departments = new ArrayList<>();

		// Step 2: get connection
		Connection connection = jdbcUtils.connect();

		// Step 3: Create a statement object
		Statement statement = connection.createStatement();

		// Step 4: execute query
		String sql = "SELECT * FROM Department";
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: handling result set
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			departments.add(department);
		}

		// disconnect
		jdbcUtils.disconnect();

		return departments;
	}

	/**
	 * This method is used for getting department by ID.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @param id
	 * @return Department
	 * 
	 * @throws Exception
	 */
	public Department getDepartmentByID(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT * FROM Department WHERE DepartmentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			jdbcUtils.disconnect();
			return department;

		} else {
			jdbcUtils.disconnect();
			throw new Exception(
					messagePoperties.getProperty("department.getDepartmentByID.cannotFindDepartmentById") + id);
		}
	}

	/**
	 * This method is check department name exists?.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @param name
	 * @return boolean
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean isDepartmentNameExists(String name) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;

		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	/**
	 * This method is used for creating department.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @param name
	 * @throws Exception
	 */
	public void createDepartment(String name) throws Exception {

		// check name exist
		if (isDepartmentNameExists(name)) {
			throw new Exception(
					messagePoperties.getProperty("department.getDepartmentByID.departmentNameIsExists") + name);
		}

		// get connection
		Connection connection = jdbcUtils.connect();

		// if not exist
		// Create a statement object
		String sql = "	INSERT INTO Department (DepartmentName)" + "	VALUE				(   ?	)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		preparedStatement.executeUpdate();

		// disconnect
		jdbcUtils.disconnect();
	}

	/**
	 * This method is check department id exists?.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @param id
	 * @return boolean
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean isDepartmentIdExists(int id) throws SQLException, IOException, ClassNotFoundException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;

		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	/**
	 * This method is used for updating department.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 26, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 26, 2020
	 * @param id
	 * @param newName
	 * @throws SQLException
	 * @throws Exception
	 */
	public void updateDepartment(int id, String newName) throws SQLException, Exception {

		// check department id exist
		if (!isDepartmentIdExists(id)) {
			throw new Exception(
					messagePoperties.getProperty("department.getDepartmentByID.cannotFindDepartmentById") + id);
		}

		// if department name not exist update

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "	UPDATE Department SET DepartmentName = ? WHERE DepartmentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);

		// Step 4: execute query
		preparedStatement.executeUpdate();

		// disconnect
		jdbcUtils.disconnect();
	}

	public void deleteDepartment(int id) throws Exception {

		// check department id exist
		if (!isDepartmentIdExists(id)) {
			throw new Exception(
					messagePoperties.getProperty("department.getDepartmentByID.cannotFindDepartmentById") + id);
		}

		// if department id not exist delete

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "DELETE FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		preparedStatement.executeUpdate();

		// disconnect
		jdbcUtils.disconnect();
	}

}
