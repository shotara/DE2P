package com.deep.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.deep.model.FollowDAO;
import com.deep.model.MemberDAO;
import com.deep.model.NoticeDAO;
import com.deep.model.domain.Follow;
import com.deep.model.domain.Member;
import com.deep.util.CommonUtil;


public class FollowContorller {

	public static final String className = "FollowController";
	
	public static int getFollower(HttpServletRequest req, HttpServletResponse res)
	{
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();
			int inputFollower = req.getParameter("inputFollowerUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowerUid").toString())) : null;
			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			//Attack defense(Parameter Check)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFollower);
			parameterList.add(sessionMemberNo);
			
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}
		
		
	//DAO
		// loginPerson is Member? (로그인한 사람이 회원이니?)
		if(!(sessionMemberNo>0)) {
			CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return 1;
		}
		
		//loginPerson is Follower ? (로그인 한사람과 팔로워가 같은가?)
		int tempFollowerMemberNo = MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollower)); //MemberUID change to MemberNo
		if((tempFollowerMemberNo==0) && (sessionMemberNo != tempFollowerMemberNo) ) {
			map.put("USER-NO", Integer.toString(tempFollowerMemberNo));
			CommonUtil.commonPrintLog("FAIL", className, "No change FollowerMemberNo or FollowerMemberNo and sessionNo is not equal", map);
			res.getWriter().write("-2");
			return 1;				
		}
		
		// 위 두가지 조건이 맞으면 DAO실행
		int followerMemberNo = FollowDAO.getFollower(inputFollower).getDeepFollower();
		return followerMemberNo;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getFollowing(HttpServletRequest req, HttpServletResponse res){
		HashMap<String, String> map = new HashMap<String, String>();
		
		try	{
			HttpSession session = req.getSession();
			
			int inputFollowing = req.getParameter("inputFollowingUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowingUid").toString())) : 0;				
			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Attack defense(Parameter check)
			ArrayList<Object> parameterList = new ArrayList<Object>();
		    parameterList.add(inputFollowing);
			parameterList.add(sessionMemberNo);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}
			
	// DAO
			// loginPerson is Member? 
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}
			
			int followingMemberNo = FollowDAO.getFollowing(inputFollowing).getDeepFollowing();
			return followingMemberNo;
			//CommonUtil.commonPrintLog("SUCCESS", className, "get Following OK", map);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	
	}

	//delete
	public static void setFollow(HttpServletRequest req, HttpServletResponse res){
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();
			int inputFollowing = req.getParameter("inputFollowingUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowingUid").toString())) : 0;				
			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputFollowing);
			parameterList.add(sessionMemberNo);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

		// DAO
			// Member or not?
			if(!(sessionMemberNo>0)) {
			CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return;
			}
			
			//Delete following
			if(!FollowDAO.setFollow(inputFollowing)) { 
				map.put("USER-NO", Integer.toString(inputFollowing));
				CommonUtil.commonPrintLog("FAIL", className, "DB Fail - Update (deleteFollowing)", map);
				res.getWriter().write("-2");
				return;				
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Delete Following OK", map);
			res.getWriter().write("1");
			return;
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void addFollow(HttpServletRequest req, HttpServletResponse res){
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();
			//when add follow, let set notice
			int inputNoticeCategory = 4;  // temp
			int inputNoticeStatus = 1; // unconfirmed 
			long inputCurrentDate = System.currentTimeMillis()/1000; 
			int inputFollowing = req.getParameter("inputFollowingUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowingUid").toString())) : 0;				
			int inputFollower = req.getParameter("inputFollowerUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowerUid").toString())) : 0;
			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check(Attack Defense)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeCategory);
			parameterList.add(inputFollowing);
			parameterList.add(inputFollower);
			parameterList.add(inputNoticeStatus);
			parameterList.add(inputCurrentDate);
			parameterList.add(sessionMemberNo);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			
		// DAO
			//1.  Member or not??
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;	
			}
			
			
		//2. UID -> Number, after Check(loginMember equal Follower?)
			// following(change No)
			int followingMemberNo = MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollowing));
			if(followingMemberNo==0) {
				map.put("USER-NO", Integer.toString(inputFollowing));
				CommonUtil.commonPrintLog("FAIL", className, "No change FollowingMemberNo", map);
				res.getWriter().write("-2");
				return;				
			}
			// follower(change No)
			int followerMemberNo = MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollower));
		    // UID->No change && loginMember is follower?
			if((followerMemberNo==0) && (sessionMemberNo != followerMemberNo)) {
				map.put("USER-NO", Integer.toString(inputFollower));
				CommonUtil.commonPrintLog("FAIL", className, "No change FollowerMemberNo or FollowerMemberNo and sessionNo is not equal", map);
				res.getWriter().write("-2");
				return;				
			}
			
		// 3. check, already follow 
			if(FollowDAO.getFollowing(inputFollowing).getDeepFollowing() < 0){
				map.put("USER-NO", Integer.toString(inputFollowing));
				CommonUtil.commonPrintLog("FAIL", className, "already Following exist", map);
				res.getWriter().write("-2");
				return;				
			}
			FollowDAO.addFollow(inputFollower, inputFollowing); //uid로 넘김
			NoticeDAO.addNotice(inputNoticeCategory, followerMemberNo, followingMemberNo, inputNoticeStatus, inputCurrentDate); //No로 넘김
					
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
}
