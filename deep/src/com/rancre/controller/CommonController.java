package com.rancre.controller;

import java.io.File;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.TimeZone;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.rancre.config.GlobalValue;
import com.rancre.model.ChannelDAO;
import com.rancre.model.MemberDAO;
import com.rancre.model.UploadDAO;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.RankCategory;
import com.rancre.model.domain.RankTop;
import com.rancre.model.domain.Upload;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

public class CommonController {
	
	private static final String className = "CommonController";
	private static final int KEY_SIZE = 1024;
	
	public static void initMain(HttpServletRequest req, HttpServletResponse res) {
	
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			String ua=req.getHeader("User-Agent").toLowerCase();
			 
			//모바일 확인 
			if (ua.matches(".*(android|avantgo|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|symbian|treo|up\\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino).*")||ua.substring(0,4).matches("1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\\-(n|u)|c55\\/|capi|ccwa|cdm\\-|cell|chtm|cldc|cmd\\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\\-s|devi|dica|dmob|do(c|p)o|ds(12|\\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\\-|_)|g1 u|g560|gene|gf\\-5|g\\-mo|go(\\.w|od)|gr(ad|un)|haie|hcit|hd\\-(m|p|t)|hei\\-|hi(pt|ta)|hp( i|ip)|hs\\-c|ht(c(\\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\\-(20|go|ma)|i230|iac( |\\-|\\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\\/)|klon|kpt |kwc\\-|kyo(c|k)|le(no|xi)|lg( g|\\/(k|l|u)|50|54|e\\-|e\\/|\\-[a-w])|libw|lynx|m1\\-w|m3ga|m50\\/|ma(te|ui|xo)|mc(01|21|ca)|m\\-cr|me(di|rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\\-2|po(ck|rt|se)|prox|psio|pt\\-g|qa\\-a|qc(07|12|21|32|60|\\-[2-7]|i\\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\\-|oo|p\\-)|sdk\\/|se(c(\\-|0|1)|47|mc|nd|ri)|sgh\\-|shar|sie(\\-|m)|sk\\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\\-|v\\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\\-|tdg\\-|tel(i|m)|tim\\-|t\\-mo|to(pl|sh)|ts(70|m\\-|m3|m5)|tx\\-9|up(\\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|xda(\\-|2|g)|yas\\-|your|zeto|zte\\-")){
				CommonUtil.commonPrintLog("SUCCESS", className, "Init Moblie Main OK", map);
				req.getRequestDispatcher("/07_Mpage/main.jsp").forward(req, res);

				return;
			}else {
				CommonUtil.commonPrintLog("SUCCESS", className, "Init Main OK", map);
				req.getRequestDispatcher("/index.jsp").forward(req, res);
				return;			
			}

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getRSAPublicKey(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {			
			// 키 생성
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(KEY_SIZE);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			// 공개키를 문자열로 변환하여 JavaScript RSA 라이브러리 넘겨준다.
			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec privateSpec = (RSAPrivateKeySpec)keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
						
			String privateKeyModulus = privateSpec.getModulus().toString(16);
			String privateKeyExponent = privateSpec.getPrivateExponent().toString(16);
			
			// JSON 오브젝트에 저장한 후 리턴
			JSONObject jObject = new JSONObject();
			jObject.put("racPublicKeyModulus", publicKeyModulus);
			jObject.put("racPublicKeyExponent", publicKeyExponent);

			HttpSession session = req.getSession();
			session.setAttribute("PrivateKey", privateKey);				
	
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			CommonUtil.commonPrintLog("SUCCESS", className, "PublicKey Generation OK", map);
			res.getWriter().write(jObject.toString());
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getRankingList(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			// Top100 Mode : 1, All Mode : 2, New Mode : 3
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 0;
			int startNo = req.getParameter("startNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("startNo").toString())) : 0;
			int categoryNo = req.getParameter("categoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("categoryNo").toString())) : 0;
			JSONObject jMainObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			
			Date date = new Date();
			SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd");
			formatType.setTimeZone(TimeZone.getTimeZone("GMT+9"));
			Timestamp beforeDate;
			Timestamp afterDate;
			
			// 배치 돈 후 데이트와 배치 돌기 전 데이트 분기
			if(date.getHours()>6) {
				date.setDate(date.getDate()-1);
				date.setHours(0);			
				date.setMinutes(0);
				date.setSeconds(0);
				beforeDate = new Timestamp(date.getTime());
				date.setDate(date.getDate()+1);
				afterDate = new Timestamp(date.getTime());
			} else {
				date.setDate(date.getDate()-2);
				date.setHours(0);			
				date.setMinutes(0);
				date.setSeconds(0);
				beforeDate = new Timestamp(date.getTime());
				date.setDate(date.getDate()+1);
				afterDate = new Timestamp(date.getTime());
			}

			// 순위 리스트
			JSONArray rankingList = new JSONArray();
			if(mode == 1) {
				ArrayList<RankTop> ranking = ChannelDAO.getRankingList(startNo);
				for(int i=0; i<ranking.size(); i++) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("outputRankTopNo", ranking.get(i).getRacRankTopNo());
					tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());

					int checkBefore  = ChannelDAO.checkChannelBefore(ranking.get(i).getRacChannelNo(),beforeDate,afterDate);
					if(checkBefore==0) {
						tempObject.put("outputRankUpDown", " rancNew'>new");

					} else {
						int beforRanking = ChannelDAO.getRankBefore(ranking.get(i).getRacChannelNo(),beforeDate,afterDate);
						if(ranking.get(i).getRacRankTopNo()-beforRanking <0) 
							tempObject.put("outputRankUpDown", " rancUp'>&utrif;"+(ranking.get(i).getRacRankTopNo()-beforRanking)*-1);
						else if(ranking.get(i).getRacRankTopNo()-beforRanking >0)
							tempObject.put("outputRankUpDown", " rancDown'>&dtrif;"+(ranking.get(i).getRacRankTopNo()-beforRanking));
						else
							tempObject.put("outputRankUpDown", "'>-");				
					}
					tempObject.put("outputCategoryNo", CommonUtil.getChannelCategoryList(ranking.get(i).getRacChannelCategory()));
					tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
					tempObject.put("outputChannelTitle", CommonUtil.splitString(ranking.get(i).getRacChannelTitle(), 2));
					tempObject.put("outputChannelFollowers", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelFollowers()));
					tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(ranking.get(i).getRacChannelViews()));
					tempObject.put("outputChannelVideoCount", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelVideoCount()));
					tempObject.put("outputChannelThumbnail", ranking.get(i).getRacChannelThumbnail());
					
					rankingList.add(tempObject);
				}
			}
			else {
				ArrayList<RankCategory> ranking = ChannelDAO.getRankingList2(mode, startNo, categoryNo);
				for(int i=0; i<ranking.size(); i++) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());
					// 카테고리 가져오기
					tempObject.put("outputCategoryNo", CommonUtil.getChannelCategoryList(ranking.get(i).getRacChannelCategory()));
					tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
					// 13자리 
					tempObject.put("outputChannelTitle", CommonUtil.splitString(ranking.get(i).getRacChannelTitle(), 2));
					String channelFollowers = CommonUtil.setCommaForInt(ranking.get(i).getRacChannelFollowers());
					if(channelFollowers.equals("-1")) channelFollowers="비공개";
					req.setAttribute("outputChannelFollowers", channelFollowers);
					tempObject.put("outputChannelFollowers", channelFollowers);
					tempObject.put("outputChannelViews", CommonUtil.setCommaForLong(ranking.get(i).getRacChannelViews()));
					tempObject.put("outputChannelVideoCount", CommonUtil.setCommaForInt(ranking.get(i).getRacChannelVideoCount()));
					tempObject.put("outputChannelThumbnail", ranking.get(i).getRacChannelThumbnail());
					
					rankingList.add(tempObject);
				}
			}

			jMainObject.put("rankingList", rankingList);
			
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get RankingList OK", map);
			res.getWriter().write(jMainObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getMRankingMain(HttpServletRequest req, HttpServletResponse res) {
		
		HashMap<String, String> map = new HashMap<String, String>();
	
		try{
			HttpSession session = req.getSession();

			int startNo = req.getParameter("startNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("startNo").toString())) : 0;
			int categoryNo = req.getParameter("categoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("categoryNo").toString())) : 0;
			JSONObject jMainObject = new JSONObject();
			
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			
			Date date = new Date();
			SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd");
			formatType.setTimeZone(TimeZone.getTimeZone("GMT+9"));
			Timestamp beforeDate;
			Timestamp afterDate;
			
			// 배치 돈 후 데이트와 배치 돌기 전 데이트 분기
			if(date.getHours()>6) {
				date.setDate(date.getDate()-1);
				date.setHours(0);			
				date.setMinutes(0);
				date.setSeconds(0);
				beforeDate = new Timestamp(date.getTime());
				date.setDate(date.getDate()+1);
				afterDate = new Timestamp(date.getTime());
			} else {
				date.setDate(date.getDate()-2);
				date.setHours(0);			
				date.setMinutes(0);
				date.setSeconds(0);
				beforeDate = new Timestamp(date.getTime());
				date.setDate(date.getDate()+1);
				afterDate = new Timestamp(date.getTime());
			}

			// 순위 리스트
		JSONArray rankingList = new JSONArray();
			ArrayList<RankTop> ranking = ChannelDAO.getRankingList(startNo);
			for(int i=0; i<ranking.size(); i++) {
				JSONObject tempObject = new JSONObject();
				tempObject.put("outputRankTopNo", ranking.get(i).getRacRankTopNo());
				tempObject.put("outputChannelNo", ranking.get(i).getRacChannelNo());

				int checkBefore  = ChannelDAO.checkChannelBefore(ranking.get(i).getRacChannelNo(),beforeDate,afterDate);
				if(checkBefore==0) {
					tempObject.put("outputRankUpDown", "new");

				} else {
					int beforRanking = ChannelDAO.getRankBefore(ranking.get(i).getRacChannelNo(),beforeDate,afterDate);
					if(ranking.get(i).getRacRankTopNo()-beforRanking <0) 
						tempObject.put("outputRankUpDown", "<span>"+(ranking.get(i).getRacRankTopNo()-beforRanking)*-1+"<i class=\"icon-down-micro\"></i></span>");
					else if(ranking.get(i).getRacRankTopNo()-beforRanking >0)
						tempObject.put("outputRankUpDown", "<span>"+(ranking.get(i).getRacRankTopNo()-beforRanking)+"<i class=\"icon-up-micro\"></i></span>");
					else
						tempObject.put("outputRankUpDown", "<i class=\"icon-minus\"></i>");				
				}
				tempObject.put("outputCategoryNo", CommonUtil.getChannelCategoryList(ranking.get(i).getRacChannelCategory()));
				tempObject.put("outputChannelUrl", ranking.get(i).getRacChannelUrl());
				tempObject.put("outputChannelTitle", CommonUtil.splitString(ranking.get(i).getRacChannelTitle(), 2));
				tempObject.put("outputChannelFollowers", CommonUtil.setMobileFollower(ranking.get(i).getRacChannelFollowers()));
				tempObject.put("outputChannelThumbnail", ranking.get(i).getRacChannelThumbnail());
				
				rankingList.add(tempObject);
			
			}

			jMainObject.put("rankingList", rankingList);
			
			
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get MRankingMain OK", map);
			res.getWriter().write(jMainObject.toString());
//			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void contactUs(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			Calendar calendar = Calendar.getInstance();
			Timestamp inputCurrentDate = new java.sql.Timestamp(calendar.getTime().getTime());
			String inputEmail = req.getParameter("inputEmail") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputEmail").toString()) : null;
			String inputContent = req.getParameter("inputContent") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputContent").toString()) : null;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputEmail);
			parameterList.add(inputContent);

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
		

			// 완료 

			  String host     = "smtp.naver.com";
			  final String user   = "shotzara@naver.com";
			  final String password  = "rmlarmla12!";

			  String to = user;

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
			   message.setSubject("문의 메일");
			   
			   // Text
			   message.setText(" 보낸이 : " + EncryptUtil.RSA_Decode(privateKey, inputEmail)
			   		+ "\n 보낸날짜 : " + inputCurrentDate
			   		+ "\n 내용 : " + EncryptUtil.RSA_Decode(privateKey, inputContent)
			   		+ ""
			   		+ "");

			   // send the message
			   Transport.send(message);
			   System.out.println("message sent successfully...");

			  } catch (MessagingException e) {
			   e.printStackTrace();
			  }
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Contact Us OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
