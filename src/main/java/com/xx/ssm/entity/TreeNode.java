package com.xx.ssm.entity;

import java.util.List;


public class TreeNode {
	private int id;
	private String nodeName;
	private String note1;
	private String note2;
	private String note3;
	public String getNote2() {
		return note2;
	}
	public void setNote2(String note2) {
		this.note2 = note2;
	}
	public String getNote3() {
		return note3;
	}
	public void setNote3(String note3) {
		this.note3 = note3;
	}
	private List<TreeNode> list;
	public void setNote1(String note1) {
		this.note1 = note1;
	}
	public String getNote1() {
		return note1;
	}
	public void setList(List<TreeNode> list) {
		this.list = list;
	}
	public List<TreeNode> getList() {
		return list;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeName() {
		return nodeName;
	}
	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", nodeName=" + nodeName + ", note1=" + note1 + ", note2=" + note2 + ", note3="
				+ note3 + ", list=" + list + "]";
	}
	 
	 
	 
}
