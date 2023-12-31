package org.example.lesson_7_testing_system.entity.finalEx2.question2;

public final class Student {

	private final int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + getId() + '\'' + "name='" + name + '\'' + '}';
	}
}
