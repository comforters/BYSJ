package com.xx.ssm.entity;

public class FlowNode {
	private int id;
	private String nodeName;
	private String nodeType;
	private int nextNodeId;
	private int prevNodeId;
	private int approverUserId;
	private int approverRoleId;
	private int defid;
	public FlowNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlowNode(int id, String nodeName, String nodeType, int nextNodeId, int prevNodeId, int approverUserId,
			int approverRoleId, int defid) {
		super();
		this.id = id;
		this.nodeName = nodeName;
		this.nodeType = nodeType;
		this.nextNodeId = nextNodeId;
		this.prevNodeId = prevNodeId;
		this.approverUserId = approverUserId;
		this.approverRoleId = approverRoleId;
		this.defid = defid;
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
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public int getNextNodeId() {
		return nextNodeId;
	}
	public void setNextNodeId(int nextNodeId) {
		this.nextNodeId = nextNodeId;
	}
	public int getPrevNodeId() {
		return prevNodeId;
	}
	public void setPrevNodeId(int prevNodeId) {
		this.prevNodeId = prevNodeId;
	}
	public int getApproverUserId() {
		return approverUserId;
	}
	public void setApproverUserId(int approverUserId) {
		this.approverUserId = approverUserId;
	}
	public int getApproverRoleId() {
		return approverRoleId;
	}
	public void setApproverRoleId(int approverRoleId) {
		this.approverRoleId = approverRoleId;
	}
	public int getDefid() {
		return defid;
	}
	public void setDefid(int defid) {
		this.defid = defid;
	}
	@Override
	public String toString() {
		return "FlowNode [id=" + id + ", nodeName=" + nodeName + ", nodeType=" + nodeType + ", nextNodeId=" + nextNodeId
				+ ", prevNodeId=" + prevNodeId + ", approverUserId=" + approverUserId + ", approverRoleId="
				+ approverRoleId + ", defid=" + defid + "]";
	}
	
}
