package org.example.lesson_6_testing_system.frontend.exception;


import org.example.lesson_6_testing_system.entity.exercise1.Department;
import org.example.lesson_6_testing_system.entity.exercise1.Position;

public class Question9 {
	public static void main(String[] args) {

		// department
		System.out.println("Nhập thông tin department: ");
		Department department = new Department();
		System.out.println(department);

		// position
		System.out.println("Nhập thông tin position: ");
		Position position = new Position();
		System.out.println(position);
	}
}
