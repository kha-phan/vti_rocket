package com.vti.entity.exercise4;

public class MyMath<N extends Number> {

	@SuppressWarnings({ "unchecked" })
	public N add(N... numbers) {

		Double sum = 0d;

		for (N number : numbers) {
			sum += number.doubleValue();
		}

		return (N) sum;
	}

	public <T extends Comparable<T>> T maximum(T x, T y, T z) {
		// assume x is initially the largest
		T max = x;

		// y is the largest so far
		if (y.compareTo(max) > 0) {
			max = y;
		}

		if (z.compareTo(max) > 0) {
			max = z; // z is the largest
		}

		return max;
	}

	@SuppressWarnings("unchecked")
	public N subtract(N x, N y) {
		Double subtract = x.doubleValue() - y.doubleValue();

		return (N) subtract;
	}

}
