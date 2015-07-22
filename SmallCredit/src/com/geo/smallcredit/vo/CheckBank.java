package com.geo.smallcredit.vo;

public class CheckBank {
  private String bankName;
  private String isSupport;
  private String desc;
  private String cardName;
  private String cardType;
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getIsSupport() {
	return isSupport;
}
public void setIsSupport(String isSupport) {
	this.isSupport = isSupport;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getCardName() {
	return cardName;
}
public void setCardName(String cardName) {
	this.cardName = cardName;
}
public String getCardType() {
	return cardType;
}
public void setCardType(String cardType) {
	this.cardType = cardType;
}
public CheckBank(String bankName, String isSupport, String desc,
		String cardName, String cardType) {
	super();
	this.bankName = bankName;
	this.isSupport = isSupport;
	this.desc = desc;
	this.cardName = cardName;
	this.cardType = cardType;
}
public CheckBank() {
	super();
}
  
}
