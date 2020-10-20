package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@WebServlet(urlPatterns = {"/user/bill-detail"})
public class ClientBillDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Client/billDetail.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
