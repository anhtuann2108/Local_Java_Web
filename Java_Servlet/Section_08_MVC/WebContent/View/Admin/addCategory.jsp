<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/Section_08_MVC/css/admin/welcome.css" rel="stylesheet">
<title>Add Category</title>
</head>
<body>
<jsp:include page="/View/Common/menu.jsp"></jsp:include>
<form action="/Section_08_MVC/admin/addCategory" method="POST">
        <div class="container" style="margin-left:15%;padding:1px 16px;height:600px;">
            <h1>Add Category</h1>
            <br>
           <label><b>ID</b></label>
           <input type="text" placeholder="Enter ID" name="id" required>
           <label><b>Name</b></label>
           <input type="text" placeholder="Enter CategoryName" name="categoryname" required>
           
            <button type="submit">Add Category</button>
        </div>
    </form>
</body>
</html>