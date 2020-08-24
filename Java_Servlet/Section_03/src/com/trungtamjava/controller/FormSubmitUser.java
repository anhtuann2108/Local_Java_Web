package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/form-submit"})
public class FormSubmitUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter output = resp.getWriter();
		
		output.println("<br>");
		output.println("<form action='/Section_03/add-user' method='post'>");
		output.println("ID: <input type='text' name='id'>");
		output.println("Name: <input type='text' name='name'>");
		output.println("Age: <input type='number' name='age' required>");
		output.println("<button type='submit' value='submit'>Add user</button>");
		output.println("</form>");
		
		output.println("<form action='/Section_03/update-user' method='post'>");
		output.println("ID: <input type='text' name='id'>");
		output.println("Name: <input type='text' name='name'>");
		output.println("Age: <input type='number' name='age' required>");
		output.println("<button type='submit' value='submit'>Update User</button>");
		output.println("</form>");
		
		output.println("<form action='/Section_03/detail-user' method='post'>");
		output.println("ID: <input type='text' name='idDetail'>");
		output.println("<button type='submit' value='submit'>Search</button>");
		output.println("</form>");
		
		output.println("<form action='/Section_03/delete-user' method='post'>");
		output.println("ID: <input type='text' name='idDelete'>");
		output.println("<button type='submit' value='submit'>Delete</button>");
		output.println("</form>");
		
		output.close();

	}
}
