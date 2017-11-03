package com.xx.ssm.entity;

import java.util.List;

public class UserInfo {
	private int id;
	private String userName;
	private String passWd;
	private List<Role> roles;
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "UserInfo [id=" + id + ", userName=" + userName + ", passWd=" + passWd + ", roles=" + roles + "]";
	}
}
