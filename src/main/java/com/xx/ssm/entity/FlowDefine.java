package com.xx.ssm.entity;

public class FlowDefine {
	private int id;
	private String flowName;
	private String jsonData;
	public FlowDefine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlowDefine(int id, String flowName, String jsonData) {
		super();
		this.id = id;
		this.flowName = flowName;
		this.jsonData = jsonData;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	@Override
	public String toString() {
		return "FlowDefine [id=" + id + ", flowName=" + flowName + ", jsonData=" + jsonData + "]";
	}
	
}
