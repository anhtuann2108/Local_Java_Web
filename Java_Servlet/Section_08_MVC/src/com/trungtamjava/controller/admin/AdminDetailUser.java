package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;
@WebServlet(urlPatterns = {"/admin/detailUser"})
public class AdminDetailUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		UserService userService = new UserServiceImpl();
		User user = userService.findById(id);
		req.setAttribute("detailUser", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/detailUser.jsp");
		dispatcher.forward(req, resp);
	}
}
