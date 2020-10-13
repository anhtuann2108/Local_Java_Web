<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="/Section_08_MVC/css/admin/welcome.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/View/Common/menu.jsp"></jsp:include>
	<div class="container" style="margin-left:15%;padding:1px 16px;height:1000px;">
	<h1> Category Information</h1>
	<table class="table">
	  <thead>
		<tr>
			<th>ID</th>
			<th>Category Name</th>
			<th>Edit</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${categoryList}" var="category">
		<tr>
			<td>
				${category.id}
			</td>
			<td>
				${category.nameCate }
			</td>
			<td><a href ="/Section_08_MVC/admin/updateCategory?id=${category.id }"> Update </a> | <a href ="/Section_08_MVC/admin/deleteCategory?id=${category.id }"> Delete </a> 
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>