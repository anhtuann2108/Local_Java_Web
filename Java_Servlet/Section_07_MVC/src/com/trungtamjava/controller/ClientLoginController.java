package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.serviceimpl.UserServiceImpl;
@WebServlet(urlPatterns = {"/login"})
public class ClientLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/login.jsp");
		dispatcher.forward(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserService userService = new UserServiceImpl();
		User user = userService.findbyName(username);
		
		if(user != null && password.equals(user.getPassword())){
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
			resp.sendRedirect(req.getContextPath()+"/user/welcome");
		}else {
			resp.sendRedirect("/Section_07_MVC/login?e=1");
		}
	}
}
