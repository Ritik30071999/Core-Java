package com.app;

public class Person implements Listener,Writer{
	String name;
	
	public void listen() {
		System.out.println("Listening Song");
	}
	public void write() {
		System.out.println("Writing Poems");
	}
	
	public Person(String name) {
		
		this.name = name;
	}
	
	void getDetails() {
		System.out.println("Name of person is "+name);
		
	}
	

}
