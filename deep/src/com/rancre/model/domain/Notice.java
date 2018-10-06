package com.deep.model.domain;

public class Notice {
	private int deepNoticeNo;
	private int deepNoticeCategory;
	private int deepMemberNo;
	private int deepNoticeTarget1;
	private int deepNoticeTarget2;
	private int deepNoticeStatus;
	private int deepNoticeCreateDate;
	private int deepNoticeConfirmDate;
	private int deepNoticeDeleteDate;
	
	public int getDeepNoticeNo() {
		return deepNoticeNo;
	}

	public void setDeepNoticeNo(int deepNoticeNo) {
		this.deepNoticeNo = deepNoticeNo;
	}

	public int getDeepNoticeCategory() {
		return deepNoticeCategory;
	}

	public void setDeepNoticeCategory(int deepNoticeCategory) {
		this.deepNoticeCategory = deepNoticeCategory;
	}

	public int getDeepMemberNo() {
		return deepMemberNo;
	}

	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}

	public int getDeepNoticeTarget1() {
		return deepNoticeTarget1;
	}

	public void setDeepNoticeTarget1(int deepNoticeTarget1) {
		this.deepNoticeTarget1 = deepNoticeTarget1;
	}

	public int getDeepNoticeTarget2() {
		return deepNoticeTarget2;
	}

	public void setDeepNoticeTarget2(int deepNoticeTarget2) {
		this.deepNoticeTarget2 = deepNoticeTarget2;
	}

	public int getDeepNoticeStatus() {
		return deepNoticeStatus;
	}

	public void setDeepNoticeStatus(int deepNoticeStatus) {
		this.deepNoticeStatus = deepNoticeStatus;
	}

	public int getDeepNoticeCreateDate() {
		return deepNoticeCreateDate;
	}

	public void setDeepNoticeCreateDate(int deepNoticeCreateDate) {
		this.deepNoticeCreateDate = deepNoticeCreateDate;
	}

	public int getDeepNoticeConfirmDate() {
		return deepNoticeConfirmDate;
	}

	public void setDeepNoticeConfirmDate(int deepNoticeConfirmDate) {
		this.deepNoticeConfirmDate = deepNoticeConfirmDate;
	}

	public int getDeepNoticeDeleteDate() {
		return deepNoticeDeleteDate;
	}

	public void setDeepNoticeDeleteDate(int deepNoticeDeleteDate) {
		this.deepNoticeDeleteDate = deepNoticeDeleteDate;
	}

	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int deepNoticeNo, int deepNoticeCategory, int deepMemberNo, int deepNoticeTarget1,
			int deepNoticeTarget2, int deepNoticeStatus, int deepNoticeCreateDate, int deepNoticeConfirmDate,
			int deepNoticeDeleteDate) {
		super();
		this.deepNoticeNo = deepNoticeNo;
		this.deepNoticeCategory = deepNoticeCategory;
		this.deepMemberNo = deepMemberNo;
		this.deepNoticeTarget1 = deepNoticeTarget1;
		this.deepNoticeTarget2 = deepNoticeTarget2;
		this.deepNoticeStatus = deepNoticeStatus;
		this.deepNoticeCreateDate = deepNoticeCreateDate;
		this.deepNoticeConfirmDate = deepNoticeConfirmDate;
		this.deepNoticeDeleteDate = deepNoticeDeleteDate;
	}

}
