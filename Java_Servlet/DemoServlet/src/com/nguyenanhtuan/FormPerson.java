package com.nguyenanhtuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/form-users"})
public class FormPerson extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<form action='/DemoServlet/add-user' method='post'>");
		out.println("Name: <input type='text' name='name'>");
		out.println("Age: <input type='text' name='age'>");
		out.println("Address: <input type='text' name='address'>");
		out.println("<input type='submit' value='submit'>");
		out.println("</form>");
		out.close();
	}
}
