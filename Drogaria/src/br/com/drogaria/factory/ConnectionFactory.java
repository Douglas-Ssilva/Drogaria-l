package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL= "jdbc:mysql://localhost:3306/drogaria";
	private static final String USER= "root";
	private static final String PASSWORD= "";
	private static Connection connection= null;
	
	static {
		init();
	}

	private static void init() {
		if(connection == null) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection= DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
