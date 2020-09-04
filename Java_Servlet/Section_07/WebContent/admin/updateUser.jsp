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
            <h1>Edit User</h1>
            <br>
            <input type="hidden" name ="id" value="<%=user.getId() %>" >
            <label><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name="name" value="<%=user.getName() %>" required>
            <label><b>UserName</b></label>
            <input type="text" placeholder="Enter Username" name="username" value="<%=user.getUsername() %>" required>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" value="<%=user.getPassword() %>"  required>
 			<label><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" value="<%=user.getEmail() %>"  required>
            <label><b>Phone</b></label>
            <input type="text" placeholder="Enter Phone" name="phone" value="<%=user.getPhone() %>" required>
			<label><b>About</b></label>
			<textarea rows="4" cols="100" name="about" placeholder="Introduce" ><%=user.getAbout()%> </textarea>
			<label><b>ROLE</b></label><br/>
			<% if (user.getRole().equals("Role_admin")) { %>
			<span>Admin<input name ="role" type ="radio" value="Role_Admin" checked="checked"></span>
			<span>User<input name ="role" type ="radio" value="Role_User"></span>
			<% }else { %>
			<span>Admin<input name ="role" type ="radio" value="Role_Admin" ></span>
			<span>User<input name ="role" type ="radio" value="Role_User" checked="checked"></span>
			<% } %>
			<label><b>Favourites</b></label><br/>
			<% String favourites = user.getFavourites(); 
			   if (favourites.contains("Movies") && favourites.contains("Music")) {%>
			<span>Movies<input name="favourites" type="checkbox" value="Movies" checked="checked"></span>
			<span>Music<input name="favourites" type="checkbox" value="Music" checked="checked"></span>
			<% } else if (favourites.contains("Movie")) { %>
			<span>Movies<input name="favourites" type="checkbox" value="Movies" checked="checked"></span>
			<span>Music<input name="favourites" type="checkbox" value="Music" ></span>
			<% } else if (favourites.contains("Music")){ %>
			<span>Movies<input name="favourites" type="checkbox" value="Movies"></span>
			<span>Music<input name="favourites" type="checkbox" value="Music" checked="checked"></span>
			<% } else { %>
			<span>Movies<input name="favourites" type="checkbox" value="Movies"></span>
			<span>Music<input name="favourites" type="checkbox" value="Music" ></span>
			<%} %>
            <button type="submit">Edit</button>
        </div>
    </form>
</body>
</html>