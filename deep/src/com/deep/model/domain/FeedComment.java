package com.deep.model.domain;

public class FeedComment {

	private int deepFeedCommentNo;
	private int deepFeedNo;
	private int deepMemberNo;
	private int deepFeedCommentStatus;
	private int deepFeedParentCommentNo; 		
	private int deepFeedCommentDepth;
	private int deepFeedCommentNotify;
	private long deepFeedCommentCreateDate;
	private String deepFeedCommentContent;
	public FeedComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepFeedCommentNo() {
		return deepFeedCommentNo;
	}
	public void setDeepFeedCommentNo(int deepFeedCommentNo) {
		this.deepFeedCommentNo = deepFeedCommentNo;
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
	public int getDeepFeedCommentStatus() {
		return deepFeedCommentStatus;
	}
	public void setDeepFeedCommentStatus(int deepFeedCommentStatus) {
		this.deepFeedCommentStatus = deepFeedCommentStatus;
	}
	public int getDeepFeedParentCommentNo() {
		return deepFeedParentCommentNo;
	}
	public void setDeepFeedParentCommentNo(int deepFeedParentCommentNo) {
		this.deepFeedParentCommentNo = deepFeedParentCommentNo;
	}
	public int getDeepFeedCommentDepth() {
		return deepFeedCommentDepth;
	}
	public void setDeepFeedCommentDepth(int deepFeedCommentDepth) {
		this.deepFeedCommentDepth = deepFeedCommentDepth;
	}
	public int getDeepFeedCommentNotify() {
		return deepFeedCommentNotify;
	}
	public void setDeepFeedCommentNotify(int deepFeedCommentNotify) {
		this.deepFeedCommentNotify = deepFeedCommentNotify;
	}
	public long getDeepFeedCommentCreateDate() {
		return deepFeedCommentCreateDate;
	}
	public void setDeepFeedCommentCreateDate(long deepFeedCommentCreateDate) {
		this.deepFeedCommentCreateDate = deepFeedCommentCreateDate;
	}
	public String getDeepFeedCommentContent() {
		return deepFeedCommentContent;
	}
	public void setDeepFeedCommentContent(String deepFeedCommentContent) {
		this.deepFeedCommentContent = deepFeedCommentContent;
	}
	public FeedComment(int deepFeedCommentNo, int deepFeedNo, int deepMemberNo, int deepFeedCommentStatus,
			int deepFeedParentCommentNo, int deepFeedCommentDepth, int deepFeedCommentNotify,
			long deepFeedCommentCreateDate, String deepFeedCommentContent) {
		super();
		this.deepFeedCommentNo = deepFeedCommentNo;
		this.deepFeedNo = deepFeedNo;
		this.deepMemberNo = deepMemberNo;
		this.deepFeedCommentStatus = deepFeedCommentStatus;
		this.deepFeedParentCommentNo = deepFeedParentCommentNo;
		this.deepFeedCommentDepth = deepFeedCommentDepth;
		this.deepFeedCommentNotify = deepFeedCommentNotify;
		this.deepFeedCommentCreateDate = deepFeedCommentCreateDate;
		this.deepFeedCommentContent = deepFeedCommentContent;
	}

}
