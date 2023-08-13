package com.vti.backend.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.vti.entity.exercise1_2.Student;
import com.vti.utils.ScannerUtils;

public class ListQ1 {

	private ArrayList<Student> students;
	private Scanner scanner;

	public ListQ1() {
		scanner = new Scanner(System.in);
		students = new ArrayList<>();
		inputStudents();
	}

	private void inputStudents() {
		// Input set students by scanner
//		System.out.println("Nhập số lượng student muốn nhập: ");
//		int n = ScannerUtils.inputIntWithString(scanner);
//
//		for (int i = 0; i < n; i++) {
//			students.add(new Student());
//		}

		// fix list students for testing
		students.add(new Student("Đăng"));
		students.add(new Student("Quý"));
		students.add(new Student("Kiên"));
		students.add(new Student("Duy"));
		students.add(new Student("Thắng"));
		students.add(new Student("Bích"));
	}

	public void printStudent() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	// a) In ra tổng số phần tử của students
	public void getAmountOfStudent() {
		System.out.println("Student Amount: " + students.size());
	}

	// b) Lấy phần tử thứ 4 của students
	public void getIndex4OfStudent() {
		System.out.println("Student thứ 4: ");
		System.out.println(students.get(3));
	}

	// c) In ra phần tử đầu và phần tử cuối của students
	public void printFirstAndLastStudent() {
		System.out.println(students.get(0));

		System.out.println(students.get(students.size() - 1));
	}

	// d) Thêm 1 phần tử vào vị trí đầu của students
	public void addStudentIntoFirstStudents() {
		students.add(0, new Student("Kiên"));

		System.out.println("List Students after adding: ");
		printStudent();
	}

	// e) Thêm 1 phần tử vào vị trí cuối của students
	public void addStudentIntoLastStudents() {
		students.add(students.size(), new Student("Quý"));

		System.out.println("List Students after adding: ");
		printStudent();
	}

	// f) Đảo ngược vị trí của students
	public void reverseStudents() {
		// reverse students
		Collections.reverse(students);

		System.out.println("List students after reverse: ");
		printStudent();
	}

	// g) Tạo 1 method tìm kiếm student theo id
	public void findStudentById() {
		System.out.println("Nhập id cần tìm: ");
		int id = ScannerUtils.inputIntWithString(scanner);

		for (Student student : students) {
			if (student.getId() == id) {
				System.out.println(student);
			}
		}
	}

	// h) Tạo 1 method tìm kiếm student theo name
	public void findStudentByName() {
		System.out.println("Nhập tên cần tìm: ");
		String name = ScannerUtils.inputStringWithString(scanner);

		for (Student student : students) {
			if (student.getName().equals(name)) {
				System.out.println(student);
			}
		}
	}

	// i) Tạo 1 method để in ra các student có trùng tên
	public void findDuplicateStudent() {
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				// So sánh tên của student
				if (students.get(i).getName().equals(students.get(j).getName())) {
					System.out.println("Các student trùng tên: ");
					System.out.println(students.get(i));
					System.out.println(students.get(j));
				}
			}
		}
	}

	// j) Xóa name của student có id = 2;
	public void deleteNameStudentId2() {
		for (Student student : students) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}

		System.out.println("Danh sách student sau khi xóa name id 2: ");
		printStudent();
	}

	// k) Delete student có id = 5;
	public void deleteStudentId5() {
		for (Student student : students) {
			if (student.getId() == 5) {
				students.remove(student);
			}
		}
	}

	// l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
	// studentCopies
	public void addAllStudentsToStudentCopies() {
		ArrayList<Student> studentCopies = new ArrayList<>();
		studentCopies.addAll(students);
	}
}
