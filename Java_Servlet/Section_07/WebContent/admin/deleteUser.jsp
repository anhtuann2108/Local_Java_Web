<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	int id = Integer.valueOf(request.getParameter("id"));
	UserService userService = new UserServiceImpl();
	userService.deleteUser(id);
	
	response.sendRedirect("/Section_06/admin/listUser.jsp");
%>