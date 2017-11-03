package com.xx.ssm.web.model;

public class UserInfoModel {
	private String userName;
	private String passWd;
	public UserInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfoModel(String userName, String passWd) {
		super();
		this.userName = userName;
		this.passWd = passWd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	@Override
	public String toString() {
		return "UserInfoModel [userName=" + userName + ", passWd=" + passWd + "]";
	}
	
}
