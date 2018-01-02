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

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    
	public UserLoginServlet() {
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
		User user1 = new User();
		UserDAO dao = new UserDAO();
		user1.setUser_name(request.getParameter("username"));
		user1.setUser_password(request.getParameter("password"));
		//判断是否登录成功
		try {
			User curUser = dao.validatePassword(user1);
			if (curUser != null){
				HttpSession session = request.getSession(true);
				session.setAttribute("user", curUser);
				response.sendRedirect("index.jsp");
			} else {
				response.getWriter().println("<script LANGUAGE='javascript'> alert('用户名或密码错误！');self.location='register.jsp'</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}

