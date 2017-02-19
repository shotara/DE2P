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

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

public class NoticeController {
	
	public static final String className = "NoticeController";

	
	//addDAO는 어디로 넣어야?
	public static int listNotice(HttpServletRequest req, HttpServletResponse res){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();
			int inputMemberNo = req.getParameter("inputMemberNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputMemberNo").toString())) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberNo);
			
			if(!CommonUtil.commonParameterCheck(parameterList)) {
			CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return 1;
			}
			
				
			//DAO
			if( NoticeDAO.getNoticelist(inputMemberNo)== 0){ // 알림 리스트가 없을때
				CommonUtil.commonPrintLog("FAIL", className, "No NoticeList", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return 0;
			}

		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		return 1; // 임시.  나중에 list를 반환해야 할 듯.
	}
	
	public static void setNotice(HttpServletRequest req, HttpServletResponse res) {//상태 바꾸기. Feed에서 뭘 보내줘야 하지 않나? 
		// 수정요망.
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();

			int inputNoticeNo = req.getParameter("inputNoticeNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;
			//int mode = 1;  //Feed에서 wirte일때 미확인(1), get일때 확인(2), delete읽때 삭제(3)
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
			//parameterList.add(mode);
			
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			
			//DAO
			/*if( NoticeDAO.setNotice(inputNoticeNo, mode) == 0){ //하나도 상태바뀐게 없음, bool타입으로 바꿔야하나?
				CommonUtil.commonPrintLog("FAIL", className, "No Update Notice Status", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			*/
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	// 확인날짜, 상태 바꿔야 할듯.
	}
	
	
	public static int getNotice(HttpServletRequest req, HttpServletResponse res){ //도메인을 하나를 가져온다??
		HashMap<String, String> map = new HashMap<String, String>();
		
		try{
			HttpSession session = req.getSession();
			//프론트에서 요청한 알림넘버를 가져온다.
			int inputNoticeNo = req.getParameter("inputNoticeNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNoticeNo").toString())) : 0;
			int inputNoticeStatus = 2; // 확인
			long inputConfirmDate = System.currentTimeMillis()/1000;
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputNoticeNo);
			parameterList.add(inputNoticeStatus);
			parameterList.add(inputConfirmDate);
						
			if(!CommonUtil.commonParameterCheck(parameterList)) {
			CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
			jObject.put("outputResult", "-1");
			res.getWriter().write(jObject.toString());
			return 1;
			}
			
			
			//checkNotice(알림의 유무) 메서드 확인 후 있으면 아래 실행
			NoticeDAO.setNotice(inputNoticeNo, inputNoticeStatus, inputConfirmDate);
			
			if( NoticeDAO.getNotice(inputNoticeNo) == 0){ //하나도 상태바뀐게 없음, bool타입으로 바꿔야하나?
				CommonUtil.commonPrintLog("FAIL", className, "No Notice", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return 0;
			}
	
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
