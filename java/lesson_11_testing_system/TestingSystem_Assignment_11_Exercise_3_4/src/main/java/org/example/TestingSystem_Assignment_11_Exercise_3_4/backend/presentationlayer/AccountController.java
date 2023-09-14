package org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.AccountService;
import org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer.IAccountService;
import org.example.TestingSystem_Assignment_11_Exercise_3_4.entiy.Account;
import org.example.TestingSystem_Assignment_11_Exercise_3_4.ultis.properties.MessageProperties;

/**
 * This class is controller of account .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class AccountController {

	private IAccountService service;
	private MessageProperties messageProperties;

	/**
	 * Constructor for class AccountController.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws IOException
	 */
	public AccountController() throws IOException {

		service = new AccountService();
		messageProperties = new MessageProperties();
	}

	/**
	 * This method is used for getting list accounts. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
		return service.getListAccounts();
	}

	/**
	 * This method is used for getting account by id. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Account getAccountByID(int id) throws Exception {
		// check Account id exist
		if (!isAccountExists(id)) {
			throw new Exception(messageProperties.getProperty("account.getAccountByID.cannotFindAccountById") + id);
		}

		return service.getAccountByID(id);
	}

	/**
	 * This method is used for creating account. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param email
	 * @param username
	 * @param fullName
	 * @throws Exception
	 */
	public void createAccount(String email, String username, String fullName) throws Exception {
		// check Account id exist
		if (isAccountExists(username)) {
			throw new Exception(messageProperties.getProperty("account.getAccountByID.usernameIsExists") + username);
		}

		service.createAccount(email, username, fullName);
	}

	/**
	 * This method is used for updating account by id. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @param username
	 * @throws Exception
	 */
	public void updateAccountByID(int id, String username) throws Exception {
		// check Account id exist
		if (!isAccountExists(id)) {
			throw new Exception(messageProperties.getProperty("account.getAccountByID.cannotFindAccountById") + id);
		}

		service.updateAccountByID(id, username);
	}

	/**
	 * This method is used for deleting account. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @throws Exception
	 */
	public void deleteAccount(int id) throws Exception {
		// check Account id exist
		if (!isAccountExists(id)) {
			throw new Exception(messageProperties.getProperty("account.getAccountByID.cannotFindAccountById") + id);
		}

		service.deleteAccount(id);
	}

	/**
	 * This method is used for check account exists by username. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param username
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException {
		return service.isAccountExists(username);
	}

	/**
	 * This method is used for account exists by id. 
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException {
		return service.isAccountExists(id);
	}

}
