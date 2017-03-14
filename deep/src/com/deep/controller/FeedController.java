package com.deep.controller;

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

import com.deep.config.GlobalValue;
import com.deep.model.FeedDAO;
import com.deep.model.MemberDAO;
import com.deep.model.UploadDAO;
import com.deep.model.domain.Feed;
import com.deep.model.domain.FeedHashtag;
import com.deep.model.domain.FeedList;
import com.deep.model.domain.FeedSeries;
import com.deep.model.domain.Member;
import com.deep.model.domain.MemberFavorite;
import com.deep.model.domain.Upload;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;

public class FeedController {

	public static final String className = "FeedController";

	public static void getFeed(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
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

			Feed feed = FeedDAO.getFeed(inputFeedNo);
			
			if(feed==null) {
				CommonUtil.commonPrintLog("fail", className, "No Feed", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// feed 뿌려주기.
			jObject.put("outputFeedNo", feed.getDeepFeedNo());
			jObject.put("outputMemberNo", feed.getDeepMemberNo());
			jObject.put("outputCategorydNo", feed.getDeepCategoryNo());
			jObject.put("outputFeedType", feed.getDeepFeedType());
			jObject.put("outputFeedCreateDate", feed.getDeepFeedCreateDate());
			jObject.put("outputFeedTitle", feed.getDeepFeedTitle());
			
			// Images process
			jObject.put("outputFeedImages", feed.getDeepFeedImages());
			jObject.put("outputFeedContent", feed.getDeepFeedContent());

			CommonUtil.commonPrintLog("SUCCESS", className, "Get Feed OK", map);
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
			
			int check = 0;
			
			if(mode == 1) {
				inputFeedStatus = 1;
				FeedDAO.addFeed(sessionMemberNo, inputCategoryNo, inputFeedStatus, inputFeedType, inputCurrentDate, inputFeedTitle, inputFeedImages, inputFeedContent);
			} else {
				inputFeedStatus = 3;
				FeedDAO.addFeed(sessionMemberNo, inputCategoryNo, inputFeedStatus, inputFeedType, inputCurrentDate, inputFeedTitle, inputFeedImages, inputFeedContent);
			}
				
			if(check!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "Add Feed Fail!!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
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

	public static JSONArray getFeedList(int listMode, int inputCategoryNo, int inputParameter, long inputCurrentDate, String aesKey) {
		
		HashMap<String, String> map = new HashMap<String, String>();

		JSONArray jArray = new JSONArray();
		
		try {
			if(listMode==1) {
				// 새로운 피드 리스트를 띄워준다. Param =inputCategoryNo  DAO로 가져온다.
				JSONArray jNewFeedArray = new JSONArray();
				ArrayList<FeedList> newFeedList = FeedDAO.getFeedList(listMode, inputCategoryNo, inputParameter, inputCurrentDate);
				
				for(int i=0; i>newFeedList.size();i++) {
					JSONObject jTempObject = new JSONObject();
					
					// 인덱스  - jSON은 순서가 없다.
					jTempObject.put("outputNewFeedNo", i+1);
					
					// Writer
					Member member = MemberDAO.getMemberByMemberNo(newFeedList.get(i).getDeepMemberNo());
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(newFeedList.get(i).getDeepMemberNo()).getDeepMemberUid());
					jTempObject.put("outputMemberName", EncryptUtil.AES_Decode(member.getDeepMemberName(), aesKey));
					jTempObject.put("outputMemberImage", MemberController.getMemberImage(member.getDeepMemberImage()));
						
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
					jTempObject.put("outputFeedLikeCount", newFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedCommentCount", newFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedShareCount", newFeedList.get(i).getDeepFeedNo());
		
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
					
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(hotFeedList.get(i).getDeepMemberNo()).getDeepMemberUid());
					jTempObject.put("outputMemberName", EncryptUtil.AES_Decode(member.getDeepMemberName(), aesKey));
					jTempObject.put("outputMemberImage", MemberController.getMemberImage(member.getDeepMemberImage()));
						
					// Feed
					jTempObject.put("outputFeedNo", hotFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputCategoryNo", hotFeedList.get(i).getDeepCategoryNo());
					jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(hotFeedList.get(i).getDeepCategoryNo()));
					jTempObject.put("outputFeedType", hotFeedList.get(i).getDeepFeedType());
					jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(hotFeedList.get(i).getDeepFeedType()));
					jTempObject.put("outputFeedTitle", hotFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedLikeCount", hotFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedCommentCount", hotFeedList.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedShareCount", hotFeedList.get(i).getDeepFeedNo());
				
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
					
					jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(hotFeedListByCategory.get(i).getDeepMemberNo()).getDeepMemberUid());
					jTempObject.put("outputMemberName", EncryptUtil.AES_Decode(member.getDeepMemberName(), aesKey));
					jTempObject.put("outputMemberImage", MemberController.getMemberImage(member.getDeepMemberImage()));
						
					// Feed
					jTempObject.put("outputFeedNo", hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputCategoryNo", hotFeedListByCategory.get(i).getDeepCategoryNo());
					jTempObject.put("outputCategoryName", CommonUtil.getCategoryName(hotFeedListByCategory.get(i).getDeepCategoryNo()));
					jTempObject.put("outputFeedType", hotFeedListByCategory.get(i).getDeepFeedType());
					jTempObject.put("outputFeedTypeName", CommonUtil.getFeedTypeName(hotFeedListByCategory.get(i).getDeepFeedType()));
					jTempObject.put("outputFeedTitle", hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedLikeCount", hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedCommentCount", hotFeedListByCategory.get(i).getDeepFeedNo());
					jTempObject.put("outputFeedShareCount", hotFeedListByCategory.get(i).getDeepFeedNo());
				
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
			ArrayList<FeedList> searchFeedList = FeedDAO.searchFeed(mode, inputSearch);

			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			for(int i=0; i>searchFeedList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				
				// 인덱스  - jSON은 순서가 없다.
				jTempObject.put("outputNewFeedNo", i+1);
				
				// Writer
				Member member = MemberDAO.getMemberByMemberNo(searchFeedList.get(i).getDeepMemberNo());
				jTempObject.put("outputMemberUid", MemberDAO.getMemberUid(searchFeedList.get(i).getDeepMemberNo()).getDeepMemberUid());
				jTempObject.put("outputMemberName", EncryptUtil.AES_Decode(member.getDeepMemberName(), aesKey));
				jTempObject.put("outputMemberImage", MemberController.getMemberImage(member.getDeepMemberImage()));
					
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
}
