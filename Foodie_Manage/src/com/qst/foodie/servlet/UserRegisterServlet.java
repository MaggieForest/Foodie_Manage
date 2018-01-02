package com.qst.foodie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.foodie.bean.User;
import com.qst.foodie.dao.UserDAO;


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3769421531563109793L;


	public UserRegisterServlet(){
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
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUser_name(request.getParameter("username"));
		user.setUser_password(request.getParameter("password"));
		user.setUser_realname(request.getParameter("realname"));
		user.setUser_sex(request.getParameter("sex"));
		user.setUser_flag("普通用户");		//默认注册为普通用户
		user.setUser_mail(request.getParameter("email"));
		//判断用户是否已经注册
		try {
			if (dao.searchByUsername(user)){
				response.getWriter().println("<script LANGUAGE='javascript'> alert('该用户已存在');self.location='register.jsp'</script>");
			} else {
				dao.save(user);
				HttpSession session = request.getSession();
				session.setAttribute("SESSION_USER", user);
				response.getWriter().println("<script LANGUAGE='javascript'> alert('注册成功！');self.location='register.jsp'</script>");
				System.out.println("注册成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
	}

}
