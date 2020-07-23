package com.nguyenanhtuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/register"})
public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<form action=\"#\" method=\"POST\">\r\n" + 
				"        <div class=\"container\">\r\n" + 
				"            <h1>Register</h1>\r\n" + 
				"            <p>Please fill in this form to create an account.</p>\r\n" + 
				"            \r\n" + 
				"            <label><b>Email</b></label>\r\n" + 
				"<br>"+
				"            <input type=\"email\" placeholder=\"Enter Email\" name=\"email\" required>\r\n" + 
				"\r\n" + "<br>"+
				"            <label><b>Your Name</b></label>\r\n" + "<br>"+
				"            <input type=\"text\" placeholder=\"Enter Name\" name=\"name\" required>\r\n" + 
				"\r\n" + "<br>"+
				"            <label><b>Username</b></label>\r\n" + "<br>"+
				"            <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required>\r\n" + 
				"\r\n" + "<br>"+
				"            <label></label><b>Password</b></label>\r\n" + "<br>"+
				"            <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\r\n" + 
				"\r\n" + "<br>"+
				"            <label></label><b>Repeat Password</b></label>\r\n" + "<br>"+
				"            <input type=\"password\" placeholder=\"Repeat Password\" name=\"psw-repeat\" required>\r\n" + 
				"\r\n" + "<br>"+
				"            <label><b>Age</b></label>\r\n" + "<br>"+
				"            <input type=\"text\" placeholder=\"Enter Age\" name=\"age\" required>\r\n" + 
				"\r\n" + "<br>"+
				"            <label><b>Address</b></label>\r\n" + "<br>"+
				"            <input type=\"text\" placeholder=\"Enter Address\" name=\"address\" required>\r\n" + 
				"\r\n" + "<br>"+
				"\r\n" + 
				"            <button type=\"submit\">Register</button>\r\n" + 
				"        </div>\r\n" + 
				"    </form>");
		out.close();
	}

}
