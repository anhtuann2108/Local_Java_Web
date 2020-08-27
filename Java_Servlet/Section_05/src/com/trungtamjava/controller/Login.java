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
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;
@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Login Page</title>");
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
		printWriter.println("<form action='/Section_05/login' method='POST'>");
		printWriter.println("<div class='container'>");
		printWriter.println("<label><b>Username</b></label>");
		printWriter.println("<input type='text' placeholder='Enter Username' name='username' required>");
		printWriter.println("<label></label><b>Password</b></label>");
		printWriter.println("<input type='password' placeholder='Enter Password' name='password' required>");
		printWriter.println("<input type='submit' value='Login'>");
		printWriter.println("</div>");
		printWriter.println("</form>");
		printWriter.println("</body>");
		printWriter.println("</html>");
		
		printWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserService userService = new UserServiceImpl();

		User user = userService.find(username);
		if (user != null && user.getPassword().equals(password)) {
			HttpSession httpSession = req.getSession();

			httpSession.setAttribute("user", user);
			if( user.getRole().equals("admin")) {
				resp.sendRedirect("/Section_05/admin/main");
			}else {
				resp.sendRedirect("/Section_05/member/welcome");
			}
		}else {
			resp.sendRedirect("/Section_05/login");
		}
	}
}
