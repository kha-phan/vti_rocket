package com.vti.entity.inheritance.question1_2;

import java.util.Scanner;

public class CanBo {

	private String hoTen;
	private byte tuoi;
	private Gender gioiTinh;
	private String diaChi;

	public CanBo() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public Byte getTuoi() {
		return tuoi;
	}

	public Gender getGioiTinh() {
		return gioiTinh;
	}

	private void setGioiTinh(int gioiTinh) {
		if (gioiTinh == 0) {
			this.gioiTinh = Gender.valueOf("MALE");
		} else if (gioiTinh == 1) {
			this.gioiTinh = Gender.valueOf("FEMALE");
		} else {
			this.gioiTinh = Gender.valueOf("UNKNOWN");
		}
	}

	public String getDiachi() {
		return diaChi;
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập họ tên: ");
		hoTen = scanner.nextLine();

		System.out.println("Nhập tuổi: ");
		tuoi = scanner.nextByte();

		System.out.println("Nhập giới tính (0:Nam, 1:Nữ, khác: Unknown): ");
		setGioiTinh(scanner.nextInt());

		System.out.println("Nhập địa chỉ: ");
		diaChi = scanner.nextLine();
	}

	public void getInfor() {
		System.out.println("Họ tên      : " + hoTen);
		System.out.println("Tuổi        : " + tuoi);
		System.out.println("Giới tính   : " + gioiTinh);
		System.out.println("Địa chỉ     : " + diaChi);
	}

	@Override
	public String toString() {
		return "CanBo{" + "hoten='" + hoTen + '\'' + ", tuoi=" + tuoi + ", gt=" + gioiTinh + ", diachi='" + diaChi
				+ '\'' + '}';
	}
}
