package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	// Question78
	private static void printErrString(String errString) {
		System.err.println(errString);
	}

	public static int inputInt(Scanner scanner, String errString) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				printErrString(errString);
			}
		}
	}

	public static float inputFloat(Scanner scanner, String errString) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine());
			} catch (Exception e) {
				printErrString(errString);
			}
		}
	}

	public static double inputDouble(Scanner scanner, String errString) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (Exception e) {
				printErrString(errString);
			}
		}
	}

	public static String inputString(Scanner scanner, String errString) {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				printErrString(errString);
			}
		}
	}

	public static int inputIntWithString(Scanner scanner) {
		return inputInt(scanner, "Please input a number as int");
	}

	public static String inputStringWithString(Scanner scanner) {
		return inputString(scanner, "Please input a string");
	}
}
