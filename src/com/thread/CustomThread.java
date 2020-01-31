package com.thread;

public class CustomThread extends Thread {
	public CustomThread(String name) {
		setName(name);
		start(); // runnable state assign CPU run method
	}

	public void run() {
		String name = getName();
		System.out.println("thread name is "+name);
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
		}
	}
}
