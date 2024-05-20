package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.Usuario;
import interfaces.AuthInterface;
import util.MySqlConexion;

public class AuthModel implements AuthInterface {

	@Override
	public Usuario verificarInicioSesion(String correo, String clave) {
		// TODO Auto-generated method stub
		
		Usuario usuario= null;
		PreparedStatement psmt = null;
		Connection cn = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConexion();
			String mysql = "SELECT usr.iduser, usr.email, pe.name, pe.lastname, "
					+ "ro.rolName FROM user AS usr "
					+ "INNER JOIN people AS pe "
					+ "ON usr.people_idpeople = pe.idpeople "
					+ "INNER JOIN rol AS ro "
					+ "ON usr.rol_idrol = ro.idrol "
					+ "WHERE email = ? AND password = ?";
			psmt = cn.prepareStatement(mysql);
			psmt.setString(1, correo);
			psmt.setString(2, clave);
			rs = psmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setNombre(rs.getString("name"));
				usuario.setApellidos(rs.getString("lastname"));
				usuario.setId(rs.getString("iduser"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRol(rs.getString("rolName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.printStackTrace();
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) rs.close();
				if (cn != null) rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return usuario;
	}

}
