package com.rancre.model.domain;

import java.sql.Timestamp;

public class Channel {
	private int racChannelNo;
	private int racMemberNo;
	private int racChannelStatus;
	private String racChannelCategory;
	private String racChannelTitle;
	private int racChannelFollowers;
	private long racChannelViews;
	private String racChannelUrl;
	private String racChannelThumbnail;
	private Timestamp racChannelCreateDate;
	private Timestamp racChannelUpdateDate;
	private Timestamp racChannelInsertDate;
	
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

	public String getRacChannelCategory() {
		return racChannelCategory;
	}

	public void setRacChannelCategory(String racChannelCategory) {
		this.racChannelCategory = racChannelCategory;
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

	public long getRacChannelViews() {
		return racChannelViews;
	}

	public void setRacChannelViews(long racChannelViews) {
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

	public Timestamp getRacChannelInsertDate() {
		return racChannelInsertDate;
	}

	public void setRacChannelInsertDate(Timestamp racChannelInsertDate) {
		this.racChannelInsertDate = racChannelInsertDate;
	}

	public Channel(int racChannelNo, int racMemberNo, int racChannelStatus, String racChannelCategory,
			String racChannelTitle, int racChannelFollowers, long racChannelViews, String racChannelUrl,
			String racChannelThumbnail, Timestamp racChannelCreateDate, Timestamp racChannelUpdateDate,
			Timestamp racChannelInsertDate) {
		super();
		this.racChannelNo = racChannelNo;
		this.racMemberNo = racMemberNo;
		this.racChannelStatus = racChannelStatus;
		this.racChannelCategory = racChannelCategory;
		this.racChannelTitle = racChannelTitle;
		this.racChannelFollowers = racChannelFollowers;
		this.racChannelViews = racChannelViews;
		this.racChannelUrl = racChannelUrl;
		this.racChannelThumbnail = racChannelThumbnail;
		this.racChannelCreateDate = racChannelCreateDate;
		this.racChannelUpdateDate = racChannelUpdateDate;
		this.racChannelInsertDate = racChannelInsertDate;
	}	
}
