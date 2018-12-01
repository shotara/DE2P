package com.rancre.model.domain;

import java.sql.Timestamp;

public class RankTop {

	private int racRankTopNo;
	private int racChannelNo;
	private int racCategoryNo;
	private String racChannelTitle;
	private int racChannelFollowers;
	private int racChannelViews;
	private int racChannelVideoCount;
	private String racChannelUrl;
	private String racChannelThumbnail;
	private Timestamp racChannelInsertDate;
	
	public RankTop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacRankTopNo() {
		return racRankTopNo;
	}
	public void setRacRankTopNo(int racRankTopNo) {
		this.racRankTopNo = racRankTopNo;
	}
	public int getRacChannelNo() {
		return racChannelNo;
	}
	public void setRacChannelNo(int racChannelNo) {
		this.racChannelNo = racChannelNo;
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
	public int getRacChannelVideoCount() {
		return racChannelVideoCount;
	}
	public void setRacChannelVideoCount(int racChannelVideoCount) {
		this.racChannelVideoCount = racChannelVideoCount;
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
	public Timestamp getRacChannelInsertDate() {
		return racChannelInsertDate;
	}
	public void setRacChannelInsertDate(Timestamp racChannelInsertDate) {
		this.racChannelInsertDate = racChannelInsertDate;
	}
	public RankTop(int racRankTopNo, int racChannelNo, int racCategoryNo, String racChannelTitle,
			int racChannelFollowers, int racChannelViews, int racChannelVideoCount, String racChannelUrl,
			String racChannelThumbnail, Timestamp racChannelInsertDate) {
		super();
		this.racRankTopNo = racRankTopNo;
		this.racChannelNo = racChannelNo;
		this.racCategoryNo = racCategoryNo;
		this.racChannelTitle = racChannelTitle;
		this.racChannelFollowers = racChannelFollowers;
		this.racChannelViews = racChannelViews;
		this.racChannelVideoCount = racChannelVideoCount;
		this.racChannelUrl = racChannelUrl;
		this.racChannelThumbnail = racChannelThumbnail;
		this.racChannelInsertDate = racChannelInsertDate;
	}
	
}
