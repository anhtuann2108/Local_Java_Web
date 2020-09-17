<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="container">
		<h1>List Product</h1>
	<table class="table">
	  <thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Image</th>
			<th>Description</th>
			<th>Edit</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${productList}" var="product">
		<tr>
			<td>
				${product.id}
			</td>
			<td>
				${product.productname }
			</td>
			<td>
				${product.price} VND
			</td>
			<td>
				${product.description}
			</td>
			<td>
				<img src="/Section_08_MVC/dowload?image=${product.image}"
								alt="Image" class="images" width="300px" height="300px">
			</td>
			<td><a href="/Section_08_MVC/admin/updateUser?id=${user.id }"> Update </a> | <a
							href="/Section_08_MVC/admin/deleteUser?id=${user.id }"> Delete </a> | <a
							href="/Section_08_MVC/admin/detailUser?id=${user.id}"> Detail </a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<h1>
			<a href="/Section_08_MVC/admin/addUser">Add User</a>
		</h1>
	<h1>
			<a href="/Section_08_MVC/admin/addProduct">Add Product</a>
		</h1>
	Log out Account <a href="/Section_08_MVC/logout">Logout</a>
	</div>
</body>


</html>