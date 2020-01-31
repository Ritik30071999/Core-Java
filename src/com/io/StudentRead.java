package com.io;

import java.io.*;

public class StudentRead {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("d:\\student.txt"));
			Student s = (Student) ois.readObject();// downcasting or narrowcasting
			String name = s.getName();
			System.out.println(name);
			String email = s.getEmail();
			System.out.println(email);
			String course = s.getCourse();
			System.out.println(course);
		} catch (FileNotFoundException fe) {
			System.out.println(fe);
		} catch (IOException ie) {
			System.out.println(ie);
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}

	}
}
