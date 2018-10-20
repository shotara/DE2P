package com.rancre.model.domain;

import java.sql.Timestamp;

public class ChannelAd {

	private int racChannelAdNo;
	private int racChannelNo;
	private String racChannelAdUrl;
	private Timestamp rachannelAdCreateDate;
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
	public String getRacChannelAdUrl() {
		return racChannelAdUrl;
	}
	public void setRacChannelAdUrl(String racChannelAdUrl) {
		this.racChannelAdUrl = racChannelAdUrl;
	}
	public Timestamp getRachannelAdCreateDate() {
		return rachannelAdCreateDate;
	}
	public void setRachannelAdCreateDate(Timestamp rachannelAdCreateDate) {
		this.rachannelAdCreateDate = rachannelAdCreateDate;
	}
	public ChannelAd(int racChannelAdNo, int racChannelNo, String racChannelAdUrl, Timestamp rachannelAdCreateDate) {
		super();
		this.racChannelAdNo = racChannelAdNo;
		this.racChannelNo = racChannelNo;
		this.racChannelAdUrl = racChannelAdUrl;
		this.rachannelAdCreateDate = rachannelAdCreateDate;
	}
	
}
