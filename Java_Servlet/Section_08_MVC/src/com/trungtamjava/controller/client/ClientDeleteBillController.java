package com.trungtamjava.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Product;
@WebServlet(urlPatterns = {"/user/deleteBill"})
public class ClientDeleteBillController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		
		BillDao billDao = new BillDaoImpl();
		
		ProductDao productDao = new ProductDaoImpl();
		
		Product product = productDao.findByBillId(id);
		Bill bill = billDao.get(id); 
		
		product.setQuantity(product.getQuantity()+bill.getQuantity());
		productDao.updateProductQuantity(product);
		
		billDao.delete(id);
		
		resp.sendRedirect(req.getContextPath()+"/user/bill-detail");
	}
}
