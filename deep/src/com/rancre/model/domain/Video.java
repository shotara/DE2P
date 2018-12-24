package com.rancre.model.domain;

import java.sql.Timestamp;

public class Video {
	private int racVideoNo;
	private int racChannelNo;
	private String racVideoId;
	private String racVideoTitle;
	private long racVideoViews;
	private String racVideoThumbnail;
	private String racVideoCreateDate;
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
	public String getRacVideoThumbnail() {
		return racVideoThumbnail;
	}
	public void setRacVideoThumbnail(String racVideoThumbnail) {
		this.racVideoThumbnail = racVideoThumbnail;
	}
	public String getRacVideoCreateDate() {
		return racVideoCreateDate;
	}
	public void setRacVideoCreateDate(String racVideoCreateDate) {
		this.racVideoCreateDate = racVideoCreateDate;
	}
	public Timestamp getRacVideoUpdateDate() {
		return racVideoUpdateDate;
	}
	public void setRacVideoUpdateDate(Timestamp racVideoUpdateDate) {
		this.racVideoUpdateDate = racVideoUpdateDate;
	}
	public Video(int racVideoNo, int racChannelNo, String racVideoId, String racVideoTitle, long racVideoViews,
			String racVideoThumbnail, String racVideoCreateDate, Timestamp racVideoUpdateDate) {
		super();
		this.racVideoNo = racVideoNo;
		this.racChannelNo = racChannelNo;
		this.racVideoId = racVideoId;
		this.racVideoTitle = racVideoTitle;
		this.racVideoViews = racVideoViews;
		this.racVideoThumbnail = racVideoThumbnail;
		this.racVideoCreateDate = racVideoCreateDate;
		this.racVideoUpdateDate = racVideoUpdateDate;
	}
	
}
