<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/loginstyle.css">
    <title>Login Page</title>
</head>

<body>
    <form action="loginpost.jsp" method="post">
        <div class="formcontainer">
            <div class="imgcontainer">
                <img src="../images/avatarlogin.jpg" alt="Avatar" class="avatar">
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
                <span class="psw"><a href="/Section_06/register.jsp">Register</a></span>
            </div>
        </div>
    </form>
</body>

</html>