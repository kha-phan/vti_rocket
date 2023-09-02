package org.example.TestingSystem_Assignment_11_Exercise_3_4.entiy;

/**
 * This class is Account entity.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class Account {

	private int accountID;
	private String email;
	private String username;
	private String fullName;

	/**
	 * Constructor for class Account.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 */
	public Account() {
	}

	/**
	 * Constructor for class Account.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param accountID
	 * @param email
	 * @param username
	 * @param fullName
	 */
	public Account(int accountID, String email, String username, String fullName) {
		this.accountID = accountID;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
	}

	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account{" + "AccountID=" + accountID + ", Email='" + email + '\'' + ", Username='" + username + '\''
				+ ", FullName='" + fullName + '\'' + '}';
	}
}
