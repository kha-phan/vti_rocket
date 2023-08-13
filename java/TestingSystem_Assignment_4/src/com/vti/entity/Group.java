package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private Account[] accounts;
	private LocalDate createDate;

	public Group() {
	}

	public Group(int id, String name, Account creator, Account[] accounts, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}

	public Group(int id, String name, Account creator, String[] usernames, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.creator = creator;

		// accounts
		Account[] accounts = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			accounts[i] = new Account(usernames[i]);
		}
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group{" + "id=" + id + ", name='" + name + '\'' + ", creator='" + creator + '\'' + ", createDate='"
				+ createDate + ", accounts=" + Arrays.toString(accounts) + '}';
	}
}
