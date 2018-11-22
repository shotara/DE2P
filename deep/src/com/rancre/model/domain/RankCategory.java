package com.rancre.model.domain;

public class RankCategory {

	private int racRankCategoryNo;
	private int racChannelNo;
	private int racCategoryNo;
	private int racRankCategoryRanking;
	private String racChannelTitle;
	private int racChannelFollowers;
	private int racChannelViews;
	private int racChannelVideoCount;
	private String racChannelUrl;
	private String racChannelThumbnail;
	public RankCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacRankCategoryNo() {
		return racRankCategoryNo;
	}
	public void setRacRankCategoryNo(int racRankCategoryNo) {
		this.racRankCategoryNo = racRankCategoryNo;
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
	public int getRacRankCategoryRanking() {
		return racRankCategoryRanking;
	}
	public void setRacRankCategoryRanking(int racRankCategoryRanking) {
		this.racRankCategoryRanking = racRankCategoryRanking;
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
	public RankCategory(int racRankCategoryNo, int racChannelNo, int racCategoryNo, int racRankCategoryRanking,
			String racChannelTitle, int racChannelFollowers, int racChannelViews, int racChannelVideoCount,
			String racChannelUrl, String racChannelThumbnail) {
		super();
		this.racRankCategoryNo = racRankCategoryNo;
		this.racChannelNo = racChannelNo;
		this.racCategoryNo = racCategoryNo;
		this.racRankCategoryRanking = racRankCategoryRanking;
		this.racChannelTitle = racChannelTitle;
		this.racChannelFollowers = racChannelFollowers;
		this.racChannelViews = racChannelViews;
		this.racChannelVideoCount = racChannelVideoCount;
		this.racChannelUrl = racChannelUrl;
		this.racChannelThumbnail = racChannelThumbnail;
	}


}
