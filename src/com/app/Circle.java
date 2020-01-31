package com.app;

public class Circle extends Shape {

	String color;

	void setColor(String color) {
		this.color = color;
	}

	void getColor() {
		System.out.println("Color is " + color);
	}

	float calArea() {
		float area = 3.14f * radius * radius;
		return area;
	}

}
