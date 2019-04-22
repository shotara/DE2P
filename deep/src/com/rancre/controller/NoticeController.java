package com.rancre.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.rancre.model.MemberDAO;
import com.rancre.model.NoticeDAO;
import com.rancre.model.domain.Notice;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

import java.util.List;


public class NoticeController {

	public static final String className = "NoticeController";

	public static void listNotice(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			long inputCurrentDate = System.currentTimeMillis()/1000;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			ArrayList<Notice> noticeList = new ArrayList<Notice>();
			noticeList = NoticeDAO.getNoticeList(sessionMemberNo);
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			int notConfirmNotice = 0;
			JSONArray jNoticeList = new JSONArray(); 
			for(int i=0; i<noticeList.size(); i++) {
				JSONObject tempNotice = new JSONObject();
								
				tempNotice.put("outputNoticeNo", noticeList.get(i).getDeepNoticeNo());
				tempNotice.put("outputNoticeCategory", noticeList.get(i).getDeepNoticeCategory());
				tempNotice.put("outputNoticeTarget1", noticeList.get(i).getDeepNoticeTarget1());
				tempNotice.put("outputNoticeTarget2", noticeList.get(i).getDeepNoticeTarget2());
				tempNotice.put("outputNoticeStatus", noticeList.get(i).getDeepNoticeStatus());	
				// 미확인상태인 것 확인으로 바꾸
				if(noticeList.get(i).getDeepNoticeStatus()==1) {
					notConfirmNotice++;
					NoticeDAO.setNotice(noticeList.get(i).getDeepNoticeNo(), 2, inputCurrentDate);
				}
				tempNotice.put("outputNoticeMessage", getNoticeMessage(noticeList.get(i).getDeepNoticeCategory(), noticeList.get(i).getDeepNoticeTarget1(), noticeList.get(i).getDeepNoticeTarget2(), aesKey));
				tempNotice.put("outputNoticeCreateDate", CommonUtil.convertUnixTime(noticeList.get(i).getDeepNoticeCreateDate(), 16));

				jNoticeList.add(tempNotice);
			}
			
			jObject.put("outputNoConfirmNotice", notConfirmNotice);
			jObject.put("outputNoticeList", jNoticeList);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Notice List OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addNotice(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			// categort1 : 팔로우를 할떄, 2 : 댓글을 달때, 3 : 댓글에 댓글을 달때, 4 : 좋아요를 할떄, 5 : 팔로우한 사람이 글을 남길
			int inputNoticeCategory = req.getParameter("inputNoticeCategory") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeCategory").toString())) : 0;
			int inputNoticeTarget1 = req.getParameter("inputNoticeTarget1") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeTarget1").toString())) : 0;
			int inputNoticeTarget2 = req.getParameter("inputNoticeTarget2") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeTarget2").toString())) : 0;
			int inputNoticeStatus = 1;
			long inputCurrentDate = System.currentTimeMillis()/1000;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check(Attack Defense)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeCategory);
			parameterList.add(inputNoticeTarget1);
			parameterList.add(inputNoticeTarget2);
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

			// add Notice
			int check=0;
			check = NoticeDAO.addNotice(inputNoticeCategory, sessionMemberNo, inputNoticeTarget1, inputNoticeTarget2, inputNoticeStatus, inputCurrentDate);
			if(check!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Notice Follow !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Notice OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void setNotice(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			// 1 : 확인 , 2 : 삭제 
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			int inputNoticeNo = req.getParameter("inputNoticeNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;
			int inputNoticeStatus;
			long inputCurrentDate = System.currentTimeMillis()/1000;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check(Attack Defense)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(mode);
			parameterList.add(inputNoticeNo);
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

			// check Notice
			int check=0;
			check = NoticeDAO.checkNotice(inputNoticeNo);
			if(check!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "No Notice !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// set Notice
			int check2=0;
			if(mode==1) inputNoticeStatus=2;
			else inputNoticeStatus=3;
			
			check2 = NoticeDAO.setNotice(inputNoticeNo, inputNoticeStatus, inputCurrentDate);
			if(check2!=1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Notice Follow !!!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Add Notice OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getNotice(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
			int inputNoticeNo = req.getParameter("inputNoticeNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
		
			// Parameter check(Attack Defense)
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
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

			// check Notice
			Notice notice = NoticeDAO.getNotice(inputNoticeNo);
			if(notice==null) {
				CommonUtil.commonPrintLog("FAIL", className, "No Notice !!!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}

			jObject.put("outputNoticeNo", notice.getDeepNoticeNo());
			jObject.put("outputNoticeCategory", notice.getDeepNoticeCategory());
			jObject.put("outputNoticeTarget1", notice.getDeepNoticeTarget1());
			jObject.put("outputNoticeTarget2", notice.getDeepNoticeTarget2());
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Notice OK", map);
			res.getWriter().write(jObject.toString());
			return;			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void countNotice(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
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

			// count Notice
			int check = NoticeDAO.countNotice(sessionMemberNo);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Count Notice OK", map);
			jObject.put("outputNoConfirmNotice", check);
			res.getWriter().write(jObject.toString());
			return;			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getNoticeMessage(int noticeCategory, int noticeTarget1, int noticeTarget2, String aesKey) {
		
		try {
			String notice = null;
//			
//			switch(noticeCategory) {
//			case 1:
//				notice = EncryptUtil.AES_Decode(MemberDAO.getMemberByMemberNo(noticeTarget1).getDeepMemberName(),aesKey) + 
//					"님이 회원님을 팔로우하기 시작했습니다.";
//				break;
//			case 2:
//				notice = EncryptUtil.AES_Decode(MemberDAO.getMemberByMemberNo(noticeTarget1).getDeepMemberName(),aesKey) + 
//					"님이 " + CommonUtil.splitString(FeedDAO.getFeed(noticeTarget2).getDeepFeedTitle(), 1) + "글에 댓글을 달았습니다.";
//				break;
//			case 3:				
//				notice = EncryptUtil.AES_Decode(MemberDAO.getMemberByMemberNo(noticeTarget1).getDeepMemberName(),aesKey) + 
//					"님이 " + CommonUtil.splitString(FeedDAO.getFeedComment(noticeTarget2), 1) + "댓글에 댓글을 달았습니다.";
//				break;
//			case 4:
//				notice = EncryptUtil.AES_Decode(MemberDAO.getMemberByMemberNo(noticeTarget1).getDeepMemberName(),aesKey) + 
//					"님이 " + CommonUtil.splitString(FeedDAO.getFeed(noticeTarget2).getDeepFeedTitle(), 1) + "글을 좋아합니다.";
//				break;
//			case 5:
//				notice = "회원님이 팔로우하는 " + EncryptUtil.AES_Decode(MemberDAO.getMemberByMemberNo(noticeTarget1).getDeepMemberName(),aesKey) + 
//					"님이 " + CommonUtil.splitString(FeedDAO.getFeed(noticeTarget2).getDeepFeedTitle(), 1) + "글을 작성했습니다.";
//				break;
//			}
//			
			return notice;
		
		} catch(Exception e) {			
			return "-1";
		}
	}
}
