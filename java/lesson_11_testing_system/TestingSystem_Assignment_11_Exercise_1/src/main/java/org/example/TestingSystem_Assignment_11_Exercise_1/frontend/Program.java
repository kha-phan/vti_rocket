package org.example.TestingSystem_Assignment_11_Exercise_1.frontend;

import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_1.backend.presentationlayer.AccountController;
import org.example.TestingSystem_Assignment_11_Exercise_1.entiy.Account;

public class Program {

	public static void main(String[] args) throws Exception {
		AccountController accountController = new AccountController();

		List<Account> accounts = accountController.getListAccounts();

		for (Account account : accounts) {
			System.out.println(account);
		}
	}
}
