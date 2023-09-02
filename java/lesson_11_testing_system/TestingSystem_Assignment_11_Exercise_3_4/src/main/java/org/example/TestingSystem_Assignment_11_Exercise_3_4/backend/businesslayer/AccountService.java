package org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.datalayer.AccountRepository;
import org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.datalayer.IAccountRepository;
import org.example.TestingSystem_Assignment_11_Exercise_3_4.entiy.Account;

/**
 * This class is service of account. 
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class AccountService implements IAccountService {

	private IAccountRepository repository;

	/**
	 * Constructor for class AccountService.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws IOException
	 */
	public AccountService() throws IOException {
		repository = new AccountRepository();
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#getListAccounts()
	*/
	@Override
	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return repository.getListAccounts();
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#getAccountByID(int)
	*/
	@Override
	public Account getAccountByID(int id) throws Exception {
		return repository.getAccountByID(id);
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#createAccount(java.lang.String, java.lang.String, java.lang.String)
	*/
	@Override
	public void createAccount(String email, String username, String fullName)
			throws ClassNotFoundException, SQLException, Exception {
		repository.createAccount(email, username, fullName);
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#updateAccountByID(int, java.lang.String)
	*/
	@Override
	public void updateAccountByID(int id, String username) throws Exception {
		repository.updateAccountByID(id, username);
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#deleteAccount(int)
	*/
	@Override
	public void deleteAccount(int id) throws Exception {
		repository.deleteAccount(id);
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#isAccountExists(java.lang.String)
	*/
	@Override
	public boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException {
		return repository.isAccountExists(username);
	}

	/* 
	* @see org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService#isAccountExists(int)
	*/
	@Override
	public boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException {
		return repository.isAccountExists(id);
	}

}
