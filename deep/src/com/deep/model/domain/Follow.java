package com.deep.model.domain;

public class Follow {
	private int deepFollowing;
	private int deepFollower;
	
	public Follow() {
		super();
	}
	
	public int getdeepFollowing()
	{
		return deepFollowing;
	}
	
	public void setdeepFollowing(int deepFollowing)
	{
		this.deepFollowing = deepFollowing;
	}
	
	public int getdeepFollower()
	{
		return deepFollower;
	}
	
	public void setdeepFollower(int deepFollower)
	{
		this.deepFollower = deepFollower;
	}
	
	public Follow(int deepFollowing, int deepFollower)
	{
		super();
		this.deepFollowing = deepFollowing;
		this.deepFollower = deepFollower;
	}

}
