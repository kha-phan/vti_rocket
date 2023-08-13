import java.util.Date;

public class Ex1_FlowControl {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Create group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";
		group1.createDate = new Date(2020, 04, 21);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "DB Fresher";
		group2.createDate = new Date(2020, 04, 21);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "C++ Fresher";
		group3.createDate = new Date(2020, 04, 16);

		// Create Deparment
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketting";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "HR";

		// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Manager";

		Position position2 = new Position();
		position2.id = 2;
		position2.name = "Team Leader";

		Position position3 = new Position();
		position3.id = 3;
		position3.name = "Trainee";

		// Create account
		Account account1 = new Account();
		account1.id = 1;
		account1.createDate = new Date(2020, 03, 17);
		account1.department = department1;
		account1.email = "An@gmail.com";
		account1.fullname = "Nguyen Van An";
		account1.position = position1;
		account1.username = "an.nguyenvan";

		Account account2 = new Account();
		account2.id = 2;
		account2.createDate = new Date(2020, 01, 9);
		account2.department = department1;
		account2.email = "Linh@gmail.com";
		account2.fullname = "Nguyen Hoai Linh";
		account2.position = position3;
		account2.username = "Linh.nguyenhoai";

		Account account3 = new Account();
		account3.id = 3;
		account3.createDate = new Date(2020, 03, 19);
		account3.department = department2;
		account3.email = "ha@gmail.com";
		account3.fullname = "Pham Hai Ha";
		account3.position = position1;
		account3.username = "Ha.phamhai";

		// add group to account
		Group[] groupOfAccount1 = { group1 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group3 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group1 };
		account3.groups = groupOfAccount3;

		// add account to group
		Account[] accountOfGroups1 = { account1, account2, account3 };
		group1.accounts = accountOfGroups1;

		// Q1.
		if (account2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else
			System.out.println("Phòng ban của nhân viên này là: "
					+ account2.department.name);

		// Q2.
		if (account2.groups == null || account2.groups.length == 0) {
			System.out.println("Nhân viên này chưa có group");

		} else if (account2.groups.length == 1) {
			System.out.println("Group của nhân viên này là"
					+ account2.groups[0]);

		} else if (account2.groups.length == 2) {
			System.out.println("Group của nhân viên này là"
					+ account2.groups[0] + ", " + account2.groups[1]);

		} else if (account2.groups.length == 3) {
			System.out
					.println("Nhân viên này là người quan trọng, tham gia nhiều group");

		} else
			System.out
					.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

		// Q3.
		System.out
				.println(account2.department == null ? "Nhân viên này chưa có phòng ban"
						: "Phòng ban của nhân viên này là :"
								+ account2.department.name);

		// Q4.
		System.out.println(account1.position.name == "Dev" ? "Đây là Developer"
				: "Người này không phải là Developer");

		// Q5.
		int x = group1.accounts.length;
		switch (x) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
		default:
			System.out.println("Nhóm có nhiều thành viên");
		}

		// Q6.
		int y = account2.groups.length;
		switch (y) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			System.out.println("Group của nhân viên này là"
					+ account2.groups[0]);
			break;
		case 2:
			System.out.println("Group của nhân viên này là"
					+ account2.groups[0] + ", " + account2.groups[1]);
			break;
		case 3:
			System.out
					.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out
					.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

		// Q7.
		String z = account1.position.name;
		switch (z) {
		case "Dev":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
		}

		// Q8.
		Account[] accounts = { account1, account2, account3 };
		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullname);
			System.out.println("Name Department: " + account.department.name);
		}

		// Q9.
		Department[] departments = { department1, department2, department3 };
		for (Department department : departments) {
			System.out.println("ID Department: " + department.id);
			System.out.println("Name Department: " + department.name);
		}

		// Q10.
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
		}

		// Q11.
		for (int i = 0; i < departments.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}

		// Q12.
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
		}

		// Q13.
		for (int i = 0; i < departments.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin department thứ " + (i + 1)
						+ " là :");
				System.out.println("ID: " + departments[i].id);
				System.out.println("Name: " + departments[i].name);
			}
		}

		// Q14.
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out
						.println("Thông tin account thứ " + (i + 1) + " là :");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Fullname: " + accounts[i].fullname);
				System.out
						.println("Department: " + accounts[i].department.name);
			}
		}

		// Q15.
		for (int i = 2; i <= 20; i = i + 2) {
			System.out.println(i);
		}

		// Q16-10.
		int i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		}

		// Q16-11.
		i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}

		// Q16-12.
		i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}

		// Q16-13.
		i = 0;
		while (i < departments.length) {

			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			i++;
		}

		// Q16-14.
		i = 0;
		while (i < accounts.length) {
			if (accounts[i].id >= 4) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullname);
			System.out.println("Department: " + accounts[i].department.name);
			i++;
		}

		// Q16-15.
		i = 2;
		while (i <= 20) {
			System.out.println(i);
			i = i + 2;
		}
	}
}
