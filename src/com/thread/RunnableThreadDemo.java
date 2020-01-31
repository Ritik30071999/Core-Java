package com.thread;

public class RunnableThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		RunnableThread eventhread = new RunnableThread("Even");
		eventhread.t.join();
		RunnableThread oddthread = new RunnableThread("Odd");
	}

}
