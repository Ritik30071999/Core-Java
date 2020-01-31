package com.app;

public class SimpleCalculator implements Calculation {

	String color, companyname;

	public SimpleCalculator(String color, String companyname) {
		this.color = color;
		this.companyname = companyname;
	}

	public void getDetails() {
		System.out.println("Color is " + color);
		System.out.println("Company name is " + companyname);
	}

	public int add(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public int multiply(int a, int b) {

		int multi = a * b;
		return multi;

	}

}
