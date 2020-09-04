<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@page import="com.trungtamjava.model.User"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
	UserService userService = new UserServiceImpl();
	int id = Integer.valueOf(request.getParameter("id"));
	User user = userService.findById(id);
	
	String url = "";
	// tao doi tuong de luu tam thoi file upload len 
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	// doi thanh duong dan toi thu muc , luu tam thoi file upload len
	diskFileItemFactory.setRepository(new File("C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_06\\WebContent"));
	
	//truyen factory vao constructor
	// doc request tu client gui len trong form upload
	ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
	
	// danh sach cac truong input tu form client
	// duoc goi la fileitems
	List<FileItem> fileItems = fileUpload.parseRequest(request);
	
	for(FileItem fileItem : fileItems){
		if(!fileItem.isFormField()){
			if(fileItem.getFieldName().equals("imagefile")){
				final String UPLOAD_FOLDER ="C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_06\\WebContent\\images";
				String name = fileItem.getName(); // tra ve ten file upload
				
				int index = name.lastIndexOf(".");
				
				String ext = name.substring(index);  // lay phan dinh dang file
				//url = "../images/"+fileItem.getName();
				
				String image = System.currentTimeMillis() + ext;
				File file = new File(UPLOAD_FOLDER + File.separator + image);
				
				fileItem.write(file);
				user.setAvatar(image);
				userService.updateAvatar(user);
			}
		}
	}
	response.sendRedirect("/Section_06/user/welcome2.jsp");
%>

</body>
</html>