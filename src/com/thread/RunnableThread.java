package com.thread;

public class RunnableThread implements Runnable {

	Thread t;

	public RunnableThread(String name) {
		// TODO Auto-generated constructor stub
		t = new Thread(this, name); // runtime polymporphism with interface
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = t.getName();
		if (name.equals("Even")) {
			System.out.println(name);
			for (int i = 2; i <= 10; i++) {
				if (i % 2 == 0)
					System.out.println(i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					System.out.println(ie);
				}
			}

		}
		// ***************************************
		if (name.equals("Odd")) {
			System.out.println(name);
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0)
					System.out.println(i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					System.out.println(ie);
				}
			}

		}

	}
}
