package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/welcome" })
public class Welcome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession = req.getSession();

		String name = "";

		Object obj = httpSession.getAttribute("username");
		if (obj != null) {
			name = (String) obj;
		} else {
			resp.sendRedirect("/Section_04/login");
		}
		printWriter.println("<h1>Welcome " + name + "</h1");
		printWriter.println("<br/> Log out Account <a href='/Section_04/logout'>Logout</a>");
	}
}
