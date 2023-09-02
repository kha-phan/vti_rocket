package org.example.TestingSystem_Assignment_11_Exercise_2.entiy;

public class Account {
	private int AccountID;
	private String Email;
	private String Username;
	private String FullName;

	public Account() {
	}

	public Account(int accountID, String email, String username, String fullName) {
		AccountID = accountID;
		Email = email;
		Username = username;
		FullName = fullName;
	}

	public int getAccountID() {
		return AccountID;
	}

	public String getEmail() {
		return Email;
	}

	public String getUsername() {
		return Username;
	}

	public String getFullName() {
		return FullName;
	}

	@Override
	public String toString() {
		return "Account{" + "AccountID=" + AccountID + ", Email='" + Email + '\'' + ", Username='" + Username + '\''
				+ ", FullName='" + FullName + '\'' + '}';
	}
}
