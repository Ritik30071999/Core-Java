package com.app;

public abstract class Box {

	int length, breadth, height;

	void setDim(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	abstract int calArea();

	abstract int calVolume();

}
