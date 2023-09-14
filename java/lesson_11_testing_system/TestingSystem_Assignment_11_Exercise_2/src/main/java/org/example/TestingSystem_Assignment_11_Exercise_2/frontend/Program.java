package org.example.TestingSystem_Assignment_11_Exercise_2.frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_2.backend.presentationlayer.AccountController;
import org.example.TestingSystem_Assignment_11_Exercise_2.entiy.Account;
import org.example.TestingSystem_Assignment_11_Exercise_2.ultis.ScannerUtils;

public class Program {

	private static AccountController accountController;

	public static void main(String[] args) throws Exception {
		accountController = new AccountController();

		int choose;
		do {
			menuAccount();

			choose = ScannerUtils.inputInt();
			switch (choose) {
			case 1:
				// get list data
				System.out.println("======List account=====");
				getListAccount();
				break;

			case 2:
				// get user by ìd
				System.out.println("=======Get account by id======");
				getAccountByID();
				break;

			case 3:
				// create user
				System.out.println("=========Create account=========");
				createAccount();
				break;

			case 4:
				// update user
				System.out.println("=========Update account=========");
				updateAccount();
				break;

			case 5:
				// delete user
				System.out.println("=========Delete account=========");
				deleteAccount();
				break;

			case 6:
				break;

			default:
				System.out.println("input wrong ! please input again.");
				break;
			}
		} while (choose != 6);
	}

	private static void menuAccount() {
		System.out.println("============MENU===========");
		System.out.println("=|1. Get list account    |=");
		System.out.println("=|2. Get account by id   |=");
		System.out.println("=|3. Create account      |=");
		System.out.println("=|4. Update account      |=");
		System.out.println("=|5. Delete account      |=");
		System.out.println("=|6. Exit                |=");
		System.out.println("===========================");
		System.out.println("You choose:                ");
	}

	private static void getListAccount() throws IOException, SQLException, ClassNotFoundException {

		List<Account> accounts = accountController.getListAccounts();

		for (Account account : accounts) {
			System.out.println(account);
		}
	}

	private static void getAccountByID() throws Exception {

		System.out.println("Input id: ");
		int id = ScannerUtils.inputId();

		Account account = accountController.getAccountByID(id);
		System.out.println(account);
	}

	private static void createAccount() throws Exception {

		System.out.println("Input email: ");
		String email = ScannerUtils.inputString("Please input email as String!");

		System.out.println("Input username: ");
		String username = ScannerUtils.inputString("Please input username as String!");

		System.out.println("Input full name: ");
		String fullName = ScannerUtils.inputString("Please input full name as String!");

		accountController.createAccount(email, username, fullName);
	}

	private static void updateAccount() throws Exception {
		System.out.println("Input id: ");
		int id = ScannerUtils.inputId();

		System.out.println("Input full name: ");
		String fullName = ScannerUtils.inputString("Please input full name as String !");

		accountController.updateAccountByID(id, fullName);
	}

	private static void deleteAccount() throws Exception {
		System.out.println("Input id: ");
		int id = ScannerUtils.inputId();

		accountController.deleteAccount(id);
	}
}
