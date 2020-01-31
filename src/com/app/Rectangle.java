package com.app;

public class Rectangle extends Shape {

	String color;

	void setColor(String color) {
		this.color = color;
	}

	void getColor() {
		System.out.println("Color is " + color);
	}

	float calArea() {
		float area = width * height;
		return area;
	}

}
