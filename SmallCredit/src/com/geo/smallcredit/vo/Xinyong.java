package com.geo.smallcredit.vo;

public class Xinyong {
	private String img;
	private String name;
	private String chaxun;
	private String you;

	public Xinyong(String img, String name, String chaxun, String you) {
		super();
		this.img = img;
		this.name = name;
		this.chaxun = chaxun;
		this.you = you;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChaxun() {
		return chaxun;
	}

	public void setChaxun(String chaxun) {
		this.chaxun = chaxun;
	}

	public String getYou() {
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() {
		return "Xinyong [img=" + img + ", name=" + name + ", chaxun=" + chaxun
				+ ", you=" + you + "]";
	}

}
