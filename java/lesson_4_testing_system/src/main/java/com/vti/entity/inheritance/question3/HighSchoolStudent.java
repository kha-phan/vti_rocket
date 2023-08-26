package com.vti.entity.inheritance.question3;

public class HighSchoolStudent extends Student {

	private String clazz;
	private String desiredUniversity;

	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return "HighSchoolStudent{" + "id='" + super.getId() + '\'' + "name='" + super.getName() + '\'' + "clazz='"
				+ clazz + '\'' + ", desiredUniversity='" + desiredUniversity + '\'' + '}';
	}
}
