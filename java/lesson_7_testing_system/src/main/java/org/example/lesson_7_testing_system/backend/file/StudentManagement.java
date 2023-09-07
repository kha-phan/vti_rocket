package org.example.lesson_7_testing_system.backend.file;

import org.example.lesson_7_testing_system.entity.file.Student;
import org.example.lesson_7_testing_system.ultis.IOStream;
import org.example.lesson_7_testing_system.ultis.ScannerUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {

	private List<Student> students;
	private String pathFile;

	public StudentManagement() {
		students = new ArrayList<>();
		pathFile = "C:\\Users\\pc\\eclipse-workspace\\TestingSystem_Assignment_71\\src\\resources\\StudentInformation.ser";
	}

	public void inputListStudents() {
		System.out.println("Input number student: ");
		int n = ScannerUtils.inputInt();

		// input list student
		for (int i = 0; i < n; i++) {
			students.add(new Student());
		}
	}

	public void printListStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void writeStudents() throws Exception {
		IOStream.writeObject(students, pathFile);
	}

	@SuppressWarnings("unchecked")
	public void readStudents() throws Exception {
		students = (List<Student>) IOStream.readObject(pathFile);
	}
}
