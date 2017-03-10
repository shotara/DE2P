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
import com.deep.model.MemberDAO;
import com.deep.model.NoticeDAO;
import com.deep.model.domain.Member;
import com.deep.model.domain.Notice;
import com.deep.model.domain.MemberUid;
import com.deep.model.domain.Upload;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import java.util.List;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

public class NoticeController {

	public static final String className = "NoticeController";

	// addDAO는 어디로 넣어야?
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
			Notice Noticelist = NoticeDAO.getNoticelist(inputMemberNo);

			if (Noticelist == null) { // when no Notice
				CommonUtil.commonPrintLog("FAIL", className, "No NoticeList", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return 1;
			}

			return (int) Noticelist.getDeepMemberNo();
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
			int inputNoticeStatus = 2; // confirm
			long inputConfirmDate = System.currentTimeMillis() / 1000;
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
			parameterList.add(inputNoticeStatus);
			parameterList.add(inputConfirmDate);

			if (!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return 1;
			}

			
			Notice noticeOne = NoticeDAO.getNotice(inputNoticeNo);
			if (noticeOne==null) { 
				CommonUtil.commonPrintLog("FAIL", className, "No Notice", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return 1;
			}
			//공지 읽음은 어디서 실행??? get할때 하나?
//			NoticeDAO.setNotice(inputNoticeNo, inputNoticeStatus, inputConfirmDate);
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

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int inputNoticeNo = req.getParameter("inputNoticeNo") != null
					? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;
			// int mode = 1; //Feed에서 wirte일때 미확인(1), get일때 확인(2), delete읽때
			// 삭제(3)

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
			// parameterList.add(mode);

			if (!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			// DAO
			/*
			 * if( NoticeDAO.setNotice(inputNoticeNo, mode) == 0){ //�ϳ���
			 * ���¹ٲ�� ����, boolŸ������ �ٲ���ϳ�?
			 * CommonUtil.commonPrintLog("FAIL", className,
			 * "No Update Notice Status", map); jObject.put("outputResult",
			 * "-3"); res.getWriter().write(jObject.toString()); return; }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Ȯ�γ�¥, ���� �ٲ�� �ҵ�.
	}

}
