package com.thread;

public class Table {
	//thread never release it resource
	public synchronized void printTable(int num) {
		Thread t;
		t = Thread.currentThread();
		System.out.println(t.getName());
		for (int i = 1; i <= 10; i++) {
			System.out.println(num + "*" + i + "=" + (i * num));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
