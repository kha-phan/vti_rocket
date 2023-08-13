package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.exercise1_2.Student;

public class Comparing {
	private List<Student> students;

	public Comparing() {
		students = new ArrayList<>();
		inputStudents();
	}

	private void inputStudents() {
		students.add(new Student("Kim", LocalDate.parse("2020-05-29"), 8));
		students.add(new Student("Kim", LocalDate.parse("2020-05-29"), 10));
		students.add(new Student("Kiên", LocalDate.parse("2015-05-04"), 6));
		students.add(new Student("Duy", LocalDate.parse("2020-01-29"), 5));
		students.add(new Student("Thắng", LocalDate.parse("2020-04-29"), 8));
		students.add(new Student("Bích", LocalDate.parse("2020-02-29"), 3));

		System.out.println("List student vừa khởi tạo: ");
		printStudent();
	}

	private void printStudent() {
		for (Student st : students) {
			System.out.println(st);
		}
	}

//	Question 1: Comparable 
//	In ra học sinh sắp xếp theo name
	public void question1() {
		Collections.sort(students);

		System.out.println("List sau khi sắp xếp theo tên/ ngày sinh/ điểm: ");
		printStudent();
	}

}
