package com.deep.model.domain;

public class Member {

	private int deepMemberNo;
	private int deepMemberStatus;
	private int deepMemberLevel;
	private String deepMemberMajor;
	private String deepMemberCareer;
	private String deepMemberEmail;
	private String deepMemberName;
	private String deepMemberPassword;
	private int deepMemberImage;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDeepMemberNo() {
		return deepMemberNo;
	}

	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}

	public int getDeepMemberStatus() {
		return deepMemberStatus;
	}

	public void setDeepMemberStatus(int deepMemberStatus) {
		this.deepMemberStatus = deepMemberStatus;
	}

	public int getDeepMemberLevel() {
		return deepMemberLevel;
	}

	public void setDeepMemberLevel(int deepMemberLevel) {
		this.deepMemberLevel = deepMemberLevel;
	}

	public String getDeepMemberMajor() {
		return deepMemberMajor;
	}

	public void setDeepMemberMajor(String deepMemberMajor) {
		this.deepMemberMajor = deepMemberMajor;
	}

	public String getDeepMemberCareer() {
		return deepMemberCareer;
	}

	public void setDeepMemberCareer(String deepMemberCareer) {
		this.deepMemberCareer = deepMemberCareer;
	}

	public String getDeepMemberEmail() {
		return deepMemberEmail;
	}

	public void setDeepMemberEmail(String deepMemberEmail) {
		this.deepMemberEmail = deepMemberEmail;
	}

	public String getDeepMemberName() {
		return deepMemberName;
	}

	public void setDeepMemberName(String deepMemberName) {
		this.deepMemberName = deepMemberName;
	}

	public String getDeepMemberPassword() {
		return deepMemberPassword;
	}

	public void setDeepMemberPassword(String deepMemberPassword) {
		this.deepMemberPassword = deepMemberPassword;
	}

	public int getDeepMemberImage() {
		return deepMemberImage;
	}

	public void setDeepMemberImage(int deepMemberImage) {
		this.deepMemberImage = deepMemberImage;
	}

	public Member(int deepMemberNo, int deepMemberStatus, int deepMemberLevel, String deepMemberMajor,
			String deepMemberCareer, String deepMemberEmail, String deepMemberName, String deepMemberPassword,
			int deepMemberImage) {
		super();
		this.deepMemberNo = deepMemberNo;
		this.deepMemberStatus = deepMemberStatus;
		this.deepMemberLevel = deepMemberLevel;
		this.deepMemberMajor = deepMemberMajor;
		this.deepMemberCareer = deepMemberCareer;
		this.deepMemberEmail = deepMemberEmail;
		this.deepMemberName = deepMemberName;
		this.deepMemberPassword = deepMemberPassword;
		this.deepMemberImage = deepMemberImage;
	}

}
