package com.vti.entity.polymorphism.question3;

public class HinhVuong extends HinhChuNhat {

	public float tinhChuVi(float a) {
		return super.tinhChuVi(a, a);
	}

	public float tinhDienTich(float a) {
		return this.tinhDienTich(a, a);
	}
}
