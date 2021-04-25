package by.htp.project1.controller.command.simplevalidator;

import by.htp.project1.bean.News;

public class FirstStageNewsValidator {
	
	public static boolean check(News news) {	
		
		if(news == null)
			return false;
		if(news.getBrief() == null || news.getBrief().isEmpty() || news.getBrief().length() > 200 )
			return false;
		if(news.getTitle() == null || news.getTitle().isEmpty() || news.getTitle().length() > 200 )
			return false;
		if(news.getContent() == null || news.getContent().isEmpty() || news.getContent().length() > 1000 )
			return false;
		
		
		
		return true;
		
	}
	
}
