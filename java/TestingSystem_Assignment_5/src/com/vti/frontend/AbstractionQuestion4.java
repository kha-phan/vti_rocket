package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.MyNews;

public class AbstractionQuestion4 {

	public static void main(String[] args) {
		question4();
	}

//	Question 4: Interface
//	Tạo một interface có tên INews bao gồm method void Display(), float Calculate().
//	Tạo một class News bao gồm thuộc tính: 
//	ID (int), Title (String), PublishDate (String), Author (String), Content (String) và AverageRate (float). 
//	Tạo các setter và getter cho từng thuộc tính, riêng AverageRate thì chỉ có getter.
//	Implement các method trong interface INews như sau:
//	a)	Method Display() sẽ in ra Title, PublishDate, Author, Content và AverageRate của tin tức ra console.
//	b)	Method có tên Calculate() để thiết đặt thuộc tính 
//	Khai báo một array có tên Rates kiểu int gồm 3 phần tử
//	AverageRate là trung bình cộng của 3 phần tử của array Rates.
//	c)	Tạo chương trình demo có tên là MyNews và tạo một menu lựa chọn gồm các mục sau:
//	•	Insert news
//	•	View list news
//	•	Average rate
//	•	Exit
//	Nếu người dùng chọn 1 từ bàn phím thì tạo một object của class News và nhập giá trị cho các thuộc tính Title, PublishDate, Author, Content sau đó yêu cầu người dùng nhập vào 3 đánh giá để lưu vào Rates.
//
//	Nếu người dùng chọn 2 từ bàn phím thì thực thi method Display().
//
//	Nếu người dùng chọn 3 từ bàn phím thì thực hiện method Calculate() để tính đánh giá trung bình, sau đó thực thi method Display().
//
//	Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương trình.
	private static void question4() {
		MyNews myNews = new MyNews();
		Scanner scanner = new Scanner(System.in);

		int choose;
		do {
			loadmenu();
			choose = scanner.nextInt();

			switch (choose) {

			case 1:
				myNews.insertNews();
				break;

			case 2:
				myNews.viewListNews();
				break;

			case 3:
				myNews.averageRate();
				myNews.viewListNews();
				break;

			case 4:
				break;

			default:
				System.out.println("Nhập sai ! Vui lòng nhập lại !");
				break;
			}
		} while (choose != 4);
	}

	private static void loadmenu() {
		System.out.println("=========MENU=========");
		System.out.println("==1. Insert news    ==");
		System.out.println("==2. View list news ==");
		System.out.println("==3. Average rate   ==");
		System.out.println("==4. Exit           ==");
		System.out.println("======================");
		System.out.println("==Bạn chọn:           ");
	}
}
