package com.app;

public class Teacher implements Listener, Writer {

	String name, experience;

	public Teacher(String name, String experience) {
		this.name = name;
		this.experience = experience;
	}

	public void listen() {
		System.out.println("Listening the problems of students");
	}

	public void write() {
		System.out.println("Make papers and assignments");
	}

	public void getDetails() {
		System.out.println("Name is " + name);
		System.out.println("Experience is " + experience + "years");
	}

}
