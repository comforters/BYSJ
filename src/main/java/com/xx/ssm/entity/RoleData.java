package com.xx.ssm.entity;

public class RoleData {
	private int id;
	private String nodeName;
	private int roleId;
	private int userId;
	public RoleData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleData(int id, String nodeName, int roleId, int userId) {
		super();
		this.id = id;
		this.nodeName = nodeName;
		this.roleId = roleId;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "RoleData [id=" + id + ", nodeName=" + nodeName + ", roleId=" + roleId + ", userId=" + userId + "]";
	}
	
}
