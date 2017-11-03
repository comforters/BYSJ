package com.xx.ssm.web.model;

import java.util.List;

public class DataModel {
	private String tltle;	
	private List<Nodes> nodes;
	private List<Lines> lines;
	private String areas;
	private int initNum;
	public DataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataModel(String tltle, List<Nodes> nodes, List<Lines> lines, String areas, int initNum) {
		super();
		this.tltle = tltle;
		this.nodes = nodes;
		this.lines = lines;
		this.areas = areas;
		this.initNum = initNum;
	}
	public String getTltle() {
		return tltle;
	}
	public void setTltle(String tltle) {
		this.tltle = tltle;
	}
	public List<Nodes> getNodes() {
		return nodes;
	}
	public void setNodes(List<Nodes> nodes) {
		this.nodes = nodes;
	}
	public List<Lines> getLines() {
		return lines;
	}
	public void setLines(List<Lines> lines) {
		this.lines = lines;
	}
	public String getAreas() {
		return areas;
	}
	public void setAreas(String areas) {
		this.areas = areas;
	}
	public int getInitNum() {
		return initNum;
	}
	public void setInitNum(int initNum) {
		this.initNum = initNum;
	}
	@Override
	public String toString() {
		return "DataModel [tltle=" + tltle + ", nodes=" + nodes + ", lines=" + lines + ", areas=" + areas + ", initNum="
				+ initNum + "]";
	}
	
}
