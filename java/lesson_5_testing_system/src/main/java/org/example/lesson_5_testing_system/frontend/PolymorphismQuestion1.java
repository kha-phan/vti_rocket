package org.example.lesson_5_testing_system.frontend;


import org.example.lesson_5_testing_system.backend.StudentManagement;

public class PolymorphismQuestion1 {

	public static void main(String[] args) {
		StudentManagement studentManagement = new StudentManagement();

		studentManagement.initStudents();
		studentManagement.caLopDiemDanh();
		studentManagement.nhomDiHocBai();
		studentManagement.nhomDiDonVeSinh();

	}
}
