package com.rancre.model.domain;

import java.sql.Timestamp;

public class Video {
	private String racVideoUrl;
	private String racVideoThumbnail;
	private long racVideoView;
	private String racVideoTitle;
	private Timestamp racVideoCreateDate;
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRacVideoUrl() {
		return racVideoUrl;
	}
	public void setRacVideoUrl(String racVideoUrl) {
		this.racVideoUrl = racVideoUrl;
	}
	public String getRacVideoThumbnail() {
		return racVideoThumbnail;
	}
	public void setRacVideoThumbnail(String racVideoThumbnail) {
		this.racVideoThumbnail = racVideoThumbnail;
	}
	public long getRacVideoView() {
		return racVideoView;
	}
	public void setRacVideoView(long racVideoView) {
		this.racVideoView = racVideoView;
	}
	public String getRacVideoTitle() {
		return racVideoTitle;
	}
	public void setRacVideoTitle(String racVideoTitle) {
		this.racVideoTitle = racVideoTitle;
	}
	public Timestamp getRacVideoCreateDate() {
		return racVideoCreateDate;
	}
	public void setRacVideoCreateDate(Timestamp racVideoCreateDate) {
		this.racVideoCreateDate = racVideoCreateDate;
	}
	public Video(String racVideoUrl, String racVideoThumbnail, long racVideoView, String racVideoTitle,
			Timestamp racVideoCreateDate) {
		super();
		this.racVideoUrl = racVideoUrl;
		this.racVideoThumbnail = racVideoThumbnail;
		this.racVideoView = racVideoView;
		this.racVideoTitle = racVideoTitle;
		this.racVideoCreateDate = racVideoCreateDate;
	}
}
