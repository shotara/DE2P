package com.deep.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.FeedHashtag;
import com.deep.model.domain.FeedList;
import com.deep.model.domain.FeedSeries;
import com.deep.util.DAOFactory;

public class FeedDAO {

	private static final String namespace = "feed";
	
	// Insert Method
	
	// Update Method
	
	// Select Method
	public static ArrayList<FeedList> getFeedList(int listMode, int inputFeedCategory, int inputParameter, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", listMode);
			map.put("categoryNo", inputFeedCategory);
			map.put("inputParam", inputParameter);
			map.put("currentDate", inputCurrentDate);

			return (ArrayList)sqlSession.selectOne(namespace + ".getFeedList", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static FeedSeries getFeedSeries(int inputDeepFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (FeedSeries)sqlSession.selectOne(namespace + ".getFeedSeries", inputDeepFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<FeedHashtag> getFeedHashtag(int inputDeepFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	

			return (ArrayList)sqlSession.selectOne(namespace + ".getFeedHashtag", inputDeepFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

}
