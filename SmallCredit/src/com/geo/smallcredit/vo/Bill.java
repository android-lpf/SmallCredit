package com.geo.smallcredit.vo;

public class Bill {
	
	private String house;
	private String state;
	private String data;
	private String price;
	private String payMode;
	private String payPeriods;
	private String OverdueDays;
	private String dedit;
	private String interest;

	public Bill(String house,String state, String data,
			String price, String payMode, String payPeriods,
			String overdueDays, String dedit, String interest) {
		super();
		this.house = house;
		this.state = state;
		this.data = data;
		this.price = price;
		this.payMode = payMode;
		this.payPeriods = payPeriods;
		OverdueDays = overdueDays;
		this.dedit = dedit;
		this.interest = interest;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPayPeriods() {
		return payPeriods;
	}

	public void setPayPeriods(String payPeriods) {
		this.payPeriods = payPeriods;
	}

	public String getOverdueDays() {
		return OverdueDays;
	}

	public void setOverdueDays(String overdueDays) {
		OverdueDays = overdueDays;
	}

	public String getDedit() {
		return dedit;
	}

	public void setDedit(String dedit) {
		this.dedit = dedit;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

}
