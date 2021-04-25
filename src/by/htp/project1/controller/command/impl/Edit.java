package by.htp.project1.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.bean.News;
import by.htp.project1.controller.command.Command;
import by.htp.project1.service.NewsService;
import by.htp.project1.service.ServiceProvider;

public class Edit implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("newsaction");
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService =  provider.getNewsService();	
		
		try {
				List<News> news = newsService.takeAll();
				try {
					Integer id = Integer.parseInt(name);
					for(int i = 0 ; i < news.size(); i ++) {
						if (news.get(i).getId() == id ) {
							News ne = news.get(i);
							request.setAttribute("news", ne);
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editNews.jsp");
							requestDispatcher.forward(request, response);
							return;
						} else {
							response.sendRedirect("Controller?command=gotoindexpage&message=News not found!!");
							return;
						}
					}
				} catch (Exception e) {
					response.sendRedirect("Controller?command=gotoindexpage&message=Something went wrong");
					return;
				}
					
		} catch (Exception e) {
			response.sendRedirect("Controller?command=gotoindexpage&message=Something went wrong");
		}
	}

}
