package org.example.lesson_8_testing_system.backend.collection;

import org.example.lesson_8_testing_system.entity.exercise1_2.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class SetQ1 {

	private Set<Student> students;
	private Scanner scanner;

	public SetQ1() {
		scanner = new Scanner(System.in);
		students = new HashSet<>();
		inputStudents();
	}

	private void inputStudents() {
		// Input list students by scanner
//		System.out.println("Nhập số lượng student muốn nhập: ");
//		int n = ScannerUtils.inputIntWithString(scanner);
//
//		for (int i = 0; i < n; i++) {
//			students.add(new Student());
//		}

		// fix list students for testing
		students.add(new Student("Thành"));
		students.add(new Student("Quang"));
		students.add(new Student("Kiên"));
		students.add(new Student("Duy"));
		students.add(new Student("Thắng"));
		students.add(new Student("Bích"));
	}

	public void printStudent() {
		Iterator<Student> studentIterator = students.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}
	}

	// a) In ra tổng số phần tử của students
	public void getAmountOfStudent() {
		System.out.println("Student Amount: " + students.size());
	}

	// b) Lấy phần tử thứ 4 của students
	public void getIndex4OfStudent() {
		Iterator<Student> studentIterator = students.iterator();
		for (int i = 0; i < 2; i++) {
			studentIterator.next();
		}

		System.out.println("Student thứ 4: ");
		System.out.println(studentIterator.next());
	}

	// c) In ra phần tử đầu và phần tử cuối của students
	public void printFirstAndLastStudent() {
		Iterator<Student> studentIterator = students.iterator();
		System.out.println("Student đầu tiên:");
		System.out.println(studentIterator.next());

		for (int i = 0; i < students.size() - 2; i++) {
			studentIterator.next();
		}

		System.out.println("Student cuối cùng: ");
		System.out.println(studentIterator.next());
	}

	// d) Thêm 1 phần tử vào vị trí đầu của students
	public void addStudentIntoFirstStudents() {

	}

	// e) Thêm 1 phần tử vào vị trí cuối của students
	public void addStudentIntoLastStudents() {

	}

	// f) Đảo ngược vị trí của students
	public void reverseStudents() {

	}

	// g) Tạo 1 method tìm kiếm student theo id
	public void findStudentById() {

	}

	// h) Tạo 1 method tìm kiếm student theo name
	public void findStudentByName() {

	}

	// i) Tạo 1 method để in ra các student có trùng tên
	public void findDuplicateStudent() {

	}

	// j) Xóa name của student có id = 2;
	public void deleteNameStudentId2() {

	}

	// k) Delete student có id = 5;
	public void deleteStudentId5() {

	}

	// l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
	// studentCopies
	public void addAllStudentsToStudentCopies() {

	}
}
