package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.impl.CategoryServiceImpl;
@WebServlet(urlPatterns = {"/admin/detailCategory"})
public class AdminDetailCategory extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.categoryList();
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/detailCategory.jsp");
		dispatcher.forward(req, resp);
	}
}
