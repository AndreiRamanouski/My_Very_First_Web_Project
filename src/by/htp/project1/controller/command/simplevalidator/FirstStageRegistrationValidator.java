package by.htp.project1.controller.command.simplevalidator;

import by.htp.project1.bean.RegistrationInfo;

public class FirstStageRegistrationValidator {
		
	
	public static boolean check(RegistrationInfo user) {
		
			if(user != null)
				return false;
			if(user.getLogin() == null || user.getLogin().isEmpty() || user.getLogin().length() > 45 )
				return false;
			if(user.getPassword() == null || user.getPassword().isEmpty() || user.getLogin().length() > 45)
				return false;
			if(user.getName() == null || user.getName().isEmpty() || user.getName().length() > 45)
				return false;	
			if(user.getSurname() == null || user.getSurname().isEmpty() || user.getSurname().length() > 45)
				return false;
				
							
		
		
			return true;
	}
	
}
