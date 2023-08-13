public class BoxingAndUnboxing {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
	}

	// Question 1:
	// Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
	// Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
	// float có 2 số sau dấu thập phân)
	public static void question1() {
		Integer salary = 5000;
		System.out.printf("%2.2f", (float) salary);
	}

	// Question 2:
	// Khai báo 1 String có value = "1234567"
	// Hãy convert String đó ra số int
	public static void question2() {
		String s1 = "1234567";
		Integer a = Integer.parseInt(s1);
		System.out.println(a);
	}

	// Question 3:
	// Khởi tạo 1 số Integer có value là chữ "1234567"
	// Sau đó convert số trên thành datatype int
	public static void question3() {
		Integer a = 1234567;
		int b = a.intValue();
		System.out.println(b);
	}
}
