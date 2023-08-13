package com.vti.entity.polymorphism.question5;

public class DienThoaiCoDien extends DienThoaiDiDong {

	@Override
	public void tanCong() {
		System.out.println("Ném là chết chó...");
	}

	public void ngheDaiRadio() {
		System.out.println("Nghe Đài radio...");
	}
}
