package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Contructor {

	// Question 1:
	// Tạo constructor cho department:
	// a) không có parameters
	// b) Có 1 parameter là nameDepartment và default id của
	// Department = 0
	// Khởi tạo 1 Object với mỗi constructor ở trên
	public void question1() {

		// construct object
		Department department = new Department();
		Department department1 = new Department("Sale");

		// print object
		System.out.println(department);
		System.out.println(department1);
	}

	// Question 2:
	// Tạo constructor cho Account:
	// a) Không có parameters
	// b) Có các parameter là AccountID, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName)
	// c) Có các parameter là AccountID, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName) và
	// Position của User, default createDate = now
	// d) Có các parameter là AccountID, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName) và
	// Position của User, createDate
	// Khởi tạo 1 Object với mỗi constructor ở trên
	public void question2() {
		// a
		Account account = new Account();
		System.out.println(account);

		// b
		Account account1 = new Account(1, "dang@gmail.com", "dangblack", "Nguyễn Hải", "Đăng");
		System.out.println(account1);

		// c
		Position position1 = new Position(1, "Sale");
		Position position2 = new Position(2, "Marketing");
		Account account2 = new Account(2, "dang@gmail.com", "dangblack", "Nguyễn Hải", "Đăng", position1);
		System.out.println(account2);

		// d
		Account account3 = new Account(3, "dang@gmail.com", "dangblack", "Nguyễn Hải", "Đăng", position2,
				LocalDate.parse("2020-05-15"));
		System.out.println(account3);
	}

	// Question 3:
	// Tạo constructor cho Group:
	// a) không có parameters
	// b) Có các parameter là GroupName, Creator, array Account[]
	// accounts, CreateDate
	// c) Có các parameter là GroupName, Creator, array String[]
	// usernames , CreateDate
	// Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
	// username, các thông tin còn lại = null).
	// Khởi tạo 1 Object với mỗi constructor ở trên
	public void question3() {
		// a
		Group group = new Group();
		System.out.println(group);

		// b
		Account creator = new Account(1, "dang1@gmail.com", "dangblack1", "Nguyễn Hải", "Đăng1");
		Account account2 = new Account(2, "dang2@gmail.com", "dangblack2", "Nguyễn Hải", "Đăng2");
		Account account3 = new Account(3, "dang3@gmail.com", "dangblack3", "Nguyễn Hải", "Đăng3");
		Account[] accounts = { creator, account2, account3 };
		Group group1 = new Group(1, "Sale", creator, accounts, LocalDate.parse("2020-05-15"));
		System.out.println(group1);

		// c
		String[] usernames = { "dangblack1", "dangblack2", "dangblack3" };
		System.out.println(group1);
		Group group2 = new Group(2, "Boss of Director", creator, usernames, LocalDate.parse("2020-05-15"));
		System.out.println(group2);
	}
}
