package com.trungtamjava.controller.unknow;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.impl.CategoryServiceImpl;
import com.trungtamjava.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/searchByName"})
public class SearchByNameController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		ProductService productService = new ProductServiceImpl();
		List<Product> productList = productService.search(name);
		req.setAttribute("productList",productList);
		
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.categoryList();
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/welcome.jsp");
		dispatcher.forward(req, resp);
	}
}
