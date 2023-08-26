package com.vti.entity.encapsulation.ex2;

/*
Exercise 4 : Encapsulation
	Question 1:
		Tạo Object Student có các property id, name, hometown, điểm học lực
		a) Tất cả các property sẽ để là private để các class khác không
		chỉnh sửa hay nhìn thấy
		b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
		dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
		c) Tạo 1 method cho phép set điểm vào
		d) Tạo 1 method cho phép cộng thêm điểm
		e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
		điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
		4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
		thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
		Demo các chức năng trên bằng class ở front-end.
*/

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
