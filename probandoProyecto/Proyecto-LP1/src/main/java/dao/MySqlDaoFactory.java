package dao;

import interfaz.AdminAuthInterface;
import interfaz.CandidatosInterface;
import interfaz.WorkerInterface;
import modelo.AuthModelo;
import modelo.CandidatoModelo;
import modelo.WorkerModelo;

public class MySqlDaoFactory extends DAOFactory {

	@Override
	public AdminAuthInterface getAuth() {
		// TODO Auto-generated method stub
		return new AuthModelo();
	}

	@Override
	public WorkerInterface getWorker() {
		// TODO Auto-generated method stub
		return new WorkerModelo();
	}

	@Override
	public CandidatosInterface getCandidato() {
		// TODO Auto-generated method stub
		return new CandidatoModelo();
	}

}
