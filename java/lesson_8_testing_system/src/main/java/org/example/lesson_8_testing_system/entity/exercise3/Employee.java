package org.example.lesson_8_testing_system.entity.exercise3;

import java.util.Arrays;

public class Employee<T> {

	private int id;
	private String name;
	private T[] salaries;

	public Employee(int id, String name, T[] salaries) {

		this.id = id;
		this.name = name;
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salaries=" + Arrays.toString(salaries) + '}';
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

	public T[] getSalaries() {
		return salaries;
	}

	public void setSalaries(T[] salaries) {
		this.salaries = salaries;
	}
}
