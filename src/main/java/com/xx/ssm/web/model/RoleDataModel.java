package com.xx.ssm.web.model;

public class RoleDataModel {
	private String nodeName;
	private int roleId;
	private int userId;
	public RoleDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDataModel( String nodeName, int roleId, int userId) {
		super();
		this.nodeName = nodeName;
		this.roleId = roleId;
		this.userId = userId;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RoleDataModel [nodeName=" + nodeName + ", roleId=" + roleId + ", userId=" + userId + "]";
	}
	
}
