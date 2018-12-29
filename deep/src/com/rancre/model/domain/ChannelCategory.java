package com.rancre.model.domain;

public class ChannelCategory {

	private int racChannelNo;
	private int racCategoryNo;
	public ChannelCategory() {
		super();
		// TODO Auto-generated constructor stub
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
	public ChannelCategory(int racChannelNo, int racCategoryNo) {
		super();
		this.racChannelNo = racChannelNo;
		this.racCategoryNo = racCategoryNo;
	}
	
}
