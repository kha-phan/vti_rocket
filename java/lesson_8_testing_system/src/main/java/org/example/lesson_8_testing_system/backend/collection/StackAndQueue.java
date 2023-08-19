package org.example.lesson_8_testing_system.backend.collection;

import org.example.lesson_8_testing_system.entity.exercise1_2.Student;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class StackAndQueue {

//	Question 2: Stack & Queue
//	Khai báo 1 danh sách lưu các tên học sinh tới tham dự phỏng vấn, thứ tự tới của các học sinh như sau:
//	Nguyễn Văn Nam, Nguyễn Văn Huyên, Trần Văn Nam, Nguyễn Văn A
//	a)	Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự sớm nhất tới muộn nhất (gợi ý dùng Stack)
//	b)	Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự từ muộn nhất tới sớm nhất (gợi ý dùng Queue)
	public void question2() {

		System.out.println("Thứ tự student đến phỏng vấn từ sớm nhất đến muộn nhất: ");
		printStudentComeEarly();

		System.out.println("Thứ tự student đến phỏng vấn từ muộn nhất đến sớm nhất: ");
		printStudentComeLate();
	}

	public void printStudentComeEarly() {
		// init data
		Stack<Student> students = new Stack<>();
		students.push(new Student("Nguyễn Văn A"));
		students.push(new Student("Trần Văn Nam"));
		students.push(new Student("Nguyễn Văn Huyên"));
		students.push(new Student("Nguyễn Văn Nam"));

		// Sử dụng pop để lấy Data Element trong stack
		System.out.println(students.pop());
		System.out.println(students.pop());
		System.out.println(students.pop());
		System.out.println(students.pop());
	}

	public void printStudentComeLate() {
		// init data
		Queue<Student> students = new LinkedList<>();
		students.add(new Student("Nguyễn Văn A"));
		students.add(new Student("Trần Văn Nam"));
		students.add(new Student("Nguyễn Văn Huyên"));
		students.add(new Student("Nguyễn Văn Nam"));

		// Sử dụng poll để lấy Data Element trong stack
		System.out.println(students.poll());
		System.out.println(students.poll());
		System.out.println(students.poll());
		System.out.println(students.poll());

	}
}
