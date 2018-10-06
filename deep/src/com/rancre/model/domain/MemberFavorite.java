package com.rancre.model.domain;

public class MemberFavorite {

	private int deepMemberNo;
	private int deepCategoryNo;
	public MemberFavorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepMemberNo() {
		return deepMemberNo;
	}
	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}
	public int getDeepCategoryNo() {
		return deepCategoryNo;
	}
	public void setDeepCategoryNo(int deepCategoryNo) {
		this.deepCategoryNo = deepCategoryNo;
	}
	public MemberFavorite(int deepMemberNo, int deepCategoryNo) {
		super();
		this.deepMemberNo = deepMemberNo;
		this.deepCategoryNo = deepCategoryNo;
	}
}
