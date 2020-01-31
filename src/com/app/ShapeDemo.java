package com.app;

public class ShapeDemo {
	public static void main(String[] args) {

		Rectangle r = new Rectangle();
		r.setDim(3, 2);
		float area = r.calArea();
		r.setColor("red");
		r.getColor();
		System.out.println("Area of Rectangle is " + area);

		Circle c = new Circle();
		c.setDim(5);
		area = c.calArea();
		c.setColor("yellow");
		c.getColor();
		System.out.println("Area of Circle is " + area);

		Square s = new Square();
		s.setDim(4, 4);
		area=s.calArea();
		s.setColor("Pink");
		s.getColor();
		System.out.println("Area of Square is " + area);
	}

}
