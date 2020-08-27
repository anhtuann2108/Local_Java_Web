package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
@WebServlet(urlPatterns = {"/member/welcome"})
public class Welcome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession = req.getSession();

		String name = "";

		Object obj = httpSession.getAttribute("user");
		if (obj != null) {
			name = ((User) obj).getUsername();
		} else {
			resp.sendRedirect("/Section_05/login");
		}
		printWriter.println("<h1>Welcome " + name + "</h1");
		printWriter.println("<br/> Log out Account <a href='/Section_05/logout'>Logout</a>");
	}
}
