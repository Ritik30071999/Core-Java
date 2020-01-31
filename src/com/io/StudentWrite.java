package com.io;

import java.io.*;

public class StudentWrite {
	public static void main(String[] args) throws IOException {
		Student s = new Student();
		s.setRollnumber(101);
		s.setName("Scott");
		s.setEmail("scott@gmail.com");
		s.setCourse("Corejava");

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\student.txt"));
		oos.writeObject(s);
		System.out.println("Object Written");
	}

}
