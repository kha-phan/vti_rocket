package com.vti.frontend.collection;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
	public static void main(String[] args) {
		Map<Integer, String> students = new HashMap<>();
		students.put(1, "Đăng");
		students.put(2, "Quý");
		students.put(3, "Kiên");
		students.put(4, "Duy");
		students.put(5, "Bích");

		for (Map.Entry<Integer, String> entry : students.entrySet()) {
			System.out.println("ID: " + entry.getKey() + " / " + "Name: " + entry.getValue());
		}
	}
}
