package com.app;

public class Cuboid extends Box {

	int calArea() {
		int area = 2 * (length * breadth + height * breadth + length * height);
		return area;
	}

	int calVolume() {
		int volume = length * breadth * height;
		return volume;
	}

}
