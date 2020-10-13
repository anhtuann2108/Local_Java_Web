<%@page import="com.trungtamjava.model.User"%>
<%@page import="com.trungtamjava.service.impl.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/Section_08_MVC/css/admin/welcome.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Category</title>
</head>
<body>
	<jsp:include page="/View/Common/menu.jsp"></jsp:include>
	<form action="/Section_08_MVC/admin/updateCategory" method="POST">
        <div class="container" style="margin-left:15%;padding:1px 16px;height:1000px;">
            <h1>Edit User</h1>
            <br>
            <input type="hidden" name ="id" value="${updateCategory.id }" >
            <label><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name="nameCategory" value="${updateCategory.nameCate }" required>
  
            <button type="submit">Edit</button>
        </div>
    </form>
</body>
</html>