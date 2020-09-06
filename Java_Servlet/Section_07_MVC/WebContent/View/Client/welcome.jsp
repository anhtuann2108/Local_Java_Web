<%@page import="com.trungtamjava.serviceimpl.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@page import="com.trungtamjava.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Section_07_MVC/css/welcomestyle.css">
    <link rel="stylesheet" href="/Section_07_MVC/css/reset.css">
    <title>Welcome Home Page</title>
</head>
<body>
    <div class="container">
        <div class="welcome">WELCOME ${user.name}</div>
        <div class="content">
            <div class="sidebar">
                <div class="avatar">
                    <img src="/Section_07_MVC/dowload?image=${user.imageAvatar}" alt="avatar">
                </div>
                <div class="hobby">
                    <ul>
                        <li>Name:${user.name}</li>
                        <li>Username:${user.username}</li>
                        <li>Email:${user.email }</li>
                        <li>Phone:${user.phone }</li>
                        <li>Favourites:${user.favourites }</li>
                    </ul>
  					<form action="/Section_07_MVC/user/upload?id=${user.id}" method="post" enctype="multipart/form-data">
						<input type="file" name="imagefile" accept="image/*">
	
						<input type="submit" value ="Upload Avatar">
					</form>                    
                </div>
            </div>
            <div class="desc">
         	${user.about}
         	<a href ="/Section_07_MVC/user/update?id=${user.id}"> Edit </a> 
            </div>
        </div>
        <div class="footer">
        　　　　<p>早稲田文理専門学校アプリ・Web制作学科ーグェン　アン　トゥアン<p>
        <a href="/Section_07_MVC/logout">Logout</a>
        </div>
    </div>
</body>
</html>