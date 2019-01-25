package com.rancre.model.domain;

import java.sql.Timestamp;

public class ChannelView {
	private int racMemberNo;
	private int racChannelNo;
	private Timestamp racChannelViewDate;
	public ChannelView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacMemberNo() {
		return racMemberNo;
	}
	public void setRacMemberNo(int racMemberNo) {
		this.racMemberNo = racMemberNo;
	}
	public int getRacChannelNo() {
		return racChannelNo;
	}
	public void setRacChannelNo(int racChannelNo) {
		this.racChannelNo = racChannelNo;
	}
	public Timestamp getRacChannelViewDate() {
		return racChannelViewDate;
	}
	public void setRacChannelViewDate(Timestamp racChannelViewDate) {
		this.racChannelViewDate = racChannelViewDate;
	}
	public ChannelView(int racMemberNo, int racChannelNo, Timestamp racChannelViewDate) {
		super();
		this.racMemberNo = racMemberNo;
		this.racChannelNo = racChannelNo;
		this.racChannelViewDate = racChannelViewDate;
	}
}
