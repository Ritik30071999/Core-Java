package com.swing;

import java.awt.BorderLayout;
import java.sql.*;

import java.awt.event.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.dbutils.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Login1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login1() {

		con = CrudOperation.createConnection();
		createGui();
	}

	public void createGui() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/college7.jpg")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1306, 709);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new LineBorder(Color.PINK, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setBounds(261, 144, -200, -88);
		contentPane.add(lblUserid);

		JLabel lblUserid_1 = new JLabel("UserId");
		lblUserid_1.setBounds(518, 144, 46, 13);
		lblUserid_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblUserid_1);

		txtid = new JTextField();
		txtid.setBounds(638, 141, 96, 19);
		contentPane.add(txtid);
		txtid.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(518, 245, 68, 13);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPassword);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(548, 347, 85, 21);
		btnSubmit.addActionListener(this); // runtime polymorphism with interface
		contentPane.add(btnSubmit);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/images/college8.jpg")));
		lblNewLabel.setBounds(461, 405, 360, 226);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);

		txtpass = new JPasswordField();
		txtpass.setBounds(638, 244, 96, 19);
		contentPane.add(txtpass);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("Button Click");
		String userid = txtid.getText().trim();
		char[] pass = txtpass.getPassword();
		String userpass = new String(pass);
		if (userid.isEmpty() || userpass.length() == 0) {

			JOptionPane.showMessageDialog(this, "data needed");
		} else {
			try {
				String strsql = "select * from login where userid=? and userpass=?";
				ps = con.prepareStatement(strsql);
				ps.setString(1, userid);
				ps.setString(2, userpass);
				rs = ps.executeQuery();
				if (rs.next()) {
					String utype = rs.getString("usertype");
					if (utype.equals("admin")) {
						AdminFrame a = new AdminFrame();
						a.setVisible(true);
						this.dispose();
					}
					if (utype.equals("counselor")) {
						CounselorFrame c = new CounselorFrame();
						c.setVisible(true);
						this.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Invalid Userid/Password");
				}

			} catch (SQLException se) {
				System.out.println(se);
			}

		}

	}
}
