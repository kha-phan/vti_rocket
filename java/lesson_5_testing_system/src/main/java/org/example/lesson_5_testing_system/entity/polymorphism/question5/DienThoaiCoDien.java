package org.example.lesson_5_testing_system.entity.polymorphism.question5;

public class DienThoaiCoDien extends DienThoaiDiDong {

	@Override
	public void tanCong() {
		System.out.println("Ném là chết chó...");
	}

	public void ngheDaiRadio() {
		System.out.println("Nghe Đài radio...");
	}
}
