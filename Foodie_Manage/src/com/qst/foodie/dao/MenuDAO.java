package com.qst.foodie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qst.foodie.bean.Menu;
import com.qst.foodie.bean.Shop;
import com.qst.foodie.util.DBUtil;

public class MenuDAO {
	
	/**
	 * 根据菜单ID删除信息
	 * @throws SQLException 
	 */
	public void delete(int menu_id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;		
		String sql = "delete from tb_menu where menu_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, menu_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	/**
	 * 根据菜单ID查找菜单信息
	 * @throws SQLException 
	 */
	public Menu getMenu(int menu_id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Menu menu = new Menu();
		String sql = "select * from tb_menu where menu_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, menu_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				menu.setShop_id(rs.getInt("shop_id"));
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getFloat("menu_price"));
				menu.setMenu_content(rs.getString("menu_content"));
				menu.setMenu_image(rs.getString("menu_image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return menu;
	}
	
	/**
	 * 保存菜品
	 * @throws SQLException 
	 */
	public void save(Menu menu, int shop_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tb_menu(shop_id, menu_name, menu_content, menu_price, menu_image) VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shop_id);
			pstmt.setString(2, menu.getMenu_name());
			pstmt.setString(3, menu.getMenu_content());
			pstmt.setFloat(4, (float) menu.getMenu_price());
			pstmt.setString(5, menu.getMenu_image());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
}
