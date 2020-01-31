package com.swing;

import java.awt.BorderLayout;

import java.awt.event.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;
	int i = 0;
	int[] r = { 210, 150, 90 };
	int[] g = { 240, 100, 80 };
	int[] b = { 180, 75, 150 };
	Color c;

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
	public Login() {

		createGui();

	}

	public void changecolor() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					c = new Color(r[i], g[i], b[i]);
					getContentPane().setBackground(c);
					i++;
					if (i > 2)
						i = 0;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
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

			if (userid.equals("scott") && userpass.equals("precursor")) {
				JOptionPane.showMessageDialog(this, "Welcome " + userid);
				AdminFrame admin = new AdminFrame();
				admin.setVisible(true);
				this.dispose(); // closes the current window/object
			}

			if (userid.equals("counselor") && userpass.equals("12345")) {
				JOptionPane.showMessageDialog(this, "Welcome " + userid);
				CounselorFrame cf = new CounselorFrame();
				cf.setVisible(true);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Invalid UserId Password");
			}

		}

	}
}
