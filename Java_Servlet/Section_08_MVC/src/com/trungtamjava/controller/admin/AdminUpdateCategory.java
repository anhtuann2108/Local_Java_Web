package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.impl.CategoryServiceImpl;
@WebServlet(urlPatterns = {"/admin/updateCategory"})
public class AdminUpdateCategory extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.searchById(id);
		
		req.setAttribute("updateCategory", category);
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("/View/Admin/updateCategory.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("nameCategory");
		
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category();
		category.setId(id);
		category.setNameCate(name);
		
		categoryService.update(category);
		
		resp.sendRedirect(req.getContextPath()+"/admin/detailCategory");
	}
}
