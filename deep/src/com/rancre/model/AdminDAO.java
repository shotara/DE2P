package com.rancre.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.rancre.model.domain.Channel;
import com.rancre.model.domain.ChannelCategory;
import com.rancre.model.domain.ChannelCost;
import com.rancre.model.domain.Feed;
import com.rancre.model.domain.FeedComment;
import com.rancre.model.domain.FeedCount;
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.Member;
import com.rancre.util.DAOFactory;

public class AdminDAO {

	private static final String namespace = "admin";

	// Insert Method
	public static int addChannelCost(
			int inputChannelNo, 
			int inputChannelAdType,
			int inputChannelCostPrice,
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("channelAdType", inputChannelAdType);	
			map.put("channelCostPrice", inputChannelCostPrice);	
			map.put("inputCurrentDate", inputCurrentDate);			

			int check = (int)sqlSession.insert(namespace + ".addChannelCost", map);
			
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
	
	public static int addChannelCategory(
			int inputChannelNo, 
			int inputCategoryNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("categoryNo", inputCategoryNo);			

			int check = (int)sqlSession.insert(namespace + ".addChannelCategory", map);
			
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
	
	public static int addChannelAdUrl(
			int inputChannelNo, 
			String inputVideoId,
			String inputVideoTitle,
			String inputVideoViews,
			String inputVideoThumbnail,
			int inputChannelAdType,
			int inputChannelAdCategory,
			Timestamp inputVideoCreateDate,
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("videoId", inputVideoId);	
			map.put("videoTitle", inputVideoTitle);				
			map.put("videoViews", inputVideoViews);
			map.put("videoThumbnail", inputVideoThumbnail);	
			map.put("channelAdType", inputChannelAdType);		
			map.put("channelAdCategory", inputChannelAdCategory);		
			map.put("videoCreateDate", inputVideoCreateDate);
			map.put("inputCurrentDate", inputCurrentDate);	
			map.put("videoExecuteDate", inputVideoCreateDate);

			int check = (int)sqlSession.insert(namespace + ".addChannelAdUrl", map);
			
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
	public static int setChannelInfo(
			int inputChannelNo, 
			String inputCategory, 
			int inputMcnNo,
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("category", inputCategory);			
			map.put("mcnNo", inputMcnNo);			
			map.put("inputCurrentDate", inputCurrentDate);			

			int check = (int)sqlSession.update(namespace + ".setChannelInfo", map);
			
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
	
	public static int setRankTopCategory(int inputChannelNo, String category) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("category", category);				

			int check = (int)sqlSession.update(namespace + ".setRankTopCategory", map);
			
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

	public static int setRankCategoryCategory(int inputChannelNo, String category, Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("category", category);			
			map.put("inputCurrentDate", inputCurrentDate);			

			int check = (int)sqlSession.update(namespace + ".setRankCategoryCategory", map);
			
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
	public static ArrayList<Channel> getChannelList(int channelStatus, int offset, int size) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("racChannelStatus", channelStatus);
			map.put("offset", offset);
			map.put("size", size);

			return (ArrayList)sqlSession.selectList(namespace + ".getChannelList", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countTotalChannel() {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace + ".countTotalChannel");
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countChannelAd(int racChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace + ".countChannelAd", racChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countChannelCost(int racChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace + ".countChannelCost", racChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getChannelCostPrice(int racChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace + ".getChannelCostPrice", racChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Channel getChannel(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (Channel)sqlSession.selectOne(namespace + ".getChannel", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<ChannelCategory> getChannelCategory(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (ArrayList) sqlSession.selectList(namespace + ".getChannelCategory", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int deleteChannelCategory(int inputChannelNo, int inputCategoryNo) {
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);
			map.put("categoryNo", inputCategoryNo);			
		
			int check = (int)sqlSession.delete(namespace + ".deleteChannelCategory", map);
			
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

	public static ArrayList<Member> getMemberList(int memberStatus, int offset, int recordsPerPage) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberStatus", memberStatus);
			map.put("offset", offset);
			map.put("size", recordsPerPage);			
		
			return (ArrayList) sqlSession.selectList(namespace + ".getMemberList", map);
			
		} finally {
			sqlSession.close();
		}
	}

}
