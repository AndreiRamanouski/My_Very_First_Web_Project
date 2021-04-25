package by.htp.project1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.controller.command.Command;

public class Localize implements Command {
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String language = request.getParameter("local");
		String commandLocalization = request.getParameter("commandLocalization"); 
		
		request.getSession(true).setAttribute("local", language);
		response.sendRedirect("Controller?" + commandLocalization);

	}

}
