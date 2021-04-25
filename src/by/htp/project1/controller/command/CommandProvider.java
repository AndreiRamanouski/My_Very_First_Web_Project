package by.htp.project1.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.project1.controller.command.impl.Edit;
import by.htp.project1.controller.command.impl.GoToIndexPage;
import by.htp.project1.controller.command.impl.GoToMainPage;
import by.htp.project1.controller.command.impl.Logination;
import by.htp.project1.controller.command.impl.LoginationPage;
import by.htp.project1.controller.command.impl.Logout;
import by.htp.project1.controller.command.impl.NewsUpdate;
import by.htp.project1.controller.command.impl.ReadWholeNews;
import by.htp.project1.controller.command.impl.RegistrationNewUser;
import by.htp.project1.controller.command.impl.SaveNewUser;

public class CommandProvider {
	
	
		Map<CommandName,Command> commands = new HashMap<>();
		
		public CommandProvider() {
			commands.put(CommandName.LOGINATION, new Logination());
			commands.put(CommandName.REGISTRATION, new RegistrationNewUser());
			commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
			commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
			commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
			commands.put(CommandName.LOGOUT, new Logout());
			commands.put(CommandName.LOGINATIONPAGE, new LoginationPage());
			commands.put(CommandName.READWHOLENEWS, new ReadWholeNews());
			commands.put(CommandName.EDIT, new Edit());
			commands.put(CommandName.NEWSUPDATE, new NewsUpdate());
		}
		
		public Command takeCommand(String commandName) {
			CommandName command;
			command = CommandName.valueOf(commandName.toUpperCase());
			return commands.get(command);
		}
		
		
		
		
}
