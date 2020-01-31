package com.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutils.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection con;
	private PreparedStatement psupdate;
	private PreparedStatement pssearch;
	private JTextField txtid;
	private JTextField txtphone;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		con = CrudOperation.createConnection();
		createGui();
	}

	public void createGui() {
		setTitle("Update");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1035, 698);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEmployeeId.setBounds(112, 113, 114, 30);
		contentPane.add(lblEmployeeId);

		JLabel lblNewLabel = new JLabel("Phone No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(112, 209, 114, 30);
		contentPane.add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEmail.setBounds(112, 296, 114, 30);
		contentPane.add(lblEmail);

		txtid = new JTextField();
		txtid.setBounds(380, 121, 114, 19);
		contentPane.add(txtid);
		txtid.setColumns(10);

		txtphone = new JTextField();
		txtphone.setBounds(380, 217, 114, 19);
		contentPane.add(txtphone);
		txtphone.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(380, 304, 114, 19);
		contentPane.add(txtemail);
		txtemail.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSearch.setBounds(194, 412, 100, 30);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(357, 412, 100, 30);
		contentPane.add(btnUpdate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption = e.getActionCommand();
		if (caption.equals("Search")) {
			String id = txtid.getText();
			if (id.isEmpty())
				JOptionPane.showMessageDialog(this, "Enter id");
			else {
				String strsql = "select * from employee where id=?";
				try {
					pssearch = con.prepareStatement(strsql);
					pssearch.setString(1, id);
					ResultSet rs = pssearch.executeQuery();
					if (rs.next()) {
						String ename = rs.getString("name");
						String ephone = rs.getString("phone");
						String email = rs.getString("email");
						txtemail.setText(email);
						txtphone.setText(ephone);
					} else {
						JOptionPane.showMessageDialog(this, "No such ID");
					}

				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}
		if (caption.equals("Update")) {
			String id = txtid.getText();
			String email = txtemail.getText();
			String phone = txtphone.getText();
			if (id.isEmpty() || email.isEmpty() || phone.isEmpty())
				System.out.println("Data Needed");
			else {
				try {
					String strupdate = "update employee set email=?, phone=? where id=?";
					psupdate = con.prepareStatement(strupdate);
					psupdate.setString(1, email);
					psupdate.setString(2, phone);
					psupdate.setString(3, id);
					int row = psupdate.executeUpdate();
					if (row > 0)
						JOptionPane.showMessageDialog(this, "Record Updated");
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

		}
		// finally
	}
}