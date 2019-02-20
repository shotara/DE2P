package com.rancre.model.domain;

import java.sql.Timestamp;

public class ChannelCost {
	
	private int racChannelCostNo;
	private int racChannelNo;
	private int racChannelAdType;
	private int racChannelCostPrice;
	private Timestamp racChannelCostCreateDate;
	public ChannelCost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacChannelCostNo() {
		return racChannelCostNo;
	}
	public void setRacChannelCostNo(int racChannelCostNo) {
		this.racChannelCostNo = racChannelCostNo;
	}
	public int getRacChannelNo() {
		return racChannelNo;
	}
	public void setRacChannelNo(int racChannelNo) {
		this.racChannelNo = racChannelNo;
	}
	public int getRacChannelAdType() {
		return racChannelAdType;
	}
	public void setRacChannelAdType(int racChannelAdType) {
		this.racChannelAdType = racChannelAdType;
	}
	public int getRacChannelCostPrice() {
		return racChannelCostPrice;
	}
	public void setRacChannelCostPrice(int racChannelCostPrice) {
		this.racChannelCostPrice = racChannelCostPrice;
	}
	public Timestamp getRacChannelCostCreateDate() {
		return racChannelCostCreateDate;
	}
	public void setRacChannelCostCreateDate(Timestamp racChannelCostCreateDate) {
		this.racChannelCostCreateDate = racChannelCostCreateDate;
	}
	public ChannelCost(int racChannelCostNo, int racChannelNo, int racChannelAdType, int racChannelCostPrice,
			Timestamp racChannelCostCreateDate) {
		super();
		this.racChannelCostNo = racChannelCostNo;
		this.racChannelNo = racChannelNo;
		this.racChannelAdType = racChannelAdType;
		this.racChannelCostPrice = racChannelCostPrice;
		this.racChannelCostCreateDate = racChannelCostCreateDate;
	}

}
