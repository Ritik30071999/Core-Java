package com.thread;

public class CustomThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		CustomThread ct = new CustomThread("number");
		ct.join();
		boolean status = ct.isAlive();
		System.out.println(status);
		new CustomThread("Digits").join(); // anonymous object
		new CustomThread("Custom");
	}

}
