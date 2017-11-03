package com.xx.ssm.web.model;

public class JsonModel {
	private String  json;

	public JsonModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonModel(String json) {
		super();
		this.json = json;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "JsonModel [json=" + json + "]";
	}
	
}
