package org.example.lesson_9_testing_system.entity;

public class Student {

	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @deprecated replace by {@link #getIdV2()}
	 * 
	 */
	@Deprecated
	public int getId() {
		return id;
	}

	public String getIdV2() {
		return "MSV" + id;
	}

	public String getName() {
		return name;
	}

}
