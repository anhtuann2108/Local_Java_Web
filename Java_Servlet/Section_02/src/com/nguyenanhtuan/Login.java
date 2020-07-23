package com.nguyenanhtuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	
		PrintWriter out = resp.getWriter();
		
		out.println("  <form action=\"#\" method=\"post\">\r\n" + 
				"        <div class=\"formcontainer\">\r\n" + 
				"            <div class=\"imgcontainer\">\r\n" + 
				"                <img src=\"Images/avatarlogin.jpg\" alt=\"Avatar\" class=\"avatar\">\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"container\">\r\n" + 
				"                <label for=\"uname\"><b>Username</b></label>\r\n" + "<br>"+
				"                <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required>\r\n" + 
				"\r\n" + "<br>"+
				"                <label for=\"psw\"><b>Password</b></label>\r\n" + "<br>"+
				"                <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\r\n" + 
				"\r\n" + "<br>"+
				"                <button type=\"submit\">Login</button>\r\n" + "<br>"+
				"                <label>\r\n" + 
				"                    <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me\r\n" + 
				"                </label>\r\n" + "<br>"+
				"            </div>\r\n" + 
				"\r\n" + 
				"            <div class=\"container\" style=\"background-color:#f1f1f1\">\r\n" + 
				"                <button type=\"button\" class=\"btn\">Cancel</button>\r\n" +
				"                <button type=\"reset\" class=\"btn\">Reset</button>\r\n" + "<br>"+
				"                <span class=\"psw\">Forgot <a href=\"#\">password?</a></span>\r\n" + 
				"            </div>\r\n" + 
				"        </div>\r\n" + 
				"    </form>");
				out.close();
	
	}

}
