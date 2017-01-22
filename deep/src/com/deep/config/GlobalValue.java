package com.deep.config;

public class GlobalValue {
	
	private static final boolean isLiveMode = false; // 배포시 true, 개발시 false
	
	public static String selectSqlMapConfig() {
		return (isLiveMode ? "com/deep/config/SqlMapConfig_AWS.xml" : "com/deep/config/SqlMapConfig_Staging.xml");
	}
}
