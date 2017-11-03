package com.xx.ssm.entity;

public class FlowInstance {
	private int id;
	private int defid;
	private int currentNodeId;
	private String ServiceUrl;
	private String status;
	private int nextNodeId;
	private int userId;
	public FlowInstance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlowInstance(int id, int defid, int currentNodeId, String serviceUrl, String status, int nextNodeId,
			int userId) {
		super();
		this.id = id;
		this.defid = defid;
		this.currentNodeId = currentNodeId;
		ServiceUrl = serviceUrl;
		this.status = status;
		this.nextNodeId = nextNodeId;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDefid() {
		return defid;
	}
	public void setDefid(int defid) {
		this.defid = defid;
	}
	public int getCurrentNodeId() {
		return currentNodeId;
	}
	public void setCurrentNodeId(int currentNodeId) {
		this.currentNodeId = currentNodeId;
	}
	public String getServiceUrl() {
		return ServiceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		ServiceUrl = serviceUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNextNodeId() {
		return nextNodeId;
	}
	public void setNextNodeId(int nextNodeId) {
		this.nextNodeId = nextNodeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
