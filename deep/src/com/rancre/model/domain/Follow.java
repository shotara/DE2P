package com.rancre.model.domain;

public class Follow {
	
	private int deepFollowing;
	private int deepFollower;
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepFollowing() {
		return deepFollowing;
	}
	public void setDeepFollowing(int deepFollowing) {
		this.deepFollowing = deepFollowing;
	}
	public int getDeepFollower() {
		return deepFollower;
	}
	public void setDeepFollower(int deepFollower) {
		this.deepFollower = deepFollower;
	}
	public Follow(int deepFollowing, int deepFollower) {
		super();
		this.deepFollowing = deepFollowing;
		this.deepFollower = deepFollower;
	}
}
