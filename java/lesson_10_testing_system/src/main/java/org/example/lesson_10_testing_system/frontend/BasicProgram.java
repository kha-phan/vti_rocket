package org.example.lesson_10_testing_system.frontend;

import java.io.IOException;
import java.sql.SQLException;

import org.example.lesson_10_testing_system.backend.Basic;
import org.example.lesson_10_testing_system.ultis.ScannerUtils;

public class BasicProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Basic program = new Basic();

		// Question 1:
		program.connect();

		// Question 2:
		program.readDataPosition();

		// Question 3:
		System.out.println("Input name: ");
		String name = ScannerUtils.inputName();
		program.createPosition(name);

		// Question 4:
		program.updatePositionName();

		// Question 5:
		System.out.println("Input id: ");
		int id = ScannerUtils.inputId();
		program.deleteDepartmentByID(id);

		// Close connection
		program.closeConnection();
	}

}
