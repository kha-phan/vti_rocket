package org.example.lesson_6_testing_system.frontend.exception;


import org.example.lesson_6_testing_system.utils.ScannerUtils;

public class Question56 {
	public static void main(String[] args) {

		System.out.println("Nhập tuổi: ");
		int age = ScannerUtils.inputAge();

		System.out.println("Tuổi của bạn: " + age);
	}
}
