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
<link href="/Section_08_MVC/css/admin/welcome.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="/View/Common/menu.jsp"></jsp:include>
	<div class="container" style="margin-left:15%;padding:1px 16px;height:1000px;">
	<h1> User Information</h1>
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
		<tbody>
		<tr>
			<td>
				${detailUser.id }
			</td>
			<td>
					${detailUser.name }
			</td>
			<td>
					${detailUser.username }
			</td>
			<td>
					${detailUser.email }
			</td>
			<td>
					${detailUser.phone }
			</td>
			<td>
					${detailUser.about }
			</td>
		</tr>
		</tbody>
	</table>
	</div>
</body>