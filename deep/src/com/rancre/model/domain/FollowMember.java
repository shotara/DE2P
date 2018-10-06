package com.deep.model.domain;

public class FollowMember {
	
	private int deepMemberNo;
	private String deepMemberName;
	private String deepMemberImage;
	private String deepMemberUid;
	public FollowMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepMemberNo() {
		return deepMemberNo;
	}
	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}
	public String getDeepMemberName() {
		return deepMemberName;
	}
	public void setDeepMemberName(String deepMemberName) {
		this.deepMemberName = deepMemberName;
	}
	public String getDeepMemberImage() {
		return deepMemberImage;
	}
	public void setDeepMemberImage(String deepMemberImage) {
		this.deepMemberImage = deepMemberImage;
	}
	public String getDeepMemberUid() {
		return deepMemberUid;
	}
	public void setDeepMemberUid(String deepMemberUid) {
		this.deepMemberUid = deepMemberUid;
	}
	public FollowMember(int deepMemberNo, String deepMemberName, String deepMemberImage, String deepMemberUid) {
		super();
		this.deepMemberNo = deepMemberNo;
		this.deepMemberName = deepMemberName;
		this.deepMemberImage = deepMemberImage;
		this.deepMemberUid = deepMemberUid;
	}
}
