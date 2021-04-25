package by.htp.project1.service;

import java.util.List;
import by.htp.project1.bean.News;
import by.htp.project1.service.impl.ServiceException;

public interface NewsService {
	List<News> takeAll() throws ServiceException;
	Boolean newsUpdate(News news) throws ServiceException;
}
