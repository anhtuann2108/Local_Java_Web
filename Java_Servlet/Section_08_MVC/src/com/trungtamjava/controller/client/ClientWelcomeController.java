package com.trungtamjava.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.impl.CategoryServiceImpl;
import com.trungtamjava.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/user/welcome"})
public class ClientWelcomeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("application/json");
		//resp.addHeader("Access-Control-Allow-Origin","*");
		
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categoryList = categoryService.categoryList();
		req.setAttribute("categoryList", categoryList);
		
		ProductService productService = new ProductServiceImpl();
		List<Product> productList = productService.listProduct();
		HttpSession session = req.getSession();
		req.setAttribute("productList", productList);
		
		
		Object obj = session.getAttribute("loginUser");
		int userId = ((User)obj).getId();
		int totalBill = 0;
		BillDao billDao = new BillDaoImpl();
		List<Bill> billList = billDao.search(userId);
		for(Bill b : billList) {
			totalBill += b.getPriceTotal();
		}
		session.setAttribute("billList", billList);
		session.setAttribute("total", totalBill);
		
		//Gson gson = new Gson();
		//PrintWriter printWriter = resp.getWriter();
		//printWriter.println(gson.toJson(categoryList));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/welcomeUser.jsp");
		dispatcher.forward(req, resp);
	}
}
