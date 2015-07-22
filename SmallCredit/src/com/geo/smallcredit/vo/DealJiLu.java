package com.geo.smallcredit.vo;

public class DealJiLu {
	private String mouthName;
	private String rotateTo;
	private String rotateToPrice;
	private String todayData;
	private String rotateToState;
	private String rotateOut;
	private String rotateOutPrice;
	private String rotateOutData;
	private String rotateOutState;
	private String buy;
	private String buyPrice;
	private String buyData;
	private String buyState;

	public DealJiLu(String mouthName, String rotateTo, String rotateToPrice,
			String todayData, String rotateToState, String rotateOut,
			String rotateOutPrice, String rotateOutData, String rotateOutState,
			String buy, String buyPrice, String buyData, String buyState) {
		super();
		this.mouthName = mouthName;
		this.rotateTo = rotateTo;
		this.rotateToPrice = rotateToPrice;
		this.todayData = todayData;
		this.rotateToState = rotateToState;
		this.rotateOut = rotateOut;
		this.rotateOutPrice = rotateOutPrice;
		this.rotateOutData = rotateOutData;
		this.rotateOutState = rotateOutState;
		this.buy = buy;
		this.buyPrice = buyPrice;
		this.buyData = buyData;
		this.buyState = buyState;
	}

	public String getMouthName() {
		return mouthName;
	}

	public void setMouthName(String mouthName) {
		this.mouthName = mouthName;
	}

	public String getRotateTo() {
		return rotateTo;
	}

	public void setRotateTo(String rotateTo) {
		this.rotateTo = rotateTo;
	}

	public String getRotateToPrice() {
		return rotateToPrice;
	}

	public void setRotateToPrice(String rotateToPrice) {
		this.rotateToPrice = rotateToPrice;
	}

	public String getTodayData() {
		return todayData;
	}

	public void setTodayData(String todayData) {
		this.todayData = todayData;
	}

	public String getRotateToState() {
		return rotateToState;
	}

	public void setRotateToState(String rotateToState) {
		this.rotateToState = rotateToState;
	}

	public String getRotateOut() {
		return rotateOut;
	}

	public void setRotateOut(String rotateOut) {
		this.rotateOut = rotateOut;
	}

	public String getRotateOutPrice() {
		return rotateOutPrice;
	}

	public void setRotateOutPrice(String rotateOutPrice) {
		this.rotateOutPrice = rotateOutPrice;
	}

	public String getRotateOutData() {
		return rotateOutData;
	}

	public void setRotateOutData(String rotateOutData) {
		this.rotateOutData = rotateOutData;
	}

	public String getRotateOutState() {
		return rotateOutState;
	}

	public void setRotateOutState(String rotateOutState) {
		this.rotateOutState = rotateOutState;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyData() {
		return buyData;
	}

	public void setBuyData(String buyData) {
		this.buyData = buyData;
	}

	public String getBuyState() {
		return buyState;
	}

	public void setBuyState(String buyState) {
		this.buyState = buyState;
	}

}
