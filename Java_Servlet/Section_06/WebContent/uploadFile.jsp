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
	String url = "";
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	diskFileItemFactory.setRepository(new File("C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_06\\WebContent"));
	
	ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
	
	List<FileItem> fileItems = fileUpload.parseRequest(request);
	
	for(FileItem fileItem : fileItems){
		if(!fileItem.isFormField()){
			if(fileItem.getFieldName().equals("file")){
				File file = new File("C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_06\\WebContent\\images\\"+fileItem.getName());
				fileItem.write(file);
				url = "/Section_06/images"+fileItem.getName();
			}
		}
	}
%>
<img src ="<%=url %>" alt="No avatar">
</body>
</html>