package com.awt;

import java.awt.*;

public class DemoFrame extends Frame {

	Color c;
	TextField txtname;
	Button btn;

	public void createComponents() {
		txtname = new TextField(10);
		btn = new Button("Submit");
		txtname.setBounds(50, 100, 100, 30);
		add(txtname);
		btn.setBounds(50, 160, 100, 30);
		add(btn);
	}

	public DemoFrame(String title) {
		super(title);
		c = new Color(120, 200, 100);
		setBackground(c);
		setSize(500, 400);
		setLayout(null);
		createComponents();
		setVisible(true);

	}

	public static void main(String[] args) {
		new DemoFrame("IntroFrame"); // anonymous object
	}

}
