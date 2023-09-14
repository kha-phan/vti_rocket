package org.example.TestingSystem_Assignment_11_Exercise_1.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_1.backend.datalayer.AccountRepository;
import org.example.TestingSystem_Assignment_11_Exercise_1.entiy.Account;

public class AccountService {

	private AccountRepository repository;

	public AccountService() throws IOException {
		repository = new AccountRepository();
	}

	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return repository.getListAccounts();
	}
}
