package by.htp.project1.controller.command.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.bean.News;
import by.htp.project1.controller.command.Command;
import by.htp.project1.controller.command.simplevalidator.FirstStageNewsValidator;
import by.htp.project1.service.NewsService;
import by.htp.project1.service.ServiceProvider;
import by.htp.project1.service.impl.ServiceException;

public class NewsUpdate implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService =  provider.getNewsService();

		News news = new News(Integer.parseInt(request.getParameter("newsaction")),request.getParameter("title")
				,request.getParameter("brief"),request.getParameter("content"), new Date());
		if (!FirstStageNewsValidator.check(news)) {
			response.sendRedirect("Controller?command=gotomainpage&message=Could not update the news. Invalid parameters");
			return;
		}
		try {
			if(newsService.newsUpdate(news)) {
				response.sendRedirect("Controller?command=gotomainpage&massage=The news was updated");
			return;
			}
		} catch (ServiceException e) {
			
			response.sendRedirect("Controller?command=gotomainpage&message=Exception!!");
			return;
		}
		
		
			response.sendRedirect("Controller?command=gotomainpage&message=Could not update the news");
		
	}

}
