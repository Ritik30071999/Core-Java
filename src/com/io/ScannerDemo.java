package com.io;

import java.util.*;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// jdk1.5
		System.out.println("Enter Radius");
		float radius = sc.nextFloat();
		float area = (float) (3.14f * Math.pow(radius, 2));
		System.out.println(area);
		if (sc != null)
			sc.close();

	}

}
