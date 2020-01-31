package com.app;

public class FootballPlayer extends Player {

	int jerseyno;

	FootballPlayer() {
		System.out.println("in footballplayer class");
	}

	FootballPlayer(int jerseyno, String name, int age) {
		super(name, age);
		this.jerseyno = jerseyno;
	}

	void getDetails() {
		super.getDetails();
		System.out.println("Jersey Number is " + jerseyno);
	}
}
