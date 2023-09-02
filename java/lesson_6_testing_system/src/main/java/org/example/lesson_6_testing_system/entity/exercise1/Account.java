package org.example.lesson_6_testing_system.entity.exercise1;

import org.example.lesson_6_testing_system.backend.exception.InvalidAgeInputingException;
import org.example.lesson_6_testing_system.utils.ScannerUtils;

public class Account {

	private int id;
	private String email;
	private String username;
	private String fullname;
	private int age;

	public Account() {
		input();
	}

	private void input() {
		System.out.println("Nhập id: ");
		id = ScannerUtils.inputInt("Please input a number as int, please input again.");

		System.out.println("Nhập email: ");
		email = ScannerUtils.inputString("Please input a email, please input again.");

		System.out.println("Nhập username: ");
		username = ScannerUtils.inputString("Please input a String, please input again.");

		System.out.println("Nhập fullname: ");
		fullname = ScannerUtils.inputString("Please input a String, please input again.");

		System.out.println("Nhập tuổi của bạn: ");
		age = inputAccountAge();

	}

//	Question 11: Custom Exception
//	Tạo custom Exception tên là: InvalidAgeInputingException.
//	Hãy viết method inputAge() ở class Account với yêu cầu như sau:
//	Khi người dùng nhập vào tuổi <= 0 thì throw ra Exception  InvalidAgeInputingException với message là: "The age must be greater than 0"
	private int inputAge() throws InvalidAgeInputingException {
		int age = ScannerUtils.inputInt("Please input an age as int, please input again.");

		if (age < 0) {
			throw new InvalidAgeInputingException("The age must be greater than 0, please input again.");
		}

		return age;
	}

//	Question 12: Tiếp tục Question 11
//	Trong class Account. Sử dụng method inputAge() từ ScannerUtils, hãy viết method inputAccountAge() với yêu cầu như sau:
//	Khi hệ thống gặp exception InvalidAgeInputingException thì sẽ in ra message.
//	Và khi người dùng nhập vào tuổi < 18 thì in ra text "Your age must be greater than 18" và yêu cầu người dùng nhập lại tuổi
	private int inputAccountAge() {
		while (true) {
			try {
				int age = inputAge();
				if (age < 18) {
					System.out.println("Your age must be greater than 18, please input again.");
				} else {
					return age;
				}
			} catch (InvalidAgeInputingException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", email='" + email + '\'' + ", username='" + username + '\'' + ", fullname='"
				+ fullname + '\'' + ", age=" + age + '}';
	}

}
