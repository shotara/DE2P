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

import com.deep.model.FeedDAO;
import com.deep.model.MemberDAO;
import com.deep.model.domain.FeedHashtag;
import com.deep.model.domain.FeedList;
import com.deep.model.domain.FeedSeries;
import com.deep.model.domain.Member;
import com.deep.model.domain.MemberFavorite;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;

public class CommonController {
	
	private static final String className = "CommonController";
	private static final int KEY_SIZE = 1024;
	
	public static void initMain(HttpServletRequest req, HttpServletResponse res) {
	
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("hbiMemberNo") != null ? Integer.parseInt(session.getAttribute("hbiMemberNo").toString()) : 0;
			int inputFeedCategory = 1;
			int inputNextFeedNo = 0;
			int listMode = 0; 	// FeedList Mode  1 : newFeedList , 2 : bestFeedListByALl, 3 : bestFeedListByCategory
			int inputHotFeedCount = 0; 	// HotFeed를 가져올 갯수  - 멤버면 10개, 방문자면 20개.
			long inputCurrentDate = System.currentTimeMillis()/1000;
			JSONObject jMainObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			if(!(sessionMemberNo>0)) {
				MemberFavorite memberFavorite = MemberDAO.getMemberFavorite(sessionMemberNo);
				inputFeedCategory = memberFavorite.getDeepCategoryNo();
			}
			
			// 새로운 피드 리스트를 띄워준다. Param =inputFeedCategory  DAO로 가져온다.
			JSONArray jNewFeedArray = new JSONArray();
			listMode = 1;
			ArrayList<FeedList> newFeedList = FeedDAO.getFeedList(listMode, inputFeedCategory, inputNextFeedNo, inputCurrentDate);
			
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
				jTempObject.put("outputFeedTitle", newFeedList.get(i).getDeepFeedNo());
				
				//사진가져오기 1개 or 2개 
				jTempObject.put("outputFeedImages", newFeedList.get(i).getDeepFeedNo());
				
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
			jMainObject.put("outputNewFeedList", jNewFeedArray);
			
			// 인기있는 피드 리스트 - 제목 분야 글쓴이
			JSONArray jHotFeedArray = new JSONArray();
			listMode = 2;
			if(!(sessionMemberNo>0)) {
				inputHotFeedCount = 20;
				ArrayList<FeedList> hotFeedList = FeedDAO.getFeedList(listMode, inputFeedCategory, inputHotFeedCount, inputCurrentDate);
				
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
				jMainObject.put("outputHotFeedList", jHotFeedArray);
				
			} else { //로그인 되있는 경우 hotFeedList와 hotFeedListByCategory를 둘 다 가져온다.
				inputHotFeedCount = 10;
				ArrayList<FeedList> hotFeedList = FeedDAO.getFeedList(listMode, inputFeedCategory, inputHotFeedCount, inputCurrentDate);
				
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
				jMainObject.put("outputHotFeedList", jHotFeedArray);
				
				// Category hotFeedListByCategory
				JSONArray jHotFeedArrayByCategory = new JSONArray();

				listMode = 3;
				ArrayList<FeedList> hotFeedListByCategory = FeedDAO.getFeedList(listMode, inputFeedCategory, inputHotFeedCount, inputCurrentDate);
				
				for(int i=0; i>hotFeedList.size();i++) {
					JSONObject jTempObject = new JSONObject();
					
					// 인덱스
					jTempObject.put("outpuHotFeedByCategoryNo", i+1);
					
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
				
					jHotFeedArrayByCategory.add(jTempObject);
				}
				// MainObject에 hotFeedList 더한다.
				jMainObject.put("outputHotFeedByCategoryList", jHotFeedArrayByCategory);
			}
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Init Main OK", map);
			res.getWriter().write(jMainObject.toString());
			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getRSAPublicKey(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {			
			// 키 생성
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(KEY_SIZE);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			// 공개키를 문자열로 변환하여 JavaScript RSA 라이브러리 넘겨준다.
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec privateSpec = (RSAPrivateKeySpec)keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
						
			String privateKeyModulus = privateSpec.getModulus().toString(16);
			String privateKeyExponent = privateSpec.getPrivateExponent().toString(16);
			
			// JSON 오브젝트에 저장한 후 리턴
			JSONObject jObject = new JSONObject();
			jObject.put("hbiPublicKeyModulus", publicKeyModulus);
			jObject.put("hbiPublicKeyExponent", publicKeyExponent);

			HttpSession session = req.getSession();
			session.setAttribute("PrivateKey", privateKey);				
	
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			CommonUtil.commonPrintLog("SUCCESS", className, "PublicKey Generation OK", map);
			res.getWriter().write(jObject.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
