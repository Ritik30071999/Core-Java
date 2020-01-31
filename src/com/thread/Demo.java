package com.thread;

public class Demo {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello");

			} // anonymous inner class
		});
		t.start();
	}

}
