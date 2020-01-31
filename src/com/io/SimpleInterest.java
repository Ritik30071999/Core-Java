package com.io;

import java.io.*;

public class SimpleInterest {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter Principal Amount");
			int p = Integer.parseInt(br.readLine());
			System.out.println("Enter Rate of Interest");
			float r = Float.parseFloat(br.readLine());
			System.out.println("Enter Time");
			float t = Float.parseFloat(br.readLine());

			float si = (p * r * t) / 100;
			System.out.println("Rs. " + si);

		} catch (IOException ie) {
			System.out.println(ie);
		}
	}
}
