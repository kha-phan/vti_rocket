package org.example.lesson_4_testing_system.entity.abstraction.quesion2_3;

public class Manager extends User {

	public Manager(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		return salaryRatio * 520;
	}

}
