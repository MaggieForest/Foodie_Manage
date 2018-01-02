package com.qst.foodie.bean;
/**
 * 用户信息类
 * @author 李卓阳
 *
 */
public class UserInfo {
	private int id;				//配送信息ID
	private int user_id;		//用户ID，参照用户类
	private String address;		//送货地址
	private String tel;			//用户电话
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
