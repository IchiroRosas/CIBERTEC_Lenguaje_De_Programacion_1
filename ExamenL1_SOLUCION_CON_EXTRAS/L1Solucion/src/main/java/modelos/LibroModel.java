package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Libro;
import util.MySqlConnection;

public class LibroModel implements interfaces.LibroInterface{

	@Override
	public List<Libro> listLibro() {
		// TODO Auto-generated method stub
		List<Libro> listado = new ArrayList<Libro>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConnection.getConnection();
			String sql = "select * from libro";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setIdLibro(rs.getString("idLibro"));
				libro.setCodigo(rs.getString("codigo"));
				libro.setNombreLibro(rs.getString("nombreLibro"));
				libro.setEdicion(rs.getString("edicion"));
				libro.setTipo(rs.getString("tipo"));
				libro.setPrecio(rs.getString("precio"));
				libro.setStock(rs.getString("stock"));
				libro.setFechaCompra(rs.getString("fechaCompra"));
				
				listado.add(libro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cn!=null) cn.close();
				if(psm!=null) psm.close();
				if(rs!=null) rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listado;
	}

	@Override
	public int createLibro(Libro libro) {
		// TODO Auto-generated method stub
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		try {
			cn = MySqlConnection.getConnection();
			String sql = "insert into libro values (null,?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, libro.getCodigo());
			psm.setString(2, libro.getNombreLibro());
			psm.setString(3, libro.getEdicion());
			psm.setString(4, libro.getTipo());
			psm.setString(5, libro.getPrecio());
			psm.setString(6, libro.getStock());
			psm.setString(7, libro.getFechaCompra());
			
			psm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (cn!=null) cn.close();
				if (psm!=null) psm.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int updateLibro(Libro libro) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement psm = null;
		int value = 0;
		try {
			cn = MySqlConnection.getConnection();
			String sql = "UPDATE libro SET codigo=?,nombreLibro=?,edicion=?,tipo=?,precio=?,stock=?,fechaCompra=? where idLibro=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, libro.getCodigo());
			psm.setString(2, libro.getNombreLibro());
			psm.setString(3, libro.getEdicion());
			psm.setString(4, libro.getTipo());
			psm.setString(5, libro.getPrecio());
			psm.setString(6, libro.getStock());
			psm.setString(7, libro.getFechaCompra());
			psm.setString(8, libro.getIdLibro());
			
			value = psm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cn!=null) cn.close();
				if(psm!=null) psm.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteLibro(String id) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement psm = null;
		int value = 0;
		try {			
			cn = MySqlConnection.getConnection();
			String sql = "delete from libro where idLibro=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			value = psm.executeUpdate();
			System.out.println("Eliminación exitosa.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cn!=null) cn.close();
				if(psm!=null) psm.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Libro getLibro(String id) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		Libro libro = new Libro();
		try {
			cn = MySqlConnection.getConnection();
			String sql = "select * from libro where idLibro=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				libro.setIdLibro(rs.getString("idLibro"));
				libro.setCodigo(rs.getString("codigo"));
				libro.setNombreLibro(rs.getString("nombreLibro"));
				libro.setEdicion(rs.getString("edicion"));
				libro.setTipo(rs.getString("tipo"));
				libro.setPrecio(rs.getString("precio"));
				libro.setStock(rs.getString("stock"));
				libro.setFechaCompra(rs.getString("fechaCompra"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(psm!=null) psm.close();
				if(rs!=null) rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return libro;
	}
	
}
