package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.impl.CategoryServiceImpl;
@WebServlet(urlPatterns = {"/admin/deleteCategory"})
public class AdminDeleteCategory extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.delete(id);
		
		resp.sendRedirect(req.getContextPath()+"/admin/detailCategory");
	}
}
