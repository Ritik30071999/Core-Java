package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class DateDemo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JDateChooser dc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateDemo frame = new DateDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DateDemo() {
		createGui();
	}
	public void createGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 628);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnShow.addActionListener(this);
		btnShow.setBounds(421, 418, 111, 27);
		contentPane.add(btnShow);
		
		dc = new JDateChooser();
		dc.setBounds(394, 148, 172, 40);
		dc.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("click");
		java.util.Date d = dc.getDate();
		System.out.println(d);
		long t = d.getTime();
		java.sql.Date sd = new java.sql.Date(t);
		System.out.println(sd);
	}
}
