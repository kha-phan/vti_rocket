package org.example.lesson_5_testing_system.entity.polymorphism.question5;

public class DienThoaiThongMinh extends DienThoaiDiDong {

	@Override
	public void tanCong() {
		System.out.println("Ném là vỡ màn ...");
	}

	public void suDung3G() {
		System.out.println("Sử dụng 3G ...");
	}

	public void chupHinh() {
		System.out.println("Chup hinh ...");
	}
}
