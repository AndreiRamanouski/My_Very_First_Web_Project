package by.htp.project1.dao;

import by.htp.project1.dao.impl.SQLNewsDAO;
import by.htp.project1.dao.impl.SQLUserDAO;

public final class DAOProvider {
	
	private static final DAOProvider provider = new DAOProvider();
	NewsDAO newsdao = new SQLNewsDAO();
	UserDAO userdao = new SQLUserDAO();
	
	
	
	public static DAOProvider getInstance() {
		
		return provider;
	}
	
	private DAOProvider() {}

	public NewsDAO getNewsdao() {
		return newsdao;
	}

	public UserDAO getUserdao() {
		return userdao;
	}
	
	
	
	
}
