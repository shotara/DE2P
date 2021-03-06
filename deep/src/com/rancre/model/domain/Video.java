package com.rancre.model.domain;

import java.sql.Timestamp;

public class Video {
	private int racVideoNo;
	private int racChannelNo;
	private int racVideoStatus;
	private String racVideoId;
	private String racVideoTitle;
	private long racVideoViews;
	private int racVideoLikeCount;
	private int racVideoDisLikeCount;
	private int racVideoCommentCount;
	private String racVideoThumbnail;
	private Timestamp racVideoCreateDate;
	private Timestamp racVideoUpdateDate;
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacVideoNo() {
		return racVideoNo;
	}
	public void setRacVideoNo(int racVideoNo) {
		this.racVideoNo = racVideoNo;
	}
	public int getRacChannelNo() {
		return racChannelNo;
	}
	public void setRacChannelNo(int racChannelNo) {
		this.racChannelNo = racChannelNo;
	}
	public int getRacVideoStatus() {
		return racVideoStatus;
	}
	public void setRacVideoStatus(int racVideoStatus) {
		this.racVideoStatus = racVideoStatus;
	}
	public String getRacVideoId() {
		return racVideoId;
	}
	public void setRacVideoId(String racVideoId) {
		this.racVideoId = racVideoId;
	}
	public String getRacVideoTitle() {
		return racVideoTitle;
	}
	public void setRacVideoTitle(String racVideoTitle) {
		this.racVideoTitle = racVideoTitle;
	}
	public long getRacVideoViews() {
		return racVideoViews;
	}
	public void setRacVideoViews(long racVideoViews) {
		this.racVideoViews = racVideoViews;
	}
	public int getRacVideoLikeCount() {
		return racVideoLikeCount;
	}
	public void setRacVideoLikeCount(int racVideoLikeCount) {
		this.racVideoLikeCount = racVideoLikeCount;
	}
	public int getRacVideoDisLikeCount() {
		return racVideoDisLikeCount;
	}
	public void setRacVideoDisLikeCount(int racVideoDisLikeCount) {
		this.racVideoDisLikeCount = racVideoDisLikeCount;
	}
	public int getRacVideoCommentCount() {
		return racVideoCommentCount;
	}
	public void setRacVideoCommentCount(int racVideoCommentCount) {
		this.racVideoCommentCount = racVideoCommentCount;
	}
	public String getRacVideoThumbnail() {
		return racVideoThumbnail;
	}
	public void setRacVideoThumbnail(String racVideoThumbnail) {
		this.racVideoThumbnail = racVideoThumbnail;
	}
	public Timestamp getRacVideoCreateDate() {
		return racVideoCreateDate;
	}
	public void setRacVideoCreateDate(Timestamp racVideoCreateDate) {
		this.racVideoCreateDate = racVideoCreateDate;
	}
	public Timestamp getRacVideoUpdateDate() {
		return racVideoUpdateDate;
	}
	public void setRacVideoUpdateDate(Timestamp racVideoUpdateDate) {
		this.racVideoUpdateDate = racVideoUpdateDate;
	}
	public Video(int racVideoNo, int racChannelNo, int racVideoStatus, String racVideoId, String racVideoTitle,
			long racVideoViews, int racVideoLikeCount, int racVideoDisLikeCount, int racVideoCommentCount,
			String racVideoThumbnail, Timestamp racVideoCreateDate, Timestamp racVideoUpdateDate) {
		super();
		this.racVideoNo = racVideoNo;
		this.racChannelNo = racChannelNo;
		this.racVideoStatus = racVideoStatus;
		this.racVideoId = racVideoId;
		this.racVideoTitle = racVideoTitle;
		this.racVideoViews = racVideoViews;
		this.racVideoLikeCount = racVideoLikeCount;
		this.racVideoDisLikeCount = racVideoDisLikeCount;
		this.racVideoCommentCount = racVideoCommentCount;
		this.racVideoThumbnail = racVideoThumbnail;
		this.racVideoCreateDate = racVideoCreateDate;
		this.racVideoUpdateDate = racVideoUpdateDate;
	}

	
}
