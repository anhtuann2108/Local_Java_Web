package com.trungtamjava.controller.client;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.serviceimpl.UserServiceImpl;

@WebServlet(urlPatterns = { "/user/upload" })
public class ClientUploadController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.valueOf(req.getParameter("id"));
			UserService userService = new UserServiceImpl();
			User user = userService.findById(id);

			// tao doi tuong de luu tam thoi file upload len
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// doi thanh duong dan toi thu muc , luu tam thoi file upload len
			diskFileItemFactory.setRepository(new File(
					"C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_07_MVC\\WebContent\\images"));

			// truyen factory vao constructor
			// doc request tu client gui len trong form upload
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);

			// danh sach cac truong input tu form client
			// duoc goi la fileitems
			List<FileItem> fileItems = fileUpload.parseRequest(req);

			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("imagefile")) {
						final String UPLOAD_FOLDER = "C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_07_MVC\\WebContent\\images";
						String name = fileItem.getName(); // tra ve ten file upload

						int index = name.lastIndexOf(".");

						String ext = name.substring(index); // lay phan dinh dang file
						
						String image = System.currentTimeMillis() + ext;
						File file = new File(UPLOAD_FOLDER + File.separator + image);

						fileItem.write(file);
						user.setImageAvatar(image);
						userService.updateAvatar(user);
						
						resp.sendRedirect(req.getContextPath()+"/user/welcome");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
