package com.rafael.tarefas;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	public static Connection getConnection() {
		String user="root";
		String password="fearofdark";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/fj21", user, password); 
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
		return con;
	}
}
