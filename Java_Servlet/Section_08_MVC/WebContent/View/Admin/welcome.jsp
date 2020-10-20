<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="/Section_08_MVC/css/admin/welcome.css" rel="stylesheet">
</head>
<body>
<% int i = 0; %>
	<jsp:include page="/View/Common/menu.jsp"></jsp:include>
	<div class="container" style="margin-left:15%;padding:1px 16px;height:1000px;">
	<h1>List User</h1>
	<table class="table">
	  <thead>
		<tr>
			<th>No.</th>
			<th>Name</th>
			<th>Username</th>
			<th>Edit</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${userList}" var="user">
		<tr>
			<td>
				<%=++i %>
			</td>
			<td>
				${user.name }
			</td>
			<td>
				${user.username}
			</td>
			<td><a href ="/Section_08_MVC/admin/updateUser?id=${user.id }"> Update </a> | <a href ="/Section_08_MVC/admin/deleteUser?id=${user.id }"> Delete </a> | <a href ="/Section_08_MVC/admin/detailUser?id=${user.id}"> Detail </a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>