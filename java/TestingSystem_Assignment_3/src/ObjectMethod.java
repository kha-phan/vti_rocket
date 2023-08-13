public class ObjectMethod {
	public static void main(String[] args) {
		Department[] departments = new Department[5];

		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Boss of director";

		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Waiting room";

		Department department5 = new Department();
		department5.id = 5;
		department5.name = "Accounting";

		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;

		// question1(department1);
		// question2(departments);
		// question3(department1);
		// question4(department1);
		// question5(department1, department2);
		question6(departments);
		System.out.println("");
		question7(departments);
	}

	// Question 1:
	// In ra thông tin của phòng ban thứ 1 (sử dụng toString())
	public static void question1(Department department) {
		System.out.println(department);
	}

	// Question 2:
	// In ra thông tin của tất cả phòng ban (sử dụng toString())
	public static void question2(Department[] departments) {
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	// Question 3:
	// In ra địa chỉ của phòng ban thứ 1
	public static void question3(Department department) {
		System.out.println(department.hashCode());
	}

	// Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
	public static void question4(Department department) {
		if (department.name.equals("Phòng A")) {
			System.out.println("Có tên là phòng A");
		} else {
			System.out.println("Không tên là phòng A");
		}
	}

	// Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
	// không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	public static void question5(Department department1, Department department2) {
		if (department1.equals(department2)) {
			System.out.println("Có bằng nhau !");
		} else {
			System.out.println("Không bằng nhau !");
		}
	}

	// Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
	// sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
	// VD:
	// Ăn gà
	// Nơi Nghỉ ngơi
	// Phòng Business
	// Phòng Sale
	// Uống nước
	public static void question6(Department[] departments) {

		// order by
		for (int i = 0; i < departments.length; i++) {
			for (int j = 0; j < departments.length - 1; j++) {

				if (departments[i].name.compareToIgnoreCase(departments[j].name) < 0) {
					// swap
					Department temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}

		// print departments
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	// Question 7: Khởi tạo 1 array học sinh gồm 5 học sinh, sau đó in ra danh sách
	// học sinh được sắp xếp theo tên
	// VD:
	// Nguyễn Văn A
	// Trần Hưng Đạo
	// Trần Văn Nam
	// Nguyễn Văn Toàn

	public static void question7(Department[] departments) {
		// order by
		for (int i = 0; i < departments.length; i++) {
			String reverseNameDepartment = reverseWords(departments[i].name);
			for (int j = 0; j < departments.length - 1; j++) {
				String reverseNameComparingDepartment = reverseWords(departments[j].name);
				if (reverseNameDepartment.compareToIgnoreCase(reverseNameComparingDepartment) < 0) {

					// swap
					Department temp = departments[i];
					departments[i] = departments[j];
					departments[j] = temp;
				}
			}
		}

		// print departments
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	private static String reverseWords(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");

		String[] words = str.split(" ");

		str = "";
		for (int i = words.length - 1; i >= 0; i--) {
			str += words[i] + " ";
		}

		return str.substring(0, str.length() - 2);
	}
}
