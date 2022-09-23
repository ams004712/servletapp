package com.shoppingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static Connection getConnection() {

		Connection con = null;
		try {
			// jdbc:mysql:aws://instance-1.XYZ.us-east-2.rds.amazonaws.com:3306
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "TestDB" + "?user=" + "root"
					+ "&password=" + "Welcome9";
			con = DriverManager.getConnection(jdbcUrl);// DriverManager.getConnection("jdbc:mysql://database-1.c2tskthlfglu.us-east-1.rds.amazonaws.com:3306/database-1",
														// "admin", "Welcome9");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;

	}

	public static void closeConnection(Connection con) {

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {

		System.out.println(getConnection());
	}

}
