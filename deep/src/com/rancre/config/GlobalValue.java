package com.deep.config;

public class GlobalValue {
	
	private static final boolean isLiveMode = false; // 배포시 true, 개발시 false
	
	// File
	public static final String UPLOAD_DIRECTORY = "05_temp";
	public static final int MEMORY_THRESHOLD = 1024 * 1024 * 50; // 50MB
	public static final int MAX_FILE_SIZE    = 1024 * 1024 * 50; // 50MB
	public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	// AWS Bucket 경로
	public static final String AWS_S3_USER_BUCKET_URL = "https://s3.ap-northeast-1.amazonaws.com/deep-test2";
	public static final String AWS_CLOUDFRONT_USER_BUCKET_URL = "d2exmevbntbem9.cloudfront.net";
	public static final String AWS_UPLOAD_BUCKET_NAME = "deep-test2";

	// Image
	public static final String imgNoProfile = AWS_CLOUDFRONT_USER_BUCKET_URL + "/common/image/no_profile.png";
	
	public static String selectSqlMapConfig() {
		return (isLiveMode ? "com/deep/config/SqlMapConfig_AWS.xml" : "com/deep/config/SqlMapConfig_Staging.xml");
	}	
}
		