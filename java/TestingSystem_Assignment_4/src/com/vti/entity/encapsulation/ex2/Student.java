package com.vti.entity.encapsulation.ex2;

public class Student {

	private int id;
	private String name;
	private String hometown;
	private float score;

	public Student(String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.score = 0;
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void plusScore(float score) {
		this.score += score;
	}

	@Override
	public String toString() {
		String grade;
		if (score < 4.0) {
			grade = "Yếu";
		} else if (score < 6) {
			grade = "Trung bình";
		} else if (score < 8) {
			grade = "Khá";
		} else {
			grade = "Giỏi";
		}

		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", hometown='" + hometown + '\'' + ", score="
				+ score + ", xepLoai='" + grade + '\'' + '}';
	}
}
