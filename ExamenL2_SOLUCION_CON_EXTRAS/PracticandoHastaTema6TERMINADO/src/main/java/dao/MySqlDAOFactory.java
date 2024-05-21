package dao;

import interfaces.MascotaInterface;
import interfaces.UsuarioAuthInterface;
import modelo.MascotaModel;
import modelo.UsuarioAuthModel;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioAuthInterface getUsuario() {
		// TODO Auto-generated method stub
		return new UsuarioAuthModel();
	}

	@Override
	public MascotaInterface getMascota() {
		// TODO Auto-generated method stub
		return new MascotaModel();
	}
	
}
