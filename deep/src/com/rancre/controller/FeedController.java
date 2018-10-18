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
import com.rancre.model.FeedDAO;
import com.rancre.model.MemberDAO;
import com.rancre.model.UploadDAO;
import com.rancre.model.domain.Feed;
import com.rancre.model.domain.FeedComment;
import com.rancre.model.domain.FeedCount;
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.MemberFavorite;
import com.rancre.model.domain.Upload;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

public class FeedController {

	public static final String className = "FeedController";

	public static void getFeed(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			// mode 1 : 임시저장, 2 : 정상등록 
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			Feed feed;
			
			if(mode==2)
				feed = FeedDAO.getFeed(inputFeedNo);
			else 
				feed = FeedDAO.getFeedReady(inputFeedNo); 
			
			if(feed==null) {
				CommonUtil.commonPrintLog("fail", className, "No Feed", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// feed 뿌려주기.
			jObject.put("outputFeedNo", feed.getDeepFeedNo());
			jObject.put("outputMemberUid", MemberDAO.getMemberUid(feed.getDeepMemberNo()));
			jObject.put("outputCategorydNo", feed.getDeepCategoryNo());
			jObject.put("outputFeedType", feed.getDeepFeedType());
			jObject.put("outputFeedCreateDate", feed.getDeepFeedCreateDate());
			jObject.put("outputFeedTitle", feed.getDeepFeedTitle());
			
			// Images process
			jObject.put("outputFeedImages", feed.getDeepFeedImages());
			jObject.put("outputFeedContent", feed.getDeepFeedContent());

			// Hashtag 
			
			// Series
			FeedSeries feedSeries = FeedDAO.getFeedSeries(inputFeedNo);
			
			if(feedSeries!=null) {
				jObject.put("outputFeedSeriesId", feedSeries.getDeepFeedSeriesId());
				jObject.put("outputFeedSeriesOrder", feedSeries.getDeepFeedSeriesOrder());
				jObject.put("outputFeedSeriesName", feedSeries.getDeepFeedSeriesName());
			}
			
			if(mode==2) {
				FeedCount feedCount = FeedDAO.getFeedCount(feed.getDeepFeedNo());
				jObject.put("outputFeedLikeCount", feedCount.getDeepLikeCount());
				jObject.put("outputFeedCommentCount", feedCount.getDeepCommentCount());
				jObject.put("outputFeedShareCount", feedCount.getDeepShareCount());
			}
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Feed OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getFeedReadyList(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			JSONArray jFeedReadyArray = new JSONArray();
			ArrayList<Feed> feedList = FeedDAO.getFeedReadyList(sessionMemberNo, System.currentTimeMillis()/1000);
			
			for(int i=0; i>feedList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				
				// Feed
				jTempObject.put("outputFeedNo", feedList.get(i).getDeepFeedNo());
				jTempObject.put("outputCategoryNo", feedList.get(i).getDeepCategoryNo());
				jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(feedList.get(i).getDeepCategoryNo()));
				jTempObject.put("outputFeedType", feedList.get(i).getDeepFeedType());
				jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(feedList.get(i).getDeepFeedType()));
				jTempObject.put("outputFeedCreateDate", CommonUtil.convertUnixTime(feedList.get(i).getDeepFeedCreateDate(), 16));
				jTempObject.put("outputFeedTitle", feedList.get(i).getDeepFeedTitle());
				
				// 시리즈인지 
				FeedSeries feedSeries = FeedDAO.getFeedSeries(feedList.get(i).getDeepFeedNo());
				if(feedSeries!=null) {
					jTempObject.put("outputIsSeries", "1");
					jTempObject.put("outputFeedSeriesId", feedSeries.getDeepFeedSeriesId());
					jTempObject.put("outputFeedSeriesOrder", feedSeries.getDeepFeedSeriesOrder());
					jTempObject.put("outputFeedSeriesName", feedSeries.getDeepFeedSeriesName());
				} else {
					jTempObject.put("outputIsSeries", "-1");
				}

				jFeedReadyArray.add(jTempObject);
			}
			
			jObject.put("outputFeedReadyList", jFeedReadyArray);

			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Feed Ready List OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeFeed(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			// mode 1 : 임시저장, 2 : 정상등록 
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			int inputCategoryNo = req.getParameter("inputCategoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputCategoryNo").toString())) : 0;
			int inputFeedStatus = 1;
			int inputFeedType = req.getParameter("inputFeedType") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedType").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;
			String inputFeedTitle = req.getParameter("inputFeedTitle") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedTitle").toString()) : "";
			String inputFeedImages = req.getParameter("inputFeedImages") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedImages").toString()) : "";
			String inputFeedContent = req.getParameter("inputFeedContent") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedContent").toString()) : "";

			// Hashtag
			String inputFeedHashtag = req.getParameter("inputFeedHashtag") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedHashtag").toString()) : "";

			// Series
			int isSeries = req.getParameter("isSeries") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("isSeries").toString())) : 0;
			int inputFeedSeriesId = req.getParameter("inputFeedSeriesId") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedSeriesId").toString())) : 0;
			int inputFeedSeriesOrder = req.getParameter("inputFeedSeriesOrder") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedSeriesOrder").toString())) : 0;
			String inputFeedSeriesName = req.getParameter("inputFeedSeriesName") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedSeriesName").toString()) : "";

			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(mode);	
			parameterList.add(inputCategoryNo);	
			parameterList.add(inputFeedStatus);	
			parameterList.add(inputFeedType);	
			if(mode==2) parameterList.add(inputFeedTitle);	
			parameterList.add(inputFeedContent);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			int checkFeed = 0, checkSeries = 0;
			
			if(mode == 1) {	// 임시저장 
				inputFeedStatus = 3;
				checkFeed = FeedDAO.addFeedReady(sessionMemberNo, inputCategoryNo, inputFeedStatus, inputFeedType, inputCurrentDate, inputFeedTitle, inputFeedImages, inputFeedContent);
				if(checkFeed!=1) {
					CommonUtil.commonPrintLog("ERROR", className, "Add Feed Fail!!!", map);
					jObject.put("outputResult", "-3");
					res.getWriter().write(jObject.toString());
					return;
				}
				
				int inputFeedNo = 0;
				
				if(!inputFeedHashtag.equals("")) {
					
				//hashtag split method	
					
					
				}
				
				if(isSeries==1) {
					inputFeedNo = FeedDAO.getFeedReadyLastOne(sessionMemberNo);
					if(inputFeedSeriesId==0) inputFeedSeriesId = inputFeedNo;
					
					checkSeries = FeedDAO.addFeedSeriesReady(inputFeedNo, sessionMemberNo, inputFeedStatus, inputFeedSeriesId, inputFeedSeriesOrder, inputCurrentDate, inputFeedSeriesName);
					if(checkSeries!=1) {
						CommonUtil.commonPrintLog("ERROR", className, "Add Feed Series Fail!!!", map);
						jObject.put("outputResult", "-5");
						res.getWriter().write(jObject.toString());
						return;
					}
				}
				
			} else { // 정상등록 
				inputFeedStatus = 1;
				checkFeed = FeedDAO.addFeed(sessionMemberNo, inputCategoryNo, inputFeedStatus, inputFeedType, inputCurrentDate, inputFeedTitle, inputFeedImages, inputFeedContent);
				if(checkFeed!=1) {
					CommonUtil.commonPrintLog("ERROR", className, "Add Feed Fail!!!", map);
					jObject.put("outputResult", "-3");
					res.getWriter().write(jObject.toString());
					return;
				}
				
				int inputFeedNo = 0;
				
				if(!inputFeedHashtag.equals("")) {
					
				//hashtag split method	
					
					
				}
				if(isSeries==1) {
					inputFeedNo = FeedDAO.getFeedLastOne(sessionMemberNo);
					if(inputFeedSeriesId==0) inputFeedSeriesId = inputFeedNo;
					
					checkSeries = FeedDAO.addFeedSeries(inputFeedNo, sessionMemberNo, inputFeedStatus, inputFeedSeriesId, inputFeedSeriesOrder, inputCurrentDate, inputFeedSeriesName);
					if(checkSeries!=1) {
						CommonUtil.commonPrintLog("ERROR", className, "Add Feed Series Fail!!!", map);
						jObject.put("outputResult", "-5");
						res.getWriter().write(jObject.toString());
						return;
					}
				}
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Feed OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void setFeed(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;
			int inputCategoryNo = req.getParameter("inputCategoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputCategoryNo").toString())) : 0;
			int inputFeedStatus = req.getParameter("inputFeedStatus") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedStatus").toString())) : 0;
			int inputFeedType = req.getParameter("inputFeedType") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedType").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;
			String inputFeedTitle = req.getParameter("inputFeedTitle") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedTitle").toString()) : "";
			String inputFeedImages = req.getParameter("inputFeedImages") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedImages").toString()) : "";
			String inputFeedContent = req.getParameter("inputFeedContent") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedContent").toString()) : "";
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : "";

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	
			parameterList.add(inputCategoryNo);	
			parameterList.add(inputFeedStatus);	
			parameterList.add(inputFeedType);	
			parameterList.add(inputFeedTitle);	
			parameterList.add(inputFeedContent);	
			parameterList.add(inputMemberUid);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Check feed writer
			if(sessionMemberNo != MemberDAO.getMemberNoByMemberUid(inputMemberUid)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Feed Writer", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			int check = FeedDAO.setFeed(inputFeedNo, sessionMemberNo, inputCategoryNo, inputFeedStatus, inputFeedType, inputCurrentDate, inputFeedTitle, inputFeedImages, inputFeedContent);
				
			if(check!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "Set Feed Fail!!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Set Feed OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void listFeed(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			int listMode = 1;
			int inputCategoryNo = req.getParameter("inputCategoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputCategoryNo").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputCategoryNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			JSONArray feedList = new JSONArray();
			feedList = getFeedList(listMode, inputCategoryNo, 15, sessionMemberNo, inputCurrentDate, aesKey);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "list Feed OK", map);
			jObject.put("outputFeedList", feedList);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static JSONArray getFeedList(int listMode, int inputCategoryNo, int inputParameter, int inputMemberNo, long inputCurrentDate, String aesKey) {
		
		HashMap<String, String> map = new HashMap<String, String>();

		JSONArray jArray = new JSONArray();
		
		try {
			if(listMode==1) {
				// 새로운 피드 리스트를 띄워준다. inputParameter - 가져올 피드 갯수   DAO로 가져온다.
				JSONArray jNewFeedArray = new JSONArray();
				ArrayList<FeedList> newFeedList = FeedDAO.getFeedList(listMode, inputCategoryNo, inputParameter, inputCurrentDate);
				
				for(int i=0; i>newFeedList.size();i++) {
					JSONObject jTempObject = new JSONObject();
					
					// 인덱스  - jSON은 순서가 없다.
					jTempObject.put("outputNewFeedNo", i+1);
					
					// Writer
					Member member = MemberDAO.getMemberByMemberNo(newFeedList.get(i).getDeepMemberNo());
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(newFeedList.get(i).getDeepMemberNo()).getRacMemberUid());
						
					// Feed
					jTempObject.put("outputFeedNo", newFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputCategoryNo", newFeedList.get(i).getDeepCategoryNo());
					jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(newFeedList.get(i).getDeepCategoryNo()));
					jTempObject.put("outputFeedType", newFeedList.get(i).getDeepFeedType());
					jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(newFeedList.get(i).getDeepFeedType()));
					jTempObject.put("outputFeedCreateDate", CommonUtil.convertUnixTime(newFeedList.get(i).getDeepFeedCreateDate(), 16));
					jTempObject.put("outputFeedTitle", newFeedList.get(i).getDeepFeedTitle());
					
					//사진가져오기
					ArrayList<HashMap<String, Object>> outputFeedImageList = new ArrayList<HashMap<String, Object>>(); 
					if(!(newFeedList.get(i).getDeepFeedImages().equals(""))) {
		
						String bucketName = GlobalValue.AWS_CLOUDFRONT_USER_BUCKET_URL + "/feed/" + newFeedList.get(i).getDeepFeedNo() + "/";
						ArrayList<String> imgList = CommonUtil.commonSpiltBySemicolon(newFeedList.get(i).getDeepFeedImages());
						for(int j=0; j<imgList.size(); j++) {
							HashMap<String, Object> outputFeedImgMap = new HashMap<String, Object>();		
							Upload upload = UploadDAO.getUploadByUploadNo(Integer.parseInt(imgList.get(j)));
							outputFeedImgMap.put("outputFeedImage", bucketName + upload.getDeepUploadEncryptFileName() +"." + upload.getDeepUploadFileExtension());
							outputFeedImageList.add(outputFeedImgMap);
						}
					}
					jTempObject.put("outputFeedImage", outputFeedImageList.get(0).get("outputMeetingImage")); // 대표 이미지
					jTempObject.put("outputFeedImageList", outputFeedImageList);
		
					jTempObject.put("outputFeedContent", newFeedList.get(i).getDeepFeedNo());
		
					FeedCount feedCount = FeedDAO.getFeedCount(newFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedLikeCount", feedCount.getDeepLikeCount());
					jTempObject.put("outputFeedCommentCount", feedCount.getDeepCommentCount());
					jTempObject.put("outputFeedShareCount", feedCount.getDeepShareCount());
		
					// 이 피드를 좋아요, 공유 했는지 
					jTempObject.put("outputIsFeedLike", FeedDAO.checkFeedLike(newFeedList.get(i).getDeepFeedNo(), inputMemberNo));
					jTempObject.put("outputIsFeedShare", FeedDAO.checkFeedShare(newFeedList.get(i).getDeepFeedNo(), inputMemberNo));
		
					// 해쉬태그 
					JSONArray jHashtagArray = new JSONArray();
					ArrayList<FeedHashtag> feedHashtag = FeedDAO.getFeedHashtag(newFeedList.get(i).getDeepFeedNo());
					for(int j=0;j<feedHashtag.size();j++) {
						JSONObject jTempHashtag = new JSONObject();
						jTempHashtag.put("outputFeedHashtag", feedHashtag.get(j).getDeepFeedHashtag());
						jHashtagArray.add(jTempHashtag);
					}
					jTempObject.put("outputFeedHashtag", jHashtagArray);
					
					// 시리즈인지 
					FeedSeries feedSeries = FeedDAO.getFeedSeries(newFeedList.get(i).getDeepFeedNo());
					if(feedSeries!=null) {
						jTempObject.put("outputIsSeries", "1");
						jTempObject.put("outputFeedSeriesId", feedSeries.getDeepFeedSeriesId());
						jTempObject.put("outputFeedSeriesOrder", feedSeries.getDeepFeedSeriesOrder());
						jTempObject.put("outputFeedSeriesName", feedSeries.getDeepFeedSeriesName());
					} else {
						jTempObject.put("outputIsSeries", "-1");
					}
					// newFeedArray에 더한다.
					jNewFeedArray.add(jTempObject);
				}
				// MainObject에 newFeedList 더한다.
				jArray = jNewFeedArray;
				
			} else if(listMode == 2) {
				// 인기있는 피드 리스트 - 제목 분야 글쓴이
				JSONArray jHotFeedArray = new JSONArray();
				ArrayList<FeedList> hotFeedList = FeedDAO.getFeedList(listMode, inputCategoryNo, inputParameter, inputCurrentDate);
				
				for(int i=0; i>hotFeedList.size();i++) {
					JSONObject jTempObject = new JSONObject();
					
					// 인덱스
					jTempObject.put("outpuHotFeedNo", i+1);
					
					// Writer
					Member member = MemberDAO.getMemberByMemberNo(hotFeedList.get(i).getDeepMemberNo());
					
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(hotFeedList.get(i).getDeepMemberNo()).getRacMemberUid());

					// Feed
					jTempObject.put("outputFeedNo", hotFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputCategoryNo", hotFeedList.get(i).getDeepCategoryNo());
					jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(hotFeedList.get(i).getDeepCategoryNo()));
					jTempObject.put("outputFeedType", hotFeedList.get(i).getDeepFeedType());
					jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(hotFeedList.get(i).getDeepFeedType()));
					jTempObject.put("outputFeedCreateDate", CommonUtil.convertUnixTime(hotFeedList.get(i).getDeepFeedCreateDate(), 16));
					jTempObject.put("outputFeedTitle", hotFeedList.get(i).getDeepFeedNo());
					FeedCount feedCount = FeedDAO.getFeedCount(hotFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedLikeCount", feedCount.getDeepLikeCount());
					jTempObject.put("outputFeedCommentCount", feedCount.getDeepCommentCount());
					jTempObject.put("outputFeedShareCount", feedCount.getDeepShareCount());
					
					// 이 피드를 좋아요, 공유 했는지 
					jTempObject.put("outputIsFeedLike", FeedDAO.checkFeedLike(hotFeedList.get(i).getDeepFeedNo(), inputMemberNo));
					jTempObject.put("outputIsFeedShare", FeedDAO.checkFeedShare(hotFeedList.get(i).getDeepFeedNo(), inputMemberNo));

					jHotFeedArray.add(jTempObject);
				}
				// MainObject에 hotFeedList 더한다.
				jArray = jHotFeedArray;
					
			} else if(listMode == 3) {
				// Category hotFeedListByCategory
				JSONArray jHotFeedArrayByCategory = new JSONArray();

				ArrayList<FeedList> hotFeedListByCategory = FeedDAO.getFeedList(listMode, inputCategoryNo, inputParameter, inputCurrentDate);
				
				for(int i=0; i>hotFeedListByCategory.size();i++) {
					JSONObject jTempObject = new JSONObject();
					
					// 인덱스
					jTempObject.put("outpuHotFeedByCategoryNo", i+1);
					
					// Writer
					Member member = MemberDAO.getMemberByMemberNo(hotFeedListByCategory.get(i).getDeepMemberNo());
					
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(hotFeedListByCategory.get(i).getDeepMemberNo()).getRacMemberUid());

						
					// Feed
					jTempObject.put("outputFeedNo", hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputCategoryNo", hotFeedListByCategory.get(i).getDeepCategoryNo());
					jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(hotFeedListByCategory.get(i).getDeepCategoryNo()));
					jTempObject.put("outputFeedType", hotFeedListByCategory.get(i).getDeepFeedType());
					jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(hotFeedListByCategory.get(i).getDeepFeedType()));
					jTempObject.put("outputFeedTitle", hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedCreateDate", CommonUtil.convertUnixTime(hotFeedListByCategory.get(i).getDeepFeedCreateDate(), 16));

					FeedCount feedCount = FeedDAO.getFeedCount(hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedLikeCount", feedCount.getDeepLikeCount());
					jTempObject.put("outputFeedCommentCount", feedCount.getDeepCommentCount());
					jTempObject.put("outputFeedShareCount", feedCount.getDeepShareCount());
					
					// 이 피드를 좋아요, 공유 했는지 
					jTempObject.put("outputIsFeedLike", FeedDAO.checkFeedLike(hotFeedListByCategory.get(i).getDeepFeedNo(), inputMemberNo));
					jTempObject.put("outputIsFeedShare", FeedDAO.checkFeedShare(hotFeedListByCategory.get(i).getDeepFeedNo(), inputMemberNo));

					jHotFeedArrayByCategory.add(jTempObject);
				}
				// MainObject에 hotFeedList 더한다.
				jArray = jHotFeedArrayByCategory;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get FeedList OK", map);

			return jArray;
		
		} catch(Exception e) {
			return null;
		}
	}

	public static void searchFeed(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			// mode 탐색 모드 피드,글쓴이 등등///
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			String inputSearch = req.getParameter("inputSearch") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputSearch").toString()) : "";

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(mode);	
			parameterList.add(inputSearch);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}

			JSONArray jSearchFeedArray = new JSONArray();
			ArrayList<Feed> searchFeedList = FeedDAO.searchFeed(mode, inputSearch);

			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			for(int i=0; i>searchFeedList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				
				// 인덱스  - jSON은 순서가 없다.
				jTempObject.put("outputNewFeedNo", i+1);
				
				// Writer
				Member member = MemberDAO.getMemberByMemberNo(searchFeedList.get(i).getDeepMemberNo());
				jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(searchFeedList.get(i).getDeepMemberNo()).getRacMemberUid());

					
				// Feed
				jTempObject.put("outputFeedNo", searchFeedList.get(i).getDeepFeedNo());
				jTempObject.put("outputCategoryNo", searchFeedList.get(i).getDeepCategoryNo());
				jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(searchFeedList.get(i).getDeepCategoryNo()));
				jTempObject.put("outputFeedType", searchFeedList.get(i).getDeepFeedType());
				jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(searchFeedList.get(i).getDeepFeedType()));
				jTempObject.put("outputFeedCreateDate", CommonUtil.convertUnixTime(searchFeedList.get(i).getDeepFeedCreateDate(), 16));
				jTempObject.put("outputFeedTitle", searchFeedList.get(i).getDeepFeedTitle());
				
				//사진가져오기
				ArrayList<HashMap<String, Object>> outputFeedImageList = new ArrayList<HashMap<String, Object>>(); 
				if(!(searchFeedList.get(i).getDeepFeedImages().equals(""))) {
	
					String bucketName = GlobalValue.AWS_CLOUDFRONT_USER_BUCKET_URL + "/feed/" + searchFeedList.get(i).getDeepFeedNo() + "/";
					ArrayList<String> imgList = CommonUtil.commonSpiltBySemicolon(searchFeedList.get(i).getDeepFeedImages());
					for(int j=0; j<imgList.size(); j++) {
						HashMap<String, Object> outputFeedImgMap = new HashMap<String, Object>();		
						Upload upload = UploadDAO.getUploadByUploadNo(Integer.parseInt(imgList.get(j)));
						outputFeedImgMap.put("outputFeedImage", bucketName + upload.getDeepUploadEncryptFileName() +"." + upload.getDeepUploadFileExtension());
						outputFeedImageList.add(outputFeedImgMap);
					}
				}
				jTempObject.put("outputFeedImage", outputFeedImageList.get(0).get("outputMeetingImage")); // 대표 이미지
				jTempObject.put("outputFeedImageList", outputFeedImageList);
	
				jTempObject.put("outputFeedContent", searchFeedList.get(i).getDeepFeedNo());
				jTempObject.put("outputFeedLikeCount", searchFeedList.get(i).getDeepFeedNo());
				jTempObject.put("outputFeedCommentCount", searchFeedList.get(i).getDeepFeedNo());
				jTempObject.put("outputFeedShareCount", searchFeedList.get(i).getDeepFeedNo());
	
				// 해쉬태그 
				JSONArray jHashtagArray = new JSONArray();
				ArrayList<FeedHashtag> feedHashtag = FeedDAO.getFeedHashtag(searchFeedList.get(i).getDeepFeedNo());
				for(int j=0;j<feedHashtag.size();j++) {
					JSONObject jTempHashtag = new JSONObject();
					jTempHashtag.put("outputFeedHashtag", feedHashtag.get(j).getDeepFeedHashtag());
					jHashtagArray.add(jTempHashtag);
				}
				jTempObject.put("outputFeedHashtag", jHashtagArray);
				
				// 시리즈인지 
				FeedSeries feedSeries = FeedDAO.getFeedSeries(searchFeedList.get(i).getDeepFeedNo());
				if(feedSeries!=null) {
					jTempObject.put("outputIsSeries", "1");
					jTempObject.put("outputFeedSeriesId", feedSeries.getDeepFeedSeriesId());
					jTempObject.put("outputFeedSeriesOrder", feedSeries.getDeepFeedSeriesOrder());
					jTempObject.put("outputFeedSeriesName", feedSeries.getDeepFeedSeriesName());
				} else {
					jTempObject.put("outputIsSeries", "-1");
				}
				// newFeedArray에 더한다.
				jSearchFeedArray.add(jTempObject);
			}	

			jObject.put("outputSearchFeedList", jSearchFeedArray);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Search Feed OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeFeedComment(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;
			int inputFeedCommentStatus = 1;
			int inputFeedParentCommentNo = req.getParameter("inputFeedParentCommentNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedParentCommentNo").toString())) : 0;
			int inputFeedCommentDepth = req.getParameter("inputFeedCommentDepth") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedCommentDepth").toString())) : 0;
			int inputFeedCommentNotify = req.getParameter("inputFeedCommentNotify") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedCommentNotify").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;
			String inputFeedCommentContent = req.getParameter("inputFeedCommentContent") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputFeedCommentContent").toString()) : "";

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	
			parameterList.add(inputFeedParentCommentNo);	
			parameterList.add(inputFeedCommentDepth);	
			parameterList.add(inputFeedCommentNotify);	
			parameterList.add(inputFeedCommentContent);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			int check = FeedDAO.addFeedComment(inputFeedNo, sessionMemberNo, inputFeedCommentStatus, inputFeedParentCommentNo, 
					inputFeedCommentDepth, inputFeedCommentNotify, inputCurrentDate,inputFeedCommentContent);
			if(check!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Feed Comment Fail !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Feed Comment OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getFeedCommentList(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();
			
			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			JSONArray jFeedCommentList = new JSONArray();
			ArrayList<FeedComment> feedCommentList = FeedDAO.getFeedCommentList(inputFeedNo);
			if(feedCommentList!=null) {
				ArrayList<FeedComment> getCommentList = initGetComment(feedCommentList);
				
				String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

				for(int i=0; i>getCommentList.size();i++) {
					JSONObject jTempObject = new JSONObject();
	
					Member member = MemberDAO.getMemberByMemberNo(getCommentList.get(i).getDeepMemberNo());
					jTempObject.put("outputFeedCommentNo", getCommentList.get(i).getDeepFeedCommentNo());
					jTempObject.put("outputFeedNo", getCommentList.get(i).getDeepFeedNo());
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(getCommentList.get(i).getDeepMemberNo()));
					jTempObject.put("outputFeedParrentCommentNo", getCommentList.get(i).getDeepFeedParentCommentNo());
					jTempObject.put("outputFeedCommentDepth", getCommentList.get(i).getDeepFeedCommentDepth());
					jTempObject.put("outputFeedCommentNotify", getCommentList.get(i).getDeepFeedCommentNotify());
					jTempObject.put("outputFeedCommentCreateDate", CommonUtil.convertUnixTime(getCommentList.get(i).getDeepFeedCommentCreateDate(), 16));
					jTempObject.put("outputFeedCommentContent", getCommentList.get(i).getDeepFeedCommentContent());

					jTempObject.put("outputIsFeedCommentLike", FeedDAO.checkFeedCommentLike(getCommentList.get(i).getDeepFeedCommentNo(), sessionMemberNo));
					jTempObject.put("outputFeedCommentLikeCount", FeedDAO.countFeedCommentLike(getCommentList.get(i).getDeepFeedCommentNo()));

					jFeedCommentList.add(jTempObject);
				}
			}
			jObject.put("outputFeedCommentList", jFeedCommentList);

			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Feed Comment List OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<FeedComment> initGetComment(ArrayList<FeedComment> commentList){
		
		ArrayList<FeedComment> tempList = new ArrayList<FeedComment>();
		
		// 패런트가 0인 코멘트의 자식 코멘트들 찾기
		for(int i =0; i < commentList.size(); i++){
			if(commentList.get(i).getDeepFeedParentCommentNo() == 0){
				tempList.add(commentList.get(i));
				getComment(commentList, commentList.get(i).getDeepFeedCommentNo(), tempList);
			}	
		}
		return tempList;
	}
	
	private static void getComment(ArrayList<FeedComment> commentList, int commentNo, ArrayList<FeedComment> tempList){
		
		for(int i =0; i < commentList.size(); i++){
			if(commentList.get(i).getDeepFeedParentCommentNo() == commentNo){
				tempList.add(commentList.get(i));
				getComment(commentList, commentList.get(i).getDeepFeedCommentNo(), tempList);
			}
		}
	}

	public static void addFeedLike(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check feed like 
			int check = FeedDAO.checkFeedLike(inputFeedNo, sessionMemberNo);
			if(check!=0) {
				CommonUtil.commonPrintLog("FAIL", className, "Already Feed Like !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// add feed like
			int check2 = FeedDAO.addFeedLike(inputFeedNo, sessionMemberNo, inputCurrentDate);
			if(check2!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Feed Like Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Feed Like OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void cancelFeedLike(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check feed like 
			int check = FeedDAO.checkFeedLike(inputFeedNo, sessionMemberNo);
			if(check!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "No Feed Like !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			int check2 = FeedDAO.deleteFeedLike(inputFeedNo, sessionMemberNo);
			if(check2!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Cancel Feed Like Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Cancel Feed Like OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFeedCommentLike(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			int inputFeedCommentNo = req.getParameter("inputFeedCommentNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedCommentNo").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedCommentNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check feed comment like 
			int check = FeedDAO.checkFeedCommentLike(inputFeedCommentNo, sessionMemberNo);
			if(check!=0) {
				CommonUtil.commonPrintLog("FAIL", className, "Already FeedComment Like !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// add feed like
			int check2 = FeedDAO.addFeedCommentLike(inputFeedCommentNo, sessionMemberNo, inputCurrentDate);
			if(check2!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Feed Comment Like Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Feed Comment Like OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void cancelFeedCommentLike(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			int inputFeedCommentNo = req.getParameter("inputFeedCommentNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedCommentNo").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedCommentNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check feed like 
			int check = FeedDAO.checkFeedCommentLike(inputFeedCommentNo, sessionMemberNo);
			if(check!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "No Feed Comment Like !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			int check2 = FeedDAO.deleteFeedCommentLike(inputFeedCommentNo, sessionMemberNo);
			if(check2!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Cancel Feed Comment Like Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Cancel Feed Comment Like OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFeedShare(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;

			int inputFeedNo = req.getParameter("inputFeedNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFeedNo").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFeedNo);	
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Member check
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check feed share
			int check = FeedDAO.checkFeedShare(inputFeedNo, sessionMemberNo);
			if(check!=0) {
				CommonUtil.commonPrintLog("FAIL", className, "Already Feed Share !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// add feed share
			int check2 = FeedDAO.addFeedShare(inputFeedNo, sessionMemberNo, inputCurrentDate);
			if(check2!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Feed Share Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Feed Share OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
