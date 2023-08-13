package com.vti.entity.inheritance.question4;

import java.util.Scanner;

public class Bao extends TaiLieu {

	private String ngayPhatHanh;

	@Override
	public void input() {
		super.input();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập ngày phát hành: ");
		ngayPhatHanh = scanner.nextLine();
	}

	@Override
	public void getInfor() {
		super.getInfor();

		System.out.println("Ngày phát hành: " + getNgayPhatHanh());
	}

	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

}
