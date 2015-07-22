package com.geo.smallcredit.vo;

public class JieSelector {
	private String name;
	private int frontImg;
	private String jieETv;
	private String currentState;
	private String jiePrice;
	private String stateShen;

	public JieSelector(String name, int frontImg, String jieETv,
			String currentState, String jiePrice, String stateShen) {
		super();
		this.name = name;
		this.frontImg = frontImg;
		this.jieETv = jieETv;
		this.currentState = currentState;
		this.jiePrice = jiePrice;
		this.stateShen = stateShen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrontImg() {
		return frontImg;
	}

	public void setFrontImg(int frontImg) {
		this.frontImg = frontImg;
	}

	public String getJieETv() {
		return jieETv;
	}

	public void setJieETv(String jieETv) {
		this.jieETv = jieETv;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getJiePrice() {
		return jiePrice;
	}

	public void setJiePrice(String jiePrice) {
		this.jiePrice = jiePrice;
	}

	public String getStateShen() {
		return stateShen;
	}

	public void setStateShen(String stateShen) {
		this.stateShen = stateShen;
	}

}
