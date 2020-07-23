package com.nguyenanhtuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/welcome"})
public class Welcome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Welcome to my home- Nguyen Anh Tuan</h1>");
		out.println("<p>My name:Nguyen Anh Tuan</p>");
		out.println("<p>Age:26</p>");
		out.println("<p>Email:learn.nguyenanhtuan@gmail.com</p>");
		out.println("<p>Address:Tokyo City</p>");
		out.close();
	}
}
