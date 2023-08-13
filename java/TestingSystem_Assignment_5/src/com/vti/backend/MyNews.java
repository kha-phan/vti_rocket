package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.abstraction.question4.News;

//Question 4: Interface
//Tạo một interface có tên INews bao gồm method void Display(), float Calculate().
//Tạo một class News bao gồm thuộc tính: 
//ID (int), Title (String), PublishDate (String), Author (String), Content (String) và AverageRate (float). 
//Tạo các setter và getter cho từng thuộc tính, riêng AverageRate thì chỉ có getter.
//Implement các method trong interface INews như sau:
//a)	Method Display() sẽ in ra Title, PublishDate, Author, Content và AverageRate của tin tức ra console.
//b)	Method có tên Calculate() để thiết đặt thuộc tính 
//Khai báo một array có tên Rates kiểu int gồm 3 phần tử
//AverageRate là trung bình cộng của 3 phần tử của array Rates.
//c)	Tạo chương trình demo có tên là MyNews và tạo một menu lựa chọn gồm các mục sau:
//•	Insert news
//•	View list news
//•	Average rate
//•	Exit
//Nếu người dùng chọn 1 từ bàn phím thì:
//•	Tạo một object của class News và nhập giá trị cho các thuộc tính Title, PublishDate, Author, Content sau đó yêu cầu người dùng nhập vào 3 đánh giá để lưu vào Rates.
//
//Nếu người dùng chọn 2 từ bàn phím thì thực thi method Display().
//
//Nếu người dùng chọn 3 từ bàn phím thì thực hiện method Calculate() để tính đánh giá trung bình, sau đó thực thi method Display().
//
//Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương trình.

public class MyNews {

	private List<News> newsList;

	public MyNews() {
		newsList = new ArrayList<>();
	}

	public void insertNews() {
		News news = new News();
		int[] rates = new int[3];

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập Title: ");
		news.setTitle(scanner.nextLine());

		System.out.println("Nhập Publish Date: ");
		news.setPublishDate(scanner.nextLine());

		System.out.println("Nhập Author: ");
		news.setAuthor(scanner.nextLine());

		System.out.println("Nhập Content: ");
		news.setContent(scanner.nextLine());

		System.out.println("Nhập 3 đánh giá: ");
		for (int i = 0; i < 3; i++) {
			System.out.println("Đánh giá " + (i + 1) + ": ");
			rates[i] = scanner.nextInt();
		}
		news.setRates(rates);

		newsList.add(news);
	}

	public void viewListNews() {
		for (News news : newsList) {
			news.display();
		}
	}

	public void averageRate() {
		for (News news : newsList) {
			System.out.println("Title: " + news.getTitle() + " / Average Rate: " + news.calculate());
		}
	}

}
