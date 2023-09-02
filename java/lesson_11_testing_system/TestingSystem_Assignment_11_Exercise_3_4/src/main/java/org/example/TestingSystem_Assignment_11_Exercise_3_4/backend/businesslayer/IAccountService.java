package org.example.TestingSystem_Assignment_11_Exercise_3_4.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.example.TestingSystem_Assignment_11_Exercise_3_4.entiy.Account;

/**
 * This class is interface of account service. 
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public interface IAccountService {

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
	List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException;

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
	Account getAccountByID(int id) throws Exception;

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
	void createAccount(String email, String username, String fullName) throws Exception;

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
	void updateAccountByID(int id, String username) throws Exception;

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
	void deleteAccount(int id) throws Exception;

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
	boolean isAccountExists(String username) throws ClassNotFoundException, SQLException, IOException;

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
	boolean isAccountExists(int id) throws ClassNotFoundException, SQLException, IOException;

}
