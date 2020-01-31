package com.app;

public class Employee 
    {
	int age,id;
	String name;
	Employee()
	{
      age=25;
      id=54321;
      name="Smith";
	}
	Employee(int age,int id,String name)
	{
	 this.age=age;
	 this.id=id;
	 this.name=name;
	}
	void setter(int age,int id,String name) 
	{
	 this.age=age;
     this.id=id;
	 this.name=name;
	}
	void getter()
	{
     System.out.println("Name of the person is "+name);
     System.out.println("Age of the person is "+age);
     System.out.println("Id of the person is "+id);
    } 
   }
  