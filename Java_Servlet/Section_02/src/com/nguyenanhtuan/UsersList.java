package com.nguyenanhtuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/userslist"})
public class UsersList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<div class=\"container\">\r\n" + 
				"        <h2>List Users</h2>\r\n" + 
				"        <table >\r\n" + 
				"            <thead class=\"thead-light\">\r\n" + 
				"                <tr>\r\n" + 
				"                    <th>Firstname</th>\r\n" + 
				"                    <th>Lastname</th>\r\n" + 
				"                    <th>Email</th>\r\n" + 
				"                </tr>\r\n" + 
				"            </thead>\r\n" + 
				"            <tbody>\r\n" + 
				"                <tr>\r\n" + 
				"                    <td>John</td>\r\n" + 
				"                    <td>Doe</td>\r\n" + 
				"                    <td>john@example.com</td>\r\n" + 
				"                </tr>\r\n" + 
				"                <tr>\r\n" + 
				"                    <td>Mary</td>\r\n" + 
				"                    <td>Moe</td>\r\n" + 
				"                    <td>mary@example.com</td>\r\n" + 
				"                </tr>\r\n" + 
				"                <tr>\r\n" + 
				"                    <td>July</td>\r\n" + 
				"                    <td>Dooley</td>\r\n" + 
				"                    <td>july@example.com</td>\r\n" + 
				"                </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"        </table>\r\n" + 
				"    </div>");
		out.close();
	}

}
