package com.app;

public class BankDemo {
	public static void main(String[] args) {
		System.out.println(Bank.BANKNAME + " Bank");
		System.out.println(Bank.BRANCH + " Branch");
		Bank.show();

		Bank b = new Bank("Scott", 12345);
		b.getData();

		Bank b1 = new Bank("Scott", 12345);
		b1.setData("Smith", 54321);
		b1.getData();
	}

}
