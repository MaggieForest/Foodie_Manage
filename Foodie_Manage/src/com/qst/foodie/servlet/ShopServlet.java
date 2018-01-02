package com.qst.foodie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.foodie.bean.Menu;
import com.qst.foodie.bean.Shop;
import com.qst.foodie.dao.ShopDAO;
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	
	public ShopServlet(){
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
		ShopDAO dao = new ShopDAO();
		List<Shop> list = new ArrayList<Shop>();
		String type = request.getParameter("type");
		if("add".equals(type)){
			Shop shop = new Shop();
			shop.setShop_name(request.getParameter("shopname"));
			shop.setShop_address(request.getParameter("address"));
			shop.setShop_tel(request.getParameter("tel"));
			shop.setShop_content(request.getParameter("content"));
			try {
				if(dao.searchByShopname(shop)){
					response.getWriter().println("<script LANGUAGE='javascript'> alert('该商家已存在');history.go(-1);</script>");
				}
				else {
					dao.addShop(shop);
					response.getWriter().println("<script LANGUAGE='javascript'> alert('添加成功！');history.go(-1);</script>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else  if("delete".equals(type)){
			String  id = request.getParameter("shop_id");
			int shop_id = Integer.parseInt(id);
			try {
				dao.deleteMenu(shop_id);
				dao.deleteShop(shop_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().println("<script LANGUAGE='javascript'> alert('删除成功！');location.replace(document.referrer);</script>");
		}else if ("updateSelect".equals(type)) {
			try {
				int shop_Id = Integer.parseInt(request.getParameter("shop_id"));
				Shop shop = dao.selectShopById(shop_Id);
				request.setAttribute("shop", shop);
				request.getRequestDispatcher("shop_update.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if("update".equals(type)){
			Shop shop = new Shop();
			shop.setShop_id(Integer.parseInt(request.getParameter("shop_id")));
			shop.setShop_name(request.getParameter("shop_name"));
			shop.setShop_address(request.getParameter("address"));
			shop.setShop_tel(request.getParameter("tel"));
			shop.setShop_content(request.getParameter("content"));
			shop.setRevenue(Float.parseFloat(request.getParameter("revenue")));
			try {
				dao.update(shop);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().println("<script LANGUAGE='javascript'> alert('更新成功！');history.go(-1);</script>");
					
		}	
	}

}
