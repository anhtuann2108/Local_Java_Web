<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form action="/Section_08_MVC/admin/addProduct" method="POST" enctype="multipart/form-data">
        <div class="container">
            <h1>Add Product List</h1>
            <br>
            <label><b>Product Name</b></label>
            <input type="text" placeholder="Enter Product Name" name="productname" required>
            <label><b>Price</b></label>
            <input type="text" placeholder="Enter Price" name="price" required>
            <label><b>Description</b></label>
            <input type="text" placeholder="Enter Description" name="description" required>
 			<label><b>Image</b></label>
            <input type="file" name="imageFile" accept="image/*">
        
            <button type="submit">Add</button>
        </div>
    </form>
</body>
</html>