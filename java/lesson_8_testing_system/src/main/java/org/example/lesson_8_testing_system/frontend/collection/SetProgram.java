package org.example.lesson_8_testing_system.frontend.collection;


import org.example.lesson_8_testing_system.backend.collection.SetQ1;

public class SetProgram {
	public static void main(String[] args) {
		question3();
	}

//	Question 3: Set 
//	Tạo 1 student có property id, name (trong đó có 3 student có name trùng nhau, id sẽ là auto increment)
//
//	Khai báo 1 Set students, sau đó 
//	a)	In ra tổng số phần tử của students
//	b)	Lấy phần tử thứ 4 của students
//	c)	In ra phần tử đầu và phần tử cuối của students
//	d)	Thêm 1 phần tử vào vị trí đầu của students
//	e)	Thêm 1 phần tử vào vị trí cuối của students
//	f)	Đảo ngược vị trí của students
//	g)	Tạo 1 method tìm kiếm student theo id
//	h)	Tạo 1 method tìm kiếm student theo name
//	i)	Tạo 1 method để in ra các student có trùng tên
//	j)	Xóa name của student có id = 2;
//	k)	Delete student có id = 5;
//	l)	Tạo 1 Set tên là studentCopies và add tất cả students vào studentCopies

	private static void question3() {
		SetQ1 set = new SetQ1();

		// a
		set.getAmountOfStudent();

		// b
		set.getIndex4OfStudent();

		// c
		set.printFirstAndLastStudent();

		// d
		set.addStudentIntoFirstStudents();

		// e
		set.addStudentIntoLastStudents();

		// f
		set.reverseStudents();

		// g
		set.findStudentById();

		// h
		set.findStudentByName();

		// i
		set.findDuplicateStudent();

		// j
		set.deleteNameStudentId2();
	}
}
