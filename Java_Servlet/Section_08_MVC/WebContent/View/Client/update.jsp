<%@page import="com.trungtamjava.model.User"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Information</title>
</head>
<body>

<form action="/Section_08_MVC/user/update" method="POST">
        <div class="container">
            <h1>Edit User</h1>
            <br>
            <input type="hidden" name ="id" value="${updateUser.id }" >
            <label><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name="name" value="${updateUser.name }" required>
            <label><b>UserName</b></label>
            <input type="text" placeholder="Enter Username" name="username" value="${updateUser.username }" required>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" value="${updateUser.password }"  required>
 			<label><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" value="${updateUser.email }"  required>
            <label><b>Phone</b></label>
            <input type="text" placeholder="Enter Phone" name="phone" value="${ updateUser.phone}" required>
			<label><b>About</b></label>
			<textarea rows="4" cols="100" name="about" placeholder="Introduce" >${updateUser.about } </textarea>
			<label><b>ROLE</b></label><br/>
			<c:choose>
				<c:when test="${updateUser.role eq 'Role_Admin'}">
					<span>Admin<input name ="role" type ="radio" value="Role_Admin" checked="checked"></span>
					<span>User<input name ="role" type ="radio" value="Role_User"></span>
				</c:when>
				<c:otherwise>
					<span>Admin<input name ="role" type ="radio" value="Role_Admin" ></span>
					<span>User<input name ="role" type ="radio" value="Role_User" checked="checked"></span>
				</c:otherwise>				
			</c:choose>
			
			<label><b>Favourites</b></label><br/>
			<c:choose>
				<c:when test="${(fn:contains(updateUser.favourites,'Movies')) && (fn:contains(updateUser.favourites,'Music'))}">
					<span>Movies<input name="favourites" type="checkbox" value="Movies" checked="checked"></span>
					<span>Music<input name="favourites" type="checkbox" value="Music" checked="checked"></span>
				</c:when>
			<c:when test="${fn:contains(updateUser.favourites,'Movies')}">
				<span>Movies<input name="favourites" type="checkbox" value="Movies" checked="checked"></span>
				<span>Music<input name="favourites" type="checkbox" value="Music" ></span>
			</c:when>
			<c:when test="${fn:contains(updateUser.favourites,'Music')}">
				<span>Movies<input name="favourites" type="checkbox" value="Movies"></span>
				<span>Music<input name="favourites" type="checkbox" value="Music" checked="checked"></span>
			</c:when>
			<c:otherwise>
				<span>Movies<input name="favourites" type="checkbox" value="Movies"></span>
				<span>Music<input name="favourites" type="checkbox" value="Music" ></span>
			</c:otherwise>
			</c:choose>
            <button type="submit">Edit</button>
        </div>
    </form>
</body>
</html>