package com.xx.ssm.web.model;

public class PayModel {
	private String fromCardNo;
	private String toCardNo;
	private String money;
	public String getFromCardNo() {
		return fromCardNo;
	}
	public void setFromCardNo(String fromCardNo) {
		this.fromCardNo = fromCardNo;
	}
	public String getToCardNo() {
		return toCardNo;
	}
	public void setToCardNo(String toCardNo) {
		this.toCardNo = toCardNo;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
}
