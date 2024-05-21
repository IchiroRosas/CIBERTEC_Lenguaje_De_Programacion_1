package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.MysqlConnection;

import entidades.Mascota;
import interfaces.MascotaInterface;
import util.MySQLConnection;

public class MascotaModel implements MascotaInterface {

	@Override
	public int createMascota(Mascota mascota) {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			psm = cn.prepareStatement("insert into mascota value (null,?,?,?,?,?)");
			psm.setString(1, mascota.getCodigo());
			psm.setString(2, mascota.getNombre());
			psm.setString(3, mascota.getMascota());
			psm.setString(4, mascota.getRaza());
			psm.setString(5, mascota.getDuenio());
			psm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
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
	public List<Mascota> listMascota() {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Mascota> listMascota = new ArrayList<Mascota>();
		
		try {
			cn = MySQLConnection.getConnection();
			String sql ="select * from mascota";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			while(rs.next()) {
				Mascota mascota = new Mascota();
				mascota.setId(rs.getString("id"));
				mascota.setCodigo(rs.getString("codigo"));
				mascota.setNombre(rs.getString("nombre"));
				mascota.setMascota(rs.getString("mascota"));
				mascota.setRaza(rs.getString("raza"));
				mascota.setDuenio(rs.getString("duenio"));
				listMascota.add(mascota);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (cn != null) cn.close();
				if (psm != null) psm.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return listMascota;
	}

	@Override
	public int updateMascota(Mascota mascota) {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		PreparedStatement psm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "update mascota set codigo=?, nombre=?, mascota=?, raza=?, duenio=? where id=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, mascota.getCodigo());
			psm.setString(2, mascota.getNombre());
			psm.setString(3, mascota.getMascota());
			psm.setString(4, mascota.getRaza());
			psm.setString(5, mascota.getDuenio());
			psm.setString(6, mascota.getId());
			
			psm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(cn!=null) cn.close();
				if(psm!=null) psm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public Mascota getMascota(String id) {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		Mascota mascota = new Mascota();
		try {
			cn = MySQLConnection.getConnection();
			String sql = "select * from mascota where id=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			if(rs.next()) {
				mascota.setId(rs.getString("id"));
				mascota.setCodigo(rs.getString("codigo"));
				mascota.setNombre(rs.getString("nombre"));
				mascota.setMascota(rs.getString("mascota"));
				mascota.setRaza(rs.getString("raza"));
				mascota.setDuenio(rs.getString("duenio"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (cn!=null) cn.close();
				if(psm!=null) psm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return mascota;
	}

	@Override
	public int deleteMascota(String id) {
		// TODO Auto-generated method stub
		Connection cn =null;
		PreparedStatement psm=null;
		try {
			cn=MySQLConnection.getConnection();
			String sql="delete from mascota where id=?";
			psm=cn.prepareStatement(sql);
			psm.setString(1, id);
			psm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
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

}
