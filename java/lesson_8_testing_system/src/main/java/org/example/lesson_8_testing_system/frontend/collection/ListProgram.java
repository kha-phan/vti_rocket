package org.example.lesson_8_testing_system.frontend.collection;


import org.example.lesson_8_testing_system.backend.collection.ListQ1;

public class ListProgram {
	public static void main(String[] args) {
		question1();
	}

	// Question 1: List
	// Tạo 1 student có property id, name (trong đó có 3 student có name
	// trùng nhau, id sẽ là auto increment)
	// Khai báo 1 ArrayList students, sau đó
	// a) In ra tổng số phần tử của students
	// b) Lấy phần tử thứ 4 của students
	// c) In ra phần tử đầu và phần tử cuối của students
	// d) Thêm 1 phần tử vào vị trí đầu của students
	// e) Thêm 1 phần tử vào vị trí cuối của students
	// f) Đảo ngược vị trí của students
	// g) Tạo 1 method tìm kiếm student theo id
	// h) Tạo 1 method tìm kiếm student theo name
	// i) Tạo 1 method để in ra các student có trùng tên
	// j) Xóa name của student có id = 2;
	// k) Delete student có id = 5;
	// l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
	// studentCopies
	public static void question1() {

		ListQ1 list = new ListQ1();

		// a
		list.getAmountOfStudent();

		// b
		list.getIndex4OfStudent();

		// c
		list.printFirstAndLastStudent();

		// d
		list.addStudentIntoFirstStudents();

		// e
		list.addStudentIntoLastStudents();

		// f
		list.reverseStudents();

		// g
		list.findStudentById();

		// h
		list.findStudentByName();

		// i
		list.findDuplicateStudent();

		// j
		list.deleteNameStudentId2();
	}
}
