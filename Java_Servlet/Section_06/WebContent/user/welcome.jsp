<%@page import="com.trungtamjava.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	String name = "";
	Object obj = httpSession.getAttribute("user");
	if(obj != null){
		name =  ((User) obj).getName();
	}else {
		response.sendRedirect("/Section_06/login/login.jsp");
	}
%>
 <h1> Welcome <%=name %></h1>
 <h1><a href="/Section_06/admin/addUser.jsp">Add User</a></h1>
 <h1><a href="/Section_06/admin/listUser.jsp">ListUser</a></h1>
 Log out Account <a href='/Section_06/login/logout.jsp'>Logout</a>
</body>
</html>