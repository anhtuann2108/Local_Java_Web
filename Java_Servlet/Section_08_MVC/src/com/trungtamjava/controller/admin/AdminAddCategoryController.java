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
@WebServlet(urlPatterns = {"/admin/addCategory"})
public class AdminAddCategoryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/addCategory.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String categoryname = req.getParameter("categoryname");
		Category category = new Category();
		category.setId(id);
		category.setNameCate(categoryname);
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.add(category);
		
		resp.sendRedirect(req.getContextPath()+"/admin/detailCategory");
	}
}
