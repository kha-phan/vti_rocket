package org.example.lesson_9_testing_system.backend;

import org.example.lesson_9_testing_system.entity.innerclass.CPU;
import org.example.lesson_9_testing_system.entity.innerclass.Car;
import org.example.lesson_9_testing_system.entity.innerclass.Car.Engine;

public class InnerClass {

//	Question 1: 
//		Tạo class CPU có property: price
//		Tạo 2 inner class Processor, Ram
//	Với Processor có các property: coreAmount, menufacturer và method getCache() và return ra 4.3
//	Với Ram có các property: memory, menufacturer và method getClockSpeed() và return ra 5.5
//	Sau đó khởi tạo object CPU và in ra cache của Processor và clockSpeed của Ram

	public void question1() {

		CPU cpu = new CPU(100);
		CPU.Ram ram = cpu.new Ram(8, "HP");
		CPU.Processor processor = cpu.new Processor(4, "Dell");

		// getClockspeed
		System.out.println(ram.getClockSpeed());

		// get cache
		System.out.println(processor.getCache());
	}

//	Question 2: 
//		Tạo Car có property: name, type
//	Tạo inner class Engine có property engineType và tạo getter, setter cho property engineType
//	Khởi tạo object Car có name = Mazda, type = 8WD, có loại động cơ là "Crysler".
//	Sau đó in ra thông tin của động cơ

	public void question2() {

		Car car = new Car("Mazda", "8WD");

		Engine engine = car.new Engine();
		engine.setEngineType("Crysler");

		car.setEngine(engine);

		car.printInfor();
	}
}
