package com.rancre.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.rancre.model.domain.Feed;
import com.rancre.model.domain.FeedComment;
import com.rancre.model.domain.FeedCount;
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.RankCategory;
import com.rancre.model.domain.RankTop;
import com.rancre.util.DAOFactory;

public class ChannelDAO {

	private static final String namespace = "channel";
	
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

	public static int addFeedLike(int inputFeedNo, int inputMemberNo, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);	
			map.put("memberNo", inputMemberNo);		
			map.put("inputCurrentDate", inputCurrentDate);			
	
	
			int check = (int)sqlSession.insert(namespace + ".addFeedLike", map);
			
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

	public static int addFeedCommentLike(int inputFeedCommentNo, int inputMemberNo, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedCommentNo", inputFeedCommentNo);	
			map.put("memberNo", inputMemberNo);		
			map.put("inputCurrentDate", inputCurrentDate);			
	
	
			int check = (int)sqlSession.insert(namespace + ".addFeedCommentLike", map);
			
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
	
	public static int addFeedShare(int inputFeedNo, int inputMemberNo, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);	
			map.put("memberNo", inputMemberNo);		
			map.put("inputCurrentDate", inputCurrentDate);			
	
	
			int check = (int)sqlSession.insert(namespace + ".addFeedShare", map);
			
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
	
	// Delete Method
	public static int deleteFeedLike(int inputFeedNo, int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);
			map.put("memberNo", inputMemberNo);			
		
			int check = (int)sqlSession.delete(namespace + ".deleteFeedLike", map);
			
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

	public static int deleteFeedCommentLike(int inputFeedCommentNo, int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedCommentNo", inputFeedCommentNo);
			map.put("memberNo", inputMemberNo);			
		
			int check = (int)sqlSession.delete(namespace + ".deleteFeedCommentLike", map);
			
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

	public static int checkFeedLike(int inputFeedNo, int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);
			map.put("memberNo", inputMemberNo);

			return (int)sqlSession.selectOne(namespace + ".checkFeedLike", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkFeedCommentLike(int inputFeedCommentNo, int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedCommentNo", inputFeedCommentNo);
			map.put("memberNo", inputMemberNo);

			return (int)sqlSession.selectOne(namespace + ".checkFeedCommentLike", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkFeedShare(int inputFeedNo, int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("feedNo", inputFeedNo);
			map.put("memberNo", inputMemberNo);

			return (int)sqlSession.selectOne(namespace + ".checkFeedShare", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countFeedCommentLike(int inputFeedCommentNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace + ".countFeedCommentLike", inputFeedCommentNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static String getFeedComment(int inputFeedCommentNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (String)sqlSession.selectOne(namespace + ".getFeedComment", inputFeedCommentNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<RankTop> getRankingList(int startNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".getRankingList", startNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<RankCategory> getRankingList2(int mode, int startNo, int categoryNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", mode);
			map.put("startNo", startNo);
			map.put("categoryNo", categoryNo);

			return (ArrayList)sqlSession.selectList(namespace + ".getRankingList2", map);
			
		} finally {
			sqlSession.close();
		}
	}
}
