package com.geo.smallcredit.vo;

public class ThirdMain {
	private int img;
	private String name;
	private String info;
	private int front;

	public ThirdMain(int img, String name, String info, int front) {
		super();
		this.img = img;
		this.name = name;
		this.info = info;
		this.front = front;
	}

	public ThirdMain() {
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

}
