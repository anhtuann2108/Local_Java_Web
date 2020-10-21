package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = {"/user/updateBillQuantity"})
public class UpdateBillQuantityController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findByBillId(id);
		BillDao billDao = new BillDaoImpl();
		Bill bill = billDao.get(id);
		
		int quantityNew = Math.abs(quantity-bill.getQuantity());
		if(quantity > bill.getQuantity()) {
			product.setQuantity(product.getQuantity()-quantityNew);
		}else {
			product.setQuantity(product.getQuantity()+quantityNew);
		}
		bill.setQuantity(quantity);
		billDao.update(bill);
		productDao.updateProductQuantity(product);
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginUser");
		int userId = ((User)obj).getId();
		int totalBill = 0;
		List<Bill> billList = billDao.search(userId);
		for(Bill b : billList) {
			totalBill += b.getPriceTotal();
		}
		
		session.setAttribute("billList", billList);
		session.setAttribute("total", totalBill);
		
		resp.sendRedirect(req.getContextPath()+"/user/bill-detail");
	}	
}
