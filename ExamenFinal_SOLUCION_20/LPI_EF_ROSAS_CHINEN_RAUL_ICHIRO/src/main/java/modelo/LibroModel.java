package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Libro;
import interfaces.LibroInterface;
import util.MySqlConexion;

public class LibroModel implements LibroInterface {

	@Override
	public List<Libro> listLibros() {
		// TODO Auto-generated method stub
		
		List<Libro> libros = new ArrayList<Libro>();
		Connection cn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		
		try {
			cn = MySqlConexion.getConexion();
			String sql="SELECT * FROM libro";
			psm = cn.prepareStatement(sql);
			rs=psm.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getString("id"));
				libro.setCodigo(rs.getString("codigo"));
				libro.setNombreLibro(rs.getString("nombreLibro"));
				libro.setStock(rs.getInt("stock"));
				libros.add(libro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(psm != null) psm.close();
				if(cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return libros;
	}

}
