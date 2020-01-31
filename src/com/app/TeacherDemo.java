package com.app;

public class TeacherDemo {
	public static void main(String[] args) {

		Teacher t = new Teacher("Smith", "10");

		Listener list = null;
		list = t;
		t.getDetails();
		list.listen();

		Writer writ = null;
		writ = t;
		writ.write();
	}

}
