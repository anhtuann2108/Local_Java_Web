package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.impl.UserServiceImpl;
@WebServlet(urlPatterns = {"/admin/welcome"})
public class AdminWelcomePage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		List<User> userList = userService.findAllUser();
		req.setAttribute("userList",userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/welcome.jsp");
		dispatcher.forward(req, resp);
	}
}
