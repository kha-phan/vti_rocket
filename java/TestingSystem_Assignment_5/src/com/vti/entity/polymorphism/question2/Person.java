package com.vti.entity.polymorphism.question2;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {

	private String name;
	private Gender gender;
	private LocalDate birthday;
	private String address;

	public Person() {
		inputInfo();
	}

	public Person(String name, Gender gender, LocalDate birthday, String address) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	protected void inputInfo() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập tên:");
		name = scanner.nextLine();

		System.out.println("Nhập giới tính (0:Nam,1:Nữ, Khác: UNKNOWN): ");
		byte choose = scanner.nextByte();

		switch (choose) {
		case 0:
			gender = Gender.valueOf("MALE");
			break;

		case 1:
			gender = Gender.valueOf("FEMALE");
			break;

		default:
			gender = Gender.valueOf("UNKNOWN");
			break;
		}

		System.out.println("Nhập ngày sinh (yyyy-MM-dd): ");
		birthday = LocalDate.parse(scanner.nextLine());

		System.out.println("Nhập địa chỉ: ");
		address = scanner.nextLine();
	}

	public void showInfo() {
		System.out.println("Tên: " + name);
		System.out.println("Giới tính: " + gender);
		System.out.println("Ngày sinh: " + birthday);
		System.out.println("Địa chỉ: " + address);
	}
}
