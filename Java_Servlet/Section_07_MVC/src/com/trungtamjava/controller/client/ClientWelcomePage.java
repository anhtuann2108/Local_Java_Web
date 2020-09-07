package com.trungtamjava.controller.client;

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
@WebServlet(urlPatterns = {"/user/welcome"})
public class ClientWelcomePage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginUser");
		int id = ((User)obj).getId();
		
		UserService userService = new UserServiceImpl();
		User user = userService.findById(id);
		req.setAttribute("user",user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/welcome.jsp");
		dispatcher.forward(req, resp);
	}
}
