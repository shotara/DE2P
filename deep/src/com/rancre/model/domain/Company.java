package com.rancre.model.domain;

import java.sql.Timestamp;

public class Company {
 private int racCompanyNo;
 private int racMemberNo;
 private String racCompanyBusinessNo;
 private String racCompanyName;
 private int racCompanyAdCategory;
 private int racCompanyTargetAge;
 private int racCompanyTargetGender;
 private Timestamp racCompanyCreateDate;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacCompanyNo() {
		return racCompanyNo;
	}
	public void setRacCompanyNo(int racCompanyNo) {
		this.racCompanyNo = racCompanyNo;
	}
	public int getRacMemberNo() {
		return racMemberNo;
	}
	public void setRacMemberNo(int racMemberNo) {
		this.racMemberNo = racMemberNo;
	}
	public String getRacCompanyBusinessNo() {
		return racCompanyBusinessNo;
	}
	public void setRacCompanyBusinessNo(String racCompanyBusinessNo) {
		this.racCompanyBusinessNo = racCompanyBusinessNo;
	}
	public String getRacCompanyName() {
		return racCompanyName;
	}
	public void setRacCompanyName(String racCompanyName) {
		this.racCompanyName = racCompanyName;
	}
	public int getRacCompanyAdCategory() {
		return racCompanyAdCategory;
	}
	public void setRacCompanyAdCategory(int racCompanyAdCategory) {
		this.racCompanyAdCategory = racCompanyAdCategory;
	}
	public int getRacCompanyTargetAge() {
		return racCompanyTargetAge;
	}
	public void setRacCompanyTargetAge(int racCompanyTargetAge) {
		this.racCompanyTargetAge = racCompanyTargetAge;
	}
	public int getRacCompanyTargetGender() {
		return racCompanyTargetGender;
	}
	public void setRacCompanyTargetGender(int racCompanyTargetGender) {
		this.racCompanyTargetGender = racCompanyTargetGender;
	}
	public Timestamp getRacCompanyCreateDate() {
		return racCompanyCreateDate;
	}
	public void setRacCompanyCreateDate(Timestamp racCompanyCreateDate) {
		this.racCompanyCreateDate = racCompanyCreateDate;
	}
	public Company(int racCompanyNo, int racMemberNo, String racCompanyBusinessNo, String racCompanyName,
			int racCompanyAdCategory, int racCompanyTargetAge, int racCompanyTargetGender,
			Timestamp racCompanyCreateDate) {
		super();
		this.racCompanyNo = racCompanyNo;
		this.racMemberNo = racMemberNo;
		this.racCompanyBusinessNo = racCompanyBusinessNo;
		this.racCompanyName = racCompanyName;
		this.racCompanyAdCategory = racCompanyAdCategory;
		this.racCompanyTargetAge = racCompanyTargetAge;
		this.racCompanyTargetGender = racCompanyTargetGender;
		this.racCompanyCreateDate = racCompanyCreateDate;
	}

}
