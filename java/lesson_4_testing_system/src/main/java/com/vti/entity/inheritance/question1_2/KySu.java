package com.vti.entity.inheritance.question1_2;

import java.util.Scanner;

public class KySu extends CanBo {

	private String nganhDaoTao;

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	@Override
	public void input() {
		super.input();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập ngành đào tạo: ");
		nganhDaoTao = scanner.nextLine();
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Ngành đào tạo  : " + nganhDaoTao);
	}
}
