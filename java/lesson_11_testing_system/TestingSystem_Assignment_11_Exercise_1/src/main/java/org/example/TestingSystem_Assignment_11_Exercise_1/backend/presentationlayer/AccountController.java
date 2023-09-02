package org.example.TestingSystem_Assignment_11_Exercise_1.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_1.backend.businesslayer.AccountService;
import org.example.TestingSystem_Assignment_11_Exercise_1.entiy.Account;

public class AccountController {

	private AccountService service;

	public AccountController() throws IOException {
		service = new AccountService();
	}

	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return service.getListAccounts();
	}
}