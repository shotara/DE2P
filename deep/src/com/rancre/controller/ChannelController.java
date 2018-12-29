package com.rancre.controller;

import java.io.File;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.rancre.config.GlobalValue;
import com.rancre.model.ChannelDAO;
import com.rancre.model.FeedDAO;
import com.rancre.model.MemberDAO;
import com.rancre.model.UploadDAO;
import com.rancre.model.domain.Channel;
import com.rancre.model.domain.ChannelAd;
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.MemberFavorite;
import com.rancre.model.domain.RankCategory;
import com.rancre.model.domain.RankTop;
import com.rancre.model.domain.Review;
import com.rancre.model.domain.Upload;
import com.rancre.model.domain.Video;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

public class ChannelController {
	
	private static final String className = "CommonController";
	private static final int KEY_SIZE = 1024;

	public static void getChannelDetail(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			String inputChannelUrl = req.getParameter("inputChannelUrl") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputChannelUrl").toString()) : "";
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");


			// Channel Detail
			Channel channel = ChannelDAO.getChannelByNo(inputChannelNo);
			req.setAttribute("outputChannelFollowers", CommonUtil.setCommaForInt(channel.getRacChannelFollowers()));
			req.setAttribute("outputChannelBeforeFollowers", 0);
			req.setAttribute("outputChannelViews", CommonUtil.setCommaForLong(channel.getRacChannelViews()));
			req.setAttribute("outputChannelTitle", channel.getRacChannelTitle());
			req.setAttribute("outputChannelCategory", CommonUtil.getChannelCategoryList(channel.getRacChannelCategory()));
			req.setAttribute("outputChannelThumbnail", channel.getRacChannelThumbnail());

			// Get Youtube Channel Video
			ArrayList<Video> recentVideoList = ChannelDAO.getRecentVieoList(inputChannelNo);
			ArrayList<HashMap<String,Object>> outputRecentVideoList = new ArrayList<HashMap<String,Object>>();
			int recentViews = 0;
			for(int i=0; i < recentVideoList.size(); i++) {
				HashMap<String,Object> tempObejct = new HashMap<String,Object>();
				tempObejct.put("outputVideoNo", recentVideoList.get(i).getRacVideoNo());
				tempObejct.put("outputChannelNo", recentVideoList.get(i).getRacChannelNo());
				tempObejct.put("outputVideoId", recentVideoList.get(i).getRacVideoId());
				tempObejct.put("outputVideoTitle", CommonUtil.splitString(recentVideoList.get(i).getRacVideoTitle(), 3));
				tempObejct.put("outputVideoThumbnail", recentVideoList.get(i).getRacVideoThumbnail());
				tempObejct.put("outputVideoViews", CommonUtil.setCommaForLong(recentVideoList.get(i).getRacVideoViews()));
				tempObejct.put("outputVideoCreateDate", recentVideoList.get(i).getRacVideoCreateDate());
				recentViews = (int) (recentViews + recentVideoList.get(i).getRacVideoViews()); 
				outputRecentVideoList.add(tempObejct);
				
			}
			
			req.setAttribute("outputChannelRecentViews", recentVideoList.size()!= 0 ? CommonUtil.setCommaForInt(recentViews / recentVideoList.size()) : 0);
			req.setAttribute("outputRecentVideoList", outputRecentVideoList);

			// Channel Ad part
			if(sessionMemberNo>0) {
				req.setAttribute("outputAdSatisfyRank", 1); // 리뷰의 점수 평균 
				req.setAttribute("outputAdViews", 10000);
				req.setAttribute("outputAdMinPrice", 100000);
				req.setAttribute("outputAdEvenPrice", 100000);
				req.setAttribute("outputAdMaxPrice", 100000);

				// Get Youtube Video API
				ArrayList<Video> channelAdList = ChannelDAO.getChannelAdVideoList(inputChannelNo);
				ArrayList<HashMap<String,Object>> adVideoList = new ArrayList<HashMap<String,Object>>();

				for(int i=0; i<channelAdList.size();i++) {
					HashMap<String,Object> tempObejct = new HashMap<String,Object>();
					tempObejct.put("outputVideoNo", channelAdList.get(i).getRacVideoNo());
					tempObejct.put("outputChannelNo", channelAdList.get(i).getRacChannelNo());
					tempObejct.put("outputVideoId", channelAdList.get(i).getRacVideoId());
					tempObejct.put("outputVideoTitle", CommonUtil.splitString(channelAdList.get(i).getRacVideoTitle(), 3));
					tempObejct.put("outputVideoThumbnail", channelAdList.get(i).getRacVideoThumbnail());
					tempObejct.put("outputVideoViews", CommonUtil.setCommaForLong(channelAdList.get(i).getRacVideoViews()));
					tempObejct.put("outputVideoCreateDate", channelAdList.get(i).getRacVideoCreateDate());
					
					adVideoList.add(tempObejct);
				}
				req.setAttribute("outputAdVideoList", adVideoList);

				// Channel Reviews
				ArrayList<Review> reviewList = ChannelDAO.getReviewList(inputChannelNo);
				ArrayList<HashMap<String,Object>> outputReviewList = new ArrayList<HashMap<String,Object>>();

				for(int i=0; i<channelAdList.size();i++) {
					HashMap<String,Object> tempObejct = new HashMap<String,Object>();
					tempObejct.put("outputReviewNo", reviewList.get(i).getRacReviewNo());
					tempObejct.put("outputChannelNo", reviewList.get(i).getRacChannelNo());
					tempObejct.put("outputChannelAdNo", reviewList.get(i).getRacChannelAdNo());
					tempObejct.put("outputChannelAdType", ChannelDAO.getChannelAd(reviewList.get(i).getRacChannelAdNo()).getRacChannelAdType());
					tempObejct.put("outputChannelCostNo", reviewList.get(i).getRacChannelCostNo());
					tempObejct.put("outputReviewSatisfy", reviewList.get(i).getRacReviewSatisfy());
					tempObejct.put("outputReviewTargetReach", reviewList.get(i).getRacReviewTargetReach());
					tempObejct.put("outputReviewTargetConversion", reviewList.get(i).getRacReviewTargetConversion());
					tempObejct.put("outputReviewTargetGender", reviewList.get(i).getRacReviewTargetGender());
					tempObejct.put("outputReviewTargetAge", reviewList.get(i).getRacReviewTargetAge());
					tempObejct.put("outputReviewRecomand", reviewList.get(i).getRacReviewRecomand());
					tempObejct.put("outputReviewAdAgain", reviewList.get(i).getRacReviewAdAgain());
					tempObejct.put("outputReviewDetail", reviewList.get(i).getRacReviewDetail());
					tempObejct.put("outputReviewCreateDate", reviewList.get(i).getRacReviewCreateDate());

					outputReviewList.add(tempObejct);
				}
				req.setAttribute("outputReivewList", outputReviewList);
				
			}
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel Detail OK", map);
			req.getRequestDispatcher("/02_page/Channel/channelDetail.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getRankingList(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			// Top100 Mode : 1, All Mode : 2, New Mode : 3
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			int startNo = req.getParameter("startNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("startNo").toString())) : 0;
			int categoryNo = req.getParameter("categoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("categoryNo").toString())) : 0;
			JSONObject jMainObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			// 순위 리스트
			JSONArray rankingList = new JSONArray();
			if(mode == 1) {
				ArrayList<RankTop> ranking = ChannelDAO.getRankingList(startNo);
				for(int i=0; i<ranking.size(); i++) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("outputRankTopNo", ranking.get(i).getRacRankTopNo());
					tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());
					tempObject.put("outputCategoryNo", CommonUtil.getChannelCategoryList(ranking.get(i).getRacChannelCategory()));
					tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
					tempObject.put("outputChannelTitle", CommonUtil.splitString(ranking.get(i).getRacChannelTitle(), 2));
					tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelFollowers()));
					tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(ranking.get(i).getRacChannelViews()));
					tempObject.put("outputChannelVideoCount", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelVideoCount()));
					tempObject.put("outputChannelThumbnail", ranking.get(i).getRacChannelThumbnail());
					
					rankingList.add(tempObject);
				}
			}
			else {
				ArrayList<RankCategory> ranking = ChannelDAO.getRankingList2(mode, startNo, categoryNo);
				for(int i=0; i<ranking.size(); i++) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());
					// 카테고리 가져오기
					tempObject.put("outputCategoryNo", CommonUtil.getChannelCategoryList(ranking.get(i).getRacChannelCategory()));
					tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
					// 13자리 
					tempObject.put("outputChannelTitle", CommonUtil.splitString(ranking.get(i).getRacChannelTitle(), 2));
					tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelFollowers()));
					tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(ranking.get(i).getRacChannelViews()));
					tempObject.put("outputChannelVideoCount", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelVideoCount()));
					tempObject.put("outputChannelThumbnail", ranking.get(i).getRacChannelThumbnail());
					
					rankingList.add(tempObject);
				}
			}


			jMainObject.put("rankingList", rankingList);
			
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get RankingList OK", map);
			res.getWriter().write(jMainObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
