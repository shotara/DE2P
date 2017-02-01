package com.deep.model.domain;

public class MemberUid {

	private int deepMemberNo;
	private String deepMemberUid;

	public MemberUid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDeepMemberNo() {
		return deepMemberNo;
	}

	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}

	public String getDeepMemberUid() {
		return deepMemberUid;
	}

	public void setDeepMemberUid(String deepMemberUid) {
		this.deepMemberUid = deepMemberUid;
	}

	public MemberUid(int deepMemberNo, String deepMemberUid) {
		super();
		this.deepMemberNo = deepMemberNo;
		this.deepMemberUid = deepMemberUid;
	}

}
