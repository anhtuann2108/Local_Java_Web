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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Bill Page</title>
<!-- Custom styles for this template -->
<link href="/Section_08_MVC/css/client/quantityBox.css" rel="stylesheet">
<link href="/Section_08_MVC/css/client/menu.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/Section_08_MVC/css/BoxProductUpdate.css">
<!-- Boostrap Modal Box -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<%int i = 0; %>
<body>
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display: none" id="mySidebar">
		<button class="w3-bar-item w3-button w3-large" onclick="w3_close()">Close &times;</button>
		
			<form action="/Section_08_MVC/user/searchByName" method="post">
			<input type="text" name="name" placeholder="Search.." style="margin-left:15px">
			<button type="submit"><i class="fa fa-search"></i></button>
			</form>
		<a href="/Section_08_MVC/user/welcome" class="w3-bar-item w3-button">All Product</a> 
		<c:forEach items="${categoryList}" var="category">
			<a href="/Section_08_MVC/user/searchById?id=${category.id}" class="w3-bar-item w3-button">${category.nameCate}</a> 
		</c:forEach>
	</div>

	<div id="main">
		<div class="header">
  			<h2>My Website</h2>
  			<p>A Website created by me </p>
		</div>
	<ul>
		<li style="float:left"><button id="openNav" class="w3-button w3-teal w3-xlarge"
			onclick="w3_open()">&#9776;</button></li>
	  	<li><a href="#">${loginUser.name }</a></li>
	  	<li><a href="/Section_08_MVC/logout">Logout</a></li>
	   		<li><a href="/Section_08_MVC/user/bill-detail">Payment</a></li>
	  	<li><a class="active" href="/Section_08_MVC/welcome">Home</a></li>
	</ul>
	<div class="container">
	 <div class="modal-header">
          <h2 class="modal-title">Bill Product</h2>
        </div>
        <div class="modal-body">
        <table class="table">
	  <thead>
		<tr>
			<th>No.</th>
			<th>Product</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${billList}" var="bill">
		<tr>
			<td>
				<%=++i %>
			</td>
			<td>
				${bill.product.productname }
			</td>
			<td>
				${bill.price}
			</td>
			<td>
				<form action="/Section_08_MVC/user/updateBillQuantity" method="POST">
					<input type="hidden" value="${bill.id}" name="id"> 
					<input type="text" style="width:5rem" value="${bill.quantity}" name = "quantity"> 
					<button type="submit" class="btn btn-primary updateBtn">更新</button>
				</form>
				
			</td> 
			<td>
				${bill.quantity*bill.price}
			</td>
			<td><a href="/Section_08_MVC/user/deleteBill?id=${bill.id}" class="btn btn-default">Delete</a></td>
		</tr>
		</c:forEach>
		<tr>
			<th><strong>TOTAL</strong></th>
			<th></th>
			<th></th>
			<td></td>
			<td></td>
			<td><strong>${total}</strong></td>	
		</tr>
		</tbody>
        </table>
        </div>
        <div class="modal-footer">
         <a href="/Section_08_MVC/user/welcome" class="btn btn-default">Close</a>
        </div>
  </div>
  </div>
	<script>
		var mySidebar = document.getElementById("mySidebar");

		function w3_open() {
			document.getElementById("main").style.marginLeft = "17%";
			document.getElementById("mySidebar").style.width = "17%";
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("openNav").style.display = 'none';
		}
		function w3_close() {
			document.getElementById("main").style.marginLeft = "0%";
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("openNav").style.display = "inline-block";
		}
		window.onclick = function(event) {
			  if (event.target == mySidebar) {
				  document.getElementById("main").style.marginLeft = "0%";
					document.getElementById("mySidebar").style.display = "none";
					document.getElementById("openNav").style.display = "inline-block";
			  }
			}
	</script>
</body>

</html>