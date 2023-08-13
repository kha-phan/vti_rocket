package com.vti.frontend;

import com.vti.backend.file.StudentManagement;
import com.vti.ultis.ScannerUtils;

public class FileProgram {

	public static void main(String[] args) throws Exception {

		StudentManagement listStudents = new StudentManagement();

		int choose;
		do {
			menuTODOStudent();
			choose = ScannerUtils.inputInt();

			switch (choose) {
			case 1:
				listStudents.inputListStudents();
				break;

			case 2:
				listStudents.printListStudents();
				break;

			case 3:
				listStudents.writeStudents();
				break;

			case 4:
				listStudents.readStudents();
				break;

			case 5:
				break;

			default:
				System.out.println("Input wrong! Please input again.");
				break;
			}
		} while (choose != 5);
	}

	private static void menuTODOStudent() {
		System.out.println("===============MENU=================");
		System.out.println("=1. Input list student             =");
		System.out.println("=2. Print list student             =");
		System.out.println("=3. Write student                  =");
		System.out.println("=4. Read student                   =");
		System.out.println("=5. Exit                           =");
		System.out.println("====================================");
		System.out.println("Bạn chọn:                           ");
	}

}
