package com.io;

import java.io.*;

public class CircleArea {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter Radius");
			float radius = Float.parseFloat(br.readLine());
			float area = 3.14f * radius * radius;
			System.out.println("Area of Circle is " + area);

		} catch (IOException ie) {
			System.out.println(ie);
		}
	}
}
