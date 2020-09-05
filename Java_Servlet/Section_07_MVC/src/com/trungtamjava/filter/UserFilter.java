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

import com.trungtamjava.service.UserService;
import com.trungtamjava.serviceimpl.UserServiceImpl;

@WebFilter(urlPatterns = { "/user/*" })
public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;

		HttpSession session = req.getSession();

		Object obj = session.getAttribute("loginUser");

		if (obj != null) {
			arg2.doFilter(arg0, arg1);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
