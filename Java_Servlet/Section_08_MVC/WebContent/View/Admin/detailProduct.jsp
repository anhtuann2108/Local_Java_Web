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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/Section_08_MVC/css/detailProduct.css">
<link rel="stylesheet" type="text/css" href="/Section_08_MVC/css/BoxProductUpdate.css">
<title>Detail Product</title>
</head>
<body>
<body>
	<div class="container">
		<h1>List Product</h1>
		<form action="/Section_08_MVC/admin/search" method="post">
			<input class="inputOut" type="text" name="name" placeholder="Search..">
			<button class="btnOut" type="submit"><i class="fa fa-search"></i></button>
		</form>
	<table class="table">
	  <thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Image</th>
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
								alt="Image" class="images" width="100px" height="100px">
			</td>
			<td>
				<button class="myBtn" >Update</button>  <button class="btnBox">Delete</button> 
				<div class="myModal">
  					<div class="modal-content">
    					<span class="close">&times;</span>
    					<form class="updateBox" action="/Section_08_MVC/admin/updateProduct" method="POST" enctype="multipart/form-data">
        				<div class="container">
        					<input class="inputBox" type="hidden" value="${product.id}" name="id" required>
            				<label><b>Product Name</b></label>
            				<input class="inputBox" type="text" value="${product.productname}" name="productname" required>
            				<label><b>Price</b></label>
            				<input class="inputBox" type="text" value="${product.price}" name="price" required>
            				<label><b>Description</b></label>
           					<input class="inputBox" type="text" value="${product.description}" name="description" required>
 							<label><b>Image</b></label>
 							<img src="/Section_08_MVC/dowload?image=${product.image}" alt="Image" class="images" width="100px" height="100px">
            				<input class="inputBox" type="file" name="imageFile" accept="image/*">
     
            				<button class="btnBox" type="submit">Add</button>
        					</div>
    					</form>
  					    </div>
				</div>
					
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<h1>
		<a href="/Section_08_MVC/admin/addUser">Add User</a>
		<a href="/Section_08_MVC/admin/addProduct">Add Product</a>
	</h1>
	Log out Account <a href="/Section_08_MVC/logout">Logout</a>
	</div>
	<!-- JS------------------------------------------------------------------------ -->
	<script>
	// Get the modal
	var modal = document.getElementsByClassName("myModal");
	console.log(modal);	
	// Get the button that opens the modal
	var btns = document.getElementsByClassName("myBtn");
	console.log(btns);
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close");
	
	// When the user clicks the button, open the modal 
  
 	[...btns].forEach((item) => 
	item.addEventListener('click', function(){
		let index = [...btns].indexOf(item)
		modal[index].style.display = 'block'
	}))
	// When the user clicks on <span> (x), close the modal
	for(let item of span){
		item.addEventListener('click', function(){
			let index = ([...span].indexOf(item))
			modal[index].style.display = 'none'
		})
	}
	window.onclick = function(event) {
		for(let item of modal){
			if (event.target == item) {
			    item.style.display = "none";
			  }
		}
	}

// When the user clicks anywhere outside of the modal, close it
		
</script>
	
</body>
</html>