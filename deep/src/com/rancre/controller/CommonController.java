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
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.MemberFavorite;
import com.rancre.model.domain.RankCategory;
import com.rancre.model.domain.RankTop;
import com.rancre.model.domain.Upload;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

public class CommonController {
	
	private static final String className = "CommonController";
	private static final int KEY_SIZE = 1024;
	
	public static void initMain(HttpServletRequest req, HttpServletResponse res) {
	
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Init Main OK", map);
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
			jObject.put("deepPublicKeyModulus", publicKeyModulus);
			jObject.put("deepPublicKeyExponent", publicKeyExponent);

			HttpSession session = req.getSession();
			session.setAttribute("PrivateKey", privateKey);				
	
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			CommonUtil.commonPrintLog("SUCCESS", className, "PublicKey Generation OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
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
//			Member memberNo = MemberDAO.getMemberByMemberNo(sessionMemberNo);
//			jObject.put("outputMemberLevel", memberNo.getDeepMemberLevel());
//			jObject.put("outputMemberMajor", memberNo.getDeepMemberMajor());
//			jObject.put("outputMemberCareer", memberNo.getDeepMemberCareer());
//			jObject.put("outputMemberEmail", memberNo.getDeepMemberEmail());
//			jObject.put("outputMemberName", memberNo.getDeepMemberName());
//			jObject.put("outputMemberImage", MemberController.getMemberImage(memberNo.getDeepMemberImage()));
//
//			// Blog/Feed 정보
			
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
				ArrayList<RankTop> ranking = ChannelDAO.getRankingList(categoryNo);
				for(int i=0; i<ranking.size(); i++) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("outputRankTopNo", ranking.get(i).getRacRankTopNo());
					tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());
					tempObject.put("outputCategoryNo", ranking.get(i).getRacCategoryNo());
					tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
					tempObject.put("outputChannelTitle", ranking.get(i).getRacChannelTitle());
					tempObject.put("outputChannelFollowers", ranking.get(i).getRacChannelFollowers());
					tempObject.put("outputChannelViews", ranking.get(i).getRacChannelViews());
					tempObject.put("outputChannelVideoCount", ranking.get(i).getRacChannelVideoCount());
					tempObject.put("outputChannelThumbnail", ranking.get(i).getRacChannelThumbnail());
					
					rankingList.add(tempObject);
				}
			}
			else {
				ArrayList<RankCategory> ranking = ChannelDAO.getRankingList2(mode, startNo, categoryNo);
				for(int i=0; i<ranking.size(); i++) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());
					tempObject.put("outputCategoryNo", ranking.get(i).getRacCategoryNo());
					tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
					tempObject.put("outputChannelTitle", ranking.get(i).getRacChannelTitle());
					tempObject.put("outputChannelFollowers", ranking.get(i).getRacChannelFollowers());
					tempObject.put("outputChannelViews", ranking.get(i).getRacChannelViews());
					tempObject.put("outputChannelVideoCount", ranking.get(i).getRacChannelVideoCount());
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
