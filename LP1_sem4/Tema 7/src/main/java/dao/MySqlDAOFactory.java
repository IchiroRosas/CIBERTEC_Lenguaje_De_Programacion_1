package dao;

import interfaces.ProductInterface;
import interfaces.SubjectInterface;
import modelo.ProductModel;
import modelo.SubjectModel;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public SubjectInterface getSubject() {
		// TODO Auto-generated method stub
		return new SubjectModel();
	}

	@Override
	public ProductInterface getProduct() {
		// TODO Auto-generated method stub
		return new ProductModel();
	}
}
