package com.app;

public class StudentDemo 
{
  public static void main(String[] args) 
  {
	 System.out.println(Student.SCHOOLNAME+" School");//static variable is printing before object creation
	 //Student.SCHOOLNAME="abcd";//it will not change as it is final variable
	 Student.show();  //static function is also called before object craetion
	 System.out.println("Principal name is "+Student.Principal_Name);
	 
	 Student s=new Student("Scott");
	 s.getData();
	 
	  
  }
}
