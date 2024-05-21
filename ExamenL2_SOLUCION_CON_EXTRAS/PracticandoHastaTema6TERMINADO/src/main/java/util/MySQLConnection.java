package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost/reforzandoL2";
			String usr ="root";
			String psw = "mysql";
			cn = DriverManager.getConnection(url,usr,psw);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("ERROR: Driver no encontrado");
		}catch(SQLException e) {
			System.out.println("ERROR DE CONEXION CON BD");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR GENERAL");
		}
		return cn;
	}

}
