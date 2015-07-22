package com.geo.smallcredit.vo;


public class UserScore {

	private String status;

	private String desc;

	private String score;

	private String level;

	private String companyName;

	private String userId;

	private String updateDate;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public UserScore() {
		super();
	}

	public UserScore(String status, String desc, String score, String level,
			String companyName, String userId, String updateDate) {
		super();
		this.status = status;
		this.desc = desc;
		this.score = score;
		this.level = level;
		this.companyName = companyName;
		this.userId = userId;
		this.updateDate = updateDate;
	}
	
	
}
