package com.rancre.model.domain;

public class Feed {

	private int deepFeedNo;
	private int deepMemberNo;
	private int deepCategoryNo;
	private int deepFeedStatus;
	private int deepFeedType;
	private long deepFeedCreateDate;
	private long deepFeedUpdateDate;
	private String deepFeedTitle;
	private String deepMemberName;
	private String deepFeedImages;
	private String deepFeedContent;
	public Feed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepFeedNo() {
		return deepFeedNo;
	}
	public void setDeepFeedNo(int deepFeedNo) {
		this.deepFeedNo = deepFeedNo;
	}
	public int getDeepMemberNo() {
		return deepMemberNo;
	}
	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}
	public int getDeepCategoryNo() {
		return deepCategoryNo;
	}
	public void setDeepCategoryNo(int deepCategoryNo) {
		this.deepCategoryNo = deepCategoryNo;
	}
	public int getDeepFeedStatus() {
		return deepFeedStatus;
	}
	public void setDeepFeedStatus(int deepFeedStatus) {
		this.deepFeedStatus = deepFeedStatus;
	}
	public int getDeepFeedType() {
		return deepFeedType;
	}
	public void setDeepFeedType(int deepFeedType) {
		this.deepFeedType = deepFeedType;
	}
	public long getDeepFeedCreateDate() {
		return deepFeedCreateDate;
	}
	public void setDeepFeedCreateDate(long deepFeedCreateDate) {
		this.deepFeedCreateDate = deepFeedCreateDate;
	}
	public long getDeepFeedUpdateDate() {
		return deepFeedUpdateDate;
	}
	public void setDeepFeedUpdateDate(long deepFeedUpdateDate) {
		this.deepFeedUpdateDate = deepFeedUpdateDate;
	}
	public String getDeepFeedTitle() {
		return deepFeedTitle;
	}
	public void setDeepFeedTitle(String deepFeedTitle) {
		this.deepFeedTitle = deepFeedTitle;
	}
	public String getDeepMemberName() {
		return deepMemberName;
	}
	public void setDeepMemberName(String deepMemberName) {
		this.deepMemberName = deepMemberName;
	}
	public String getDeepFeedImages() {
		return deepFeedImages;
	}
	public void setDeepFeedImages(String deepFeedImages) {
		this.deepFeedImages = deepFeedImages;
	}
	public String getDeepFeedContent() {
		return deepFeedContent;
	}
	public void setDeepFeedContent(String deepFeedContent) {
		this.deepFeedContent = deepFeedContent;
	}
	public Feed(int deepFeedNo, int deepMemberNo, int deepCategoryNo, int deepFeedStatus, int deepFeedType,
			long deepFeedCreateDate, long deepFeedUpdateDate, String deepFeedTitle, String deepMemberName,
			String deepFeedImages, String deepFeedContent) {
		super();
		this.deepFeedNo = deepFeedNo;
		this.deepMemberNo = deepMemberNo;
		this.deepCategoryNo = deepCategoryNo;
		this.deepFeedStatus = deepFeedStatus;
		this.deepFeedType = deepFeedType;
		this.deepFeedCreateDate = deepFeedCreateDate;
		this.deepFeedUpdateDate = deepFeedUpdateDate;
		this.deepFeedTitle = deepFeedTitle;
		this.deepMemberName = deepMemberName;
		this.deepFeedImages = deepFeedImages;
		this.deepFeedContent = deepFeedContent;
	}

}
