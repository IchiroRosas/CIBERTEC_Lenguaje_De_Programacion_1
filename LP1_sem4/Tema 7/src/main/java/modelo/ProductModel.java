package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Product;
import entidades.Subject;
import interfaces.ProductInterface;
import util.MySqlConexion;

public class ProductModel implements ProductInterface {

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		List<Product> listProducts = new ArrayList<Product>();
		Connection cn=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		
		try {
			cn = MySqlConexion.getConexion();
			String sql="SELECT * FROM Product";
			psm = cn.prepareStatement(sql);
			rs=psm.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getString("idProduct"));
				prod.setDescripcion(rs.getString("description"));
				prod.setStock(rs.getString("stock"));
				prod.setPrecio(rs.getString("price"));
				listProducts.add(prod);
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
		return listProducts;
	}

}
