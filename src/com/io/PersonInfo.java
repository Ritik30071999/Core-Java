package com.io;

import java.io.*;

public class PersonInfo {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\personinfo.txt", true))) {
			System.out.println("Enter Your Name");
			String name = br.readLine();
			System.out.println("Enter Your Phone");
			String phone = br.readLine();
			// int phone = Integer.parseInt(br.readLine()); can also be used
			System.out.println("Enter Your City");
			String city = br.readLine();

			bw.write(name);
			bw.newLine();
			bw.write(phone);
			bw.newLine();
			bw.write(city);
			bw.newLine();

			System.out.println("Name is " + name + " Phone No. is " + phone + " City is " + city);

		} catch (IOException ie) {
			System.out.println(ie);
		}

	}
}
