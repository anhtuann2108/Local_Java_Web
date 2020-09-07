package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.service.UserService;
import com.trungtamjava.serviceimpl.UserServiceImpl;
@WebServlet(urlPatterns = {"/admin/deleteUser"})
public class AdminDeleteUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		UserService userService = new UserServiceImpl();
		userService.deleteUser(id);
		resp.sendRedirect(req.getContextPath()+"/admin/welcome");
	}
}
