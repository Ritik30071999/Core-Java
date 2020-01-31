package com.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbutils.CrudOperation;

import java.sql.*;

public class ViewAllEmployee extends JFrame {

	private JPanel contentPane;
	private JTable emptable;
	private Connection con;
	private PreparedStatement pscount, psdata;
	private ResultSet rscount, rsdata;

	String[] colNames = { "EmployeeID", "Name", "EmailId", "Phone" };
	String[][] data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllEmployee frame = new ViewAllEmployee();
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
	public ViewAllEmployee() {
		con = CrudOperation.createConnection();
		createGui();

	}

	public void fillTable() {
		try {
			int rowcnt = 0;
			String strcount = "select count(*) from employee";
			pscount = con.prepareStatement(strcount);
			rscount = pscount.executeQuery();
			if (rscount.next()) {
				rowcnt = rscount.getInt(1);
				System.out.println(rowcnt);
				data = new String[rowcnt][4];// 2-d array creation
			}
			String strsql = "select * from employee";
			psdata = con.prepareStatement(strsql);
			rsdata = psdata.executeQuery();
			int row = 0;
			while (rsdata.next()) {
				String id = rsdata.getString("id");
				String name = rsdata.getString("name");
				String email = rsdata.getString("email");
				String phone = rsdata.getString("phone");

				data[row][0] = id;
				data[row][1] = name;
				data[row][2] = email;
				data[row][3] = phone;

				row++;
			}
		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			if (psdata != null) {
				try {
					psdata.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (pscount != null) {
				try {
					pscount.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (rsdata != null) {
				try {
					rsdata.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
			if (rscount != null) {
				try {
					rscount.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}
	}

	public void createGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 122, 684, 410);
		contentPane.add(scrollPane);

		emptable = new JTable();

		JTableHeader header = emptable.getTableHeader();
		header.setBackground(Color.black);
		header.setForeground(Color.white);
		header.setFont(new Font("Arial", Font.BOLD, 20));

		/*
		 * emptable.setModel(new DefaultTableModel( new Object[][] { { "emp001", "john",
		 * "john@gmail.com", "9898989898" }, { "emp002", "scott", "scott@gmail.com",
		 * "9879879879" }, { "emp003", "smith", "smith@gmail.com", "5675675675" }, {
		 * "emp004", "bob", "bob@gmail.com", "7867867867" } }, new String[] {
		 * "Employee ID", "Name", "Email ID", "Phone No." }));
		 */

		fillTable();
		emptable.setModel(new DefaultTableModel(data, colNames));

		scrollPane.setViewportView(emptable);
	}
}
