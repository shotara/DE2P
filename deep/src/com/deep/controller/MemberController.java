package com.deep.controller;

import java.io.File;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.deep.model.MemberDAO;
import com.deep.model.domain.Member;
import com.deep.util.CommonUtil;
import com.deep.util.EncryptUtil;

public class MemberController {

	public static final String className = "MemberContorller";

	public static void checkMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			String inputMemberEmail = req.getParameter("inputMemberEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberEmail").toString()) : null;				
	
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// 파라미터 체크
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberEmail);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 개인키 가져오기
			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
			if(privateKey == null) {
				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}			

//			// RSA 복호화
//			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
//				
//			// AES 암호화
//			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
//			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);

			// 입력받은 이메일이 DB에 있는지 확인		    			
			if(!(MemberDAO.checkMember(inputMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			jObject.put("outputResult", "1");	
			CommonUtil.commonPrintLog("SUCCESS", className, "Check Member OK", map);			
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void loginMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			String inputMemberEmail = req.getParameter("inputMemberEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberEmail").toString()) : null;
			String inputMemberPassword = req.getParameter("inputMemberPassword") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPassword").toString()) : null;
				
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// 파라미터 체크
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberEmail);
			parameterList.add(inputMemberPassword);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 개인키 가져오기
			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
			if(privateKey == null) {
				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}			

			// RSA 복호화
			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
				
			// AES 암호화
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);

			// 입력받은 이메일이 DB에 있는지 확인

			// 허가된 회원인지 확인

			// SHA-256 암호화
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
	
			// 비밀번호가 일치하지 않는 경우
			
		    // 회원 UID 가져오기
			
			// 완료
	//		MemberController.setMemberSession(session, checkMember, outputMemberUid, aesKey);
		    
			
			map.put("USER-NO", "0");
			CommonUtil.commonPrintLog("SUCCESS", className, "User Login OK", map);			
			res.getWriter().write(jObject.toString());
			return;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 회원 세션 할당
	public static void setMemberSession(HttpSession session, Member member, String inputMemberUid, String aesKey) {

		try {
//			session.setMaxInactiveInterval(3600);
//			session.setAttribute("hbiMemberNo", member.getHbiMemberNo());
//			session.setAttribute("hbiMemberUid", inputMemberUid);	
//			session.setAttribute("hbiMemberCategory", member.getHbiMemberCategory());
//			session.setAttribute("hbiMemberAgeGroup", member.getHbiMemberAgeGroup());
//			session.setAttribute("hbiMemberHomePlace", member.getHbiMemberHomePlace());
//			session.setAttribute("hbiMemberFrequencyPlace", member.getHbiMemberFrequencyPlace());
//			session.setAttribute("hbiMemberFacebookId", EncryptUtil.AES_Decode(member.getHbiMemberFacebookId(), aesKey));
//			session.setAttribute("hbiMemberChatId", member.getHbiMemberChatId());
//			session.setAttribute("hbiMemberName", EncryptUtil.AES_Decode(member.getHbiMemberName(), aesKey));
//			session.setAttribute("hbiMemberEmail", EncryptUtil.AES_Decode(member.getHbiMemberEmail(), aesKey));
//			session.setAttribute("hbiMemberPhone", EncryptUtil.AES_Decode(member.getHbiMemberPhone(), aesKey));
//			session.setAttribute("hbiMemberProfileImg", MemberController.getMemberProfileImg(member.getHbiMemberProfileImg()));
//			session.setAttribute("hbiMemberProfileText", member.getHbiMemberProfileText());	    
//			session.setAttribute("hbiMemberIsChatUser", ChatController.checkIsChatMember(member.getHbiMemberNo()));
//			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
