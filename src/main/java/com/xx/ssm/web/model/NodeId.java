package com.xx.ssm.web.model;

public class NodeId {
	private int id;

	public NodeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NodeId(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NodeId [id=" + id + "]";
	}
	
}
