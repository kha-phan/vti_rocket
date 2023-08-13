package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.TuyenSinh;

public class AbstractionQuestion5 {

	public static void main(String[] args) {
		question5();
	}

// Question 5: 
//	Các thí sinh dự thi đại học bao gồm các thí sinh thi khối A, B, và khối C. Các thí sinh cần quản lý các thông tin sau: Số báo danh, họ tên, địa chỉ, mức ưu tiên.
//
//	Thí sinh thi khối A thi các môn: Toán, Lý, Hoá.
//	Thí sinh thi khối B thi các môn: Toán, Hoá, Sinh.
//	Thí sinh thi khối C thi các môn: Văn, Sử, Địa.
//
//	a)	Xây dựng các class để quản lý các thi sinh dự thi đại học.
//	b)	Xây dựng interface ITuyenSinh và class TuyenSinh có các chức năng:
//	a.	Thêm mới thí sinh.
//	b.	Hiện thị thông tin của thí sinh và khối thi của thí sinh.
//	c.	Tìm kiếm theo số báo danh.
//	d.	Thoát khỏi chương trình.
	private static void question5() {

		TuyenSinh tuyenSinh = new TuyenSinh();
		Scanner scanner = new Scanner(System.in);

		int choose;

		do {
			loadMenu();
			choose = scanner.nextInt();

			switch (choose) {

			case 1:
				tuyenSinh.themThiSinh();
				break;

			case 2:
				tuyenSinh.hienThiSinh();
				break;

			case 3:
				tuyenSinh.timThiSinh();
				break;

			case 4:
				break;

			default:
				System.out.println("Nhập sai ! Vui lòng nhập lại !");
				break;
			}

		} while (choose != 4);

		scanner.close();
	}

	private static void loadMenu() {
		System.out.println("===============MENU=================");
		System.out.println("=||1. Thêm mới thí sinh          ||=");
		System.out.println("=||2. Hiện thông tin thí sinh    ||=");
		System.out.println("=||3. Tìm kiếm theo số báo danh  ||=");
		System.out.println("=||4. Thoát                      ||=");
		System.out.println("====================================");
		System.out.println("=====Bạn chọn:                      ");
	}
}
