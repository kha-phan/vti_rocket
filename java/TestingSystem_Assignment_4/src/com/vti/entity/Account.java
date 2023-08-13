package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {

	private int id;
	private String email;
	private String username;
	private String fullname;
	private Department department;
	private Position position;
	private LocalDate createDate;
	private Group[] groups;

	public Account() {
	}

	public Account(int id, String email, String username, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = firstName + " " + lastName;
	}

	public Account(int id, String email, String username, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = firstName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	public Account(int id, String email, String username, String firstName, String lastName, Position position,
			LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

	public Account(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", email='" + email + '\'' + ", username='" + username + '\'' + ", fullname='"
				+ fullname + '\'' + ", department=" + department + ", position=" + position + ", createDate="
				+ createDate + ", groups=" + Arrays.toString(groups) + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

}
