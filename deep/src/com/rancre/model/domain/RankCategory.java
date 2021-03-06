package com.rancre.model.domain;

import java.sql.Timestamp;

public class RankCategory {

	private int racRankCategoryNo;
	private int racChannelNo;
	private int racCategoryNo;
	private String racChannelCategory;
	private int racRankCategoryRanking;
	private String racChannelTitle;
	private int racChannelFollowers;
	private long racChannelViews;
	private int racChannelVideoCount;
	private String racChannelUrl;
	private String racChannelThumbnail;
	private Timestamp racChannelInsertDate;
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
	public String getRacChannelCategory() {
		return racChannelCategory;
	}
	public void setRacChannelCategory(String racChannelCategory) {
		this.racChannelCategory = racChannelCategory;
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
	public long getRacChannelViews() {
		return racChannelViews;
	}
	public void setRacChannelViews(long racChannelViews) {
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
	public RankCategory(int racRankCategoryNo, int racChannelNo, int racCategoryNo, String racChannelCategory,
			int racRankCategoryRanking, String racChannelTitle, int racChannelFollowers, long racChannelViews,
			int racChannelVideoCount, String racChannelUrl, String racChannelThumbnail,
			Timestamp racChannelInsertDate) {
		super();
		this.racRankCategoryNo = racRankCategoryNo;
		this.racChannelNo = racChannelNo;
		this.racCategoryNo = racCategoryNo;
		this.racChannelCategory = racChannelCategory;
		this.racRankCategoryRanking = racRankCategoryRanking;
		this.racChannelTitle = racChannelTitle;
		this.racChannelFollowers = racChannelFollowers;
		this.racChannelViews = racChannelViews;
		this.racChannelVideoCount = racChannelVideoCount;
		this.racChannelUrl = racChannelUrl;
		this.racChannelThumbnail = racChannelThumbnail;
		this.racChannelInsertDate = racChannelInsertDate;
	}


}
