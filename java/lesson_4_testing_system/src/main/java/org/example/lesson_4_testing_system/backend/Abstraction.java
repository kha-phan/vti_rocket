package org.example.lesson_4_testing_system.backend;


import org.example.lesson_4_testing_system.entity.abstraction.quesion2_3.Employee;
import org.example.lesson_4_testing_system.entity.abstraction.quesion2_3.Manager;
import org.example.lesson_4_testing_system.entity.abstraction.quesion2_3.Waiter;
import org.example.lesson_4_testing_system.entity.abstraction.question1.Phone;
import org.example.lesson_4_testing_system.entity.abstraction.question1.VietnamesePhone;

public class Abstraction {

	public void question1() {
		Phone phone = new VietnamesePhone();
		phone.insertContact("Đăng Black", "0825294200");
		phone.removeContact("Đăng Black");
		phone.updateContact("Đăng Black", "0962282193");
		phone.searchContact("Đăng Black");
	}

	public void question2_3() {
		Employee employee = new Employee("Đăng Black", 6.9);
		employee.displayInfo();

		Manager manager = new Manager("Quang Anh", 9.6);
		manager.displayInfo();

		Waiter waiter = new Waiter("Chiến Panda", 2.6);
		waiter.displayInfo();
	}

}
