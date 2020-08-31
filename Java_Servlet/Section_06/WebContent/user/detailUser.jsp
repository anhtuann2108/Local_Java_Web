<%@page import="com.trungtamjava.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<h1> User Information</h1>
	<%
	UserService userService = new UserServiceImpl();
	List<User> userList = userService.findAllUser();
	%>
	<table class="table">
	  <thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Username</th>
			<th>Email</th>
			<th>Phone</th>
			<th>About</th>
		</tr>
		</thead>
		<%
			for (User user : userList) {
		%>
		<tbody>
		<tr>
			<td>
				<%=
					user.getId()
				%>
			</td>
			<td>
				<%=
					user.getName()
				%>
			</td>
			<td>
				<%=
					user.getUsername()
				%>
			</td>
			<td>
				<%=
					user.getEmail()
				%>
			</td>
			<td>
				<%=
					user.getPhone()
				%>
			</td>
			<td>
				<%=
					user.getAbout()
				%>
			</td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	</div>
</body>