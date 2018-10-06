package com.rancre.model.domain;

public class FeedCount {

	private int deepLikeCount;
	private int deepCommentCount;
	private int deepShareCount;
	public FeedCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepLikeCount() {
		return deepLikeCount;
	}
	public void setDeepLikeCount(int deepLikeCount) {
		this.deepLikeCount = deepLikeCount;
	}
	public int getDeepCommentCount() {
		return deepCommentCount;
	}
	public void setDeepCommentCount(int deepCommentCount) {
		this.deepCommentCount = deepCommentCount;
	}
	public int getDeepShareCount() {
		return deepShareCount;
	}
	public void setDeepShareCount(int deepShareCount) {
		this.deepShareCount = deepShareCount;
	}
	public FeedCount(int deepLikeCount, int deepCommentCount, int deepShareCount) {
		super();
		this.deepLikeCount = deepLikeCount;
		this.deepCommentCount = deepCommentCount;
		this.deepShareCount = deepShareCount;
	}
}
