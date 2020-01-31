package com.thread;

public class SyncDemo {
	public static void main(String[] args) {
		Table tbl = new Table();
		CalciThread ct = new CalciThread("Casio", tbl, 4);
		MobileThread mt = new MobileThread("Redmi", tbl, 5);
	}
}
