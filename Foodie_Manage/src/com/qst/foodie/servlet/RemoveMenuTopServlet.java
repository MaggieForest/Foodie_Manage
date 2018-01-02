package com.qst.foodie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.foodie.dao.MenuTopDAO;

@WebServlet("/RemoveMenuTopServlet")
public class RemoveMenuTopServlet extends HttpServlet {
	
	public RemoveMenuTopServlet(){
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
		int menu_id = Integer.parseInt(request.getParameter("menu_id"));
		MenuTopDAO dao = new MenuTopDAO();
		try {
			dao.remove(menu_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().println("<script LANGUAGE='javascript'>location.replace(document.referrer);</script>");

	}

}
