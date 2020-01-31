package com.app;

public class Player {
	String name;
	int age;

	Player() {
		//super()    //explicitly creating default constructor of super class (makes no sense)
		System.out.println("In player class");
	}

	Player(String name, int age) {
		this.name = name;
		this.age = age;

	}

	void getDetails() {
		System.out.println("Name of player is " + name);
		System.out.println("Age of player is " + age);
	}

}
