package by.htp.project1.dao;


import by.htp.project1.bean.RegistrationInfo;
import by.htp.project1.bean.User;

public interface UserDAO {

	public User authorization(String login, String password) throws DAOException;
	
	public boolean registration(RegistrationInfo user)throws DAOException;
	
	
}
