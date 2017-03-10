package com.deep.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import com.deep.model.NoticeDAO;
import com.deep.model.domain.Notice;
import com.deep.util.CommonUtil;
import java.util.List;


public class NoticeController {

	public static final String className = "NoticeController";

	public static int listNotice(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();
			int inputMemberNo = req.getParameter("inputMemberNo") != null
					? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputMemberNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberNo);

			if (!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}

			// 로그인한 사람이 회원인지 아닌지 체크해야하나?

			// DAO
			Notice noticelist = NoticeDAO.getNoticelist(inputMemberNo);

			if (noticelist == null) { // when no Notice
				CommonUtil.commonPrintLog("FAIL", className, "No NoticeList", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return 1;
			}

			return noticelist.getDeepMemberNo();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return 1;

	}

	public static int getNotice(HttpServletRequest req, HttpServletResponse res) {
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();
			int inputNoticeNo = req.getParameter("inputNoticeNo") != null
					? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;
//			int inputNoticeStatus = 2; // confirm
//			long inputConfirmDate = System.currentTimeMillis() / 1000;
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
//			parameterList.add(inputNoticeStatus);
//			parameterList.add(inputConfirmDate);

			if (!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}

			Notice noticeOne = NoticeDAO.getNotice(inputNoticeNo);
			if (noticeOne == null) {
				CommonUtil.commonPrintLog("FAIL", className, "No Notice", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return 1;
			}
			// 공지 읽음은 어디서 실행??? get할때 하나?
			// NoticeDAO.setNotice(inputNoticeNo, inputNoticeStatus,
			// inputConfirmDate);
			return noticeOne.getDeepNoticeNo();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void setNotice(HttpServletRequest req, HttpServletResponse res) {
		// set Status. Please update feed part.
		// only implement follow part.

		// 공지의 읽었음을 변경하는 set메소드.
		// 공지가 오는때?(알림): follow 추가, 삭제 / feed가 될때 안될때/blog....
		// 언제바꾸나? 미확인-add되었을때, 읽음-get? 아님 search, read?(follow부분엔 따로없어서 안함).

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int inputNoticeNo = req.getParameter("inputNoticeNo") != null
					? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;
			int mode = req.getParameter("mode") != null
					? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			long inputCurrentDate = System.currentTimeMillis() / 1000;
			// Status는 Feed에만 있는 것인가?
			// mode : 메소드 어디서 불러왔는지의 구분. 즉 status와 관련. (default-1(미확인),
			// read-2(확인), delete-3(삭제))

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
			parameterList.add(mode);
			parameterList.add(inputCurrentDate);

			if (!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// DAO
			if (NoticeDAO.setNotice(inputNoticeNo, mode, inputCurrentDate) == 0) {
				// 하나도 상태바뀐게 없음, bool타입으로 바꿔야하나?
				CommonUtil.commonPrintLog("FAIL", className, "No Update Notice Status", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
