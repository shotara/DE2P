package com.rancre.model.domain;

import java.sql.Timestamp;

public class ChannelAd {

	private int racChannelAdNo;
	private int racChannelNo;
	private String racVideoId;
	private String racVideoTitle;
	private long racVideoViews;
	private String racVideoThumbnail;
	private int racChannelAdType;
	private int racChannelAdCategory;
	private Timestamp racVideoCreateDate;
	private Timestamp racVideoUpdateDate;
	private Timestamp racChannelAdCreateDate;
	private Timestamp racChannelAdExecuteDate;
	public ChannelAd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacChannelAdNo() {
		return racChannelAdNo;
	}
	public void setRacChannelAdNo(int racChannelAdNo) {
		this.racChannelAdNo = racChannelAdNo;
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
	public int getRacChannelAdType() {
		return racChannelAdType;
	}
	public void setRacChannelAdType(int racChannelAdType) {
		this.racChannelAdType = racChannelAdType;
	}
	public int getRacChannelAdCategory() {
		return racChannelAdCategory;
	}
	public void setRacChannelAdCategory(int racChannelAdCategory) {
		this.racChannelAdCategory = racChannelAdCategory;
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
	public Timestamp getRacChannelAdCreateDate() {
		return racChannelAdCreateDate;
	}
	public void setRacChannelAdCreateDate(Timestamp racChannelAdCreateDate) {
		this.racChannelAdCreateDate = racChannelAdCreateDate;
	}
	public Timestamp getRacChannelAdExecuteDate() {
		return racChannelAdExecuteDate;
	}
	public void setRacChannelAdExecuteDate(Timestamp racChannelAdExecuteDate) {
		this.racChannelAdExecuteDate = racChannelAdExecuteDate;
	}
	public ChannelAd(int racChannelAdNo, int racChannelNo, String racVideoId, String racVideoTitle, long racVideoViews,
			String racVideoThumbnail, int racChannelAdType, int racChannelAdCategory, Timestamp racVideoCreateDate,
			Timestamp racVideoUpdateDate, Timestamp racChannelAdCreateDate, Timestamp racChannelAdExecuteDate) {
		super();
		this.racChannelAdNo = racChannelAdNo;
		this.racChannelNo = racChannelNo;
		this.racVideoId = racVideoId;
		this.racVideoTitle = racVideoTitle;
		this.racVideoViews = racVideoViews;
		this.racVideoThumbnail = racVideoThumbnail;
		this.racChannelAdType = racChannelAdType;
		this.racChannelAdCategory = racChannelAdCategory;
		this.racVideoCreateDate = racVideoCreateDate;
		this.racVideoUpdateDate = racVideoUpdateDate;
		this.racChannelAdCreateDate = racChannelAdCreateDate;
		this.racChannelAdExecuteDate = racChannelAdExecuteDate;
	}


}
