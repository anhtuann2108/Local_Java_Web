<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Section_08_MVC/css/style.css">
<title>Insert title here</title>
</head>
<body>
<form action="/Section_08_MVC/register" method="POST">
        <div class="container">
            <h1>Register</h1>
            <br>
           <label><b>ID</b></label>
            <input type="text" placeholder="Enter ID" name="id" >
            <label><b>Name</b></label>
            <input type="text" placeholder="Enter Name " name="name" required>
            <label><b>UserName</b></label>
            <input type="text" placeholder="Enter Username" name="username" required>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="password" required>
 			<label><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" required>
            <label><b>Phone</b></label>
            <input type="text" placeholder="Enter Phone" name="phone" required>
			<label><b>About</b></label>
			<textarea rows="4" cols="100" name="about" placeholder="Introduce"></textarea>
			<label><b>Favourites</b></label><br/>
			<span>Movies<input name="favourites" type="checkbox" value="Movies"></span>
			<span>Music<input name="favourites" type="checkbox" value="Music"></span>
			
            <button type="submit">Register</button>
        </div>
    </form>
</body>
</html>