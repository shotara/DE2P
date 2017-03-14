package com.deep.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Feed;
import com.deep.model.domain.FeedHashtag;
import com.deep.model.domain.FeedList;
import com.deep.model.domain.FeedSeries;
import com.deep.util.DAOFactory;

public class FeedDAO {

	private static final String namespace = "feed";
	
	// Insert Method
	public static int addFeed(
			int inputMemberNo, 
			int inputCategoryNo, 
			int inputFeedStatus, 
			int inputFeedType,
			long inputCurrentDate,
			String inputFeedTitle, 
			String inputFeedImages, 
			String inputFeedContent) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("categoryNo", inputCategoryNo);	
			map.put("feedStatus", inputFeedStatus);
			map.put("feedType", inputFeedType);			
			map.put("inputCurrentDate", inputCurrentDate);			
			map.put("feedTitle", inputFeedTitle);
			map.put("feedImages", inputFeedImages);			
			map.put("feedContent", inputFeedContent);

			int check = (int)sqlSession.insert(namespace + ".addFeed", map);
			
			if(check == 1) {
				sqlSession.commit();
				return check;
			} else {
				sqlSession.rollback();
				return check;
			}
		} finally {
			sqlSession.close();
		}
	}
	// Update Method
	
	// Select Method
	public static ArrayList<FeedList> getFeedList(int listMode, int inputCategoryNo, int inputParameter, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", listMode);
			map.put("categoryNo", inputCategoryNo);
			map.put("inputParam", inputParameter);
			map.put("currentDate", inputCurrentDate);

			return (ArrayList)sqlSession.selectOne(namespace + ".getFeedList", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static FeedSeries getFeedSeries(int inputFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (FeedSeries)sqlSession.selectOne(namespace + ".getFeedSeries", inputFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<FeedHashtag> getFeedHashtag(int inputFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	

			return (ArrayList)sqlSession.selectOne(namespace + ".getFeedHashtag", inputFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Feed getFeed(int inputFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (Feed)sqlSession.selectOne(namespace + ".getFeed", inputFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int setFeed(
			int inputFeedNo, 
			int inputMemberNo, 
			int inputCategoryNo, 
			int inputFeedStatus,
			int inputFeedType, 
			long inputCurrentDate, 
			String inputFeedTitle, 
			String inputFeedImages,
			String inputFeedContent) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);
			map.put("memberNo", inputMemberNo);			
			map.put("categoryNo", inputCategoryNo);			
			map.put("feedStatus", inputFeedStatus);			
			map.put("feedType", inputFeedType);
			map.put("inputCurrentDate", inputCurrentDate);
			map.put("feedTitle", inputFeedTitle);			
			map.put("feedImages", inputFeedImages);			
			map.put("feedContent", inputFeedContent);			
			int check = (int)sqlSession.update(namespace + ".setFeed", map);
			
			if(check == 1) {
				sqlSession.commit();
				return check;
			} else {
				sqlSession.rollback();
				return check;
			}
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<FeedList> searchFeed(int mode, String inputSearch) {
		// TODO Auto-generated method stub
		return null;
	}
}
