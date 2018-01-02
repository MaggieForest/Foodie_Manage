package com.qst.foodie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.qst.foodie.bean.User;
import com.qst.foodie.bean.UserInfo;
import com.qst.foodie.util.DBUtil;


public class UserInfoDAO {
	
	/**
	 * 保存用户配送信息
	 * @param userInfo
	 * @throws SQLException 
	 */
	public void save(UserInfo userInfo) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO user_info(user_id, address, tel) VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userInfo.getUser_id());
			pstmt.setString(2, userInfo.getAddress());
			pstmt.setString(3, userInfo.getTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	
	/**
	 * 更新用户信息
	 * @throws SQLException 
	 */
	public int update(UserInfo userInfo) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE user_info SET address=?, tel=? WHERE user_id=?";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userInfo.getAddress());
			pstmt.setString(2, userInfo.getTel());
			pstmt.setInt(3, userInfo.getUser_id());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return i;
	}
	
	/**
	 * 根据用户查询配送信息
	 * @throws SQLException 
	 */
	public UserInfo searchByUser(User user) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user_info WHERE user_id=?";
		UserInfo userInfo = new UserInfo();		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_id());
			rs = pstmt.executeQuery();
			if (rs.next()){
				userInfo.setAddress(rs.getString("address"));
				userInfo.setTel(rs.getString("tel"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return null;
	}
}
