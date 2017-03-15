package com.deep.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Feed;
import com.deep.model.domain.FeedComment;
import com.deep.model.domain.FeedCount;
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
	
	public static int addFeedReady(
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

			int check = (int)sqlSession.insert(namespace + ".addFeedReady", map);
			
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
	
	public static int addFeedSeries(
			int inputFeedNo, 
			int inputMemberNo, 
			int inputFeedStatus, 
			int inputFeedSeriesId,
			int inputFeedSeriesOrder, 
			long inputCurrentDate, 
			String inputFeedSeriesName) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);	
			map.put("memberNo", inputMemberNo);
			map.put("feedStatus", inputFeedStatus);
			map.put("feedSeriesId", inputFeedSeriesId);			
			map.put("feedSeriesOrder", inputFeedSeriesOrder);
			map.put("inputCurrentDate", inputCurrentDate);			
			map.put("feedSeriesName", inputFeedSeriesName);			

			int check = (int)sqlSession.insert(namespace + ".addFeedSeries", map);
			
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
	
	public static int addFeedSeriesReady(
			int inputFeedNo, 
			int inputMemberNo, 
			int inputFeedStatus,
			int inputFeedSeriesId, 
			int inputFeedSeriesOrder, 
			long inputCurrentDate, 
			String inputFeedSeriesName) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);	
			map.put("memberNo", inputMemberNo);
			map.put("feedStatus", inputFeedStatus);
			map.put("feedSeriesId", inputFeedSeriesId);			
			map.put("feedSeriesOrder", inputFeedSeriesOrder);
			map.put("inputCurrentDate", inputCurrentDate);			
			map.put("feedSeriesName", inputFeedSeriesName);			

			int check = (int)sqlSession.insert(namespace + ".addFeedSeriesReady", map);
			
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


	public static int addFeedComment(int inputFeedNo, int inputMemberNo, int inputFeedCommentStatus,
			int inputFeedParentCommentNo, int inputFeedCommentDepth, int inputFeedCommentNotify,
			long inputCurrentDate, String inputFeedCommentContent) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);	
			map.put("memberNo", inputMemberNo);
			map.put("feedCommentStatus", inputFeedCommentStatus);
			map.put("feedParentCommentNo", inputFeedParentCommentNo);			
			map.put("feedCommentDepth", inputFeedCommentDepth);
			map.put("feddCommentNotify", inputFeedCommentNotify);			
			map.put("inputCurrentDate", inputCurrentDate);			
			map.put("feedCommentContent", inputFeedCommentContent);			
	
			int check = (int)sqlSession.insert(namespace + ".addFeedComment", map);
			
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
	
	// Select Method
	public static ArrayList<FeedList> getFeedList(int listMode, int inputCategoryNo, int inputParameter, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", listMode);
			map.put("categoryNo", inputCategoryNo);
			map.put("inputParam", inputParameter);
			map.put("currentDate", inputCurrentDate);

			return (ArrayList)sqlSession.selectList(namespace + ".getFeedList", map);
			
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
	
	public static Feed getFeedReady(int inputFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (Feed)sqlSession.selectOne(namespace + ".getFeedReady", inputFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Feed> searchFeed(int mode, String inputSearch) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", mode);
			map.put("search", inputSearch);

			return (ArrayList)sqlSession.selectList(namespace + ".searchFeed", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getFeedLastOne(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".getFeedLastOne", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getFeedReadyLastOne(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".getFeedReadyLastOne", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Feed> getFeedReadyList(int inputMemberNo, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("inputCurrentDate", inputCurrentDate);

			return (ArrayList)sqlSession.selectList(namespace + ".getFeedReadyList", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static FeedCount getFeedCount(int inputFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (FeedCount)sqlSession.selectOne(namespace + ".getFeedCount", inputFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<FeedComment> getFeedCommentList(int inputFeedNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".getFeedCommentList", inputFeedNo);
			
		} finally {
			sqlSession.close();
		}
	}
}
