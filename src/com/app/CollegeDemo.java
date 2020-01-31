package com.app;

public class CollegeDemo {
	public static void main(String[] args) {

		EngineeringCollege ec = new EngineeringCollege();
		System.out.println(ec); //hash code of the object

		SportsCollege sc = new SportsCollege();
		System.out.println(sc); //hash code of the object
		
		College c=null;
		c=ec;
		c.setName("AKGEC");
		c.getName();
		c.showFacilities();         //engg colg method
		ec.show();
		
		c=sc;
		c.setName("KD Singh");
		c.getName();
		c.showFacilities();         //sports colg method

	}
}
