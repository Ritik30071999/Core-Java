package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.event.*;

import java.sql.*;

public class Department extends JFrame implements ActionListener {

	private Connection con;
	private PreparedStatement psdept;

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txthod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department frame = new Department();
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
	public Department() {
		setTitle("Department");
		con = CrudOperation.createConnection();
		createGui();

	}

	public void createGui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1075, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		getContentPane().setBackground(Color.CYAN);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID:-");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(226, 159, 62, 26);
		getContentPane().add(lblId);

		JLabel lblName = new JLabel("Name:-");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(226, 250, 62, 26);
		getContentPane().add(lblName);

		JLabel lblHod = new JLabel("HOD:-");
		lblHod.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblHod.setBounds(226, 345, 62, 26);
		getContentPane().add(lblHod);

		txtid = new JTextField();
		txtid.setBounds(523, 165, 96, 19);
		getContentPane().add(txtid);
		txtid.setColumns(10);

		txtname = new JTextField();
		txtname.setBounds(523, 256, 96, 19);
		getContentPane().add(txtname);
		txtname.setColumns(10);

		txthod = new JTextField();
		txthod.setBounds(523, 351, 96, 19);
		getContentPane().add(txthod);
		txthod.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSubmit.setBounds(390, 467, 96, 35);
		getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userid = txtid.getText().trim();
		String username = txtname.getText().trim();
		String userhod = txthod.getText().trim();

		if (userid.isEmpty() || username.isEmpty() || userhod.isEmpty()) {
			JOptionPane.showMessageDialog(this, "data needed");
		} else {
			try {
				String strinsert = "insert into department values(?,?,?)";
				psdept = con.prepareStatement(strinsert);
				psdept.setString(1, userid);
				psdept.setString(2, username);
				psdept.setString(3, userhod);

				int row = psdept.executeUpdate();
				if (row > 0) {
					System.out.println("row inserted successfully");
					JOptionPane.showMessageDialog(this, "recorded successfully");
					txtid.setText("");
					txtname.setText("");
					txthod.setText("");
				}

			} catch (SQLException se) {
				System.out.println(se);
			} finally {
				try {
					if (psdept != null)
						psdept.close();
				} catch (SQLException se) {
					System.out.println(se);
				}

			}
		}

	}

}
