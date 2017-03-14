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
import com.deep.model.domain.FeedHashtag;
import com.deep.model.domain.FeedList;
import com.deep.model.domain.FeedSeries;
import com.deep.model.domain.Member;
import com.deep.model.domain.MemberFavorite;
import com.deep.model.domain.Upload;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;

public class CommonController {
	
	private static final String className = "CommonController";
	private static final int KEY_SIZE = 1024;
	
	public static void initMain(HttpServletRequest req, HttpServletResponse res) {
	
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			int inputCategoryNo = 1;
			int inputNextFeedNo = 0;
			int listMode = 0; 	// FeedList Mode  1 : newFeedList , 2 : bestFeedListByALl, 3 : bestFeedListByCategory
			int inputHotFeedCount = 0; 	// HotFeed를 가져올 갯수  - 멤버면 10개, 방문자면 20개.
			long inputCurrentDate = System.currentTimeMillis()/1000;
			JSONObject jMainObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			if(sessionMemberNo>0) {
				MemberFavorite memberFavorite = MemberDAO.getMemberFavorite(sessionMemberNo);
				inputCategoryNo = memberFavorite.getDeepCategoryNo();
			}
			
			// 새로운 피드 리스트를 띄워준다. Param =inputCategoryNo  DAO로 가져온다.
			JSONArray jNewFeedArray = new JSONArray();
			listMode = 1;
			jNewFeedArray = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, inputCurrentDate, aesKey);

			// MainObject에 newFeedList 더한다.
			jMainObject.put("outputNewFeedList", jNewFeedArray);
			
			// 인기있는 피드 리스트 - 제목 분야 글쓴이
			JSONArray jHotFeedArray = new JSONArray();
			listMode = 2;
			if(!(sessionMemberNo>0)) {
				inputHotFeedCount = 20;
				jHotFeedArray = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, inputCurrentDate, aesKey);
				
				// MainObject에 hotFeedList 더한다.
				jMainObject.put("outputHotFeedList", jHotFeedArray);
				
			} else { //로그인 되있는 경우 hotFeedList와 hotFeedListByCategory를 둘 다 가져온다.
				inputHotFeedCount = 10;
				jHotFeedArray = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, inputCurrentDate, aesKey);
				
				jMainObject.put("outputHotFeedList", jHotFeedArray);
				
				// Category hotFeedListByCategory
				JSONArray jHotFeedArrayByCategory = new JSONArray();

				listMode = 3;
				jHotFeedArrayByCategory = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, inputCurrentDate, aesKey);

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

	public static void getMyPage(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// 회원인지 확인
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 회정정보를 가져온다
			Member memberNo = MemberDAO.getMemberByMemberNo(sessionMemberNo);
			jObject.put("outputMemberLevel", memberNo.getDeepMemberLevel());
			jObject.put("outputMemberMajor", memberNo.getDeepMemberMajor());
			jObject.put("outputMemberCareer", memberNo.getDeepMemberCareer());
			jObject.put("outputMemberEmail", memberNo.getDeepMemberEmail());
			jObject.put("outputMemberName", memberNo.getDeepMemberName());
			jObject.put("outputMemberImage", MemberController.getMemberImage(memberNo.getDeepMemberImage()));

			// Blog/Feed 정보
			
			// 팔로우 수			
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "My Page OK", map);
			res.getWriter().write(jObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
