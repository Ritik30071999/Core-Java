package com.io;

import java.io.*;

public class Information {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Your Name");
			String name = br.readLine();
			System.out.println("Enter Your Age");
			int age = Integer.parseInt(br.readLine());
			if (age >= 18) {
				System.out.println(name + " you can vote");
			} else {
				System.out.println(name + " you are not eligible to vote. Sorry mate!");
			}

		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}

	}
}
