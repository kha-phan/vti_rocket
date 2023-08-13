package com.vti.frontend;

import com.vti.backend.StudentManagement;

public class PolymorphismQuestion1 {

	public static void main(String[] args) {
		StudentManagement studentManagement = new StudentManagement();

		studentManagement.initStudents();
		studentManagement.caLopDiemDanh();
		studentManagement.nhomDiHocBai();
		studentManagement.nhomDiDonVeSinh();

	}
}
