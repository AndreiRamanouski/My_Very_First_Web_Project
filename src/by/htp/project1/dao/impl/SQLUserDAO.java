package by.htp.project1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.project1.bean.RegistrationInfo;
import by.htp.project1.bean.User;
import by.htp.project1.bean.UserLoginationInfo;
import by.htp.project1.dao.DAOException;
import by.htp.project1.dao.UserDAO;

public class SQLUserDAO implements UserDAO{
	private final String REGISTRATION = "INSERT INTO usersfinaltable VALUES(?,?,?,?)";
	
	private final static String MY_BASE = "jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC";
	
	static {
		MYSQLDriverLoader.getInstance();
	}
	

	@Override
	public User authorization(String login, String password) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		User user = null;
		try {
		con = DriverManager.getConnection(MY_BASE + 
		        "","root", "");
		
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM usersfinaltable WHERE login = '" + login +"' AND password = '" + password+"'");
			
			while (rs.next()) {
				
					user = new User(rs.getString("name"),rs.getString("surname"),rs.getString("role"));
				
			} 
		}  catch (SQLException e) {
				throw new DAOException(e);
		} finally{
			
				try {
					if(con!=null)
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
				
			} 
		return user;
	}

	@Override
	public boolean registration(RegistrationInfo user) throws DAOException {
			
			boolean res = false;
			Connection con = null;
			PreparedStatement pst = null;
			
			try {
				
				con = DriverManager.getConnection(MY_BASE + 
				        "","root", "");
				pst = con.prepareStatement(REGISTRATION);
				pst.setString(1, user.getLogin());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getName());
				pst.setString(4, user.getSurname());
				
				res = true;
				
			} catch (SQLException e) {
				throw new DAOException(e);
			} finally {
				try {
					if(con!=null)
					con.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				} 
			}
			
			return res;
		}
	

	

	
}
