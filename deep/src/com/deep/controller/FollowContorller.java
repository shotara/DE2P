package com.deep.controller;

import java.io.File;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.deep.config.GlobalValue;
import com.deep.model.FollowDAO;
import com.deep.model.MemberDAO;
import com.deep.model.NoticeDAO;
import com.deep.model.domain.Follow;
import com.deep.model.domain.Member;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
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
			
			//공격 방어(파라미터 체크)
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
		// 로그인과 팔로워같은지 확인해줘야하나? (일단안해놈)
		// 회원이면 No가져오고 아니면 리턴
		if(!(sessionMemberNo>0)) {
			CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return 1;
		}
		int followerMemberNo = FollowDAO.getFollower(sessionMemberNo);
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
			// sessionMemberNo 로그인 정보, 
			
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
				return 1;
			}
			
			// DAO
			// 회원이면 No가져오고 아니면 리턴
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}
			int followingMemberNo = FollowDAO.getFollowing(sessionMemberNo);
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
			// 회원이인지
			if(!(sessionMemberNo>0)) {
			CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return;
			}
			
			//UID -> No로 
			if(!(MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollowing))>0)) {
				map.put("USER-NO", Integer.toString(inputFollowing));
				CommonUtil.commonPrintLog("FAIL", className, "DB Fail - Update (deleteFollowing)", map);
				res.getWriter().write("-2");
				return;				
			}
			int followingMemberNo = MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollowing));
			
			//팔로윙 삭제. 
			if(!FollowDAO.setFollow(followingMemberNo)) {
				map.put("USER-NO", Integer.toString(followingMemberNo));
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
			int inputNoticeCategory = 4;
			int inputNoticeStatus = 1; // 미확인
			long inputCurrentDate = System.currentTimeMillis()/1000;
			int inputFollowing = req.getParameter("inputFollowingUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowingUid").toString())) : 0;				
			int inputFollower = req.getParameter("inputFollowerUid") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputFollowerUid").toString())) : 0;
			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check
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
			// 회원이인지
			if(!(sessionMemberNo>0)) {
			CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return;
			}
			
			//UID -> No로 
			if(!(MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollowing))>0)) {
				map.put("USER-NO", Integer.toString(inputFollowing));
				CommonUtil.commonPrintLog("FAIL", className, "DB Fail - Update (deleteFollowing)", map);
				res.getWriter().write("-2");
				return;				
			}
			
			if(!(MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollower))>0)) {
				map.put("USER-NO", Integer.toString(inputFollowing));
				CommonUtil.commonPrintLog("FAIL", className, "DB Fail - Update (deleteFollower)", map);
				res.getWriter().write("-2");
				return;				
			}
			int followingMemberNo = MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollowing));
			int followerMemberNo = MemberDAO.getMemberNoByMemberUid(Integer.toString(inputFollower));
			
			//이미 팔로우가 되어 있으면 예외처리. (01, 10)?
			if(followingMemberNo == FollowDAO.getFollowing(sessionMemberNo)){
				map.put("USER-NO", Integer.toString(followingMemberNo));
				CommonUtil.commonPrintLog("FAIL", className, "already following exists", map);
				res.getWriter().write("-2");
				return;				
			}
			FollowDAO.addFollow(followerMemberNo, followingMemberNo);
			NoticeDAO.addNotice(inputNoticeCategory, inputFollower, inputFollowing, inputNoticeStatus, inputCurrentDate);
					
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
}
