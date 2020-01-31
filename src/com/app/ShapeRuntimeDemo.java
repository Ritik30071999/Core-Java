package com.app;

public class ShapeRuntimeDemo {
	public static void main(String[] args) {

		RectangleRuntime r = new RectangleRuntime();
		System.out.println(r);

		TriangleRuntime t = new TriangleRuntime();
		System.out.println(t);

		CircleRuntime c = new CircleRuntime();
		System.out.println(c);

		ShapeRuntime s = null;
		s = r;
		s.setDim(5.0f,6.0f,0.0f);
		float area = s.calArea();
		System.out.println("Area of Rectangle is " + area);

		s = t;
		s.setDim(0.0f,3.0f,4.0f);
		area = s.calArea();
		System.out.println("Area of Trinagle is " + area);

		s = c;
		s.setDim(4.0f,0.0f,0.0f);
		area = c.calArea();
		System.out.println("Area of Circle is " + area);
	}

}
