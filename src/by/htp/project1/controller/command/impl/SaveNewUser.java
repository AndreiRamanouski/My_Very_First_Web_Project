package by.htp.project1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.project1.bean.RegistrationInfo;
import by.htp.project1.controller.command.Command;
import by.htp.project1.controller.command.simplevalidator.FirstStageRegistrationValidator;
import by.htp.project1.service.ServiceProvider;
import by.htp.project1.service.UserService;
import by.htp.project1.service.impl.ServiceException;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService =  provider.getUserService();
		
		RegistrationInfo user = new RegistrationInfo(request.getParameter("login"),
				request.getParameter("password"),request.getParameter("name"),request.getParameter("surname"));
	
		if(!FirstStageRegistrationValidator.check(user)) {
			response.sendRedirect("Controller?command=gotoindexpage&message=Registration is NOT OK");
			return;
		} 
		
				 try {
						if(userService.registration(user)) {
						response.sendRedirect("Controller?command=gotoindexpage&message=Registration is OK!");
						return;
						}
					} catch (ServiceException e) {
						response.sendRedirect("Controller?command=gotoindexpage&message=Registration is NOT OK. Exception!");
						return;
					}
					
					response.sendRedirect("Controller?command=gotoindexpage&message=Registration is NOT OK!");
			

				
	}
}



