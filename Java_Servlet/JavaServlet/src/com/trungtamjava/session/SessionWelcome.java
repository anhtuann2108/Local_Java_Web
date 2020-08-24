package com.trungtamjava.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/session-welcome" })
public class SessionWelcome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		String name ="";
		
		HttpSession httpSession = req.getSession();
		
		Object obj = httpSession.getAttribute("username");
		
		if(obj!= null) {
			name = (String) obj;
		}else {
			resp.sendRedirect("/JavaServlet/session-login");
		}
		printWriter.println("Welcome "+name);
		printWriter.println("<br/> Log out <a href='/JavaServlet/session-logout'>Logout </a>");
	}
}
