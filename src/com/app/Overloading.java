package com.app;

public class Overloading 
{
	void add(int x,int y)
	{
	int sum=x+y;
	System.out.println("sum of two integers "+sum);
	}
	void add(float x,float y)
	{
	 float sum=x+y;
	 System.out.println("sum of two floats "+sum);
	}
	void add(int x,float y)
	{
	 float sum=x+y;
	 System.out.println("sum of two int and float "+sum);
	}
	public static void main(String[] args) 
	{
	 Overloading o=new Overloading();
	 o.add(2.3f,3.4f);
	 o.add(2,3.5f);
	 o.add(2, 3);
	}
}
