package com.vti.backend;

import com.vti.entity.finalEx2.MyMath;
import com.vti.entity.finalEx2.question2.Student;
import com.vti.entity.finalEx2.question3.PrimaryStudent;
import com.vti.entity.finalEx2.question3.SecondaryStudent;

public class Final {

	public void question1() {
		System.out.println(MyMath.sum(6));
	}

	public void question2() throws Exception {
		Student student1 = new Student(1, "Đăng");
		System.out.println(student1);
		Student student2 = new Student(2, "Duy");
		System.out.println(student2);
	}

	public void question3() {
		PrimaryStudent.study();
		SecondaryStudent.study();
	}
}
