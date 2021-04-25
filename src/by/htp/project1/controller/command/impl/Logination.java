package by.htp.project1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.project1.bean.User;
import by.htp.project1.controller.command.Command;
import by.htp.project1.service.ServiceProvider;
import by.htp.project1.service.UserService;
import by.htp.project1.service.impl.ServiceException;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		String login = request.getParameter("login");
		String password  = request.getParameter("password");
		
		if(login.equals("") || password.equals("") ) {

			response.sendRedirect("Controller?command=gotoindexpage&message=Write something");
			
		} else {
			ServiceProvider provider = ServiceProvider.getInstance();
			UserService userService = provider.getUserService();
			User user = null;
			
			try {
				user = userService.authorization(login, password);
				if(user == null) {
					response.sendRedirect("Controller?command=gotoindexpage&message=User is null");
					return;
				}
					HttpSession session = request.getSession(true);
					session.setAttribute("status", true);
					session.setAttribute("name", user.getName());
					session.setAttribute("surname", user.getSurname());
					session.setAttribute("role", user.getRole());
					
					
					response.sendRedirect("Controller?command=gotomainpage");
					
				
			} catch (ServiceException e) {
				response.sendRedirect("Controller?command=gotoindexpage&message=caught exception Logination");
			}
			
			
		}
		
	}

}
