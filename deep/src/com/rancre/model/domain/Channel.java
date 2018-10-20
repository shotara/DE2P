package com.rancre.model.domain;

import java.sql.Timestamp;

public class Channel {
	private int racChannelNo;
	private int racMemberNo;
	private int racChannelStatus;
	private int racCategoryNo;
	private String racChannelTitle;
	private int racChannelFollowers;
	private int racChannelViews;
	private String racChannelUrl;
	private String racChannelThumbnail;
	private Timestamp racChannelCreateDate;
	private Timestamp racChannelUpdateDate;
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacChannelNo() {
		return racChannelNo;
	}
	public void setRacChannelNo(int racChannelNo) {
		this.racChannelNo = racChannelNo;
	}
	public int getRacMemberNo() {
		return racMemberNo;
	}
	public void setRacMemberNo(int racMemberNo) {
		this.racMemberNo = racMemberNo;
	}
	public int getRacChannelStatus() {
		return racChannelStatus;
	}
	public void setRacChannelStatus(int racChannelStatus) {
		this.racChannelStatus = racChannelStatus;
	}
	public int getRacCategoryNo() {
		return racCategoryNo;
	}
	public void setRacCategoryNo(int racCategoryNo) {
		this.racCategoryNo = racCategoryNo;
	}
	public String getRacChannelTitle() {
		return racChannelTitle;
	}
	public void setRacChannelTitle(String racChannelTitle) {
		this.racChannelTitle = racChannelTitle;
	}
	public int getRacChannelFollowers() {
		return racChannelFollowers;
	}
	public void setRacChannelFollowers(int racChannelFollowers) {
		this.racChannelFollowers = racChannelFollowers;
	}
	public int getRacChannelViews() {
		return racChannelViews;
	}
	public void setRacChannelViews(int racChannelViews) {
		this.racChannelViews = racChannelViews;
	}
	public String getRacChannelUrl() {
		return racChannelUrl;
	}
	public void setRacChannelUrl(String racChannelUrl) {
		this.racChannelUrl = racChannelUrl;
	}
	public String getRacChannelThumbnail() {
		return racChannelThumbnail;
	}
	public void setRacChannelThumbnail(String racChannelThumbnail) {
		this.racChannelThumbnail = racChannelThumbnail;
	}
	public Timestamp getRacChannelCreateDate() {
		return racChannelCreateDate;
	}
	public void setRacChannelCreateDate(Timestamp racChannelCreateDate) {
		this.racChannelCreateDate = racChannelCreateDate;
	}
	public Timestamp getRacChannelUpdateDate() {
		return racChannelUpdateDate;
	}
	public void setRacChannelUpdateDate(Timestamp racChannelUpdateDate) {
		this.racChannelUpdateDate = racChannelUpdateDate;
	}
	public Channel(int racChannelNo, int racMemberNo, int racChannelStatus, int racCategoryNo,
			String racChannelTitle, int racChannelFollowers, int racChannelViews, String racChannelUrl,
			String racChannelThumbnail, Timestamp racChannelCreateDate, Timestamp racChannelUpdateDate) {
		super();
		this.racChannelNo = racChannelNo;
		this.racMemberNo = racMemberNo;
		this.racChannelStatus = racChannelStatus;
		this.racCategoryNo = racCategoryNo;
		this.racChannelTitle = racChannelTitle;
		this.racChannelFollowers = racChannelFollowers;
		this.racChannelViews = racChannelViews;
		this.racChannelUrl = racChannelUrl;
		this.racChannelThumbnail = racChannelThumbnail;
		this.racChannelCreateDate = racChannelCreateDate;
		this.racChannelUpdateDate = racChannelUpdateDate;
	}
	
}
