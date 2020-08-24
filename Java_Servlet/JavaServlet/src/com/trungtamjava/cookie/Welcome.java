package com.trungtamjava.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/welcome" })
public class Welcome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		String name ="";
		
		Cookie[] cookies = req.getCookies();
		try {
			for(Cookie cookie : cookies) {
			if(cookie.getName().equals("username")) {
				name = cookie.getValue();
			}
		}
		}catch(Exception e) {
			
		}
		if(name.equals("")) {
			resp.sendRedirect("/JavaServlet/login");
		}
		printWriter.println("Welcome "+ name);
	}
}
