package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;
@WebServlet(urlPatterns = {"/member/register"})
public class MemberController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Register Page</title>");
		printWriter.println("<meta charset='UTF-8'>");
		printWriter.println("<style>");
		printWriter.println("form{\r\n" + 
				"    border: 3px solid lightblue;" + 
				"    margin: 50px auto;" + 
				"    width: 600px;" + 
				"}" + 
				".container{" + 
				"    padding: 20px;" + 
				"}" + 
				"input{" + 
				"    width: 100%;" + 
				"    padding: 12px 20px;" + 
				"    margin: 8px 0;" + 
				"    display: inline-block;" + 
				"    border: 1px solid #ccc;" + 
				"    box-sizing: border-box;" + 
				"    background-color: #f1f1f1;" + 
				"  }" + 
				"  button {" + 
				"    background-color: #4CAF50;" + 
				"    color: white;" + 
				"    text-align: center;" + 
				"    padding: 14px 20px;" + 
				"    margin: 8px 0;" + 
				"    border: none;" + 
				"    cursor: pointer;" + 
				"    width: 100%;}");
		printWriter.println("</style>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<form action='/Section_05/member/register' method='POST'>");
		printWriter.println("<div class='container'>");
		printWriter.println("<label><b>Username</b></label>");
		printWriter.println("<input type='text' placeholder='Enter Username' name='username' required>");
		printWriter.println("<label></label><b>Password</b></label>");
		printWriter.println("<input type='password' placeholder='Enter Password' name='password' required>");
		printWriter.println("<input type='submit' value='Register'>");
		printWriter.println("</div>");
		printWriter.println("</form>");
		printWriter.println("</body>");
		printWriter.println("</html>");

		printWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		User user = new User();
		
		UserService userService = new UserServiceImpl();
		
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setRole("member");
		userService.create(user);
		
		printWriter.println("Create Successfully!");
	}
}
