package com.xx.ssm.web.model;

public class Nodes {
	private String name;
	private int left;
	private int top;
	private String type;
	private int width;
	private int height;
	private int userId;
	private int roleId;
	private boolean  alt;
	public Nodes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Nodes(String name, int left, int top, String type, int width, int height, int userId, int roleId,
			boolean alt) {
		super();
		this.name = name;
		this.left = left;
		this.top = top;
		this.type = type;
		this.width = width;
		this.height = height;
		this.userId = userId;
		this.roleId = roleId;
		this.alt = alt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public boolean isAlt() {
		return alt;
	}
	public void setAlt(boolean alt) {
		this.alt = alt;
	}
	@Override
	public String toString() {
		return "Nodes [name=" + name + ", left=" + left + ", top=" + top + ", type=" + type + ", width=" + width
				+ ", height=" + height + ", userId=" + userId + ", roleId=" + roleId + ", alt=" + alt + "]";
	}
	
}
