<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	HttpSession httpSession = request.getSession();

	httpSession.removeAttribute("user");

	response.sendRedirect("/Section_06/login/login.jsp");
%>