package by.htp.project1.service;

import by.htp.project1.service.impl.NewsServiceImpl;
import by.htp.project1.service.impl.UserServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider provider = new ServiceProvider();
	private final NewsService news = new NewsServiceImpl();
	private final UserService user = new UserServiceImpl();
	
	public static ServiceProvider getInstance() {
		return provider;
	}
	
	
	
	public NewsService getNewsService() {
		return news;
	}



	public UserService getUserService() {
		return user;
	}



	private ServiceProvider() {}
}
