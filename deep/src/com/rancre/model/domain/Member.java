package com.rancre.model.domain;

import java.sql.Timestamp;

public class Member {

	private int racMemberNo;
	private int racMemberStatus;
	private int racMemberType;
	private int racMemberFreeCoupon;
	private String racMemberEmail;
	private String racMemberPassword;
	private String racMemberAuthToken;
	private Timestamp racMemberCreateDate;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRacMemberNo() {
		return racMemberNo;
	}

	public void setRacMemberNo(int racMemberNo) {
		this.racMemberNo = racMemberNo;
	}

	public int getRacMemberStatus() {
		return racMemberStatus;
	}

	public void setRacMemberStatus(int racMemberStatus) {
		this.racMemberStatus = racMemberStatus;
	}

	public int getRacMemberType() {
		return racMemberType;
	}

	public void setRacMemberType(int racMemberType) {
		this.racMemberType = racMemberType;
	}

	public int getRacMemberFreeCoupon() {
		return racMemberFreeCoupon;
	}

	public void setRacMemberFreeCoupon(int racMemberFreeCoupon) {
		this.racMemberFreeCoupon = racMemberFreeCoupon;
	}

	public String getRacMemberEmail() {
		return racMemberEmail;
	}

	public void setRacMemberEmail(String racMemberEmail) {
		this.racMemberEmail = racMemberEmail;
	}

	public String getRacMemberPassword() {
		return racMemberPassword;
	}

	public void setRacMemberPassword(String racMemberPassword) {
		this.racMemberPassword = racMemberPassword;
	}

	public String getRacMemberAuthToken() {
		return racMemberAuthToken;
	}

	public void setRacMemberAuthToken(String racMemberAuthToken) {
		this.racMemberAuthToken = racMemberAuthToken;
	}

	public Timestamp getRacMemberCreateDate() {
		return racMemberCreateDate;
	}

	public void setRacMemberCreateDate(Timestamp racMemberCreateDate) {
		this.racMemberCreateDate = racMemberCreateDate;
	}

	public Member(int racMemberNo, int racMemberStatus, int racMemberType, int racMemberFreeCoupon,
			String racMemberEmail, String racMemberPassword, String racMemberAuthToken, Timestamp racMemberCreateDate) {
		super();
		this.racMemberNo = racMemberNo;
		this.racMemberStatus = racMemberStatus;
		this.racMemberType = racMemberType;
		this.racMemberFreeCoupon = racMemberFreeCoupon;
		this.racMemberEmail = racMemberEmail;
		this.racMemberPassword = racMemberPassword;
		this.racMemberAuthToken = racMemberAuthToken;
		this.racMemberCreateDate = racMemberCreateDate;
	}
	

}
