package com.qst.foodie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.qst.foodie.bean.User;
import com.qst.foodie.util.DBUtil;

/**
 * 用户操作类
 * @author 李卓阳
 *
 */
public class UserDAO {
	
	/**
	 * 根据用户名查询用户
	 * @throws SQLException 
	 */
	public User searchByUsername(String username) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		String sql = "SELECT * FROM tb_user WHERE user_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()){
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_realname(rs.getString("user_realname"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_flag(rs.getString("user_flag"));
				user.setUser_mail(rs.getString("user_mail"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
	
	/**
	 * 根据ID查询用户
	 * @throws SQLException 
	 */
	public User searchById(int id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		String sql = "SELECT * FROM tb_user WHERE user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()){
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_realname(rs.getString("user_realname"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_flag(rs.getString("user_flag"));
				user.setUser_mail(rs.getString("user_mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return user;
	}
	
	/**
	 * 更新用户
	 * @throws SQLException 
	 */
	public int update(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;	
		String sql = "UPDATE tb_user SET user_name=?, user_password=?, user_realname=?, user_sex=?, user_flag=?, user_mail=? WHERE user_id=?";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_realname());
			pstmt.setString(4, user.getUser_sex());
			pstmt.setString(5, user.getUser_flag());
			pstmt.setString(6, user.getUser_mail());
			pstmt.setInt(7, user.getUser_id());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return i;
	}
	
	/**
	 * 保存用户
	 * @throws SQLException 
	 */
	public void save(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO tb_user(user_name, user_password, user_realname, user_sex, user_flag, user_mail) VALUES(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_realname());
			pstmt.setString(4, user.getUser_sex());
			pstmt.setString(5, user.getUser_flag());
			pstmt.setString(6, user.getUser_mail());
			System.out.println("impl: " + user.getUser_mail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}

	/**
	 * 根据用户名查询用户是否存在
	 * @throws SQLException 
	 */
	public boolean searchByUsername(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_user WHERE user_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
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
	 * 验证密码是否正确，用户不存在则返回 false
	 * @throws SQLException 
	 */
	public User validatePassword(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tb_user WHERE user_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			rs = pstmt.executeQuery();
			if (rs.next()){
				String password = rs.getString("user_password");
				if (password.equals(user.getUser_password())){
					user.setUser_name(rs.getString("user_name"));
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_realname(rs.getString("user_realname"));
					user.setUser_sex(rs.getString("user_sex"));
					user.setUser_flag(rs.getString("user_flag"));
					user.setUser_mail(rs.getString("user_mail"));
					return user;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
}
