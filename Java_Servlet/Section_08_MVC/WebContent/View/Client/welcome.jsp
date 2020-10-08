<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/styles.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Product-Page</title>
<!-- Custom styles for this template -->
<link href="/Section_08_MVC/css/client/product-page.css"
	rel="stylesheet">
</head>
<body>
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display: none" id="mySidebar">
		<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close &times;</button>
		
			<form action="/Section_08_MVC/searchByName" method="post">
			<input type="text" name="name" placeholder="Search.." style="margin-left:15px">
			<button type="submit"><i class="fa fa-search"></i></button>
			</form>
		<a href="/Section_08_MVC/welcome" class="w3-bar-item w3-button">All Product</a> 
		<c:forEach items="${categoryList}" var="category">
			<a href="/Section_08_MVC/searchById?id=${category.id}" class="w3-bar-item w3-button">${category.nameCate}</a> 
		</c:forEach>
	</div>

	<div id="main">
		<div class="w3-teal">
			<button id="openNav" class="w3-button w3-teal w3-xlarge"
				onclick="w3_open()">&#9776;</button>
			<div class="w3-container">
				<h1>Welcome</h1>
				<a href="/Section_08_MVC/login" >Login</a>
    			<a href="/Section_08_MVC/logout">Logout</a>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${productList}" var="product">
					<div class="column">
						<div class="card">
							<img src="/Section_08_MVC/dowload?image=${product.image}"
								alt="Image" class="images">
							<h1>${product.productname }</h1>
							<p class="price">${product.price}VND</p>
							<p>${product.description}</p>
							<p>
								<button>Add to Cart</button>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script>
		function w3_open() {
			document.getElementById("main").style.marginLeft = "25%";
			document.getElementById("mySidebar").style.width = "25%";
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("openNav").style.display = 'none';
		}
		function w3_close() {
			document.getElementById("main").style.marginLeft = "0%";
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("openNav").style.display = "inline-block";
		}
	</script>
</body>

</html>