<%@page import="com.trungtamjava.model.User"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add User</title>
</head>
<body>
	<%
		int id = Integer.valueOf(request.getParameter("id"));
		UserService userService  = new UserServiceImpl();
		User user = userService.findById(id);
	%>
<form action="updateUserPost.jsp" method="POST">
        <div class="container">
            <h1>Edit About</h1>
            <br>
            <input type="hidden" name ="id" value="<%=user.getId() %>" >
			<label><b>About</b></label>
			<textarea rows="4" cols="100" name="about" placeholder="Introduce" ><%=user.getAbout()%> </textarea>
			
            <button type="submit">Edit</button>
        </div>
    </form>
</body>
</html>