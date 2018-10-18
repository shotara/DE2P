package com.rancre.model.domain;

public class MemberUid {

	private int racMemberNo;
	private String racMemberUid;
	public int getRacMemberNo() {
		return racMemberNo;
	}
	public void setRacMemberNo(int racMemberNo) {
		this.racMemberNo = racMemberNo;
	}
	public String getRacMemberUid() {
		return racMemberUid;
	}
	public void setRacMemberUid(String racMemberUid) {
		this.racMemberUid = racMemberUid;
	}
	public MemberUid(int racMemberNo, String racMemberUid) {
		super();
		this.racMemberNo = racMemberNo;
		this.racMemberUid = racMemberUid;
	}
	public MemberUid() {
		super();
		// TODO Auto-generated constructor stub
	}
}
