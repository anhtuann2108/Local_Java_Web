<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/Section_08_MVC/css/loginstyle.css">
    <title>Login Page</title>
</head>
<% String error = request.getParameter("e");%>
<body>
	<c:if test="${param.e !=null }">
		<center><p>  Username or password wrong!!!</p></center>
	</c:if>
    <form action="/Section_08_MVC/login" method="post">
        <div class="formcontainer">
            <div class="imgcontainer">
                <img src="/Section_08_MVC/image/avatarlogin.jpg" alt="Avatar" class="avatar">
            </div>
            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>

                <button type="submit">Login</button>
                <label>
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" class="btn">Cancel</button>
                <button type="reset" class="btn">Reset</button>
                <span class="psw">||<a href="#">Forgot password?</a></span>
                <span class="psw"><a href="/Section_08_MVC/register">Register</a></span>
            </div>
        </div>
    </form>
</body>

</html>