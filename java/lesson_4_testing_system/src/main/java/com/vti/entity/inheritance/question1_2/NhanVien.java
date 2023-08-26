package com.vti.entity.inheritance.question1_2;

import java.util.Scanner;

public class NhanVien extends CanBo {

	private String congViec;

	public String getCongViec() {
		return congViec;
	}

	@Override
	public void input() {
		super.input();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập công việc: ");
		congViec = scanner.nextLine();
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Công việc  : " + getCongViec());
	}

}
