package com.app;

public class Cube extends Box {

	int calArea() {
		int area = 6 * length * length;
		return area;
	}

	int calVolume() {
		int volume = length * breadth * height;
		return volume;
	}

}
