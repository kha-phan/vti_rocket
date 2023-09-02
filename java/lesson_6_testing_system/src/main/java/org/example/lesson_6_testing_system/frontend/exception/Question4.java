package org.example.lesson_6_testing_system.frontend.exception;

import org.example.lesson_6_testing_system.entity.exercise1.Department;

public class Question4 {

	private static Department[] departments = new Department[3];

	public static void main(String[] args) {

		// Init Department
		Department department1 = new Department(1, "Sale");
		Department department2 = new Department(2, "Marketing");
		Department department3 = new Department(3, "BOD");

		departments[1] = department1;
		departments[2] = department2;
		departments[3] = department3;

		// Get index
		getIndex(5);
	}

	private static void getIndex(int index) {
		try {
			System.out.println(departments[index]);

		} catch (Exception e) {
			System.err.println("Cannot find department !");
		}

	}
}
