package com.xx.ssm.web.model;

public class Lines {
	private String type;
	private String from;
	private String to;
	private String name;
	private boolean alt;
	public Lines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lines(String type, String from, String to, String name, boolean alt) {
		super();
		this.type = type;
		this.from = from;
		this.to = to;
		this.name = name;
		this.alt = alt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAlt() {
		return alt;
	}
	public void setAlt(boolean alt) {
		this.alt = alt;
	}
	@Override
	public String toString() {
		return "Lines [type=" + type + ", from=" + from + ", to=" + to + ", name=" + name + ", alt=" + alt + "]";
	}
	
}
