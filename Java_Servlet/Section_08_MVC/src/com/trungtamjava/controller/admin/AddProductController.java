package com.trungtamjava.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/admin/addProduct"})
public class AddProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/Admin/AddProduct.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();

			factory.setRepository(new File("C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_08_MVC\\WebContent\\image"));
		
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			
			List<FileItem> fieldList = servletFileUpload.parseRequest(req);

			Product product = new Product();
		
			for (FileItem item : fieldList) {
				
				if (item.getFieldName().equals("productname")) {
					String name = item.getString();
					product.setProductname(name);
				}
				
				if (item.getFieldName().equals("price")) {
					String price = item.getString();
					product.setPrice(Integer.parseInt(price));
				}
			
				if (item.getFieldName().equals("description")) {
					String description = item.getString();
					product.setDescription(description);
				}
				if( item.getFieldName().equals("categoryId")) {
					String categoryId = item.getString();
					Category category = new Category();
					category.setId(Integer.parseInt(categoryId));
					product.setCategory(category);
				}
				if (item.getFieldName().equals("imageFile")) {
				
					if (item.getSize() > 0) {
						final String UPLOAD_FOLDER = "C:\\Users\\anhtu\\Desktop\\Github\\Local_Repo\\Local_Java_Web\\Java_Servlet\\Section_08_MVC\\WebContent\\image";
						
						String name = item.getName();
						int index = name.lastIndexOf(".");
						String ext = name.substring(index);
						
						String image = System.currentTimeMillis() + ext;//ten file 
						File file = new File(UPLOAD_FOLDER + File.separator + image);
						
						item.write(file);
						
						product.setImage(image);
					}
				}
			}
		
			ProductService producService = new ProductServiceImpl();
			producService.addProduct(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product-detail");
		} catch (Exception e) {
			System.out.println("Loi " + e);
		}
	}
}
