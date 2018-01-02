package com.qst.foodie.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

/**
 * ��ݿ������
 * @author ��׿��
 *
 */
public class DBUtil {
	private static BasicDataSource dataSource = null;
	private static Connection conn = null;
	
	public DBUtil(){
	}
	
	/**
	 * ��ʼ����ݿ����ӳ�
	 */
	public static void init(){
		if (dataSource != null){
			try {
				dataSource.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dataSource = null;
		}
		//ʹ��Properties��������ݿ����ӳ���Ϣ
		try {
			Properties p = new Properties();
			p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			p.setProperty("url", "jdbc:mysql://localhost:3306/wsdc?useUnicode=true&characterEncoding=utf-8");
			p.setProperty("username", "root");
			p.setProperty("password", "123");
			p.setProperty("maxActive", "30");				//���ô��ڻ״̬����ݿ����ӵ������Ŀ��0��ʾ��������
			p.setProperty("maxIdle", "10");					//���ô��ڿ���״̬����ݿ����ӵ������Ŀ��0��ʾ��������
			p.setProperty("maxWait", "1000");				//����û�д��ڿ���״̬������ʱ��������ݿ������������ȴ�ʱ�䣨��λms����������ʱ�佫�׳��쳣��-1��ʾ�����ڵȴ�
			p.setProperty("removeAbandoned", "false");
			p.setProperty("removeAbandonedTimeout", "120");
			p.setProperty("testOnBorrow", "true");
			p.setProperty("logAbandoned", "true");
			//��ָ����Ϣ�������Դ
			dataSource = (BasicDataSource)BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡ��ݿ�����
	 * @return Connection����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/wsdc?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String psw = "123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,psw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ر���ݿ�����
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeJDBC(ResultSet rs, Statement stmt, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}