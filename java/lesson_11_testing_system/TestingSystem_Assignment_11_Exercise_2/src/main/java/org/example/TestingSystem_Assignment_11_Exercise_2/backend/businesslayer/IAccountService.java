package org.example.TestingSystem_Assignment_11_Exercise_2.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_2.entiy.Account;

public interface IAccountService {

	List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException;

	Account getAccountByID(int id) throws Exception;

	void createAccount(String email, String username, String fullName) throws Exception;

	void updateAccountByID(int id, String username) throws Exception;

	void deleteAccount(int id) throws Exception;

	boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException;

	boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException;

}
