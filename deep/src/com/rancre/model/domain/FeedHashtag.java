package com.rancre.model.domain;

public class FeedHashtag {
	
	private int deepFeedNo;
	private long deepFeedHashtagDate;
	private String deepFeedHashtag;
	public FeedHashtag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepFeedNo() {
		return deepFeedNo;
	}
	public void setDeepFeedNo(int deepFeedNo) {
		this.deepFeedNo = deepFeedNo;
	}
	public long getDeepFeedHashtagDate() {
		return deepFeedHashtagDate;
	}
	public void setDeepFeedHashtagDate(long deepFeedHashtagDate) {
		this.deepFeedHashtagDate = deepFeedHashtagDate;
	}
	public String getDeepFeedHashtag() {
		return deepFeedHashtag;
	}
	public void setDeepFeedHashtag(String deepFeedHashtag) {
		this.deepFeedHashtag = deepFeedHashtag;
	}
	public FeedHashtag(int deepFeedNo, long deepFeedHashtagDate, String deepFeedHashtag) {
		super();
		this.deepFeedNo = deepFeedNo;
		this.deepFeedHashtagDate = deepFeedHashtagDate;
		this.deepFeedHashtag = deepFeedHashtag;
	}
}
