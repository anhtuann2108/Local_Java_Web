package com.trungtamjava.controller.unknow;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.impl.CategoryServiceImpl;
import com.trungtamjava.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/welcome"})
public class WelcomeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginUser");
		if(obj!=null) {
			resp.sendRedirect(req.getContextPath() +"/user/welcome");
		}else {
			CategoryService categoryService = new CategoryServiceImpl();
			List<Category> categoryList = categoryService.categoryList();
			req.setAttribute("categoryList", categoryList);
			
			ProductService productService = new ProductServiceImpl();
			List<Product> productList = productService.listProduct();
			req.setAttribute("productList", productList);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/welcome.jsp");
			dispatcher.forward(req, resp);	
		}
		
	}
}
