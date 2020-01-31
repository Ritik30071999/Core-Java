package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.sql.*;

public class DeleteEmployee extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JComboBox<String> cmbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		con = CrudOperation.createConnection();
		setResizable(false);
		createGui();
	}

	public void fillCombo() {
		try {
			String strsql = "select id from employee";
			ps = con.prepareStatement(strsql);
			rs = ps.executeQuery();// fires select query
			while (rs.next()) {
				String empid = rs.getString("id");
				cmbid.addItem(empid);
			}
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	public void createGui() {
		setTitle("Delete");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1197, 696);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cmbid = new JComboBox();
		cmbid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		cmbid.setModel(new DefaultComboBoxModel(new String[] { "Select EmployeeID" }));
		cmbid.setBounds(500, 141, 175, 35);
		fillCombo();
		contentPane.add(cmbid);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnDelete.setBounds(553, 276, 85, 21);
		contentPane.add(btnDelete);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int option = JOptionPane.showConfirmDialog(this, "Are u sure to delete record?");
		System.out.println(option);
		if (option == 0) {
			String employeeid = (String) cmbid.getSelectedItem(); // to get value from checkbox //downcasting
			if (employeeid.equals("Select EmployeeID")) {
				JOptionPane.showMessageDialog(this, "Select valid ID");
			} else {
				String strdelete = "delete from employee where id=?";
				try {
					ps = con.prepareStatement(strdelete);
					ps.setString(1, employeeid);
					int row = ps.executeUpdate();
					if (row > 0) {
						JOptionPane.showMessageDialog(this, "record deleted successfully");
					}
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}
	}
}
