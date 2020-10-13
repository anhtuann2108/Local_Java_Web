<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link href="/Section_08_MVC/css/admin/welcome.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/View/Common/menu.jsp"></jsp:include>
	<form action="/Section_08_MVC/admin/addProduct" method="POST" enctype="multipart/form-data">
        <div class="container" style="margin-left:15%;padding:1px 16px;height:1000px;">
            <h1>Add Product List</h1>
            <br>
            <label><b>Product Name</b></label>
            <input type="text" placeholder="Enter Product Name" name="productname" required>
            <label><b>Price</b></label>
            <input type="text" placeholder="Enter Price" name="price" required>
            <label><b>Description</b></label>
            <input type="text" placeholder="Enter Description" name="description" required>
            <label><b>Category ID</b></label>
            <input type="text" placeholder="Enter Category ID" name="categoryId" required>
 			<label><b>Image</b></label>
            <input type="file" name="imageFile" accept="image/*">
        
            <button type="submit">Add</button>
        </div>
    </form>
</body>
</html>