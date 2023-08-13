package com.vti.backend;

import com.vti.entity.staticEx1.MyMath;
import com.vti.entity.staticEx1.PrimaryStudent;
import com.vti.entity.staticEx1.SecondaryStudent;
import com.vti.entity.staticEx1.Student;

public class Static {

	private Student[] students;

	public void question1() throws Exception {
		students = new Student[3];
		students[0] = new Student("Nguyễn Văn A");
		students[1] = new Student("Nguyễn Văn B");
		students[2] = new Student("Nguyễn Văn C");

		for (Student student : students) {
			System.out.println(student);
		}

		// Thay đổi thành đại học công nghệ
		Student.college = "Đại học công nghệ";

		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void question2() {
		// Question2
		System.out.println("Số tiền của nhóm trước khi tiêu: ");
		System.out.println(Student.getMoneyGroup());

		// Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
		students[0].spend(50);
		System.out.println("Số tiền sau khi student 1 tiêu: ");
		System.out.println(Student.getMoneyGroup());

		System.out.println("Số tiền của student 2 trước khi tiêu: ");
		System.out.println(Student.getMoneyGroup());

		// Student thứ 2 lấy 20k đi mua bánh mì
		students[1].spend(20);
		System.out.println("Số tiền sau khi student 2 tiêu: ");
		System.out.println(Student.getMoneyGroup());

		System.out.println("Số tiền của student 3 trước khi tiêu: ");
		System.out.println(Student.getMoneyGroup());

		// Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
		students[2].spend(150);
		System.out.println("Số tiền sau khi student 3 tiêu: ");
		System.out.println(Student.getMoneyGroup());

		// cả nhóm mỗi người lại đóng quỹ mỗi người 50k
		for (Student student : students) {
			student.fund();
		}

		System.out.println("Số tiền sau khi đóng quỹ: ");
		System.out.println(Student.getMoneyGroup());
	}

	public void question3() {
		System.out.println(MyMath.max(6, 9));
		System.out.println(MyMath.min(6, 9));
		System.out.println(MyMath.sum(6, 9));
	}

	public void question4() {
		Student.changecollege("Đại học Mở hà Nội");

		System.out.println("Sau khi gọi method changeCollege: ");
		for (Student student : students) {
			System.out.println(student.getCollege());
		}
	}

	public void question5() {
		System.out.println("Số sinh viên được tạo: ");
		System.out.println(Student.counter);
	}

	public void question6() throws Exception {
		Student student1 = new PrimaryStudent("Nguyễn Văn A");
		Student student2 = new PrimaryStudent("Nguyễn Văn B");
		Student student3 = new SecondaryStudent("Nguyễn Văn C");
		Student student4 = new SecondaryStudent("Nguyễn Văn D");
		Student student5 = new SecondaryStudent("Nguyễn Văn E");
		Student student6 = new SecondaryStudent("Nguyễn Văn F");

		System.out.println("Couter of Student: " + Student.counter);
		System.out.println("Couter of Primary Student: " + PrimaryStudent.counterPrimary);
		System.out.println("Couter of Secondary Student: " + SecondaryStudent.counterSecondary);
	}

	public void question7() throws Exception {
		Student student1 = new PrimaryStudent("Nguyễn Văn A");
		Student student2 = new PrimaryStudent("Nguyễn Văn B");
		Student student3 = new SecondaryStudent("Nguyễn Văn C");
		Student student4 = new SecondaryStudent("Nguyễn Văn D");
		Student student5 = new SecondaryStudent("Nguyễn Văn E");
		Student student6 = new SecondaryStudent("Nguyễn Văn F");
		Student student7 = new SecondaryStudent("Nguyễn Văn G");
		Student student8 = new SecondaryStudent("Nguyễn Văn H");
		Student student9 = new SecondaryStudent("Nguyễn Văn I");
	}

}
