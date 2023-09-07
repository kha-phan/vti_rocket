package org.example.lesson_7_testing_system.entity.staticEx1;

public final class PrimaryStudent extends Student {

	public static int counterPrimary = 0;

	public PrimaryStudent(String name) throws Exception {
		super(name);
		counterPrimary++;
	}
}
