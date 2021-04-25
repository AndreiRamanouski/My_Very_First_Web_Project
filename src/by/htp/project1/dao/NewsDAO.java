package by.htp.project1.dao;

import java.util.List;

import by.htp.project1.bean.News;

public interface NewsDAO {

	List<News> all()throws DAOException;
	Boolean update(News news) throws DAOException;
	boolean addNews(News news) throws DAOException;
	
}
