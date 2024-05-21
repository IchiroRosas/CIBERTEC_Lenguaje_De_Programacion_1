package dao;

import interfaces.LibroInterface;
import interfaces.ProveedorInterface;
import interfaces.VentaInterface;
import modelo.LibroModel;
import modelo.ProveedorModel;
import modelo.VentaModel;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public ProveedorInterface getProveedor() {
		// TODO Auto-generated method stub
		return new ProveedorModel();
	}

	@Override
	public LibroInterface getLibro() {
		// TODO Auto-generated method stub
		return new LibroModel();
	}

	@Override
	public VentaInterface getVenta() {
		// TODO Auto-generated method stub
		return new VentaModel();
	}
	
}
