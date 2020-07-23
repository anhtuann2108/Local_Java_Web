package com.nguyenanhtuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/testServletConfig"}, initParams = {@WebInitParam(name="tuan",value="Nguyen Anh Tuan")})
public class ServletConfig extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = super.getServletConfig().getInitParameter("tuan");
		resp.getContentType();
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("Xin chao "+name);
		
		writer.println(getServletConfig().getServletName());
	}
}
