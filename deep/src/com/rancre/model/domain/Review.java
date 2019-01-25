package com.rancre.model.domain;

import java.sql.Timestamp;

public class Review {
	private int racReviewNo;
	private int racReviewStatus;
	private int racMemberNo;
	private int racChannelNo;
	private int racChannelAdNo;
	private int racChannelCostNo;
	private int racReviewSatisfy;
	private int racReviewTargetReach;
	private int racReviewTargetConversion;
	private int racReviewTargetGender;
	private int racReviewTargetAge;
	private int racReviewRecomand;
	private int racReviewAdAgain;
	private String racReviewDetail;
	private Timestamp racReviewCreateDate;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRacReviewNo() {
		return racReviewNo;
	}
	public void setRacReviewNo(int racReviewNo) {
		this.racReviewNo = racReviewNo;
	}
	public int getRacReviewStatus() {
		return racReviewStatus;
	}
	public void setRacReviewStatus(int racReviewStatus) {
		this.racReviewStatus = racReviewStatus;
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
	public int getRacChannelAdNo() {
		return racChannelAdNo;
	}
	public void setRacChannelAdNo(int racChannelAdNo) {
		this.racChannelAdNo = racChannelAdNo;
	}
	public int getRacChannelCostNo() {
		return racChannelCostNo;
	}
	public void setRacChannelCostNo(int racChannelCostNo) {
		this.racChannelCostNo = racChannelCostNo;
	}
	public int getRacReviewSatisfy() {
		return racReviewSatisfy;
	}
	public void setRacReviewSatisfy(int racReviewSatisfy) {
		this.racReviewSatisfy = racReviewSatisfy;
	}
	public int getRacReviewTargetReach() {
		return racReviewTargetReach;
	}
	public void setRacReviewTargetReach(int racReviewTargetReach) {
		this.racReviewTargetReach = racReviewTargetReach;
	}
	public int getRacReviewTargetConversion() {
		return racReviewTargetConversion;
	}
	public void setRacReviewTargetConversion(int racReviewTargetConversion) {
		this.racReviewTargetConversion = racReviewTargetConversion;
	}
	public int getRacReviewTargetGender() {
		return racReviewTargetGender;
	}
	public void setRacReviewTargetGender(int racReviewTargetGender) {
		this.racReviewTargetGender = racReviewTargetGender;
	}
	public int getRacReviewTargetAge() {
		return racReviewTargetAge;
	}
	public void setRacReviewTargetAge(int racReviewTargetAge) {
		this.racReviewTargetAge = racReviewTargetAge;
	}
	public int getRacReviewRecomand() {
		return racReviewRecomand;
	}
	public void setRacReviewRecomand(int racReviewRecomand) {
		this.racReviewRecomand = racReviewRecomand;
	}
	public int getRacReviewAdAgain() {
		return racReviewAdAgain;
	}
	public void setRacReviewAdAgain(int racReviewAdAgain) {
		this.racReviewAdAgain = racReviewAdAgain;
	}
	public String getRacReviewDetail() {
		return racReviewDetail;
	}
	public void setRacReviewDetail(String racReviewDetail) {
		this.racReviewDetail = racReviewDetail;
	}
	public Timestamp getRacReviewCreateDate() {
		return racReviewCreateDate;
	}
	public void setRacReviewCreateDate(Timestamp racReviewCreateDate) {
		this.racReviewCreateDate = racReviewCreateDate;
	}
	public Review(int racReviewNo, int racReviewStatus, int racMemberNo, int racChannelNo, int racChannelAdNo,
			int racChannelCostNo, int racReviewSatisfy, int racReviewTargetReach, int racReviewTargetConversion,
			int racReviewTargetGender, int racReviewTargetAge, int racReviewRecomand, int racReviewAdAgain,
			String racReviewDetail, Timestamp racReviewCreateDate) {
		super();
		this.racReviewNo = racReviewNo;
		this.racReviewStatus = racReviewStatus;
		this.racMemberNo = racMemberNo;
		this.racChannelNo = racChannelNo;
		this.racChannelAdNo = racChannelAdNo;
		this.racChannelCostNo = racChannelCostNo;
		this.racReviewSatisfy = racReviewSatisfy;
		this.racReviewTargetReach = racReviewTargetReach;
		this.racReviewTargetConversion = racReviewTargetConversion;
		this.racReviewTargetGender = racReviewTargetGender;
		this.racReviewTargetAge = racReviewTargetAge;
		this.racReviewRecomand = racReviewRecomand;
		this.racReviewAdAgain = racReviewAdAgain;
		this.racReviewDetail = racReviewDetail;
		this.racReviewCreateDate = racReviewCreateDate;
	}
}
