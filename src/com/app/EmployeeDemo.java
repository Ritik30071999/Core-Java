package com.app;

public class EmployeeDemo {

    public static void main(String[] args) {
	
    Employee e=new Employee();
    e.getter();
    Employee e1=new Employee(20,57639,"John");
    e1.getter();
    Employee e2=new Employee();
    e2.getter();
    e2.setter(28,78656,"Steve");
    e2.getter();
    }
}
