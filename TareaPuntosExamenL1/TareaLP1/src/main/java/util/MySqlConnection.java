package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	public static Connection getConnection() {
		Connection cn= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/BD_ELEFANTES";
			String usr = "root";
			String psw = "mysql";
			cn = DriverManager.getConnection(url,usr,psw);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Drive no encontrado" + e.getMessage());
		} catch (SQLException e){
			System.out.println("ERROR de conexión con BD" + e.getMessage());
		} catch (Exception e){
			System.out.println("ERROR" + e.getMessage());
		}
		return cn;
	}
}
