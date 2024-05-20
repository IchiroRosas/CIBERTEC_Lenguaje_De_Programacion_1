package dao;

import interfaces.AuthInterface;
import interfaces.SessionInterface;
import modelo.AuthModel;
import modelo.SessionModel;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public AuthInterface getAuth() {
		// TODO Auto-generated method stub
		return new AuthModel();
	}

	@Override
	public SessionInterface getSession() {
		// TODO Auto-generated method stub
		return new SessionModel();
	}

}
