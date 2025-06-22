package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection con;

	public static Connection getCon() {
		return con;
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet", "root", "");
			System.out.println("Connection avec succes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
