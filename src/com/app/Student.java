package com.app;

public class Student 
{
	String name;
	static final String SCHOOLNAME="MontFort";
	static final String MOTTO="Spread Joy";
	static final String Principal_Name;	
	static                                               
	{                                                    //static block never needs to be called
	 Principal_Name="xyz";
	 System.out.println(Principal_Name);
	}
	Student(String name)
	{
	 this.name=name;
	}
   	static void show()
   	{
   		System.out.println("School name is "+SCHOOLNAME);
   		System.out.println("School motto is "+MOTTO);
   		//System.out.println(name);//name variable cannot be printed in static function as it is instance variable
   	}
	void getData()
	{
      System.out.println("name of student is "+name);
	  System.out.println("name of school is "+SCHOOLNAME);
    }
   
}
