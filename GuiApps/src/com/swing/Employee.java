package com.swing;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Employee extends JFrame implements ActionListener, WindowListener {

	private Connection con;
	private PreparedStatement psemployee;

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JRadioButton rdmale, rdfemale;
	private ButtonGroup gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		this.addWindowListener(this); // employeeFrameObject
		con = CrudOperation.createConnection(); // empdb
		createGui();
	}

	public void createGui() {
		setTitle("Employee Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1220, 695);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdentity = new JLabel("Identity");
		lblIdentity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdentity.setBounds(288, 170, 68, 33);
		contentPane.add(lblIdentity);

		txtid = new JTextField();
		txtid.setBounds(509, 170, 153, 26);
		contentPane.add(txtid);
		txtid.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(288, 264, 68, 19);
		contentPane.add(lblName);

		txtname = new JTextField();
		txtname.setBounds(509, 266, 153, 26);
		contentPane.add(txtname);
		txtname.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEmail.setBounds(288, 354, 68, 19);
		contentPane.add(lblEmail);

		txtemail = new JTextField();
		txtemail.setBounds(509, 353, 153, 26);
		contentPane.add(txtemail);
		txtemail.setColumns(10);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPhoneNo.setBounds(288, 446, 91, 13);
		contentPane.add(lblPhoneNo);

		txtphone = new JTextField();
		txtphone.setBounds(509, 440, 153, 26);
		contentPane.add(txtphone);
		txtphone.setColumns(10);

		rdmale = new JRadioButton("Male");
		rdmale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rdmale.setBounds(339, 522, 91, 40);
		contentPane.add(rdmale);

		rdfemale = new JRadioButton("Female");
		rdfemale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rdfemale.setBounds(520, 522, 105, 40);
		contentPane.add(rdfemale);

		gender = new ButtonGroup();
		gender.add(rdmale);
		gender.add(rdfemale);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSubmit.setBounds(417, 596, 98, 33);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 40));
		lblEmployee.setBounds(385, 36, 207, 70);
		contentPane.add(lblEmployee);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userid = txtid.getText().trim();
		String username = txtname.getText().trim();
		String useremail = txtemail.getText().trim();
		String userphone = txtphone.getText().trim();

		String gen = null;
		if (rdmale.isSelected())
			gen = rdmale.getText();
		if (rdfemale.isSelected())
			gen = rdfemale.getText();

		if (userid.isEmpty() || username.isEmpty() || useremail.isEmpty() || userphone.isEmpty() || gen.isEmpty()) {
			JOptionPane.showMessageDialog(this, "data needed");
		} else {
			/*
			 * if (userid.equals("226010") && username.equals("scott") &&
			 * useremail.equals("scott@gmail.com") && userphone.equals("9898989898")) {
			 * JOptionPane.showMessageDialog(this, "Welcome " + username); this.dispose(); }
			 * else { JOptionPane.showMessageDialog(this, "Invalid UserId Password"); }
			 */
			try {
				String strinsert = "insert into employee values(?,?,?,?,?)";
				psemployee = con.prepareStatement(strinsert); // dbms compiles this query
				psemployee.setString(1, userid);
				psemployee.setString(2, username);
				psemployee.setString(3, useremail);
				psemployee.setString(4, userphone);
				psemployee.setString(5, gen);

				int row = psemployee.executeUpdate();
				if (row > 0) {
					System.out.println("row inserted successfully");
					JOptionPane.showMessageDialog(this, "record added successfully");
					txtid.setText("");
					txtname.setText("");
					txtemail.setText("");
					txtphone.setText("");
				}

			} catch (SQLException se) {
				System.out.println(se);
			} finally {
				if (psemployee != null) {
					try {
						psemployee.close();
					} catch (SQLException se) {
						System.out.println(se);
					}
				}

			}

		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Frame is getting closed");
		try {
			if (con != null)
				con.close();
		} catch (SQLException se) {
			System.out.println(se);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
