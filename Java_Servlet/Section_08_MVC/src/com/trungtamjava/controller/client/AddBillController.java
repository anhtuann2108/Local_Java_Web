package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/user/addBill"})
public class AddBillController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.valueOf(req.getParameter("userid"));
		int id = Integer.valueOf(req.getParameter("id"));
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		ProductService productService = new ProductServiceImpl();
		Product product = productService.product(id);
		
		if(product.getQuantity() > quantity) {
			Bill bill = new Bill();
			User buyser = new User();
			buyser.setId(userId);
			bill.setBuyer(buyser);
			bill.setProduct(product);
			bill.setPrice(product.getPrice());
			bill.setPriceTotal(product.getPrice()*quantity);
			bill.setQuantity(quantity);
			Date date = new Date();
			bill.setBuyDate(date.toString());
			
			product.setQuantity(product.getQuantity()-quantity);
			BillDao billDao = new BillDaoImpl();
			productService.updateProductQuantity(product);
			billDao.create(bill);
			
			resp.sendRedirect(req.getContextPath()+"/user/welcome");
		}
	}
}
