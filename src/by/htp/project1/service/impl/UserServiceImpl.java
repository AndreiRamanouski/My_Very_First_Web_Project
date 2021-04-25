package by.htp.project1.service.impl;

import by.htp.project1.bean.RegistrationInfo;
import by.htp.project1.bean.User;
import by.htp.project1.dao.DAOException;
import by.htp.project1.dao.DAOProvider;
import by.htp.project1.dao.UserDAO;
import by.htp.project1.service.UserService;

public class UserServiceImpl implements UserService {
   DAOProvider provider = DAOProvider.getInstance();
   UserDAO userDAO = provider.getUserdao();
  

	@Override
	public boolean registration(RegistrationInfo user) throws ServiceException {
		boolean result = false;
		try {
			result = userDAO.registration(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return result;
		
		
	}
   
	@Override
	public User authorization(String login, String password) throws ServiceException {
		if (login == null || password == null ||
				login.equals("") || password.equals(""))
				throw new ServiceException("Write something");
		
		User user =null;
		
		try {
			user = userDAO.authorization(login, password);
		} catch (DAOException e) {
			
			throw new ServiceException("error message", e);
		}
		
		return user;
	}


}
