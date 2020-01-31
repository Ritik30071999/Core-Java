package com.app;

public class PersonDemo {
	public static void main(String[] args) {
		
		Person p = new Person("Scott");
		p.getDetails();
		p.write();
		p.listen();
		
	    Listener list = null;            //runtime polymorphism
	    list = p;
	    list.listen();
	    
	    Writer writ = null;             //runtime polymorphism
	    writ = p;
	    writ.write();
	}

}
