package com.rancre.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.rancre.model.domain.Channel;
import com.rancre.model.domain.ChannelAd;
import com.rancre.model.domain.ChannelCost;
import com.rancre.model.domain.Feed;
import com.rancre.model.domain.FeedComment;
import com.rancre.model.domain.FeedCount;
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.RankCategory;
import com.rancre.model.domain.RankTop;
import com.rancre.model.domain.Review;
import com.rancre.model.domain.Video;
import com.rancre.util.DAOFactory;

public class ChannelDAO {

	private static final String namespace = "channel";

	public static int addChannelAd(
			int racChannelNo, 
			String decryptChannelAdUrl, 
			int inputChannelAdType,
			int inputChannelAdCategory, 
			Timestamp inputCurrentDate,
			Timestamp executeDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", racChannelNo);
			map.put("videoId", decryptChannelAdUrl);	
			map.put("channelAdType", inputChannelAdType);
			map.put("channelAdCategory", inputChannelAdCategory);			
			map.put("inputCurrentDate", inputCurrentDate);			
			map.put("executeDate", executeDate);			

			int check = (int)sqlSession.insert(namespace + ".addChannelAd", map);
			
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

	public static int addChannelCost(
			int racChannelNo, 
			int commercialPrice, 
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
				
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", racChannelNo);
			map.put("channelCostPrice", commercialPrice);			
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

	public static int addReview(
			int inputMemberNo,
			int inpoutReviewStatus, 
			int channelNo,
			int channelAdNo, 
			int channelCostNo, 
			int inputReviewSatisfy,
			int inputReviewTargetReach, 
			int inputReviewTargetConvert, 
			int inputReviewTargetSex,
			int inputReviewTargetAge, 
			int inputReviewRecomand, 
			int inputReviewAdAgain, 
			String inputReviewDetail,
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
				
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("reviewStatus", inpoutReviewStatus);
			map.put("channelNo", channelNo);			
			map.put("channelAdNo", channelAdNo);			
			map.put("channelCostNo", channelCostNo);					
			map.put("reviewSatisfy", inputReviewSatisfy);
			map.put("reviewTargetReach", inputReviewTargetReach);			
			map.put("reviewTargetConvert", inputReviewTargetConvert);			
			map.put("reviewTargetSex", inputReviewTargetSex);
			map.put("reviewTargetAge", inputReviewTargetAge);			
			map.put("reviewTargetRecomand", inputReviewRecomand);		
			map.put("reviewTargetAdAgain", inputReviewAdAgain);
			map.put("reviewTargetDetail", inputReviewDetail);			
			map.put("inputCurrentDate", inputCurrentDate);		

			int check = (int)sqlSession.insert(namespace + ".addReview", map);
			
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

	public static int addChannelView(int inputMemberNo, int racChannelNo, Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", racChannelNo);	
			map.put("memberNo", inputMemberNo);			
			map.put("inputCurrentDate", inputCurrentDate);			

			int check = (int)sqlSession.insert(namespace + ".addChannelView", map);
			
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
	

	public static int addChannelLike(
			int inputMemberNo, 
			int inputChannelNo, 
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);	
			map.put("memberNo", inputMemberNo);			
			map.put("inputCurrentDate", inputCurrentDate);			

			int check = (int)sqlSession.insert(namespace + ".addChannelLike", map);
			
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

	public static int addChannel(
			int inputMemberNo, 
			int inputChannelStatus, 
			String inputCategory,
			String channelTitle, 
			int followers, 
			int views,
			String checkChannelUrl, 
			String thumbnail, 
			String inputCountry, 
			Timestamp inputCreateDate,
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
				
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("channelStatus", inputChannelStatus);
			map.put("channelCategory", inputCategory);			
			map.put("channelTitle", channelTitle);			
			map.put("channelFollowers", followers);					
			map.put("channelViews", views);
			map.put("channelUrl", checkChannelUrl);			
			map.put("channelThumbnail", thumbnail);			
			map.put("channelRegion", inputCountry);
			map.put("channelCreateDate", inputCreateDate);			
			map.put("channelInsertDate", inputCurrentDate);		
	
			int check = (int)sqlSession.insert(namespace + ".addChannel", map);
			
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
	public static int deleteChannelLike(int inputMemberNo, int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelNo", inputChannelNo);	
			map.put("memberNo", inputMemberNo);			

			int check = (int)sqlSession.delete(namespace + ".deleteChannelLike", map);
			
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
	
	public static int setVideoStatus(int racVideoNo, int racVideoStatus) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("videoNo", racVideoNo);	
			map.put("videoStatus", racVideoStatus);			

			int check = (int)sqlSession.update(namespace + ".setVideoStatus", map);
			
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

	public static Channel getChannelByNo(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (Channel)sqlSession.selectOne(namespace + ".getChannelByNo", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<ChannelAd> getChannelAdList(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".getChannelAdList", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Review> getReviewList(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".getReviewList", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Video> getRecentVieoList(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".getRecentVieoList", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<ChannelAd> getChannelAdVideoList(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".getChannelAdVideoList", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ChannelAd getChannelAd(int inputChannelAdNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ChannelAd)sqlSession.selectOne(namespace + ".getChannelAd", inputChannelAdNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Channel> autoComplete(String inputChannelTitle) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".autoComplete", inputChannelTitle);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Channel getChannelByTitle(String inputChannelTitle) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (Channel)sqlSession.selectOne(namespace + ".getChannelByTitle", inputChannelTitle);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getChannelAdLastOne() {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".getChannelAdLastOne");
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getChannelCostLastOne() {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".getChannelCostLastOne");
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkChannelLike(int inputMemberNo, int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("channelNo", inputChannelNo);

			return (int)sqlSession.selectOne(namespace + ".checkChannelLike", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkChannelUrl(String checkChannelUrl) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".checkChannelUrl", checkChannelUrl);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Channel> getRecomandChannel(Timestamp inputCurrentDate, int limit) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("inputCurrentDate", inputCurrentDate);
			map.put("limit", limit);
			return (ArrayList)sqlSession.selectList(namespace + ".getRecomandChannel", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Channel> searchChannelList(String inputChannelTitle) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ArrayList)sqlSession.selectList(namespace + ".searchChannelList", inputChannelTitle);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ChannelCost getChannelCost(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (ChannelCost)sqlSession.selectOne(namespace + ".getChannelCost", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkRankTop(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".checkRankTop", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkRankCategory(int inputChannelNo, Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelDate", inputCurrentDate);
			map.put("channelNo", inputChannelNo);
			
			return (int)sqlSession.selectOne(namespace + ".checkRankCategory", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static RankCategory getRankCategory(int inputChannelNo, Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("channelDate", inputCurrentDate);
			map.put("channelNo", inputChannelNo);
			
			return (RankCategory)sqlSession.selectOne(namespace + ".getRankCategory", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getFolloewrsPrevWeek(int inputChannelNo, Timestamp currentTime, Timestamp currentTime2) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("beforeDate", currentTime);
			map.put("afterDate", currentTime2);
			map.put("channelNo", inputChannelNo);
			
			return (int)sqlSession.selectOne(namespace + ".getFolloewrsPrevWeek", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkChannelSummaryCount(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".checkChannelSummaryCount", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getRankBefore(int inputChannelNo,Timestamp beforeDate, Timestamp afterDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("beforeDate", beforeDate);
			map.put("afterDate", afterDate);
			map.put("inputChannelNo", inputChannelNo);
			
			return (int)sqlSession.selectOne(namespace + ".getRankBefore", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int getChannelAverageCost(int inputChannelNo) {
	
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".getChannelAverageCost", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkChannelCost(int inputChannelNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".checkChannelCost", inputChannelNo);
			
		} finally {
			sqlSession.close();
		}
	}

}
