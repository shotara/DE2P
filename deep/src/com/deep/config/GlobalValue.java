package com.deep.config;

public class GlobalValue {
	
	private static final boolean isLiveMode = false; // 배포시 true, 개발시 false
	
	public static String selectSqlMapConfig() {
		return (isLiveMode ? "com/honbabin/config/SqlMapConfig_AWS.xml" : "com/honbabin/config/SqlMapConfig_Staging.xml");
	}
}
