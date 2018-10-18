package com.rancre.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.rancre.model.MemberDAO;
import com.rancre.model.domain.MemberFavorite;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

public class BlogController {

	private static final String className = "BlogController";
	
	public static void initBlog(HttpServletRequest req, HttpServletResponse res) {
		
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
			jNewFeedArray = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, sessionMemberNo, inputCurrentDate, aesKey);

			// MainObject에 newFeedList 더한다.
			jMainObject.put("outputNewFeedList", jNewFeedArray);
			
			// 인기있는 피드 리스트 - 제목 분야 글쓴이
			JSONArray jHotFeedArray = new JSONArray();
			listMode = 2;
			if(!(sessionMemberNo>0)) {
				inputHotFeedCount = 20;
				jHotFeedArray = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, sessionMemberNo, inputCurrentDate, aesKey);
				
				// MainObject에 hotFeedList 더한다.
				jMainObject.put("outputHotFeedList", jHotFeedArray);
				
			} else { //로그인 되있는 경우 hotFeedList와 hotFeedListByCategory를 둘 다 가져온다.
				inputHotFeedCount = 10;
				jHotFeedArray = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, sessionMemberNo, inputCurrentDate, aesKey);
				
				jMainObject.put("outputHotFeedList", jHotFeedArray);
				
				// Category hotFeedListByCategory
				JSONArray jHotFeedArrayByCategory = new JSONArray();

				listMode = 3;
				jHotFeedArrayByCategory = FeedController.getFeedList(listMode, inputCategoryNo, inputHotFeedCount, sessionMemberNo, inputCurrentDate, aesKey);

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

}
