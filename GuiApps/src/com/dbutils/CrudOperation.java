package com.dbutils;

import java.sql.*;

public class CrudOperation {

	private static Connection con;

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // create the object of the Driver class
													// factorMethod->create object that can't be created by new keyword
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
			                                        //name or IP Address of the machine where DB is installed
			                                        //connection string

		} catch (SQLException | ClassNotFoundException cse) {
			System.out.println(cse);
		}
		return con;
	}

	/*
	 * public static void main(String[] args) { Connection cn = createConnection();
	 * System.out.println(cn); }
	 */

}
