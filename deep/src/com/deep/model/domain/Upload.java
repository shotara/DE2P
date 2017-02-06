package com.deep.model.domain;

public class Upload {

	private int deepUploadNo;
	private int deepMemberNo;
	private int deepUploadCategory;
	private int deepUploadStatus;
	private int deepUploadThumbnail;
	private long deepUploadCreateDate;
	private long deepUploadDeleteDate;
	private long deepUploadFileSize;
	private String deepUploadFileExtension;
	private String deepUploadOriginalFileName;
	private String deepUploadEncrytFileName;
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeepUploadNo() {
		return deepUploadNo;
	}
	public void setDeepUploadNo(int deepUploadNo) {
		this.deepUploadNo = deepUploadNo;
	}
	public int getDeepMemberNo() {
		return deepMemberNo;
	}
	public void setDeepMemberNo(int deepMemberNo) {
		this.deepMemberNo = deepMemberNo;
	}
	public int getDeepUploadCategory() {
		return deepUploadCategory;
	}
	public void setDeepUploadCategory(int deepUploadCategory) {
		this.deepUploadCategory = deepUploadCategory;
	}
	public int getDeepUploadStatus() {
		return deepUploadStatus;
	}
	public void setDeepUploadStatus(int deepUploadStatus) {
		this.deepUploadStatus = deepUploadStatus;
	}
	public int getDeepUploadThumbnail() {
		return deepUploadThumbnail;
	}
	public void setDeepUploadThumbnail(int deepUploadThumbnail) {
		this.deepUploadThumbnail = deepUploadThumbnail;
	}
	public long getDeepUploadCreateDate() {
		return deepUploadCreateDate;
	}
	public void setDeepUploadCreateDate(long deepUploadCreateDate) {
		this.deepUploadCreateDate = deepUploadCreateDate;
	}
	public long getDeepUploadDeleteDate() {
		return deepUploadDeleteDate;
	}
	public void setDeepUploadDeleteDate(long deepUploadDeleteDate) {
		this.deepUploadDeleteDate = deepUploadDeleteDate;
	}
	public long getDeepUploadFileSize() {
		return deepUploadFileSize;
	}
	public void setDeepUploadFileSize(long deepUploadFileSize) {
		this.deepUploadFileSize = deepUploadFileSize;
	}
	public String getDeepUploadFileExtension() {
		return deepUploadFileExtension;
	}
	public void setDeepUploadFileExtension(String deepUploadFileExtension) {
		this.deepUploadFileExtension = deepUploadFileExtension;
	}
	public String getDeepUploadOriginalFileName() {
		return deepUploadOriginalFileName;
	}
	public void setDeepUploadOriginalFileName(String deepUploadOriginalFileName) {
		this.deepUploadOriginalFileName = deepUploadOriginalFileName;
	}
	public String getDeepUploadEncrytFileName() {
		return deepUploadEncrytFileName;
	}
	public void setDeepUploadEncrytFileName(String deepUploadEncrytFileName) {
		this.deepUploadEncrytFileName = deepUploadEncrytFileName;
	}
	public Upload(int deepUploadNo, int deepMemberNo, int deepUploadCategory, int deepUploadStatus,
			int deepUploadThumbnail, long deepUploadCreateDate, long deepUploadDeleteDate, long deepUploadFileSize,
			String deepUploadFileExtension, String deepUploadOriginalFileName, String deepUploadEncrytFileName) {
		super();
		this.deepUploadNo = deepUploadNo;
		this.deepMemberNo = deepMemberNo;
		this.deepUploadCategory = deepUploadCategory;
		this.deepUploadStatus = deepUploadStatus;
		this.deepUploadThumbnail = deepUploadThumbnail;
		this.deepUploadCreateDate = deepUploadCreateDate;
		this.deepUploadDeleteDate = deepUploadDeleteDate;
		this.deepUploadFileSize = deepUploadFileSize;
		this.deepUploadFileExtension = deepUploadFileExtension;
		this.deepUploadOriginalFileName = deepUploadOriginalFileName;
		this.deepUploadEncrytFileName = deepUploadEncrytFileName;
	}
}
