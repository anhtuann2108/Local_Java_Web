<%@page import="java.io.IOException"%>
<%@page import="com.trungtamjava.model.User"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

UserService userService = new UserServiceImpl();
User user = userService.findbyName(username);

if (user != null && password.equals(user.getPassword())) {
	HttpSession htpHttpSession = request.getSession();

	htpHttpSession.setAttribute("user", user);
	
	if (user.getRole().equals("Role_Admin")) {
		response.sendRedirect("/Section_06/admin/listUser.jsp");
	} else {
		response.sendRedirect("/Section_06/user/welcome.jsp");
	}
} else {
	response.sendRedirect("/Section_06/login/login.jsp");
}
%>