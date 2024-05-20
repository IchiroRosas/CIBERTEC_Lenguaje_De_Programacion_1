package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.Users;
import interfaz.AdminAuthInterface;
import util.SQLConexion;

public class AuthModelo implements AdminAuthInterface {

	@Override
	public Users InicioSesion(String correo, String contraseña) {
		Users user = null;
		PreparedStatement pstm = null;
		Connection cn = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
	        String mysql = "SELECT * FROM USERS WHERE correo=? AND contraseña=?";
	        pstm = cn.prepareStatement(mysql);
	        pstm.setString(1, correo);
	        pstm.setString(2, contraseña);
	        rs = pstm.executeQuery();
	        if(rs.next()) {
	        	user = new Users();
	        	user.setNombres(rs.getString("nombres"));
	        	user.setApellidos(rs.getString("apellidos"));
	        	user.setRol(rs.getString("rol"));
	        }
	        	   
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) cn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}
}