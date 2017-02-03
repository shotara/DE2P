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

			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;				
			String inputMemberParam = req.getParameter("inputMemberParam") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberParam").toString()) : null;				
	
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(mode);	
			parameterList.add(inputMemberParam);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Get Private key
			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
			if(privateKey == null) {
				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}			

//			// RSA Decrypt
//			String decryptMemberParam = EncryptUtil.RSA_Decode(privateKey, inputMemberParam);
//				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
//			String encryptMemberParam = EncryptUtil.AES_Encode(decryptMemberParam, aesKey);
			String encryptMemberParam = EncryptUtil.AES_Encode(inputMemberParam, aesKey);

			// Check Member Email, Name    			
			if(MemberDAO.checkMember(mode, encryptMemberParam)>0) {
				CommonUtil.commonPrintLog("FAIL", className, "Already Member Name/Email Exist", map);
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
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberEmail);
			parameterList.add(inputMemberPassword);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
//			// Get Private key
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
//			// RSA Decrypt
//			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
//			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
//				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
//			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputMemberEmail, aesKey);

			if(!(MemberDAO.checkMember(1, encryptMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// SHA-256 Encrypt
//			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(inputMemberPassword);

			Member member = MemberDAO.getMemberByMemberMail(encryptMemberEmail, encryptMemberPassword);
			
			// Password not correct
			if(member == null) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check member permit
			if(member.getDeepMemberStatus() != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member Permit!", map);
				jObject.put("outputResult", "-5");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Get MemberUID
			MemberUid outputMemberUid = MemberDAO.getMemberUid(member.getDeepMemberNo());
			
			// Success
			MemberController.setMemberSession(session, member, outputMemberUid.getDeepMemberUid(), aesKey);
			
			System.out.println(session.getAttribute("deepMemberNo"));
			map.put("USER-NO", "0");
			CommonUtil.commonPrintLog("SUCCESS", className, "User Login OK", map);			
			res.getWriter().write(jObject.toString());
			return;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Set member session
	public static void setMemberSession(HttpSession session, Member member, String inputMemberUid, String aesKey) {

		try {
			session.setMaxInactiveInterval(3600);
			session.setAttribute("deepMemberNo", member.getDeepMemberNo());
			session.setAttribute("deepMemberUid", inputMemberUid);	
			session.setAttribute("deepMemberLever", member.getDeepMemberLevel());
			session.setAttribute("deepMemberName", EncryptUtil.AES_Decode(member.getDeepMemberName(), aesKey));
			session.setAttribute("deepMemberEmail", EncryptUtil.AES_Decode(member.getDeepMemberEmail(), aesKey));
			session.setAttribute("deepMemberMajor", EncryptUtil.AES_Decode(member.getDeepMemberMajor(), aesKey));
			session.setAttribute("deepMemberCareer", EncryptUtil.AES_Decode(member.getDeepMemberCareer(), aesKey));
//			session.setAttribute("deepMemberImage", MemberController.getMemberProfileImg(member.getDeepMemberImage();	    
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// join 
	public static void JoinMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int inputMemberStatus = 1;
			int inputMemberLevel = 1;
			long inputCurrentDate = System.currentTimeMillis()/1000;
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
			
			// Parameter check
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
//			// Get Private key
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
//			// RSA Decrypt
//			String decryptMemberMajor = EncryptUtil.RSA_Decode(privateKey, inputMemberMajor);
//			String decryptMemberCareer = EncryptUtil.RSA_Decode(privateKey, inputMemberCareer);
//			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
//			String decryptMemberName = EncryptUtil.RSA_Decode(privateKey, inputMemberName);
//			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
//				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
//			String encryptMemberMajor = EncryptUtil.AES_Encode(decryptMemberMajor, aesKey);
//			String encryptMemberCareer = EncryptUtil.AES_Encode(decryptMemberCareer, aesKey);
//			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
//			String encryptMemberName = EncryptUtil.AES_Encode(decryptMemberName, aesKey);
			
			String encryptMemberMajor = EncryptUtil.AES_Encode(inputMemberMajor, aesKey);
			String encryptMemberCareer = EncryptUtil.AES_Encode(inputMemberCareer, aesKey);
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputMemberEmail, aesKey);
			String encryptMemberName = EncryptUtil.AES_Encode(inputMemberName, aesKey);
			
			// Check the email in the database
			if((MemberDAO.checkMember(1, encryptMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "Alredy Exist Mail", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Check the name in the database
			if((MemberDAO.checkMember(2, encryptMemberName)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "Alredy Exist Name", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}			
			
			// SHA-256 Encrypt
//			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(inputMemberPassword);
			
			Member member = MemberDAO.getMemberByMemberMail(encryptMemberEmail, encryptMemberPassword);
			
			// Password and passwordConfirm is not correct
			if(!inputMemberPassword.equals(inputMemberPasswordConfirm)) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-5");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Join member 
			int check = MemberDAO.addMember(inputMemberStatus, inputMemberLevel, inputCurrentDate, encryptMemberMajor, encryptMemberCareer, encryptMemberEmail, encryptMemberName, encryptMemberPassword, inputMemberImage);

			if(check != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Member Fail", map);
				jObject.put("outputResult", "-6");
				res.getWriter().write(jObject.toString());
				return;
			}			
			
			// Create MemberUid
			String memberUid = encryptMemberEmail.substring(0,6) + encryptMemberName.substring(0,6) + Long.toString(inputCurrentDate).substring(0,4);
			System.out.println(memberUid);
			int createMemberUid = MemberDAO.addMemberUid(encryptMemberEmail, memberUid);
			
			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "User Join OK", map);			
			res.getWriter().write(jObject.toString());
			return;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void logoutMember(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
				
		try {
			HttpSession session = req.getSession(false);
			
			// 세션이 없는 경우
			if(session == null) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				res.getWriter().write("-1");
				return;
			}
			
			session.invalidate();
			
			CommonUtil.commonPrintLog("SUCCESS", className, "User Logout OK", map);
			res.getWriter().write("1");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
