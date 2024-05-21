package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidades.Venta;
import interfaces.VentaInterface;
import util.MySqlConexion;

public class VentaModel implements VentaInterface {

	@Override
	public int createVenta(Venta venta) {
		// TODO Auto-generated method stub
		
		int value = 0;
		Connection cn= null;
		PreparedStatement psm=null;
		try {
			cn= MySqlConexion.getConexion();
			
			String sql="INSERT INTO venta VALUES (null,now(), ?,?)";
			psm=cn.prepareStatement(sql);
			
			psm.setString(1, venta.getIdProveedor());
			psm.setString(2, venta.getIdLibro());
			
			value=psm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(psm !=null) psm.close();
				if(cn != null) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return 0;
	}

}
