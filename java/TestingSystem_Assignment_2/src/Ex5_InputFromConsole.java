import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex5_InputFromConsole {
	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);

		// Q1.
		System.out.println("Moi ban nhap vao 3 so nguyen duong ");
		for (int i = 0; i < 3; i++) {
			int x = scanner.nextInt();
			System.out.println("Ban da nhap: " + x + "\n");
		}

		// Q2.
		System.out.println("Moi ban nhap vao 2 so thuc");
		for (int i = 0; i < 2; i++) {
			double d = scanner.nextDouble();
			System.out.println("Ban da nhap: " + d + "\n");
		}

		// Q3.
		System.out.println("Moi ban nhap vao ho");
		String s1 = scanner.next();
		System.out.println("Moi ban nhap vao ten");
		String s2 = scanner.next();
		System.out.println("Ten ban da nhap: " + s1 + " " + s2 + "\n");

		// Q4.
		System.out.println("Moi nhap vao ngay sinh");
		String dob = scanner.next();
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dob);
		System.out.println("Input: " + date);

		// Q5.
		inputAccount();

		// Q7.
		System.out.println("Moi ban nhap vao 1 so chan");
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("Input: " + number);
		} else {
			System.out.println("Nhap sai");
		}

		// Q8.
		while (true) {
			System.out
					.println("Mời bạn nhập vào chức năng muốn sử dụng (1: tao account or 2: tao department");
			int methodNumber = scanner.nextInt();

			switch (methodNumber) {
			case 1:
				inputAccount();
				break;
			case 2:
				inputDepartment();
				break;
			default:
				System.out.println("Mời bạn nhập lại");
			}
		}

		// Q9. // Q10. // Q11.
		// TODO
	}

	// Q5.
	public static void inputAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap vao Account ID:");
		int id = scanner.nextInt();

		scanner.nextLine();
		System.out.print("Nhap vao username:");
		String userName = scanner.nextLine();

		System.out.print("Nhap vao Department:");
		String department = scanner.nextLine();

		System.out.print("Nhap vao Position ID (tu 1 -> 5):");
		int position = scanner.nextInt(6);
		switch (position) {
		case 1:
			System.out.print("Dev");
			break;
		case 2:
			System.out.print("Test");
			break;
		case 3:
			System.out.print("ScrumMaster");
			break;
		case 4:
			System.out.print("PM");
			break;
		default:
			System.out.print("SA");
		}

		System.out.print("\nNhap vao group:");
		scanner.nextLine();
		String groups = scanner.nextLine();

		System.out.print("\nNhap vao ngay:");
		String date = scanner.nextLine();
	}

	// Q6.
	public static void inputDepartment() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap ten department muon tao");
		String department = scanner.nextLine();
	}
}
