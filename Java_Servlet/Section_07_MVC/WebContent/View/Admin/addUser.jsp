<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/Section_07_MVC/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add User</title>
</head>
<body>
<form action="/Section_07_MVC/admin/addUser" method="POST">
        <div class="container">
            <h1>Add List User</h1>
            <br>
           <label><b>ID</b></label>
            <input type="text" placeholder="Enter ID" name="id" required>
            <label><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name="name" required>
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
			<label><b>ROLE</b></label><br/>
			<span>Admin<input name ="role" type ="radio" value="Role_Admin"></span>
			<span>User<input name ="role" type ="radio" value="Role_User"></span>
			<label><b>Favourites</b></label><br/>
			<span>Movies<input name="favourites" type="checkbox" value="Movies"></span>
			<span>Music<input name="favourites" type="checkbox" value="Music"></span>
			
            <button type="submit">Add</button>
        </div>
    </form>
</body>
</html>