package com.app;

public interface Calculation {

	float PI=3.14f;
	
	int add(int n1,int n2);              //abstract methods by default
	int multiply(int n1,int n2);
	
	default double squareRoot(double num)  {
		return 0.0;
	}
	
}
