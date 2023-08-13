package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.inheritance.question4.Bao;
import com.vti.entity.inheritance.question4.Sach;
import com.vti.entity.inheritance.question4.TaiLieu;
import com.vti.entity.inheritance.question4.TapChi;

//Question 4: 
//Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất), Tên nhà xuất bản, số bản phát hành.
//
//Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
//Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
//Các báo cần quản lý thêm: Ngày phát hành.
//
//Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một cách hiệu quả.
//Xây dựng lớp QuanLySach có các chức năng sau
//a)	Thêm mới tài liêu: Sách, tạp chí, báo.
//b)	Xoá tài liệu theo mã tài liệu.
//c)	Hiện thị thông tin về tài liệu.
//d)	Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
//e)	Thoát khỏi chương trình.

public class QLTL {

	private List<TaiLieu> taiLieus;

	public QLTL() {
		taiLieus = new ArrayList<>();
	}

	// a) Thêm mới tài liêu: Sách, tạp chí, báo.
	public void inputTaiLieu() {
		int n;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập số tài liệu mà bạn muốn nhập:  ");
		n = scanner.nextInt();

		byte choose;
		TaiLieu taiLieu = new TaiLieu();
		for (int i = 0; i < n; i++) {

			System.out.println("Bạn muốn nhập tài liệu nào? (1:Sách || 2: Tạp chí || 3: Báo) ");
			choose = scanner.nextByte();

			switch (choose) {
			case 1:
				taiLieu = new Sach();
				break;
			case 2:
				taiLieu = new TapChi();
				break;
			case 3:
				taiLieu = new Bao();
				break;
			default:
				System.out.println("Nhập sai !");
				i--;
				break;
			}
			taiLieu.input();
			taiLieus.add(taiLieu);
		}
	}

	// b) Xoá tài liệu theo mã tài liệu.
	public void deleteTaiLieu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập mã tài liệu cần xóa: ");
		int maTaiLieu = scanner.nextInt();

		for (TaiLieu taiLieu : taiLieus) {
			if (maTaiLieu == taiLieu.getMaTaiLieu()) {
				taiLieus.remove(taiLieu);
			}
		}
	}

	// c) Hiện thị thông tin về tài liệu.
	public void printTaiLieu() {
		for (TaiLieu taiLieu : taiLieus) {
			taiLieu.getInfor();
		}
	}

	// d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
	public void findTaiLieu() {
		Scanner scanner = new Scanner(System.in);

		int choose;
		System.out.println("Bạn muốn tìm kiếm theo loại nào? (1:Sách || 2: Tạp chí || 3: Báo)");
		choose = scanner.nextByte();

		switch (choose) {
		case 1:
			for (TaiLieu taiLieu : taiLieus) {
				if (taiLieu instanceof Sach) {
					taiLieu.getInfor();
				}
			}
			break;
		case 2:
			for (TaiLieu taiLieu : taiLieus) {
				if (taiLieu instanceof TapChi) {
					taiLieu.getInfor();
				}
			}
			break;
		case 3:
			for (TaiLieu taiLieu : taiLieus) {
				if (taiLieu instanceof Bao) {
					taiLieu.getInfor();
				}
			}
			break;
		default:
			System.out.println("Nhập sai !");
			break;
		}
	}

}
