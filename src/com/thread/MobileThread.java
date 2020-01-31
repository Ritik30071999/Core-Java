package com.thread;

public class MobileThread extends Thread {
	Table tbl;
	int number;

	public MobileThread(String name, Table tbl, int number) {
		setName(name);
		this.tbl = tbl;
		this.number = number;
		start();
	}

	public void run() {
		tbl.printTable(number);
	}

}
