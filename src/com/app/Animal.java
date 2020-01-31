package com.app;

public class Animal {
	String color, type;
	String nailstype = "normal";

	void setData(String color, String type) {
		this.color = color;
		this.type = type;
	}

	void getData() {
		System.out.println("Color is " + color);
		System.out.println("Type is " + type);
	}

}
