package com.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		System.out.println(t);
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
