package com.deep.model.domain;

public class FeedSeries {

	private int deepFeedSeriesNo;
	private int deepFeedNo;
	private int deepMemberNo;
	private int deepFeedSeriesStatus;
	private int deepFeedSeriesId;
	private int deepFeedSeriesOrder;
	private long deepFeedSeriesCreateDate;
	private String deepFeedSeriesName;
	public FeedSeries() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepFeedSeriesNo() {
		return deepFeedSeriesNo;
	}
	public void setDeepFeedSeriesNo(int deepFeedSeriesNo) {
		this.deepFeedSeriesNo = deepFeedSeriesNo;
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
	public int getDeepFeedSeriesStatus() {
		return deepFeedSeriesStatus;
	}
	public void setDeepFeedSeriesStatus(int deepFeedSeriesStatus) {
		this.deepFeedSeriesStatus = deepFeedSeriesStatus;
	}
	public int getDeepFeedSeriesId() {
		return deepFeedSeriesId;
	}
	public void setDeepFeedSeriesId(int deepFeedSeriesId) {
		this.deepFeedSeriesId = deepFeedSeriesId;
	}
	public int getDeepFeedSeriesOrder() {
		return deepFeedSeriesOrder;
	}
	public void setDeepFeedSeriesOrder(int deepFeedSeriesOrder) {
		this.deepFeedSeriesOrder = deepFeedSeriesOrder;
	}
	public long getDeepFeedSeriesCreateDate() {
		return deepFeedSeriesCreateDate;
	}
	public void setDeepFeedSeriesCreateDate(long deepFeedSeriesCreateDate) {
		this.deepFeedSeriesCreateDate = deepFeedSeriesCreateDate;
	}
	public String getDeepFeedSeriesName() {
		return deepFeedSeriesName;
	}
	public void setDeepFeedSeriesName(String deepFeedSeriesName) {
		this.deepFeedSeriesName = deepFeedSeriesName;
	}
	public FeedSeries(int deepFeedSeriesNo, int deepFeedNo, int deepMemberNo, int deepFeedSeriesStatus,
			int deepFeedSeriesId, int deepFeedSeriesOrder, long deepFeedSeriesCreateDate, String deepFeedSeriesName) {
		super();
		this.deepFeedSeriesNo = deepFeedSeriesNo;
		this.deepFeedNo = deepFeedNo;
		this.deepMemberNo = deepMemberNo;
		this.deepFeedSeriesStatus = deepFeedSeriesStatus;
		this.deepFeedSeriesId = deepFeedSeriesId;
		this.deepFeedSeriesOrder = deepFeedSeriesOrder;
		this.deepFeedSeriesCreateDate = deepFeedSeriesCreateDate;
		this.deepFeedSeriesName = deepFeedSeriesName;
	}

}
