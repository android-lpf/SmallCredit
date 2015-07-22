package com.geo.smallcredit.vo;


public class Group {

	private String name;
	private boolean isShown;
	private int count;
	private int firstPositionInList;

	public int getFirstPositionInList() {
		return firstPositionInList;
	}

	public void setFirstPositionInList(int firstPositionInList) {
		this.firstPositionInList = firstPositionInList;
	}

	public String getName() {
		return name;
	}

	public void setName(String groupName) {
		this.name = groupName;
	}

	public boolean isShown() {
		return isShown;
	}

	public void setShown(boolean isShown) {
		this.isShown = isShown;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
