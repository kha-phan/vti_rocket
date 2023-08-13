package com.vti.entity.abstraction.question5;

public class Khoi {

	private String ten;
	private String monThi;

	public String getMonThi() {
		if (ten.equals("A")) {
			monThi = "Toán, Lý, Hóa";

		} else if (ten.equals("B")) {
			monThi = "Toán, Hóa, Sinh";

		} else if (ten.equals("C")) {
			monThi = "Văn, Sử, Địa";

		} else {
			monThi = "Không xác định";
		}

		return monThi;

	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
}
