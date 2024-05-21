package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidades.Usuario;
import interfaces.UsuarioAuthInterface;
import util.MySQLConnection;

public class UsuarioAuthModel implements UsuarioAuthInterface {

	@Override
	public Usuario iniciarSesion(String correo, String clave) {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "select * from usuario where correo=? and contrasenia=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, correo);
			psm.setString(2, clave);
			rs = psm.executeQuery();
			if(rs.next()) {
				usuario.setCodigo(rs.getString("codigo"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(psm!=null) psm.close();
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return usuario;
	}

}
