package com.deep.model.domain;

public class FeedList {
	
	private int deepFeedNo;
	private int deepMemberNo;
	private int deepCategoryNo;
	private int deepFeedStatus;
	private int deepFeedType;
	private long deepFeedCreateDate;
	private String deepFeedTitle;
	private String deepFeedImages;
	private String deepFeedContent;
	private int deepFeedLikeCount;
	private int deepFeedCommentCount;
	private int deepFeedShareCount;
	public FeedList() {
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
	public String getDeepFeedTitle() {
		return deepFeedTitle;
	}
	public void setDeepFeedTitle(String deepFeedTitle) {
		this.deepFeedTitle = deepFeedTitle;
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
	public int getDeepFeedLikeCount() {
		return deepFeedLikeCount;
	}
	public void setDeepFeedLikeCount(int deepFeedLikeCount) {
		this.deepFeedLikeCount = deepFeedLikeCount;
	}
	public int getDeepFeedCommentCount() {
		return deepFeedCommentCount;
	}
	public void setDeepFeedCommentCount(int deepFeedCommentCount) {
		this.deepFeedCommentCount = deepFeedCommentCount;
	}
	public int getDeepFeedShareCount() {
		return deepFeedShareCount;
	}
	public void setDeepFeedShareCount(int deepFeedShareCount) {
		this.deepFeedShareCount = deepFeedShareCount;
	}
	public FeedList(int deepFeedNo, int deepMemberNo, int deepCategoryNo, int deepFeedStatus, int deepFeedType,
			long deepFeedCreateDate, String deepFeedTitle, String deepMemberName, String deepFeedImages,
			String deepFeedContent, int deepFeedLikeCount, int deepFeedCommentCount, int deepFeedShareCount) {
		super();
		this.deepFeedNo = deepFeedNo;
		this.deepMemberNo = deepMemberNo;
		this.deepCategoryNo = deepCategoryNo;
		this.deepFeedStatus = deepFeedStatus;
		this.deepFeedType = deepFeedType;
		this.deepFeedCreateDate = deepFeedCreateDate;
		this.deepFeedTitle = deepFeedTitle;
		this.deepFeedImages = deepFeedImages;
		this.deepFeedContent = deepFeedContent;
		this.deepFeedLikeCount = deepFeedLikeCount;
		this.deepFeedCommentCount = deepFeedCommentCount;
		this.deepFeedShareCount = deepFeedShareCount;
	}
	
}
