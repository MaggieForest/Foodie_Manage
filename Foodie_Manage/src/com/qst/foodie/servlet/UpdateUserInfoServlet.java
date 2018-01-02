package com.qst.foodie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.foodie.bean.User;
import com.qst.foodie.bean.UserInfo;
import com.qst.foodie.dao.UserInfoDAO;
@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 7724880508150250366L;

	public UpdateUserInfoServlet(){
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
		UserInfoDAO dao = new UserInfoDAO();
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		User userif = (User) request.getSession().getAttribute("user");
		try {
			UserInfo userInfo = dao.searchByUser(userif);
			if (userInfo == null){
				//创建配送信息
				userInfo.setUser_id(userif.getUser_id());
				userInfo.setAddress(address);
				userInfo.setTel(tel);
				dao.save(userInfo);
			} else {
				//更新配送信息
				userInfo.setUser_id(userif.getUser_id());
				userInfo.setAddress(address);
				userInfo.setTel(tel);
				dao.update(userInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().println("<script LANGUAGE='javascript'> alert('更新成功！');history.go(-1);</script>"); 
	}

}
