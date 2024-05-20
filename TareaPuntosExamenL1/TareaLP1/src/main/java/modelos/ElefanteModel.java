package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Elefante;
import util.MySqlConnection;

public class ElefanteModel implements interfaces.ElefanteInterface{

	@Override
	public List<Elefante> listElefante() {
		// TODO Auto-generated method stub
		List<Elefante> listado = new ArrayList<Elefante>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConnection.getConnection();
			String sql = "select * from elefante";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Elefante elefante = new Elefante();
				elefante.setIdElefante(rs.getString("idElefante"));
				elefante.setNombre(rs.getString("nombre"));
				elefante.setOrigen(rs.getString("origen"));
				elefante.setPatas(rs.getString("patas"));
				elefante.setOrejas(rs.getString("orejas"));
				elefante.setTrompa(rs.getString("trompa"));
				elefante.setPeso(rs.getString("peso"));
				elefante.setFechaNacimiento(rs.getString("fechaNacimiento"));
				
				listado.add(elefante);
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
	public int createElefante(Elefante elefante) {
		// TODO Auto-generated method stub
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		try {
			cn = MySqlConnection.getConnection();
			String sql = "insert into elefante values (null,?,?,?,?,?,?,?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, elefante.getNombre());
			psm.setString(2, elefante.getOrigen());
			psm.setString(3, elefante.getPatas());
			psm.setString(4, elefante.getOrejas());
			psm.setString(5, elefante.getTrompa());
			psm.setString(6, elefante.getPeso());
			psm.setString(7, elefante.getFechaNacimiento());
			
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
	public int updateElefante(Elefante elefante) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement psm = null;
		int value = 0;
		try {
			cn = MySqlConnection.getConnection();
			String sql = "UPDATE elefante SET nombre=?,origen=?,patas=?,orejas=?,trompa=?,peso=?,fechaNacimiento=? where idElefante=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, elefante.getNombre());
			psm.setString(2, elefante.getOrigen());
			psm.setString(3, elefante.getPatas());
			psm.setString(4, elefante.getOrejas());
			psm.setString(5, elefante.getTrompa());
			psm.setString(6, elefante.getPeso());
			psm.setString(7, elefante.getFechaNacimiento());
			psm.setString(8, elefante.getIdElefante());
			
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
	public int deleteElefante(String id) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement psm = null;
		int value = 0;
		try {			
			cn = MySqlConnection.getConnection();
			String sql = "delete from elefante where idElefante=?";
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
	public Elefante getElefante(String id) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		Elefante elefante = new Elefante();
		try {
			cn = MySqlConnection.getConnection();
			String sql = "select * from elefante where idElefante=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				elefante.setIdElefante(rs.getString("idElefante"));
				elefante.setNombre(rs.getString("nombre"));
				elefante.setOrigen(rs.getString("origen"));
				elefante.setPatas(rs.getString("patas"));
				elefante.setOrejas(rs.getString("orejas"));
				elefante.setTrompa(rs.getString("trompa"));
				elefante.setPeso(rs.getString("peso"));
				elefante.setFechaNacimiento(rs.getString("fechaNacimiento"));
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
		return elefante;
	}
	
}
