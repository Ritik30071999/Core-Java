package com.app;

public class Lion extends Animal {

	String color;
	String nailstype = "sharp";

	void eatingHabbits() {
		System.out.println("Eat Flesh");

	}

	void getData() {
		super.getData();
		System.out.println(super.nailstype);
		System.out.println(nailstype);
	}

}
