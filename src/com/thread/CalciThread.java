package com.thread;

public class CalciThread extends Thread {
	Table tbl;
	int number;

	public CalciThread(String name, Table tbl, int number) {
		setName(name);
		this.tbl = tbl;
		this.number = number;
		start();
	}

	public void run() {
		tbl.printTable(number);
	}

}
