package org.example.lesson_9_testing_system.frontend;

import java.util.Date;

import org.example.lesson_9_testing_system.backend.Annotations;

public class AnnotationProgram {

	public static void main(String[] args) {
		Annotations annotations = new Annotations();

		quesiton1();
		annotations.question2();
	}

	// Question 1: @Deprecated
	// Khai báo 1 instance có datatype Date và có value là ngày 18/05/2020.
	// Bạn sẽ thấy java cảnh báo, hãy tắt cảnh báo này đi
	@SuppressWarnings("deprecation")
	public static void quesiton1() {
		Date date = new Date(2020, 4, 29);
		System.out.println(date);
	}
}
