package com.rancre.model.domain;

public class ChannelLike {
	private int racMemberNo;
	private int racChannelNo;
	public ChannelLike() {
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
	public ChannelLike(int racMemberNo, int racChannelNo) {
		super();
		this.racMemberNo = racMemberNo;
		this.racChannelNo = racChannelNo;
	}
	
}
