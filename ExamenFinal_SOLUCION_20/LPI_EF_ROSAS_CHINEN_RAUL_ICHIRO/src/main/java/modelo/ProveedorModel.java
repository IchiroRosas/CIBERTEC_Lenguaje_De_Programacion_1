package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Proveedor;
import interfaces.ProveedorInterface;
import util.MySqlConexion;

public class ProveedorModel implements ProveedorInterface {

	@Override
	public List<Proveedor> listProveedores() {
		// TODO Auto-generated method stub
		
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		Connection cn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		
		try {
			cn = MySqlConexion.getConexion();
			String sql="SELECT * FROM proveedor";
			psm = cn.prepareStatement(sql);
			rs=psm.executeQuery();
			while (rs.next()) {
				Proveedor prov = new Proveedor();
				prov.setId(rs.getString("id"));
				prov.setRuc(rs.getString("ruc"));
				prov.setNombre(rs.getString("nombre"));
				proveedores.add(prov);
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
		
		return proveedores;
	}

}
