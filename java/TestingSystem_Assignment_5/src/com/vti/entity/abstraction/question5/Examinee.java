package com.vti.entity.abstraction.question5;

import java.util.Scanner;

public class Examinee {

	private String sbd;
	private String hoTen;
	private String diaChi;
	private byte mucUuTien;
	private Khoi khoi;

	public String getSbd() {
		return sbd;
	}

	public void nhap() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập số báo danh: ");
		sbd = scanner.nextLine();

		System.out.println("Nhập họ tên: ");
		hoTen = scanner.nextLine();

		System.out.println("Nhập địa chỉ: ");
		diaChi = scanner.nextLine();

		System.out.println("Nhập mức ưu tiên: ");
		mucUuTien = scanner.nextByte();

		System.out.println("Nhập khối A/B/C");
		khoi = new Khoi();
		khoi.setTen(scanner.nextLine());
	}

	@Override
	public String toString() {
		return "Examinee{" + "sbd='" + sbd + '\'' + ", hoTen='" + hoTen + '\'' + ", diaChi='" + diaChi + '\''
				+ ", mucUuTien=" + mucUuTien + ", khoi=" + khoi.getMonThi() + '}';
	}
}
