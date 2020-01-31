package com.app;

public class Shape {
	float width, height;
	float radius;

	void setDim(float width, float height) {
		this.width = width;
		this.height = height;
	}

	void setDim(float radius) {
		this.radius = radius;
	}

	/*
	 * void setDim(float side) { this.side=side; }
	 */

	float calArea() {
		return 0;
	}

}
