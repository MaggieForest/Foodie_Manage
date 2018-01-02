package com.qst.foodie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.foodie.bean.Menu;
import com.qst.foodie.dao.MenuDAO;
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	
	public MenuServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MenuDAO dao = new MenuDAO();
		String type = request.getParameter("type");
		if("delete".equals(type)){
			int menu_id = Integer.parseInt(request.getParameter("menu_id"));
			try {
				dao.delete(menu_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().println("<script LANGUAGE='javascript'>location.replace(document.referrer);</script>");
		}else if("updateSelect".equals(type)){
			int menu_id = Integer.parseInt(request.getParameter("menu_id"));
			try {
				Menu menu = dao.getMenu(menu_id);
				request.setAttribute("menu", menu);
				request.getRequestDispatcher("update_food.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
