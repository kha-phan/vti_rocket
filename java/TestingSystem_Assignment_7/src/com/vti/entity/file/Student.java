package com.vti.entity.file;

import java.io.Serializable;

import com.vti.ultis.ScannerUtils;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int counter = 0;

	private int id;
	private String name;

	public Student() {
		this.id = ++counter;
		input();
	}

	public Student(String name) {
		this.name = name;
	}

	private void input() {
		System.out.println("Input name: ");
		name = ScannerUtils.inputName();
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
