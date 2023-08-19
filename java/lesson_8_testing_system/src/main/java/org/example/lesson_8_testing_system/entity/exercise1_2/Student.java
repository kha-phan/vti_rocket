package org.example.lesson_8_testing_system.entity.exercise1_2;

import org.example.lesson_8_testing_system.utils.ScannerUtils;

import java.time.LocalDate;
import java.util.Scanner;



public class Student implements Comparable<Student> {
	private static int counter = 0;

	private int id;
	private String name;
	private LocalDate birthDay;
	private int score;

	public Student() {
		inputStudent();
		setId(++counter);
	}

	public Student(String name) {
		this.name = name;
		setId(++counter);
	}

	public Student(String name, LocalDate birthDay, int score) {
		this.name = name;
		this.birthDay = birthDay;
		this.score = score;
		setId(++counter);
	}

	private void inputStudent() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập tên student: ");
		name = ScannerUtils.inputString(scanner, "Please input a name as String...");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", birthDay=" + birthDay + ", score=" + score + '}';
	}

	@Override
	public int compareTo(Student student) {
		if (name.compareTo(student.name) > 0) {
			return 1;
		}

		if (name.compareTo(student.name) < 0) {
			return -1;
		}

		return 0;
	}
}
