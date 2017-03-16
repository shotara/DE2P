package com.deep.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.deep.model.FollowDAO;
import com.deep.model.MemberDAO;
import com.deep.model.NoticeDAO;
import com.deep.model.domain.Follow;
import com.deep.model.domain.FollowMember;
import com.deep.model.domain.Member;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;


public class FollowContorller {

	public static final String className = "FollowController";
	
	public static void getFollower(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : "";
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			//Attack defense(Parameter Check)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberUid);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}

			int inputMemberNo = MemberDAO.getMemberNoByMemberUid(inputMemberUid);
			
			ArrayList<FollowMember> followList = new ArrayList<FollowMember>();
			followList = FollowDAO.getFollower(inputMemberNo);
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			JSONArray jFollowerList = new JSONArray(); 
			for(int i=0; i<followList.size(); i++) {
				JSONObject tempFollower = new JSONObject();
								
				tempFollower.put("outputFollowerName", EncryptUtil.AES_Decode(followList.get(i).getDeepMemberName(),aesKey));
				tempFollower.put("outputFollowerImage", followList.get(i).getDeepMemberImage());
				tempFollower.put("outputFollowerUid", followList.get(i).getDeepMemberUid());
				
				jFollowerList.add(tempFollower);
			}
			
			jObject.put("outputFollowerCount", jFollowerList.size());
			jObject.put("outputFollowerList", jFollowerList);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Follower OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getFollowing(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : "";
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			//Attack defense(Parameter Check)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberUid);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}

			int inputMemberNo = MemberDAO.getMemberNoByMemberUid(inputMemberUid);
			
			ArrayList<FollowMember> followList = new ArrayList<FollowMember>();
			followList = FollowDAO.getFollowing(inputMemberNo);
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			JSONArray jFollowingList = new JSONArray(); 
			for(int i=0; i<followList.size(); i++) {
				JSONObject tempFollowing = new JSONObject();
								
				tempFollowing.put("outputFollowingName", EncryptUtil.AES_Decode(followList.get(i).getDeepMemberName(),aesKey));
				tempFollowing.put("outputFollowingImage", followList.get(i).getDeepMemberImage());
				tempFollowing.put("outputFollowingUid", followList.get(i).getDeepMemberUid());
				
				jFollowingList.add(tempFollowing);
			}
			
			jObject.put("outputFollowingCount", jFollowingList.size());
			jObject.put("outputFollowingList", jFollowingList);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Following OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFollow(HttpServletRequest req, HttpServletResponse res){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : "";
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check(Attack Defense)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberUid);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}

			// check follow 
			int check=0;
			int inputMemberNo = MemberDAO.getMemberNoByMemberUid(inputMemberUid);
			
			check = FollowDAO.checkFollow(sessionMemberNo, inputMemberNo);
			if(check!=0) {
				CommonUtil.commonPrintLog("FAIL", className, "Already Follow !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// add Follow
			int check2=0;
			check2 = FollowDAO.addFollow(sessionMemberNo, inputMemberNo);
			if(check2!=0) {
				CommonUtil.commonPrintLog("ERROR", className, "Add Follow Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Follow OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void cancelFollow(HttpServletRequest req, HttpServletResponse res){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : "";
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check(Attack Defense)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberUid);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}

			// check follow 
			int check=0;
			int inputMemberNo = MemberDAO.getMemberNoByMemberUid(inputMemberUid);
			
			check = FollowDAO.checkFollow(sessionMemberNo, inputMemberNo);
			if(check!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "No Follow !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// delete Follow
			int check2=0;
			check2 = FollowDAO.deleteFollow(sessionMemberNo, inputMemberNo);
			if(check2!=0) {
				CommonUtil.commonPrintLog("ERROR", className, "Cancel Follow Fail !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Cancel Follow OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void countFollow(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : "";
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			//Attack defense(Parameter Check)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberUid);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			int inputMemberNo = MemberDAO.getMemberNoByMemberUid(inputMemberUid);
			
			Follow follow = FollowDAO.countFollow(inputMemberNo);
			
			
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Following OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
