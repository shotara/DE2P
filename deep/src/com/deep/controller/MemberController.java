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
import com.deep.model.domain.MemberUid;
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
			
//			// 개인키 가져오기
//			PrivateKey privateKey = null;
//			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
//			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
//			
//			if(privateKey == null) {
//				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
//				jObject.put("outputResult", "-2");
//				res.getWriter().write(jObject.toString());
//				return;
//			}			
//
//			// RSA 복호화
//			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
//			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
//				
			// AES 암호화
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
//			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputMemberEmail, aesKey);

			
			// 입력받은 이메일이 DB에 있는지 확인
			if(!(MemberDAO.checkMember(inputMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// SHA-256 암호화
//			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(inputMemberPassword);
			
			Member member = MemberDAO.getMemberByMemberMail(encryptMemberEmail, encryptMemberPassword);
			
			// 비밀번호가 일치하지 않는 경우
			if(member != null) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 허가된 회원인지 확인
			if(member.getDeepMemberStatus() != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member Permit!", map);
				jObject.put("outputResult", "-5");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 회원 UID 가져오기
			MemberUid outputMemberUid = MemberDAO.getMemberUid(member.getDeepMemberNo());
			
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

	// 회원가입 
	public static void JoinMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int inputMemberStatus = 1;
			int inputMemberLevel = 1;
			String inputMemberMajor = req.getParameter("inputMemberMajor") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberMajor").toString()) : null;
			String inputMemberCareer = req.getParameter("inputMemberCareer") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberCareer").toString()) : null;
			String inputMemberEmail = req.getParameter("inputMemberEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberEmail").toString()) : null;
			String inputMemberName = req.getParameter("inputMemberName") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberName").toString()) : null;
			String inputMemberPassword = req.getParameter("inputMemberPassword") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPassword").toString()) : null;
			String inputMemberPasswordConfirm = req.getParameter("inputMemberPasswordConfirm") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPasswordConfirm").toString()) : null;
			int inputMemberImage = -1;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// 파라미터 체크
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberMajor);
			parameterList.add(inputMemberCareer);
			parameterList.add(inputMemberEmail);
			parameterList.add(inputMemberName);
			parameterList.add(inputMemberPassword);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
//			
//			// 개인키 가져오기
//			PrivateKey privateKey = null;
//			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
//			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
//			
//			if(privateKey == null) {
//				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
//				jObject.put("outputResult", "-2");
//				res.getWriter().write(jObject.toString());
//				return;
//			}			
//
//			// RSA 복호화
//			String decryptMemberMajor = EncryptUtil.RSA_Decode(privateKey, inputMemberMajor);
//			String decryptMemberCareer = EncryptUtil.RSA_Decode(privateKey, inputMemberCareer);
//			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
//			String decryptMemberName = EncryptUtil.RSA_Decode(privateKey, inputMemberName);
//			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
//				
			// AES 암호화
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
//			String encryptMemberMajor = EncryptUtil.AES_Encode(decryptMemberMajor, aesKey);
//			String encryptMemberCareer = EncryptUtil.AES_Encode(decryptMemberCareer, aesKey);
//			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
//			String encryptMemberName = EncryptUtil.AES_Encode(decryptMemberName, aesKey);
			
			String encryptMemberMajor = EncryptUtil.AES_Encode(inputMemberMajor, aesKey);
			String encryptMemberCareer = EncryptUtil.AES_Encode(inputMemberCareer, aesKey);
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputMemberEmail, aesKey);
			String encryptMemberName = EncryptUtil.AES_Encode(inputMemberName, aesKey);
			
			// 입력받은 이메일이 DB에 있는지 확인
			if((MemberDAO.checkMember(inputMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "Alredy Exist Mail", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// SHA-256 암호화
//			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(inputMemberPassword);
			
			Member member = MemberDAO.getMemberByMemberMail(encryptMemberEmail, encryptMemberPassword);
			
			// 비밀번호와 비밀번호 확인 일치하지 않는 경우
			if(inputMemberPassword != inputMemberPasswordConfirm) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 회원가입 
			int check = MemberDAO.addMember(inputMemberStatus, inputMemberLevel, encryptMemberMajor, encryptMemberCareer, encryptMemberEmail, encryptMemberName, encryptMemberPassword, inputMemberImage);

			if(check != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Member Fail", map);
				jObject.put("outputResult", "-5");
				res.getWriter().write(jObject.toString());
				return;
			}			
			
			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "User Login OK", map);			
			res.getWriter().write(jObject.toString());
			return;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
