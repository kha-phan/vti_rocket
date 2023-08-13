package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.inheritance.question1_2.CanBo;
import com.vti.entity.inheritance.question1_2.CongNhan;
import com.vti.entity.inheritance.question1_2.KySu;
import com.vti.entity.inheritance.question1_2.NhanVien;

//Question 2: Tiếp tục Question 1
//Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
//a)	Thêm mới cán bộ.
//b)	Tìm kiếm theo họ tên.
//c)	Hiện thị thông tin về danh sách các cán bộ.
//d)	Nhập vào tên của cán bộ và delete cán bộ đó
//e)	Thoát khỏi chương trình.

public class QLCB {

	private ArrayList<CanBo> canBos;

	public QLCB() {
		canBos = new ArrayList<>();
	}

	// a) Thêm mới cán bộ.
	public void addCanBo() {
		int n;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập số cán bộ muốn nhập:  ");
		n = scanner.nextInt();

		byte choose;
		CanBo canBo = new CanBo();
		for (int i = 0; i < n; i++) {
			System.out.println("Bạn muốn nhập cán bộ nào? (1:Công nhân || 2: Kỹ sư || 3: Nhân Viên) ");
			choose = scanner.nextByte();

			switch (choose) {
			case 1:
				canBo = new CongNhan();
				break;
			case 2:
				canBo = new KySu();
				break;
			case 3:
				canBo = new NhanVien();
				break;
			default:
				System.out.println("Nhập sai !");
				i--;
				break;
			}

			canBo.input();
			canBos.add(canBo);

			scanner.close();
		}
	}

	// b) Tìm kiếm theo họ tên.
	public void findCanBo() {
		Scanner scanner = new Scanner(System.in);

		String hoTen;
		System.out.println("Nhập họ tên cần tìm: ");
		hoTen = scanner.nextLine();

		for (CanBo canBo : canBos) {
			if (hoTen.equals(canBo.getHoTen())) {
				canBo.getInfor();
			}
		}
	}

	// c) Hiện thị thông tin về danh sách các cán bộ.
	public void printInforCanBo() {
		for (CanBo canBo : canBos) {
			canBo.getInfor();
		}
	}

	// d) Nhập vào tên của cán bộ và delete cán bộ đó
	public void deleteCanBo() {
		Scanner scanner = new Scanner(System.in);

		String hoTen;
		System.out.println("Nhập họ tên cần xóa: ");
		hoTen = scanner.nextLine();

		canBos.removeIf(cb -> hoTen.equals(cb.getHoTen()));
	}
}
