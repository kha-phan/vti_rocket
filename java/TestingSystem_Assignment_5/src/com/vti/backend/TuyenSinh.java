package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.abstraction.question5.Examinee;

public class TuyenSinh implements ITuyenSinh {

	private Scanner scanner;

	private List<Examinee> examinees;

	public TuyenSinh() {
		examinees = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	@Override
	public void themThiSinh() {
		System.out.println("Nhập số thí sinh muốn nhập: ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			Examinee examinee = new Examinee();
			examinee.nhap();
			examinees.add(examinee);
		}
	}

	@Override
	public void hienThiSinh() {
		for (Examinee examinee : examinees) {
			System.out.println(examinee);
		}
	}

	@Override
	public void timThiSinh() {

		System.out.println("Nhập sbd cần tìm: ");
		String sbd = scanner.nextLine();

		for (Examinee examinee : examinees) {
			if (examinee.getSbd().equals(sbd)) {
				System.out.println(examinee);
			}
		}
	}
}
