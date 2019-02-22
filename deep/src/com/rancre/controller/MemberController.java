package com.rancre.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONException;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import com.rancre.config.GlobalValue;
import com.rancre.model.AdminDAO;
import com.rancre.model.ChannelDAO;
import com.rancre.model.MemberDAO;
import com.rancre.model.NoticeDAO;
import com.rancre.model.UploadDAO;
import com.rancre.model.domain.Channel;
import com.rancre.model.domain.ChannelLike;
import com.rancre.model.domain.ChannelView;
import com.rancre.model.domain.Company;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.MemberUid;
import com.rancre.model.domain.Notice;
import com.rancre.model.domain.Paging;
import com.rancre.model.domain.RankCategory;
import com.rancre.model.domain.RankTop;
import com.rancre.model.domain.Review;
import com.rancre.model.domain.Upload;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

public class MemberController {

	public static final String className = "MemberController";

	public static void checkMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();
			// mode = 1 : mail , 3 : name
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

			// RSA Decrypt
			String decryptMemberParam = EncryptUtil.RSA_Decode(privateKey, inputMemberParam);
				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberParam = EncryptUtil.AES_Encode(decryptMemberParam, aesKey);

			// Check Member Email, Name    			
			if(MemberDAO.checkMember(mode, encryptMemberParam)>0) {
				CommonUtil.commonPrintLog("FAIL", className, "Already Member Name/Email Exist", map);
				jObject.put("outputResult", "-3");
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

	public static void getChangeUserInfo(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();
			String inputEmail = req.getParameter("inputEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputEmail").toString()) : null;
			String inputCheckValue = req.getParameter("inputCheckValue") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputCheckValue").toString()) : null;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputEmail);
			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputEmail, aesKey);

			// Check Member Email, Name    			
			if(MemberDAO.checkValidMemberByToken(encryptMemberEmail, inputCheckValue)==0) {
				CommonUtil.commonPrintLog("FAIL", className, "Not Member Email Exist", map);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				return;
			}			
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get User OK", map);
			req.setAttribute("outputMemberEmail",inputEmail);
			req.getRequestDispatcher("/02_page/Auth/inquirycomplete.jsp").forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkValidMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			String inputMemberEmail = req.getParameter("inputMemberEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberEmail").toString()) : null;				
	
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberEmail);
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

			// RSA Decrypt
			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);

			// Check Member Email, Name    			
			if(MemberDAO.checkValidMember(encryptMemberEmail)==0) {
				CommonUtil.commonPrintLog("FAIL", className, "Not Member Email Exist", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
	
			  String host     = "smtp.naver.com";
			  final String user   = "shotzara@naver.com";
			  final String password  = "rmlarmla12!";
	
			  String to = decryptMemberEmail;
	
			  // Get the session object
			  Properties props = new Properties();
			  props.put("mail.smtp.host", host);
			  props.put("mail.smtp.auth", "true");
	
			  Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(user, password);
			   }
			  });
	
			   MimeMessage message = new MimeMessage(mailSession);
			   message.setFrom(new InternetAddress(user));
			   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
			   // Subject
			   message.setSubject("Rancre 비밀번호 찾기 입니다.");

			   String checkValue = Long.toString(System.currentTimeMillis()/1000).substring(0,6);
			   
			   int check = MemberDAO.setAuthTokenByValidMember(encryptMemberEmail, checkValue);
				if(check!=1) {
					CommonUtil.commonPrintLog("ERROR", className, "SET AUTHTOKEN FAIL", map);
					jObject.put("outputResult", "-4");
					res.getWriter().write(jObject.toString());
					return;
				}	   
			   
			   // Text
			   String url = "http://rancre.com/member?action=getChangeUserInfo&inputEmail="+decryptMemberEmail+"&inputCheckValue="+checkValue;
			   String text = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\r\n" + 
			   		"<html xmlns='http://www.w3.org/1999/xhtml'>\r\n" + 
			   		"<head>\r\n" + 
			   		"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />\r\n" + 
			   		"<title>랭크리 이메일 인증</title>\r\n" + 
			   		"<meta name='viewport' content='width=device-width, initial-scale=1.0' />\r\n" + 
			   		"</head>\r\n" + 
			   		"<body style='margin: 0; padding: 0;'>\r\n" + 
			   		"	<table align='center' border='0' cellpadding='0' cellspacing='0'\r\n" + 
			   		"		width='600'>\r\n" + 
			   		"		<tr>\r\n" + 
			   		"			<td bgcolor='#ffffff' align='center'\r\n" + 
			   		"				style='font-size: 42px; color: #f11834; font-weight: bold; padding: 40px 0px 0px 0px;'>Rancre\r\n" + 
			   		"			</td>\r\n" + 
			   		"		</tr>\r\n" + 
			   		"		<tr>\r\n" + 
			   		"			<td bgcolor='#ffffff' style='padding: 40px 30px 60px 30px;'>\r\n" + 
			   		"				<table border='0' cellpadding='0' cellspacing='0' width='100%'\r\n" + 
			   		"					align='center'>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center' style='font-size:18px;'>안녕하세요! 랭크리입니다.</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center' style='font-size:18px; padding:10px 0px 0px 0px;'>아래의 인증 URL을 눌러 회원정보를 재설정해주시기 바랍니.</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center'>&nbsp;</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center'>&nbsp;</td>\r\n" + 
			   		"					</tr>\r\n" + 
					"					<tr>\r\n" + 
					"						<td align='center'><a href='"+url+"' target=\"_blank\" style=\"width: 120px; padding: 12px 12px; border-radius: 2px; background-color: #f11834;font-family: Helvetica, Arial, sans-serif;font-size: 14px; color: #ffffff;text-decoration: none; display: inline-block;\">\r\n" + 
					"                          회원정보 재설정           \r\n" + 
					"                      </a></td>\r\n" + 
					"					</tr>"  +
			   		"					<tr>\r\n" + 
			   		"						<td align='center'>&nbsp;</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center'>&nbsp;</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center' style='font-size:18px;'>이메일 인증을 완료하지 않은 경우, 서비스 이용에 제한이 있을 수 있습니다.\r\n" + 
			   		"						</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"				</table>\r\n" + 
			   		"			</td>\r\n" + 
			   		"		</tr>\r\n" + 
			   		"		<tr>\r\n" + 
			   		"			<td bgcolor='#f11834' style='padding: 30px 30px 30px 30px;'>\r\n" + 
			   		"				<table border='0' cellpadding='0' cellspacing='0' width='100%'>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align='center' style='color: #ffffff'>랭크리는 더 다양한 채널을 분석하기\r\n" + 
			   		"							위한 서비스입니다.</td>\r\n" + 
			   		"					</tr>\r\n" + 
			   		"				</table>\r\n" + 
			   		"\r\n" + 
			   		"			</td>\r\n" + 
			   		"		</tr>\r\n" + 
			   		"	</table>\r\n" + 
			   		"</body>\r\n" + 
			   		"</html>";
			   message.setContent(text, "text/html; charset=utf-8");
			   Transport.send(message);
			   System.out.println("message sent successfully...");
			
			
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

			// RSA Decrypt
			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
//			String encryptMemberEmail = EncryptUtil.AES_Encode(inputMemberEmail, aesKey);

			if(!(MemberDAO.checkMember(1, encryptMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// SHA-256 Encrypt
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
			Member member = MemberDAO.getMemberByMemberMail(encryptMemberEmail, encryptMemberPassword);
			
			// Password not correct
			if(member == null) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// check member permit
			if(member.getRacMemberStatus() != 2) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member Permit!", map);
				jObject.put("outputResult", "-5");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Get MemberUID
			MemberUid outputMemberUid = MemberDAO.getMemberUid(member.getRacMemberNo());
			
			// Success
			MemberController.setMemberSession(session, member, outputMemberUid.getRacMemberUid(), aesKey);
			
			map.put("USER-NO", "0");
			CommonUtil.commonPrintLog("SUCCESS", className, "User Login OK", map);		
			jObject.put("outputResult", "1");
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
			session.setAttribute("racMemberNo", member.getRacMemberNo());
			session.setAttribute("racMemberUid", inputMemberUid);	
			session.setAttribute("racMemberEmail", EncryptUtil.AES_Decode(member.getRacMemberEmail(), aesKey));
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// join 
	public static void joinMember(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int inputMemberStatus = 1;
			Calendar calendar = Calendar.getInstance();
			Timestamp inputCurrentDate = new java.sql.Timestamp(calendar.getTime().getTime());
			String inputMemberEmail = req.getParameter("inputMemberEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberEmail").toString()) : null;
			String inputBusinessNumber = req.getParameter("inputBusinessNumber") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputBusinessNumber").toString()) : null;
			String inputCompanyName = req.getParameter("inputCompanyName") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputCompanyName").toString()) : null;
			String inputMemberPassword = req.getParameter("inputMemberPassword") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPassword").toString()) : null;
			String inputMemberPasswordConfirm = req.getParameter("inputMemberPasswordConfirm") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPasswordConfirm").toString()) : null;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberEmail);
			parameterList.add(inputBusinessNumber);
			parameterList.add(inputCompanyName);
			parameterList.add(inputMemberPassword);
			parameterList.add(inputMemberPasswordConfirm);
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
         
			// RSA Decrypt
			String decryptCompanyName = EncryptUtil.RSA_Decode(privateKey, inputCompanyName);
			String decryptBusinessNumber = EncryptUtil.RSA_Decode(privateKey, inputBusinessNumber);
			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptCompanyName = EncryptUtil.AES_Encode(decryptCompanyName, aesKey);
			String encryptBusinessNumber = EncryptUtil.AES_Encode(decryptBusinessNumber, aesKey);
			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
			
			// Check the email in the database
			if((MemberDAO.checkMember(1, encryptMemberEmail)>0)) {
				CommonUtil.commonPrintLog("FAIL", className, "Alredy Exist Mail", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}

			// SHA-256 Encrypt
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);			
			String decryptMemberPasswordConfirm = EncryptUtil.RSA_Decode(privateKey, inputMemberPasswordConfirm);

			// Password and passwordConfirm is not correct
			if(!(decryptMemberPassword.equals(decryptMemberPasswordConfirm))) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-5");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Join member 
			String authToken = Long.toString(System.currentTimeMillis()/1000).substring(4,10); /// AuthToken
			int check = MemberDAO.addMember(inputMemberStatus, inputCurrentDate, encryptMemberEmail, encryptMemberPassword, authToken);

			if(check != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Member Fail", map);
				jObject.put("outputResult", "-6");
				res.getWriter().write(jObject.toString());
				return;
			}			
			
			// Create MemberUid
			String memberUid = decryptMemberEmail.substring(0,3) + Long.toString(System.currentTimeMillis()/1000).substring(2,10);
			int createMemberUid = MemberDAO.addMemberUid(encryptMemberEmail, memberUid);
			
			// Create Business 
			
			int createCompany = MemberDAO.addCompany(encryptMemberEmail, encryptCompanyName, encryptBusinessNumber, inputCurrentDate);
			if(createCompany != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Company Fail", map);
			}			
			
			// 완료 

			  String host     = "smtp.naver.com";
			  final String user   = "shotzara@naver.com";
			  final String password  = "rmlarmla12!";

			  String to = decryptMemberEmail;

			  // Get the session object
			  Properties props = new Properties();
			  props.put("mail.smtp.host", host);
			  props.put("mail.smtp.auth", "true");

			  Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(user, password);
			   }
			  });

			  // Compose the message
			  try {
			   MimeMessage message = new MimeMessage(mailSession);
			   message.setFrom(new InternetAddress(user));
			   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			   // Subject
			   message.setSubject("Rancre에 오신것을 환영합니다!");
			   
			   // Text
			   String url = "http://localhost:8080/member?action=checkPermitJoin&inputEmail="+decryptMemberEmail+"&inputCheckValue="+authToken;
			   String text = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\r\n" + 
			   		"			   <html xmlns='http://www.w3.org/1999/xhtml'>\r\n" + 
			   		"			   <head>\r\n" + 
			   		"			   <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />\r\n" + 
			   		"			   <title>랭크리 이메일 인증</title>\r\n" + 
			   		"			   <meta name='viewport' content='width=device-width, initial-scale=1.0' />\r\n" + 
			   		"			   </head>\r\n" + 
			   		"			   <body style='margin: 0; padding: 0;'>\r\n" + 
			   		"			   	<table align='center' border='0' cellpadding='0' cellspacing='0'\r\n" + 
			   		"			   		width='600'>\r\n" + 
			   		"			   		<tr>\r\n" + 
			   		"			   			<td bgcolor='#ffffff' align='center'\r\n" + 
			   		"			   				style='font-size: 42px; color: #f11834; font-weight: bold; padding: 40px 0px 0px 0px;'>Rancre\r\n" + 
			   		"			   			</td>\r\n" + 
			   		"			   		</tr>\r\n" + 
			   		"			   		<tr>\r\n" + 
			   		"			   			<td bgcolor='#ffffff' style='padding: 40px 30px 60px 30px;'>\r\n" + 
			   		"			   				<table border='0' cellpadding='0' cellspacing='0' width='100%'\r\n" + 
			   		"			   					align='center'>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center' style='font-size:18px;'>안녕하세요! 랭크리입니다. 회원가입을 신청해주셔서 감사합니다.</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center' style='font-size:18px; padding:10px 0px 0px 0px;'>아래의 인증 URL을 눌러 회원가입을 완료해주시기 바랍니다.</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center'>&nbsp;</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center'>&nbsp;</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"					<tr>\r\n" + 
			   		"						<td align=\"center\"><a href='"+url+"' target=\"_blank\" style=\"width: 120px; padding: 12px 12px; border-radius: 2px; background-color: #f11834;font-family: Helvetica, Arial, sans-serif;font-size: 14px; color: #ffffff;text-decoration: none; display: inline-block;\">\r\n" + 
			   		"                          이메일 인증하기            \r\n" + 
			   		"                      </a></td>\r\n" + 
			   		"					</tr>" +
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center'>&nbsp;</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center'>&nbsp;</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center' style='font-size:18px;'>이메일 인증을 완료하지 않은 경우, 서비스 이용에 제한이 있을 수 있습니다.\r\n" + 
			   		"			   						</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   				</table>\r\n" + 
			   		"			   			</td>\r\n" + 
			   		"			   		</tr>\r\n" + 
			   		"			   		<tr>\r\n" + 
			   		"			   			<td bgcolor='#f11834' style='padding: 30px 30px 30px 30px;'>\r\n" + 
			   		"			   				<table border='0' cellpadding='0' cellspacing='0' width='100%'>\r\n" + 
			   		"			   					<tr>\r\n" + 
			   		"			   						<td align='center' style='color: #ffffff'>랭크리는 더 다양한 채널을 분석하기\r\n" + 
			   		"			   							위한 서비스입니다.</td>\r\n" + 
			   		"			   					</tr>\r\n" + 
			   		"			   				</table>\r\n" + 
			   		"\r\n" + 
			   		"			   			</td>\r\n" + 
			   		"			   		</tr>\r\n" + 
			   		"			   	</table>\r\n" + 
			   		"			   </body>\r\n" + 
			   		"			   </html>";
//			   message.setText(text);
			   // send the message
			   message.setContent(text, "text/html; charset=utf-8");
			   Transport.send(message);
			   System.out.println("message sent successfully...");

			  } catch (MessagingException e) {
			   e.printStackTrace();
			  }
			
			
			CommonUtil.commonPrintLog("SUCCESS", className, "User Join OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Logout Member
	public static void logoutMember(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
				
		try {
			HttpSession session = req.getSession(false);
			JSONObject jObject = new JSONObject();
			// 세션이 없는 경우
			if(session == null) {
				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			session.invalidate();
			CommonUtil.commonPrintLog("SUCCESS", className, "User Logout OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setMember(HttpServletRequest req, HttpServletResponse res) {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//
//		try {
//			HttpSession session = req.getSession();
//
//			int sessionMemberNo = session.getAttribute("deepMemberNo") != null ? Integer.parseInt(session.getAttribute("deepMemberNo").toString()) : 0;
//			String inputMemberMajor = req.getParameter("inputMemberMajor") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberMajor").toString()) : null;
//			String inputMemberCareer = req.getParameter("inputMemberCareer") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberCareer").toString()) : null;
//			String inputMemberName = req.getParameter("inputMemberName") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberName").toString()) : null;
//			String inputMemberPassword = req.getParameter("inputMemberPassword") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPassword").toString()) : null;
//			String inputMemberPasswordConfirm = req.getParameter("inputMemberPasswordConfirm") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPasswordConfirm").toString()) : null;
//			int inputMemberImage = -1;
//
//			JSONObject jObject = new JSONObject();
//			res.setContentType("application/json");
//			res.setCharacterEncoding("UTF-8");
//
////			// Get Private key
////			PrivateKey privateKey = null;
////			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
////			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
////			
////			if(privateKey == null) {
////				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
////				jObject.put("outputResult", "-2");
////				res.getWriter().write(jObject.toString());
////				return;
////			}			
////         
////			// RSA Decrypt
////			String decryptMemberMajor = EncryptUtil.RSA_Decode(privateKey, inputMemberMajor);
////			String decryptMemberCareer = EncryptUtil.RSA_Decode(privateKey, inputMemberCareer);
////			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
////			String decryptMemberName = EncryptUtil.RSA_Decode(privateKey, inputMemberName);
////			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
//
//			
//			// AES Encrypt
//			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
////			String encryptMemberMajor = EncryptUtil.AES_Encode(decryptMemberMajor, aesKey);
////			String encryptMemberCareer = EncryptUtil.AES_Encode(decryptMemberCareer, aesKey);
////			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);
////			String encryptMemberName = EncryptUtil.AES_Encode(decryptMemberName, aesKey);
//			
//			String encryptMemberMajor = EncryptUtil.AES_Encode(inputMemberMajor, aesKey);
//			String encryptMemberCareer = EncryptUtil.AES_Encode(inputMemberCareer, aesKey);
//			String encryptMemberName = EncryptUtil.AES_Encode(inputMemberName, aesKey);
//			
//			// Check the email in the database
//			if(!(sessionMemberNo>0)) {
//				CommonUtil.commonPrintLog("FAIL", className, "No Member", map);
//				jObject.put("outputResult", "-3");
//				res.getWriter().write(jObject.toString());
//				return;
//			}
//			
//			// Check the name in the database
//			if((MemberDAO.checkMember(2, encryptMemberName)>0)) {
//				CommonUtil.commonPrintLog("FAIL", className, "Alredy Exist Name", map);
//				jObject.put("outputResult", "-4");
//				res.getWriter().write(jObject.toString());
//				return;
//			}			
//			
//			
//			// SHA-256 Encrypt
////			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);
//			String encryptMemberPassword = EncryptUtil.SHA256_Encode(inputMemberPassword);
//			
//			
//			// Set member 
//			int mode; 	// mode 1 : password change  2 : not change
//			if(!inputMemberPassword.equals("")) {
//				mode = 1;
//				// Password and passwordConfirm is not correct
//				if(!inputMemberPassword.equals(inputMemberPasswordConfirm)) {
//					CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
//					jObject.put("outputResult", "-5");
//					res.getWriter().write(jObject.toString());
//					return;
//				}
//			} else mode = 2; 
//			
//			int check = MemberDAO.setMember(mode, sessionMemberNo, encryptMemberMajor, encryptMemberCareer, encryptMemberName, encryptMemberPassword);
//
//			if(check != 1) {
//				CommonUtil.commonPrintLog("FAIL", className, "Add Member Fail", map);
//				jObject.put("outputResult", "-6");
//				res.getWriter().write(jObject.toString());
//				return;
//			}			
//
//			// 완료 
//			CommonUtil.commonPrintLog("SUCCESS", className, "User Join OK", map);			
//			res.getWriter().write(jObject.toString());
//			return;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static void loginCheck(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Login Check OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkCompany(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();
			
			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputNumber = req.getParameter("inputNumber") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNumber").toString())) : 0;				
			String inputCompany = req.getParameter("inputCompany") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputCompany").toString()) : null;
			String checkResult = "";
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
			if(privateKey == null) {
				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}	
			

	        String returnString = "";
	        HttpURLConnection connection = null;
	        OutputStream os =null;


	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();
	        Document doc = parser.newDocument();
	        
	        Element root = doc.createElement("map");
	        root.setAttribute("id","ATTABZAA001R08");
	        doc.appendChild(root);
	        Element pubcUserNo = doc.createElement("pubcUserNo");
	        root.appendChild(pubcUserNo);

	        Element mobYn = doc.createElement("mobYn");
	        mobYn.setTextContent("N");
	        root.appendChild(mobYn);

	        Element inqrTrgtClCd = doc.createElement("inqrTrgtClCd");
	        inqrTrgtClCd.setTextContent("1");
	        root.appendChild(inqrTrgtClCd);
	        
	        Element txprDscmNo = doc.createElement("txprDscmNo");
	        txprDscmNo.setTextContent(inputCompany);
	        root.appendChild(txprDscmNo);
	  
	        Element dongCode = doc.createElement("dongCode");
	        dongCode.setTextContent("15");
	        root.appendChild(dongCode);
	        
	        Element psbSearch = doc.createElement("psbSearch");
	        psbSearch.setTextContent("Y");
	        root.appendChild(psbSearch);  
	        
	        Element map2 = doc.createElement("map");
	        map2.setAttribute("id","userReqInfoVO");
	        root.appendChild(map2);   
	        
	        TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer former = factory.newTransformer();
	        former.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        former.setOutputProperty(OutputKeys.INDENT, "yes");
	        
	        StringWriter sw = new StringWriter();
	        StreamResult result = new StreamResult(sw);
	        DOMSource source = new DOMSource(doc);
	        former.transform(source, result);
	        
	        try{
	           //전송할 서버 url
	            URL searchUrl = new URL("https://teht.hometax.go.kr/wqAction.do?actionId=ATTABZAA001R08&screenId=UTEABAAA13&popupYn=false&realScreenId=");
	            connection = (HttpURLConnection)searchUrl.openConnection();
	            connection.setDoOutput(true);
	            connection.setRequestMethod("POST");
	            connection.setRequestProperty( "Content-Type", "text/xml" );
	            connection.setRequestProperty( "Content-Length", Integer.toString(sw.toString().length()));

	            os = connection.getOutputStream();

	            os.write( sw.toString().getBytes("utf-8") );
	            os.flush();
	            os.close();

	            //결과값 수신
	            int rc = connection.getResponseCode();
	            if(rc==200){
	                InputStreamReader in = new InputStreamReader(connection.getInputStream(),"utf-8");
	                BufferedReader br = new BufferedReader(in);
	                String strLine;
	                while ((strLine = br.readLine()) != null){
	                    returnString = returnString.concat(strLine);
	                }

	            }else{
	                System.out.println("http response code error: "+rc+"\n");
	    			jObject.put("outputResult", "-2");
	                return;
	            }

	        } catch( IOException e ){
	            System.out.println("search URL connect failed: " + e.getMessage());
				jObject.put("outputResult", "-3");
	            e.printStackTrace();
	        }finally{
	        	if(os!=null) os.close();
	        	connection.disconnect();
	        }
			
	        
	        try {
				org.json.JSONObject objsct = null;
	            org.json.JSONObject xmlJSONObj = XML.toJSONObject(returnString);
	            String jsonPrettyPrintString = xmlJSONObj.toString(4);
	            returnString = jsonPrettyPrintString;
	            objsct = xmlJSONObj;
		        
	            checkResult = objsct.getJSONObject("map").getString("trtCntn");
		        
		        
	        } catch (JSONException je) {
	            System.out.println(je.toString());
	        }
	        
	        if(checkResult.equals("부가가치세 일반과세자 입니다.")) {
				String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
				String encryptBusinessNumber = EncryptUtil.AES_Encode(inputCompany, aesKey);
				jObject.put("outputResult", "1");
//
//				int check = MemberDAO.checkCompany(encryptBusinessNumber);
//				if(check==0) {
//				} else {
//					jObject.put("outputResult", "-1");
//
//				}

	        } else {
				jObject.put("outputResult", "-2");
	        }
	        
			CommonUtil.commonPrintLog("SUCCESS", className, "Company Check OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkEmail(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();
			
			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputNumber = req.getParameter("inputNumber") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputNumber").toString())) : 0;				
			String inputEmail = req.getParameter("inputEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputEmail").toString()) : null;
			String key = "zrmMgIa4mQMssyPY1Y%2Fao0z7Xr6i7i9YOdn%2B0sISrGUHkdbMsay3aU6ov%2BH5wo9%2BEBzXfCQ0teCQn1Jz45YoGg%3D%3D";
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
//			if(privateKey == null) {
//				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
//				jObject.put("outputResult", "-2");
//				res.getWriter().write(jObject.toString());
//				return;
//			}	
			

			String host = "smtp.naver.com";
			final String user = "shotzara";
			final String password = "rmlarmla12!";
			
		    // Get the session object
		    Properties props = new Properties();
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.auth", "true");
		  
		    Session sessionMail = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(user, password);
			   }
		    });
		  
		    MimeMessage message = new MimeMessage(sessionMail);
		    message.setFrom(new InternetAddress(user));
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(inputEmail));

		    String randomNum = "123123123";
		    // Subject
		    message.setSubject("안녕하세요. 크리에이터 광고의 모든것, 랭크리입니다.");
			   
		    // Text
		    message.setText("가입 인증 번호입니다.\n 인증번호 : "+randomNum);

		    // send the message
		    Transport.send(message);
		    System.out.println("message sent successfully...");
			jObject.put("outputAuthNo", randomNum);

			CommonUtil.commonPrintLog("SUCCESS", className, "Login Check OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void permitJoin(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			String inputEmail = req.getParameter("inputEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputEmail").toString()) : null;
			String inputCheckValue = req.getParameter("inputCheckValue") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputCheckValue").toString()) : null;
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// 메일/ 회원체크
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputEmail, aesKey);
			
			int check = MemberDAO.checkMemberAuthToken(encryptMemberEmail, inputCheckValue);
			if(check!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "AuthToken not correct!!!", map);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				return;
			}
			int check2 = MemberDAO.permitJoin(encryptMemberEmail);
			if(check2!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "Join Permit Fail", map);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Join Permit OK", map);
			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void checkPermitJoin(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			String inputEmail = req.getParameter("inputEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputEmail").toString()) : null;
			String inputCheckValue = req.getParameter("inputCheckValue") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputCheckValue").toString()) : null;
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// 메일/ 회원체크
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputEmail, aesKey);
			
			int check = MemberDAO.checkMemberAuthToken(encryptMemberEmail, inputCheckValue);
			if(check!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "AuthToken not correct!!!", map);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				return;
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Join Permit Chek OK", map);
			MemberUid memberUid = MemberDAO.getMemberUidByEmail(encryptMemberEmail);
			req.setAttribute("memberUid",memberUid.getRacMemberUid());
			req.setAttribute("inputEmail",inputEmail);
			req.setAttribute("inputCheckValue",inputCheckValue);
			req.getRequestDispatcher("/02_page/Auth/joinPermit.jsp").forward(req, res);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addMemberAdTarget(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {			
			HttpSession session = req.getSession();

			int inputAdCategory = req.getParameter("inputAdCategory") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputAdCategory").toString())) : 0;				
			int inputTargetAge = req.getParameter("inputTargetAge") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputTargetAge").toString())) : 0;				
			int inputTargetSex = req.getParameter("inputTargetSex") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputTargetSex").toString())) : 0;				
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : null;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
			if(privateKey == null) {
				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}	
			

			String decryptMemberUid = EncryptUtil.RSA_Decode(privateKey, inputMemberUid);
				
			// 회원의 광고 타겟 저장 
			int check = MemberDAO.addMemberAdTarget(inputAdCategory, inputTargetAge, inputTargetSex, decryptMemberUid);
			if(check!=1) {
				CommonUtil.commonPrintLog("SUCCESS", className, "Join Permit Fail", map);
				jObject.put("outputResult", "-1");
			}
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Join Permit OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void goReview(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();
			
			String inputMemberUid = req.getParameter("inputMemberUid") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberUid").toString()) : null;
			String inputEmail = req.getParameter("inputEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputEmail").toString()) : null;
			String inputCheckValue = req.getParameter("inputCheckValue") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputCheckValue").toString()) : null;

			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			PrivateKey privateKey = null;
			privateKey = (PrivateKey)session.getAttribute("PrivateKey");				
			session.removeAttribute("PrivateKey"); // 키의 재사용 방지
			
			if(privateKey == null) {
				CommonUtil.commonPrintLog("ERROR", className, "PrivateKey is Null", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}	
			
			String decryptMemberUid = EncryptUtil.RSA_Decode(privateKey, inputMemberUid);
			Member member = MemberDAO.getMemberByMemberUid(decryptMemberUid);
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(inputEmail, aesKey);

			int check = MemberDAO.checkMemberAuthToken(encryptMemberEmail, inputCheckValue);
			if(check!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "AuthToken not correct!!!", map);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				return;
			}
			
			int check2 = MemberDAO.permitJoin(encryptMemberEmail);
			if(check2!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "Join Permit Fail", map);
				req.getRequestDispatcher("/error.jsp").forward(req, res);
				return;
			}
			
			MemberController.setMemberSession(session, member, decryptMemberUid, aesKey);

			CommonUtil.commonPrintLog("SUCCESS", className, "goReview OK", map);
			req.getRequestDispatcher("/02_page/Review/review.jsp").forward(req, res);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getMypage(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();
		
			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			Calendar calendar = Calendar.getInstance();
			calendar.set(calendar.HOUR_OF_DAY,4);
			calendar.set(calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) -1);
			Timestamp inputCurrentDate = new java.sql.Timestamp(calendar.getTime().getTime()); 
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			Company company = MemberDAO.getCompanyByMemberNo(sessionMemberNo);
			req.setAttribute("outputCompanyName", EncryptUtil.AES_Decode(company.getRacCompanyName(), aesKey));
			
			Member member = MemberDAO.getMemberByMemberNo(sessionMemberNo);
			String memberName = EncryptUtil.AES_Decode(member.getRacMemberEmail(), aesKey);
			req.setAttribute("outputMemberName", memberName.substring(0, memberName.indexOf("@")));

			// 리뷰 리스트 
			ArrayList<Review> reviewList = MemberDAO.getReviewListByMemberNo(sessionMemberNo, 0);
			int reviewCount = MemberDAO.countMemberReview(sessionMemberNo);
			req.setAttribute("outputReviewCount", reviewCount);
			
			Paging reviewPaging = new Paging(1, 5);
			reviewPaging.setNumberOfRecords(reviewCount);
			reviewPaging.makePaging();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
			ArrayList<HashMap<String,Object>> outputReviewList = new ArrayList<HashMap<String,Object>>();
			for(int i=0; i<reviewList.size();i++) {
				HashMap<String,Object> tempObject = new HashMap<String,Object>();
				tempObject.put("outputChannelTitle", ChannelDAO.getChannelByNo(reviewList.get(i).getRacChannelNo()).getRacChannelTitle());
				tempObject.put("outputReviewSatisfy", CommonUtil.getReviewSatisfy(reviewList.get(i).getRacReviewSatisfy()));
				tempObject.put("outputReviewCreateDate", dateFormat.format(reviewList.get(i).getRacReviewCreateDate()));
				tempObject.put("outputReviewStatus", CommonUtil.getReviewStatus(reviewList.get(i).getRacReviewStatus()));

				outputReviewList.add(tempObject);
			}
			req.setAttribute("outputReviewList", outputReviewList);
			req.setAttribute("reviewFirstPageNo", reviewPaging.getFirstPageNo());
			req.setAttribute("reviewPrevPageNo", reviewPaging.getPrevPageNo());
			req.setAttribute("reviewCurrentPageNo", reviewPaging.getCurrentPageNo());
			req.setAttribute("reviewNextPageNo", reviewPaging.getNextPageNo());
			req.setAttribute("reviewPaging", reviewPaging);
			
			// 최근 본 채널
			ArrayList<Channel> channelViewList = MemberDAO.getRecentChannelList(sessionMemberNo, 0);
			int recentCount = MemberDAO.countMemberChannelView(sessionMemberNo);
			req.setAttribute("outputRecentCount", recentCount);
			
			Paging recentPaging = new Paging(1, 5);
			recentPaging.setNumberOfRecords(recentCount);
			recentPaging.makePaging();

			ArrayList<HashMap<String,Object>> outputChannelViewList = new ArrayList<HashMap<String,Object>>();
			for(int i=0; i<channelViewList.size();i++) {
				HashMap<String,Object> tempObject = new HashMap<String,Object>();
				tempObject.put("outputChannelName", channelViewList.get(i).getRacChannelTitle());
				tempObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(channelViewList.get(i).getRacChannelCategory()));
				tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(channelViewList.get(i).getRacChannelFollowers()));
				tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(channelViewList.get(i).getRacChannelViews()));
				tempObject.put("outputChannelThumbnail", channelViewList.get(i).getRacChannelThumbnail());
				tempObject.put("outputChannelNo", channelViewList.get(i).getRacChannelNo());
				tempObject.put("outputChannelLike", ChannelDAO.checkChannelLike(sessionMemberNo, channelViewList.get(i).getRacChannelNo()));
				outputChannelViewList.add(tempObject);
			}
			
			if(channelViewList.size()==0) {
				ArrayList<Channel> recomandChannelList = ChannelDAO.getRecomandChannel(inputCurrentDate, 4);
				ArrayList<HashMap<String,Object>> outputRecomandChannelList = new ArrayList<HashMap<String,Object>>();
				for(int i=0; i < recomandChannelList.size(); i++) {
					HashMap<String,Object> tempObject = new HashMap<String,Object>();
					tempObject.put("outputChannelNo", recomandChannelList.get(i).getRacChannelNo());
					tempObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(recomandChannelList.get(i).getRacChannelCategory()));
					tempObject.put("outputChannelUrl", recomandChannelList.get(i).getRacChannelUrl());
					tempObject.put("outputChannelTitle", recomandChannelList.get(i).getRacChannelTitle());
					tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(recomandChannelList.get(i).getRacChannelFollowers()));
					tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(recomandChannelList.get(i).getRacChannelViews()));
					tempObject.put("outputChannelThumbnail", recomandChannelList.get(i).getRacChannelThumbnail());
					outputRecomandChannelList.add(tempObject);
				}
				
				req.setAttribute("outputChannelViewRandom", outputRecomandChannelList);
			}
			req.setAttribute("outputChannelViewList", outputChannelViewList);
			req.setAttribute("recentFirstPageNo", recentPaging.getFirstPageNo());
			req.setAttribute("recentPrevPageNo", recentPaging.getPrevPageNo());
			req.setAttribute("recentCurrentPageNo", recentPaging.getCurrentPageNo());
			req.setAttribute("recentNextPageNo", recentPaging.getNextPageNo());
			req.setAttribute("recentPaging", recentPaging);
			
			// 관심 채널 
			ArrayList<Channel> channelLikeList = MemberDAO.getChannelLikeList(sessionMemberNo, 0);
			int likeCount = MemberDAO.countMemberChannelLike(sessionMemberNo);
			req.setAttribute("outputLikeCount", likeCount);
			
			Paging likePaging = new Paging(1, 5);
			likePaging.setNumberOfRecords(likeCount);
			likePaging.makePaging();

			ArrayList<HashMap<String,Object>> outputChannelLikeList = new ArrayList<HashMap<String,Object>>();
			for(int i=0; i<channelLikeList.size();i++) {
				HashMap<String,Object> tempObject = new HashMap<String,Object>();
				tempObject.put("outputChannelName", channelLikeList.get(i).getRacChannelTitle());
				tempObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(channelLikeList.get(i).getRacChannelCategory()));
				tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(channelLikeList.get(i).getRacChannelFollowers()));
				tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(channelLikeList.get(i).getRacChannelViews()));
				tempObject.put("outputChannelThumbnail", channelLikeList.get(i).getRacChannelThumbnail());
				tempObject.put("outputChannelNo", channelLikeList.get(i).getRacChannelNo());
				tempObject.put("outputChannelLike", ChannelDAO.checkChannelLike(sessionMemberNo, channelLikeList.get(i).getRacChannelNo()));
				outputChannelLikeList.add(tempObject);
			}
			if(channelLikeList.size()==0) {
				ArrayList<Channel> recomandChannelList = ChannelDAO.getRecomandChannel(inputCurrentDate, 4);
				ArrayList<HashMap<String,Object>> outputRecomandChannelList2 = new ArrayList<HashMap<String,Object>>();
				for(int i=0; i < recomandChannelList.size(); i++) {
					HashMap<String,Object> tempObject = new HashMap<String,Object>();
					tempObject.put("outputChannelNo", recomandChannelList.get(i).getRacChannelNo());
					tempObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(recomandChannelList.get(i).getRacChannelCategory()));
					tempObject.put("outputChannelUrl", recomandChannelList.get(i).getRacChannelUrl());
					tempObject.put("outputChannelTitle", recomandChannelList.get(i).getRacChannelTitle());
					tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(recomandChannelList.get(i).getRacChannelFollowers()));
					tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(recomandChannelList.get(i).getRacChannelViews()));
					tempObject.put("outputChannelThumbnail", recomandChannelList.get(i).getRacChannelThumbnail());
					outputRecomandChannelList2.add(tempObject);
				}
				
				req.setAttribute("outputChannelLikeRandom", outputRecomandChannelList2);
			}
			req.setAttribute("outputChannelLikeList", outputChannelLikeList);
			req.setAttribute("likeFirstPageNo", likePaging.getFirstPageNo());
			req.setAttribute("likePrevPageNo", likePaging.getPrevPageNo());
			req.setAttribute("likeCurrentPageNo", likePaging.getCurrentPageNo());
			req.setAttribute("likeNextPageNo", likePaging.getNextPageNo());
			req.setAttribute("likePaging", likePaging);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "GET MyPage OK", map);
			req.getRequestDispatcher("/02_page/Corp/mainCorp.jsp").forward(req, res);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getRecentChannelList(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int startNo = req.getParameter("startNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("startNo").toString())) : 0;
			int pageNo = req.getParameter("pageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("pageNo").toString())) : 0;
			JSONObject jObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 최근 리스트
			ArrayList<Channel> channelViewList = MemberDAO.getRecentChannelList(sessionMemberNo, startNo);
			int recentCount = MemberDAO.countMemberChannelView(sessionMemberNo);
			jObject.put("outputRecentCount", recentCount);
			
			Paging recentPaging = new Paging(pageNo, 5);
			recentPaging.setNumberOfRecords(recentCount);
			recentPaging.makePaging();

			JSONArray outputChannelViewList = new JSONArray();
			for(int i=0; i<channelViewList.size();i++) {
				JSONObject tempObject = new JSONObject();
				tempObject.put("outputChannelName", channelViewList.get(i).getRacChannelTitle());
				tempObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(channelViewList.get(i).getRacChannelCategory()));
				tempObject.put("outputChannelFollowers", channelViewList.get(i).getRacChannelFollowers());
				tempObject.put("outputChannelViews", channelViewList.get(i).getRacChannelViews());
				tempObject.put("outputChannelThumbnail", channelViewList.get(i).getRacChannelThumbnail());
				tempObject.put("outputChannelNo", channelViewList.get(i).getRacChannelNo());
				tempObject.put("outputChannelLike", ChannelDAO.checkChannelLike(sessionMemberNo, channelViewList.get(i).getRacChannelNo()));

				outputChannelViewList.add(tempObject);
			}
			jObject.put("outputChannelList", outputChannelViewList);
			jObject.put("recentFirstPageNo", recentPaging.getFirstPageNo());
			jObject.put("recentPrevPageNo", recentPaging.getPrevPageNo());
			jObject.put("recentCurrentPageNo", recentPaging.getCurrentPageNo());
			jObject.put("recentNextPageNo", recentPaging.getNextPageNo());
			jObject.put("recentFinalPageNo", recentPaging.getFinalPageNo());

			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Recent Channl(mypage) OK", map);
			res.getWriter().write(jObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getReviewList(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int startNo = req.getParameter("startNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("startNo").toString())) : 0;
			int pageNo = req.getParameter("pageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("pageNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 최근 리스트
			ArrayList<Review> reviewList = MemberDAO.getReviewListByMemberNo(sessionMemberNo, startNo);
			int reviewCount = MemberDAO.countMemberReview(sessionMemberNo);
			jObject.put("outputReviewCount", reviewCount);
			
			Paging reveiwPaging = new Paging(pageNo, 5);
			reveiwPaging.setNumberOfRecords(reviewCount);
			reveiwPaging.makePaging();

			JSONArray outputReviewList = new JSONArray();
			for(int i=0; i<reviewList.size();i++) {
				JSONObject tempObject = new JSONObject();
				tempObject.put("outputChannelTitle", ChannelDAO.getChannelByNo(reviewList.get(i).getRacChannelNo()));
				tempObject.put("outputReviewSatisfy", CommonUtil.getReviewSatisfy(reviewList.get(i).getRacReviewSatisfy()));
				tempObject.put("outputReviewCreateDate", reviewList.get(i).getRacReviewCreateDate());
				tempObject.put("outputReviewStatus", CommonUtil.getReviewStatus(reviewList.get(i).getRacReviewStatus()));
				tempObject.put("outputChannelNo", reviewList.get(i).getRacChannelNo());

				outputReviewList.add(tempObject);
			}
			jObject.put("outputReviewList", outputReviewList);
			jObject.put("reviewFirstPageNo", reveiwPaging.getFirstPageNo());
			jObject.put("reviewPrevPageNo", reveiwPaging.getPrevPageNo());
			jObject.put("reviewCurrentPageNo", reveiwPaging.getCurrentPageNo());
			jObject.put("reviewNextPageNo", reveiwPaging.getNextPageNo());
			jObject.put("reviewFinalPageNo", reveiwPaging.getFinalPageNo());

			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get  Review (mypage) OK", map);
			res.getWriter().write(jObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getLikeChannelList(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int startNo = req.getParameter("startNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("startNo").toString())) : 0;
			int pageNo = req.getParameter("pageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("pageNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			if(!(sessionMemberNo>0)) {
				CommonUtil.commonPrintLog("ERROR", className, "No Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 최근 리스트
			ArrayList<Channel> channelLikeList = MemberDAO.getChannelLikeList(sessionMemberNo, startNo);
			int likeCount = MemberDAO.countMemberChannelLike(sessionMemberNo);
			jObject.put("outputRecentCount", likeCount);
			
			Paging likePaging = new Paging(pageNo, 5);
			likePaging.setNumberOfRecords(likeCount);
			likePaging.makePaging();

			JSONArray outputChannelViewList = new JSONArray();
			for(int i=0; i<channelLikeList.size();i++) {
				JSONObject tempObject = new JSONObject();
				tempObject.put("outputChannelName", channelLikeList.get(i).getRacChannelTitle());
				tempObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(channelLikeList.get(i).getRacChannelCategory()));
				tempObject.put("outputChannelFollowers", channelLikeList.get(i).getRacChannelFollowers());
				tempObject.put("outputChannelViews", channelLikeList.get(i).getRacChannelViews());
				tempObject.put("outputChannelThumbnail", channelLikeList.get(i).getRacChannelThumbnail());
				tempObject.put("outputChannelNo", channelLikeList.get(i).getRacChannelNo());
				tempObject.put("outputChannelLike", ChannelDAO.checkChannelLike(sessionMemberNo, channelLikeList.get(i).getRacChannelNo()));

				outputChannelViewList.add(tempObject);
			}
			jObject.put("outputChannelList", outputChannelViewList);
			jObject.put("likeFirstPageNo", likePaging.getFirstPageNo());
			jObject.put("likePrevPageNo", likePaging.getPrevPageNo());
			jObject.put("likeCurrentPageNo", likePaging.getCurrentPageNo());
			jObject.put("likeNextPageNo", likePaging.getNextPageNo());
			jObject.put("likeFinalPageNo", likePaging.getFinalPageNo());

			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Like Channl(mypage) OK", map);
			res.getWriter().write(jObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void changeMemberPassword(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			String inputMemberEmail = req.getParameter("inputMemberEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberEmail").toString()) : null;
			String inputMemberPassword = req.getParameter("inputMemberPassword") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPassword").toString()) : null;
			String inputMemberPasswordConfirm = req.getParameter("inputMemberPasswordConfirm") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputMemberPasswordConfirm").toString()) : null;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputMemberEmail);
			parameterList.add(inputMemberPassword);
			parameterList.add(inputMemberPasswordConfirm);
			
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
         
			// RSA Decrypt
			String decryptMemberEmail = EncryptUtil.RSA_Decode(privateKey, inputMemberEmail);
			String decryptMemberPassword = EncryptUtil.RSA_Decode(privateKey, inputMemberPassword);
				
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			String encryptMemberEmail = EncryptUtil.AES_Encode(decryptMemberEmail, aesKey);

			// SHA-256 Encrypt
			String encryptMemberPassword = EncryptUtil.SHA256_Encode(decryptMemberPassword);			
			String decryptMemberPasswordConfirm = EncryptUtil.RSA_Decode(privateKey, inputMemberPasswordConfirm);

			// Password and passwordConfirm is not correct
			if(!(decryptMemberPassword.equals(decryptMemberPasswordConfirm))) {
				CommonUtil.commonPrintLog("FAIL", className, "Password Not Correct!", map);
				jObject.put("outputResult", "-3");
				res.getWriter().write(jObject.toString());
				return;
			}

			// Join member 
			int check = MemberDAO.changeMemberPassword(encryptMemberEmail, encryptMemberPassword);

			if(check != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Change Password Fail", map);
				jObject.put("outputResult", "-4");
				res.getWriter().write(jObject.toString());
				return;
			}			
			
			CommonUtil.commonPrintLog("SUCCESS", className, "User Join OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
