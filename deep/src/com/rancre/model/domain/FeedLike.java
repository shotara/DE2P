package com.rancre.model.domain;

public class FeedLike {

	private int deepFeedNo;
	private int deepMemberNo;
	private long deepFeedLikeDate;
	public FeedLike() {
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
	public long getDeepFeedLikeDate() {
		return deepFeedLikeDate;
	}
	public void setDeepFeedLikeDate(long deepFeedLikeDate) {
		this.deepFeedLikeDate = deepFeedLikeDate;
	}
	public FeedLike(int deepFeedNo, int deepMemberNo, long deepFeedLikeDate) {
		super();
		this.deepFeedNo = deepFeedNo;
		this.deepMemberNo = deepMemberNo;
		this.deepFeedLikeDate = deepFeedLikeDate;
	}
}
