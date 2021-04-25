package by.htp.project1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.project1.bean.News;
import by.htp.project1.dao.DAOException;
import by.htp.project1.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO{
	private final String STATEMENT = "SELECT * FROM news";
	
	
	private final static String MY_BASE = "jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC";
	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public List<News> all() throws DAOException {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		List<News> news =null;
		try {
			con = DriverManager.getConnection(MY_BASE + 
		        "","root", "");
			
			st = con.createStatement();
			rs = st.executeQuery(STATEMENT);
			news = new ArrayList<News>();
			
			while (rs.next()) {
				
			int id = rs.getInt("idnews");
			String title = rs.getString("title");
			String brief = rs.getString("brief");
			String content = rs.getString("content");
			Date date = rs.getDate("date");
			News n = new News(id,title,brief,content,date);
			news.add(n);
			
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
		
		
		return news;
	}
	@Override
	public boolean addNews(News news) throws DAOException {
		boolean result = false;
		String insert = "INSERT INTO news VALUES(?,?,?,?)";
		Date date = new Date();
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			
			con = DriverManager.getConnection(MY_BASE + 
			        "","root", "");

			pst = con.prepareStatement(insert);
			pst.setString(2, news.getTitle());
			pst.setString(3, news.getBrief());
			pst.setString(4, news.getContent());
			pst.setDate(5, (java.sql.Date) date);
			
			pst.executeUpdate();
			
			result = true;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally{
		
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			
		}
		return result;
	}


	@Override
	public Boolean update(News news) throws DAOException {
		Boolean result = false;
		
		String update = "UPDATE news SET title='" + news.getTitle() + "', brief='" + news.getBrief() + "', content='" + news.getContent() + "' WHERE idnews=" + news.getId();
		Connection con = null;
		Statement st = null;
		
		
		try {
			con = DriverManager.getConnection(MY_BASE + 
			        "","root", "");
			st = con.createStatement();
			st.executeUpdate(update);
			
			result = true;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally{
		
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
			
		}
		return result;
	}

	
}
