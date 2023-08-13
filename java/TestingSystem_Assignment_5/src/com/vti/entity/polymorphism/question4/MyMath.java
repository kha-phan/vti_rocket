package com.vti.entity.polymorphism.question4;

public class MyMath {

	public int sum(int a, int b) {
		return a + b;
	}

	public int sum(byte a, byte b) {
		return a + b;
	}

	public float sum(float a, float b) {
		return a + b;
	}

	public int sum(int a, byte b) {
		return a + b;
	}

	public float sum(byte a, float b) {
		return a + b;
	}

	public int getArea(int chieuDai, int chieuRong) {
		return chieuDai * chieuRong;
	}

	public int getArea(int canh) {
		return canh * canh;
	}

	public int getPerimeter(int chieuDai, int chieuRong) {
		return (chieuDai + chieuRong) * 2;
	}

	public int getPerimeter(int canh) {
		return canh * 4;
	}
}
