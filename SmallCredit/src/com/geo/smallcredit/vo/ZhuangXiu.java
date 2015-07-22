package com.geo.smallcredit.vo;

public class ZhuangXiu {
	private int img;
	private String name;

	public ZhuangXiu(int img, String name) {
		super();
		this.img = img;
		this.name = name;
	}

	public ZhuangXiu() {
		super();
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
