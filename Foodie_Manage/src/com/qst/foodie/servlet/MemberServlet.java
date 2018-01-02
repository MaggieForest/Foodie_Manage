package com.qst.foodie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.foodie.bean.User;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	
	public MemberServlet() {
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
		User user = (User) request.getSession().getAttribute("user");
		if (user == null){
			response.sendRedirect("register.jsp");
			return;
		}
//		if (user.getUser_id() <= 0){
//			response.sendRedirect("register.jsp");
//			return;
//		}
		if ("¹ÜÀíÔ±".equals(user.getUser_flag())){
			response.sendRedirect("adm.jsp");
		} else {
			response.sendRedirect("user.jsp");
		}
	}
 
	}


