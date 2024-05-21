package dao;

import interfaces.LibroInterface;
import interfaces.ProveedorInterface;
import interfaces.VentaInterface;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract ProveedorInterface getProveedor();
	public abstract LibroInterface getLibro();
	public abstract VentaInterface getVenta();
	
	public static DAOFactory getDaoFactory(int tipo) {
		switch (tipo) {
		case MYSQL:
			return new MySqlDAOFactory();
			
		case SQLSERVER:
			return null;
			
		case ORACLE:
			return null;
		default:
			return null;
		}
	}
	
}
