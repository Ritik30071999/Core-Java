package com.app;

//name,constructors,methods
import static java.lang.Math.*;
import static java.lang.System.*;

public class StaticDemo {
	public static void main(String[] args) {

		double sq = sqrt(16);               //static import of Math class
		out.println(sq);                    //static import of System class

		double pw = pow(2, 6);
		out.println(pw);
	}

}
