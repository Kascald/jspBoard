package com.mysite.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "forceEncoding", value = "true", description = "forceEncoding")
		})
public class EncodingFilter extends HttpFilter implements Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String encoding = "";
	private String forceEncoding = "false";
	
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (null != encoding && !"".equals(encoding)) {
			System.out.println("Apply Request Encoding");
			request.setCharacterEncoding(encoding);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
		if (null != encoding && "true".equalsIgnoreCase(forceEncoding)) {
			System.out.println("Apply Response Encoding");
			response.setCharacterEncoding(encoding);
		}
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding") == null ? "" : fConfig.getInitParameter("encoding");
		forceEncoding = fConfig.getInitParameter("forceEncoding") == null ? "false" : fConfig.getInitParameter("forceEncoding");
	}

}
