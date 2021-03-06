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
import com.trungtamjava.service.impl.UserServiceImpl;
@WebServlet(urlPatterns = {"/admin/addUser"})
public class AdminAddUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/addUser.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String about = req.getParameter("about");
		String[] favourites = req.getParameterValues("favourites");
		String role = req.getParameter("role");
		String fav ="";
		for(String f : favourites){
			fav += f + ",";
		}
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAbout(about);
		user.setFavourites(fav);
		user.setRole(role);
		user.setImageAvatar(req.getContextPath()+"/images/images.jpg");
		
		userService.addUser(user);
		
		resp.sendRedirect(req.getContextPath()+"/admin/welcome");
	}
}
