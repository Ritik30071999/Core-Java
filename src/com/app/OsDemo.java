package com.app;
import com.os.*;

public class OsDemo {
	public static void main(String[] args) {
		
		Linux linux = new Linux();
		linux.ShowFeatures();
		
		Dos dos = new Dos();
		dos.ShowFeatures();
		
	}

}
