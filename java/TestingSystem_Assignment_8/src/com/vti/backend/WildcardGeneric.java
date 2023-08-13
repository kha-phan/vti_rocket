package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.exercise4.MyMath;
import com.vti.entity.exercise4.MyNumber;
import com.vti.entity.exercise4.Salary;

public class WildcardGeneric {

//	Question 1: 
//		Tạo 1 class Salary để đại diện cho datatype là các số
//		a)	Hãy config class Salary như sau: Salary <N> với N phải được extends từ Number.class
//		b)	Tạo method để print ra salary hiện tại
	public void question1() {
		// Integer
		Salary<Integer> salary = new Salary<Integer>(69000);
		System.out.println(salary);
	}

//
//	Question 2: 
//		Tạo 1 class MyNumber để đại diện cho datatype là các số
//		Hãy config class MyNumber như sau: MyNumber<N> với N phải được extends từ Number.class
	public void question2() {
		// Double
		MyNumber<Double> number = new MyNumber<Double>(6900.900);
		System.out.println(number);
	}

//	Question 3: T generic (method)
//	Tạo method tính max của 2 số (số nhập vào có thể là float, double, int, long).
//	Demo chương trình
	public void question3() {

		MyMath<Integer> math = new MyMath<>();

		// Integer
		int maxInt = math.maximum(1, 10, 8);
		System.out.println(maxInt);

		// float
		float maxFloat = math.maximum(1.5f, 10.3f, 10.2f);
		System.out.println(maxFloat);
	}

//	Question 4: T generic (method & class)
//	Tạo class MyMath<T> có thể làm việc được với các số int, long, double và có chứa các method sau:
//	a)	tính tổng của 2 số
//	b)	tính tổng của 3 số
//	c)	tính tổng của 4 số
//	d)	tính hiệu của 2 số
//	e)	hàm tính số mũ (a,b)
//
//	Gợi ý: sử dụng optional parameter.
//
//	Demo chương trình
	public void question4() {

		MyMath<Integer> mathInt = new MyMath<>();
		MyMath<Float> mathFloat = new MyMath<>();

		// add
		Integer sumInt1 = mathInt.add(1, 10);
		System.out.println(sumInt1);

		int sumInt2 = mathInt.add(1, 10, 8);
		System.out.println(sumInt2);

		Float sumFloat = mathFloat.add(1.5f, 10.3f, 10.2f);
		System.out.println(sumFloat);

		// subtract
		int subInt1 = mathInt.subtract(10, 1);
		System.out.println(subInt1);

		float subFloat2 = mathFloat.subtract(10f, 5f);
		System.out.println(subFloat2);
	}

//	Question 5:
//		Tạo 1 cursor như sau: List<Object> listWildcards.
//		Hãy khởi tạo đối tượng có chứa thông tin của khách hàng (mỗi thông tin là 1 element) và thêm các giá trị vào trong ArrayList như: 
//		a)	Nguyễn Văn Nam
//		b)	30 tuổi
//		c)	Hà đông, Hà nội
	public void question5() {
		List<Object> inforCustomers = new ArrayList<>();
		inforCustomers.add("Nguyễn Văn Nam");
		inforCustomers.add(30);
		inforCustomers.add("Hà đông, Hà nội");

		for (Object object : inforCustomers) {
			System.out.println(object);
		}
	}
}
