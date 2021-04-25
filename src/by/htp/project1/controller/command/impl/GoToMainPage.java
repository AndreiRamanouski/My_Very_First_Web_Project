package by.htp.project1.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project1.bean.News;
import by.htp.project1.bean.User;
import by.htp.project1.controller.command.Command;
import by.htp.project1.service.NewsService;
import by.htp.project1.service.ServiceProvider;
import by.htp.project1.service.impl.ServiceException;

public class GoToMainPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService =  provider.getNewsService();	
		
		if(session==null) {
			response.sendRedirect("Controller?command=gotoindexpage&message=Session is null");
		}
		
		try {
			Boolean istrue = (Boolean) session.getAttribute("status");
			User user = (User) session.getAttribute("user");
			
			if(istrue || istrue != null) {
				try {
					List<News> news = newsService.takeAll();
					
					request.setAttribute("news", news);
				} catch (ServiceException e) {
					response.sendRedirect("Controller?command=gotoindexpage&message=Something went wrong");
					return;
				}
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
					requestDispatcher.forward(request, response);
		} else {
			
			request.setAttribute("message", "You need to log in!");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		} catch(Exception e) {
			response.sendRedirect("Controller?command=gotoindexpage&message=U need to log in!");
		}
		
	}
}
