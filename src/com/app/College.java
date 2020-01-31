package com.app;

public abstract class College {

	String name;

	void setName(String name) {
		this.name = name;
	}

	abstract void showFacilities();

	void getName() {
		System.out.println("Name of College is " + name);
	}

}
