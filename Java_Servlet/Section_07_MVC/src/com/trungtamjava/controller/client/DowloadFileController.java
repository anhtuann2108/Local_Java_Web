package com.trungtamjava.controller.client;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
@WebServlet(urlPatterns = {"/dowload"})
public class DowloadFileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String image = req.getParameter("image");
		final String UPLOAD_FOLDER = "C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_07_MVC\\WebContent\\images";
		File file = new File(UPLOAD_FOLDER + File.separator + image);
		if (file.exists()) {
			FileUtils.copyFile(file, resp.getOutputStream());
		}
	}
}
