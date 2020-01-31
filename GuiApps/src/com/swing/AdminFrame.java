package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AdminFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem miempadd, miempupdate, miempdelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setTitle("Admin");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createGui();
	}

	public void createGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 544);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu empmenu = new JMenu("EmployeeDetails");
		menuBar.add(empmenu);

		miempadd = new JMenuItem("AddEmployee");
		miempadd.addActionListener(this);
		empmenu.add(miempadd);

		miempupdate = new JMenuItem("UpdateEmployee");
		miempupdate.addActionListener(this);
		empmenu.add(miempupdate);

		miempdelete = new JMenuItem("DeleteEmployee");
		miempdelete.addActionListener(this);
		empmenu.add(miempdelete);

		JMenu empaccount = new JMenu("Account");
		menuBar.add(empaccount);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToAdmin = new JLabel("Welcome To Admin Frame");
		lblWelcomeToAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblWelcomeToAdmin.setBounds(336, 43, 402, 37);
		contentPane.add(lblWelcomeToAdmin);

		JButton btnSubmit = new JButton("Employee");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setIcon(null);
		btnSubmit.setBounds(473, 302, 97, 30);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnUpdate.addActionListener(this);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(473, 373, 97, 30);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnDelete.addActionListener(this);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(473, 439, 97, 30);
		contentPane.add(btnDelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Welcome");

		String caption = e.getActionCommand();
		System.out.println(caption);
		if (caption.equalsIgnoreCase("Employee")) {
			Employee emp = new Employee();
			emp.setVisible(true);
		}
		if (caption.equalsIgnoreCase("Update")) {
			UpdateEmployee emp = new UpdateEmployee();
			emp.setVisible(true);
		}
		if (caption.equalsIgnoreCase("Delete")) {
			DeleteEmployee del = new DeleteEmployee();
			del.setVisible(true);
		}
	}
}
