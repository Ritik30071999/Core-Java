package com.app;

public class BoxDemo {
	public static void main(String[] args) {

		Cube c = new Cube();
		c.setDim(3, 3, 3);
		int area = c.calArea();
		System.out.println("Area of Cube is " + area);
		int volume = c.calVolume();
		System.out.println("Volume of Cube is " + volume);

		Cuboid c1 = new Cuboid();
		c1.setDim(2, 3, 4);
		area = c1.calArea();
		System.out.println("Area of Cuboid is " + area);
		volume = c1.calVolume();
		System.out.println("Volume of Cuboid is " + volume);

	}
}
