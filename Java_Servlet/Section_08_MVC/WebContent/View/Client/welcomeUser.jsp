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
<title>Product-Page</title>
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
		<li><button data-toggle="modal" data-target="#myModal" class="w3-button w3-teal w3-xlarge"><i class="fa fa-shopping-cart"></i></button></li>
	  	<li><a href="#">${loginUser.name }</a></li>
	  	<li><a href="/Section_08_MVC/logout">Logout</a></li>
	   	<li><a href="/Section_08_MVC/user/bill-detail">Payment</a></li>
	  	<li><a class="active" href="/Section_08_MVC/welcome">Home</a></li>
	</ul>
		<div class="container">
			<div class="row">
				<c:forEach items="${productList}" var="product">
					<div class="column">
						<div class="card">
							<img src="/Section_08_MVC/dowload?image=${product.image}"
								alt="Image" class="images">
							<h1>${product.productname }</h1>
							<p class="price">${product.price}¥</p>
							<p>${product.description}</p>
							<p><button class="myBtn" >Add to Cart</button> </p>
								<div class="myModal">
  								<div class="modal-content">
			    					<form class="updateBox" action="/Section_08_MVC/user/addBill" method="POST">
				        				<div class="containerBox">
				        					<input class="inputBox" type="hidden" value="${product.id}" name="id" required>
				        					<input class="inputBox" type="hidden" value="${loginUser.id}" name="userid" required>
				            				<label><b>Quantity</b></label>
				            				<input class="inputBox" placeholder="Please enter quantity" type="text" name="quantity" required>
				            				<button class="btnBoxModal" type="submit"> Add</button>
				        				</div>
			    					</form>
			  					</div>
								</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div style="width:80rem"class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Bill Product</h4>
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
				<input class="quantityInput" style="width:5rem" value="${bill.quantity}" > <button data-id ="${bill.id}" class="btn btn-primary updateBtn">更新</button>
			</td> 
			<td>
				${bill.quantity*bill.price}
			</td>
		</tr>
		</c:forEach>
		<tr>
			<th><strong>TOTAL</strong></th>
			<th></th>
			<th></th>
			<td></td>
			<td><strong>${total}</strong></td>	
		</tr>
		</tbody>
        </table>
        </div>
        <div class="modal-footer">
         <a href="/Section_08_MVC/user/bill-detail" class="btn btn-default">Payment</a>
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
	<script>
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
		var modal = document.getElementsByClassName("myModal");
		console.log(modal);	
		// Get the button that opens the modal
		var btns = document.getElementsByClassName("myBtn");
		// When the user clicks the button, open the modal 
		
	 	[...btns].forEach((item) => 
		item.addEventListener('click', function(){
			let index = [...btns].indexOf(item)
			modal[index].style.display = 'block'
		}))
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			for(let item of modal){
				if (event.target == item) {
				    item.style.display = "none";
				  }
			}
		}
	 //update product
	 var updateBtn = document.getElementsByClassName("updateBtn");
	[...updateBtn].forEach(item=>{
		 const id = item.getAttribute("data-id");
		item.addEventListener("click",(event)=>{
			const quantity = event.target.previousElementSibling.value;
			updateFtn(id,quantity)
		});
	}
	)
	 
	 const updateFtn = (id,quantity)=>{
		 $.ajax({
			 method: "POST",
			 url: "http://localhost:8080/Section_08_MVC/user/updateBillQuantity",
			 data: {id,quantity}  
		 }).done(data=>console.log(data))
	 }
	 
	 
	</script>
</body>

</html>