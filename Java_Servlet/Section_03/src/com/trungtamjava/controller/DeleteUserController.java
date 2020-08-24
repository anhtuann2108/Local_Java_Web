package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;

@WebServlet(urlPatterns = { "/delete-user" })
public class DeleteUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter print = resp.getWriter();

		User user = new User();

		user.setId(Integer.parseInt(req.getParameter("idDelete")));
	
		UserService userService = new UserServiceImpl();
		
		userService.delete(user);
		
		print.println("Delete Successfully!");
		print.println("<a href=\"/Section_03/user-list\">User List</a>");
		print.close();
	}
}
