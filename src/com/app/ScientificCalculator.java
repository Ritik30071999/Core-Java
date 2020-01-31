package com.app;

public class ScientificCalculator implements Calculation {
	String color, companyname;
	int price;

	public ScientificCalculator(String color, String companyname, int price) {
		this.color = color;
		this.companyname = companyname;
		this.price=price;
	}

	public void getDetails() {
		System.out.println("Color is " + color);
		System.out.println("Company name is " + companyname);
		System.out.println("Price is "+price);
	}

	public int add(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public int multiply(int a, int b) {

		int multi = a * b;
		return multi;

	}
	
	public double squareRoot(double a) {
		
		double sq = Math.sqrt(a);
		return sq;
	}

}
