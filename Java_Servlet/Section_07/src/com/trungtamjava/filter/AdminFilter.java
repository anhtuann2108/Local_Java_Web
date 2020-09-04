package com.trungtamjava.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		HttpSession httpSession = httpReq.getSession();
		Object obj = httpSession.getAttribute("user");
		
		if(obj != null && ((User) obj).getRole().equals("Role_Admin")){
			chain.doFilter(request, response);
		}else if (obj != null && ((User) obj).getRole().equals("Role_User")){
			httpResp.sendRedirect("/Section_06/user/welcome.jsp");
		}else {
			httpResp.sendRedirect("/Section_06/login/login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
