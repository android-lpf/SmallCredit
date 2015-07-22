package com.geo.smallcredit.vo;

public class BaseBean {

	public int code;
	public String token;
	public String info;
	public String phone;
	public String userid;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public BaseBean(int code, String token, String info,String phone,String userid) {
		super();
		this.code = code;
		this.token = token;
		this.info = info;
		this.phone=phone;
		this.userid=userid;
	}
	public BaseBean() {
		super();
	}
	
}
