package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnJDBC {
	static String url="jdbc:mysql://localhost:3306/qlthisinh";
	static String user = "root";
	static String password = "Giangta01*";
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
