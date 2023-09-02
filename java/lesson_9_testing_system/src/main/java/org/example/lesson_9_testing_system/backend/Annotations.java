package org.example.lesson_9_testing_system.backend;

import org.example.lesson_9_testing_system.entity.Student;

public class Annotations {

//	Question 2: @Deprecated 
//	Tạo 1 class student id, name với id là int và tự động tăng
//	B1: Sau đó tạo getter cho id
//	B2: Tại main() method, ta sẽ tạo instance của student có name = "Nguyễn Văn A" và in ra tên của student.
//	B3: Sau đó hệ thống thay đổi method getter của id, bạn sẽ phải tạo ra getter cho id như sau (viết thêm method sau vào)
//	Method sẽ return ra String là "MSV: " + id (nghĩa là thêm chữ MSV vào trước id 
//	B4: bạn sẽ đánh dấu method default getter (ở bước 1) là cũ và tạo comment để những người sau sẽ sử dụng method mới (là method ở bước 3)
//	B5: tại method main() viết thêm demo sử dụng method getter mới này (không xóa code cũ đi)
	
	@SuppressWarnings("deprecation")
	public void question2() {
		Student student = new Student(1, "Nguyễn Văn A");
		System.out.println(student.getId());
		System.out.println(student.getName());

		// TODO ....

		System.out.println(student.getIdV2());

	}
}
