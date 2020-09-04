<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@page import="com.trungtamjava.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/welcomestyle.css">
    <link rel="stylesheet" href="../css/reset.css">
    <title>Welcome Home Page</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	String name = "";
	String username="";
	Object obj = httpSession.getAttribute("user");
	if(obj != null){
		name =  ((User) obj).getName();
		username = ((User) obj).getUsername();
	}else {
		response.sendRedirect("/Section_06/login/login.jsp");
	}
	UserService userService = new UserServiceImpl();
	User user = userService.findbyName(username);
	
%>
    <div class="container">
        <div class="welcome">WELCOME <%=name %></div>
        <div class="content">
            <div class="sidebar">
                <div class="avatar">
                    <img src="../images/<%=user.getAvatar() %>" alt="avatar">
                  
                </div>
                <div class="hobby">
                    <ul>
                        <li>Name:<%=user.getName() %></li>
                        <li>Username:<%=user.getUsername()%></li>
                        <li>Email:<%=user.getEmail()%></li>
                        <li>Phone:<%=user.getPhone()%></li>
                        <li>Favourites:<%=user.getFavourites()%></li>
                    </ul>
  					<form action="uploadFile.jsp?id=<%=user.getId() %>" method="post" enctype="multipart/form-data">
						<input type="file" name="imagefile" accept="image/*">
	
						<input type="submit" value ="Upload Avatar">
					</form>                    
                </div>
            </div>
            <div class="desc">
         	<%=user.getAbout() %>
         	<a href ="updateUser.jsp?id=<%=user.getId()%>"> Edit </a> 
            </div>
        </div>
        <div class="footer">
        　　　　<p>早稲田文理専門学校アプリ・Web制作学科ーグェン　アン　トゥアン<p>
        <a href='/Section_06/login/logout.jsp'>Logout</a>
        </div>
    </div>
</body>
</html>
