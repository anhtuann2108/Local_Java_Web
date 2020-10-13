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
import com.trungtamjava.service.impl.UserServiceImpl;
@WebServlet(urlPatterns = {"/login"})
public class ClientLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginUser");
		if(obj!=null) {
			resp.sendRedirect(req.getContextPath() +"/user/welcome");
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/login.jsp");
			dispatcher.forward(req, resp);	
		}
			
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
			if(user.getRole().equals("Role_User")) {
				resp.sendRedirect(req.getContextPath()+"/user/welcome");
			}
			else if (user.getRole().equals("Role_Admin")) {
				resp.sendRedirect(req.getContextPath()+"/admin/welcome");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login?e=1");
		}
	}
}
