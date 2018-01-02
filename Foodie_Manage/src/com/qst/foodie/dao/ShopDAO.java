package com.qst.foodie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qst.foodie.bean.Menu;
import com.qst.foodie.bean.Shop;
import com.qst.foodie.bean.User;
import com.qst.foodie.util.DBUtil;

public class ShopDAO {
	
	/**
	 * 修改商家信息
	 * @throws SQLException 
	 */
	public void update(Shop shop) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;	
		String sql = "UPDATE tb_shop SET shop_name=?, shop_address=?, shop_tel=?, shop_content=?, revenue=? WHERE shop_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shop.getShop_name());
			pstmt.setString(2, shop.getShop_address());
			pstmt.setString(3, shop.getShop_tel());
			pstmt.setString(4, shop.getShop_content());
			pstmt.setFloat(5, shop.getRevenue());
			pstmt.setInt(6, shop.getShop_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}	
	}
	
	/**
	 * 根据商家ID查找信息
	 * @throws SQLException 
	 */
	public Shop selectShopById(int shop_id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop shop = new Shop();
		String sql = "select * from tb_shop where shop_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shop_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				shop.setShop_id(rs.getInt("shop_id"));
				shop.setShop_name(rs.getString("shop_name"));
				shop.setShop_address(rs.getString("shop_address"));
				shop.setShop_tel(rs.getString("shop_tel"));
				shop.setRevenue(rs.getFloat("revenue"));
				shop.setShop_content(rs.getString("shop_content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return shop;
	}
	
	/**
	 * 根据商家ID删除商家菜单
	 * @throws SQLException 
	 */
	public void deleteMenu(int shop_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;		
		String sql = "delete from tb_menu where shop_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shop_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	
	/**
	 * 根据商家ID删除商家
	 * @throws SQLException 
	 */
	public void deleteShop(int shop_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;		
		String sql = "delete  from tb_shop where shop_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shop_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	
	/**
	 * 添加商家
	 * @throws SQLException 
	 */
	public void addShop(Shop shop) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO tb_shop(shop_name, shop_address, shop_tel, shop_content) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shop.getShop_name());
			pstmt.setString(2, shop.getShop_address());
			pstmt.setString(3, shop.getShop_tel());
			pstmt.setString(4, shop.getShop_content());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	/**
	 * 根据商家名查询商家ID
	 * @throws SQLException 
	 */
	public int searchByShopname(String shop_name) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT shop_id FROM tb_shop WHERE shop_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shop_name);
			rs = pstmt.executeQuery();
			if (rs.next()){
				return rs.getInt("shop_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return 0;
	}
	/**
	 * 根据商家名查询商家是否存在
	 * @throws SQLException 
	 */
	public boolean searchByShopname(Shop shop) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_shop WHERE shop_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shop.getShop_name());
			rs = pstmt.executeQuery();
			if (rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return false;
	}
	/**
	 * 获取商家集合
	 * @throws SQLException 
	 */
	public List<Shop> getShopList() throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Shop> list = new ArrayList<Shop>();
		String sql = "select * from tb_shop";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Shop shop = new Shop();
				shop.setShop_id(rs.getInt("shop_id"));
				shop.setShop_name(rs.getString("shop_name"));
				shop.setShop_address(rs.getString("shop_address"));
				shop.setShop_tel(rs.getString("shop_tel"));
				shop.setRevenue(rs.getFloat("revenue"));
				shop.setShop_content(rs.getString("shop_content"));
				shop.setMenuList(getMenuList(rs.getInt("shop_id")));
				list.add(shop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
	/**
	 * 获取商家菜单集合
	 */
	public List<Menu> getMenuList(int shop_id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		String sql = "select * from tb_menu where shop_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shop_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenu_id(rs.getInt("menu_id"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_content(rs.getString("menu_content"));
				menu.setMenu_price(rs.getFloat("menu_price"));
				menu.setMenu_image(rs.getString("menu_image"));
				list.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
