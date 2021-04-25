package by.htp.project1.service.impl;

import java.util.List;

import by.htp.project1.bean.News;
import by.htp.project1.dao.DAOException;
import by.htp.project1.dao.DAOProvider;
import by.htp.project1.dao.NewsDAO;
import by.htp.project1.service.NewsService;

public class NewsServiceImpl implements NewsService {



	@Override
	public List<News> takeAll() throws ServiceException {
		
		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO newsDAO = daoProvider.getNewsdao();
		List<News> news;
		try {
			 news = newsDAO.all();
		} catch (DAOException e) {
			throw new ServiceException(e);
			
		}
		
		return news;
	}

	@Override
	public Boolean newsUpdate(News news) throws ServiceException {
		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO newsDAO = daoProvider.getNewsdao();
		Boolean result =false;
		try {
			result = newsDAO.update(news);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	
	
}
