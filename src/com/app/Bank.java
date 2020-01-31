package com.app;

public class Bank {
	static final String BANKNAME = "PNB";
	static final String BRANCH = "Hazratganj";
	String cusname;
	int accno;

	Bank(String cusname, int accno) {
		this.cusname = cusname;
		this.accno = accno;
	}

	void setData(String cusname, int accno) {
		this.cusname = cusname;
		this.accno = accno;
	}

	void getData() {
		System.out.println("Customer Name is " + cusname);
		System.out.println("Account Number is " + accno);
		System.out.println("Bank Name is " + BANKNAME);
		System.out.println("Branch is " + BRANCH);
	}

	static void show() {
		System.out.println("Bank Name is " + BANKNAME);
		System.out.println("Branch is " + BRANCH);
	}
}
