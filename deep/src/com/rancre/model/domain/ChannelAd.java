package com.rancre.model.domain;

import java.sql.Timestamp;

public class ChannelAd {

	private int racChannelAdNo;
	private int racChannelNo;
	private int racChannelType;
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
	public int getRacChannelType() {
		return racChannelType;
	}
	public void setRacChannelType(int racChannelType) {
		this.racChannelType = racChannelType;
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
	public ChannelAd(int racChannelAdNo, int racChannelNo, int racChannelType, String racChannelAdUrl,
			Timestamp rachannelAdCreateDate) {
		super();
		this.racChannelAdNo = racChannelAdNo;
		this.racChannelNo = racChannelNo;
		this.racChannelType = racChannelType;
		this.racChannelAdUrl = racChannelAdUrl;
		this.rachannelAdCreateDate = rachannelAdCreateDate;
	}

}
