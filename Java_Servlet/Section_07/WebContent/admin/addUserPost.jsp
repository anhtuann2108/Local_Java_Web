<%@page import="com.trungtamjava.model.User"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	int id = Integer.valueOf(request.getParameter("id"));
	String name = request.getParameter("name");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String about = request.getParameter("about");
	String[] favourites = request.getParameterValues("favourites");
	String role = request.getParameter("role");
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
	user.setAvatar("../images/images.jpg");
	
	userService.addUser(user);
	
	response.sendRedirect("/Section_06/user/listUser.jsp");
	
%>