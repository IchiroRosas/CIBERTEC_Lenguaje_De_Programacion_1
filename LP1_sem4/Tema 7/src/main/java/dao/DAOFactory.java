package dao;

import interfaces.ProductInterface;
import interfaces.SubjectInterface;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	//public abstract SubjectInterface getSubject();
	//public abstract ProfesoresInterface getProfesores();
	//public abstract EstudianteInterface getEstudiante();
	//public abstract AuthInterface getAuth();
	//public abstract SessionInterface getSession();
	public abstract SubjectInterface getSubject();
	public abstract ProductInterface getProduct();
	
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
