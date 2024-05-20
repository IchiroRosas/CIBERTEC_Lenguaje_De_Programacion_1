package dao;

import interfaz.AdminAuthInterface;
import interfaz.CandidatosInterface;
import interfaz.WorkerInterface;

public abstract class DAOFactory {
	
	public static final int MYSQL=1;
	public static final int SQLSERVER=2;
	public static final int ORACLE=3;
	
	public abstract AdminAuthInterface getAuth();
	public abstract WorkerInterface getWorker();
	public abstract CandidatosInterface getCandidato();
	
	public static DAOFactory getDaoFactory(int tipo) {
		switch (tipo) {
		case MYSQL:
			return new MySqlDaoFactory();
			
		case SQLSERVER:
			return null;
			
		case ORACLE:
			return null;
		default:
			return null;
		}
	}
	
}