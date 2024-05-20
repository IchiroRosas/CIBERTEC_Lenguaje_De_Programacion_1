package dao;

import interfaces.SubjectInterface;
import modelo.SubjectModel;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public SubjectInterface getSubject() {
		// TODO Auto-generated method stub
		return new SubjectModel();
	}

}
