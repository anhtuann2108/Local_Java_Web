<%@page import="com.trungtamjava.model.User"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	String about = request.getParameter("about");
	int id = Integer.valueOf(request.getParameter("id"));
	UserService userService = new UserServiceImpl();
	User user = new User();
	
	user.setId(id);
	user.setAbout(about);
	
	userService.updateAbout(user);
	
	response.sendRedirect("/Section_06/user/welcome2.jsp");
	
%>