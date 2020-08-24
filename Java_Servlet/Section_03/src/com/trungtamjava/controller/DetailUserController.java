package com.trungtamjava.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;

@WebServlet(urlPatterns = {"/detail-user"})
public class DetailUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter print = resp.getWriter();

		User user = new User();

		user.setId(Integer.parseInt(req.getParameter("idDetail")));

		UserService userService = new UserServiceImpl();
		

		print.println("<table style=\"border: 1px solid black;\n"
				+ "  border-collapse: collapse; border-bottom-style:none;\">\n" + "  <tr>\n"
				+ "    <th style=\"border: 1px solid black;\n"
				+ "  border-collapse: collapse; text-align: left; padding: 5px;\n"
				+ "  width: 10rem; border-bottom-style:none; \">ID</th>\n"
				+ "    <th style=\"border: 1px solid black;\n"
				+ "  border-collapse: collapse; text-align: left; padding: 5px;\n"
				+ "  width: 10rem; border-bottom-style:none; \">Name</th> \n"
				+ "  <th style=\"border: 1px solid black;\n"
				+ "  border-collapse: collapse; text-align: center;padding: 5px;\n"
				+ "  width: 10rem; border-bottom-style:none;\">Age</th>\n" + "  </tr>\n" + "</table>");
		List<User> users = userService.search(user.getId());

		for (User userWeb : users) {
			print.println("<table style=\"border: 1px solid black;\n" + "  border-collapse: collapse; \" >\n"
					+ "  <tr>\n" + "    <th style=\"border: 1px solid black;\n"
					+ "  border-collapse: collapse; text-align: left; padding: 5px;\n" + "  width: 10rem; \"> "
					+ userWeb.getId() + " </th>\n" + "    <td style=\"border: 1px solid black;\n"
					+ "  border-collapse: collapse; padding: 5px;\n" + "  width: 10rem; \"> " + userWeb.getName()
					+ "</td>\n" + "  \t<td  style=\"border: 1px solid black;\n"
					+ "  border-collapse: collapse; padding: 5px;\n" + "  width: 10rem; \">" + userWeb.getAge()
					+ "</td>\n" + " </tr>" + "</table>");
		}
		print.println("<a href=\"/Section_03/user-list\">User List</a>");
		print.close();

	}
}
