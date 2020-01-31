package com.app;

public class CalculatorDemo {
	public static void main(String[] args) {

		SimpleCalculator s = new SimpleCalculator("Blue", "Casio");
		s.getDetails();
		int sum = s.add(5, 4);
		int multi = s.multiply(5, 4);
		System.out.println("Sum is " + sum);
		System.out.println("Multiplication is " + multi);
		System.out.println(Calculation.PI);
		
		ScientificCalculator sc = new ScientificCalculator("Black", "Casio",500);
		sc.getDetails();
		sum = sc.add(5, 4);
	    multi = sc.multiply(5, 4);
	    double sq = sc.squareRoot(16.0);
		System.out.println("Sum is " + sum);
		System.out.println("Multiplication is " + multi);
		System.out.println("Square Root is "+sq);
		System.out.println(Calculation.PI);

	
	}

}
