package dao;

import interfaces.EstudianteInterface;
import modelo.EstudianteModel;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public EstudianteInterface getEstudiante() {
		// TODO Auto-generated method stub
		return new EstudianteModel();
	}

}
