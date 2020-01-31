package com.app;

public class Cub extends Lion {

	String nailstype = "soft";

	void getData() {
		super.getData(); // lion getdata
		System.out.println("Cub's nail type is " + nailstype);

	}

}
