package by.htp.project1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {

	private String encoding;
	private ServletContext context;
	private static final String CHARACTER_ENCODING = "characterEncoding";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		context.log("Charset was set.");
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter(CHARACTER_ENCODING);
		context = fConfig.getServletContext();
		context.log("Parameter encoding=" + encoding);
	}

}
