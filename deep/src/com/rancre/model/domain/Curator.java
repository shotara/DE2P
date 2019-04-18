package com.rancre.model.domain;

import java.sql.Timestamp;

public class Curator {

	private int racCuratorNo;
	private int racMemberNo;
	private int racChannelNo;
	private String racCuratorContent;
	private Timestamp racCuratorCreateDate;
	public Curator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacCuratorNo() {
		return racCuratorNo;
	}
	public void setRacCuratorNo(int racCuratorNo) {
		this.racCuratorNo = racCuratorNo;
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
	public String getRacCuratorContent() {
		return racCuratorContent;
	}
	public void setRacCuratorContent(String racCuratorContent) {
		this.racCuratorContent = racCuratorContent;
	}
	public Timestamp getRacCuratorCreateDate() {
		return racCuratorCreateDate;
	}
	public void setRacCuratorCreateDate(Timestamp racCuratorCreateDate) {
		this.racCuratorCreateDate = racCuratorCreateDate;
	}
	public Curator(int racCuratorNo, int racMemberNo, int racChannelNo, String racCuratorContent,
			Timestamp racCuratorCreateDate) {
		super();
		this.racCuratorNo = racCuratorNo;
		this.racMemberNo = racMemberNo;
		this.racChannelNo = racChannelNo;
		this.racCuratorContent = racCuratorContent;
		this.racCuratorCreateDate = racCuratorCreateDate;
	}
	
	
}
