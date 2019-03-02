package com.rancre.controller;

import java.io.File;
import java.net.URL;
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
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.rancre.config.GlobalValue;
import com.rancre.model.AdminDAO;
import com.rancre.model.ChannelDAO;
import com.rancre.model.FeedDAO;
import com.rancre.model.MemberDAO;
import com.rancre.model.UploadDAO;
import com.rancre.model.domain.Channel;
import com.rancre.model.domain.ChannelAd;
import com.rancre.model.domain.ChannelCategory;
import com.rancre.model.domain.ChannelCost;
import com.rancre.model.domain.Company;
import com.rancre.model.domain.Feed;
import com.rancre.model.domain.FeedComment;
import com.rancre.model.domain.FeedCount;
import com.rancre.model.domain.FeedHashtag;
import com.rancre.model.domain.FeedList;
import com.rancre.model.domain.FeedSeries;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.MemberFavorite;
import com.rancre.model.domain.Paging;
import com.rancre.model.domain.Review;
import com.rancre.model.domain.Upload;
import com.rancre.util.CommonUtil;
import com.rancre.util.EncryptUtil;

public class AdminController {

	public static final String className = "AdminController";

	public static void getChannelList(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int page = req.getParameter("page") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("page").toString())) : 1;
			int size = req.getParameter("size") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("size").toString())) : 10;
			
			if(page==0) page=1;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			/// Check Admin Member 

			JSONArray jChannelArray = new JSONArray();
			int channelStatus = 2; // 정상 등록 
			Paging paging = new Paging(page, size);
			int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();

			// 현재 대출 가능한 도서(book_lending_possible이 true인 목록만 가져옴)
			ArrayList<Channel> channelList = AdminDAO.getChannelList(channelStatus, offset, paging.getRecordsPerPage());

			// bookList 전체 갯수 구하여 numberOfRecords 메소드에 셋팅함 
			paging.setNumberOfRecords(AdminDAO.countTotalChannel());
			paging.makePaging();

			for(int i=0; i<channelList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				// channel
				jTempObject.put("outputChannelNo", channelList.get(i).getRacChannelNo());
				jTempObject.put("outputChannelTitle", channelList.get(i).getRacChannelTitle());
				jTempObject.put("outputChannelUrl", channelList.get(i).getRacChannelUrl());
				jTempObject.put("outputChannelFollowers", channelList.get(i).getRacChannelFollowers());
				jTempObject.put("outputChannelViews", channelList.get(i).getRacChannelViews());
				jTempObject.put("outputChannelCategory", channelList.get(i).getRacChannelCategory());
				// 후기 가져오기
				jTempObject.put("outputPostscriptCount", 0);
				// 광고 영상에 대하여 
				jTempObject.put("outputChannelAdCount", AdminDAO.countChannelAd(channelList.get(i).getRacChannelNo()));
				// 단가에 대하여  
				int costCount = AdminDAO.countChannelCost(channelList.get(i).getRacChannelNo());
				if(costCount != 0) {
					jTempObject.put("outputChannelCostCount",costCount);
					jTempObject.put("outputChannelCostEvenPrice", AdminDAO.getChannelCostPrice(channelList.get(i).getRacChannelNo())/costCount);

				} else {
					jTempObject.put("outputChannelCostCount","미등록");
					jTempObject.put("outputChannelCostEvenPrice", "0");

				}

				jChannelArray.add(jTempObject);
			}

			jObject.put("outputChannelList", jChannelArray);
			jObject.put("firstPageNo", paging.getFirstPageNo());
			jObject.put("prevPageNo", paging.getPrevPageNo());
			jObject.put("currentPageNo", paging.getCurrentPageNo());
			jObject.put("nextPageNo", paging.getNextPageNo());
			jObject.put("paging", paging);
	
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel List OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/channelList.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getChannelEtcList(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int page = req.getParameter("page") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("page").toString())) : 1;
			int size = req.getParameter("size") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("size").toString())) : 10;
			
			if(page==0) page=1;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			/// Check Admin Member 

			JSONArray jChannelArray = new JSONArray();
			Paging paging = new Paging(page, size);
			int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();

			// 현재 대출 가능한 도서(book_lending_possible이 true인 목록만 가져옴)
			ArrayList<Channel> channelList = AdminDAO.getChannelEtcList(offset, paging.getRecordsPerPage());

			// bookList 전체 갯수 구하여 numberOfRecords 메소드에 셋팅함 
			paging.setNumberOfRecords(AdminDAO.countTotalChannel());
			paging.makePaging();

			for(int i=0; i<channelList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				// channel
				jTempObject.put("outputChannelNo", channelList.get(i).getRacChannelNo());
				jTempObject.put("outputChannelTitle", channelList.get(i).getRacChannelTitle());
				jTempObject.put("outputChannelUrl", channelList.get(i).getRacChannelUrl());
				jTempObject.put("outputChannelFollowers", channelList.get(i).getRacChannelFollowers());
				jTempObject.put("outputChannelViews", channelList.get(i).getRacChannelViews());
				jTempObject.put("outputChannelCategory", channelList.get(i).getRacChannelCategory());
				// 후기 가져오기
				jTempObject.put("outputPostscriptCount", 0);
				// 광고 영상에 대하여 
				jTempObject.put("outputChannelAdCount", AdminDAO.countChannelAd(channelList.get(i).getRacChannelNo()));
				// 단가에 대하여  
				int costCount = AdminDAO.countChannelCost(channelList.get(i).getRacChannelNo());
				if(costCount != 0) {
					jTempObject.put("outputChannelCostCount",costCount);
					jTempObject.put("outputChannelCostEvenPrice", AdminDAO.getChannelCostPrice(channelList.get(i).getRacChannelNo())/costCount);

				} else {
					jTempObject.put("outputChannelCostCount","미등록");
					jTempObject.put("outputChannelCostEvenPrice", "0");

				}

				jChannelArray.add(jTempObject);
			}

			jObject.put("outputChannelList", jChannelArray);
			jObject.put("firstPageNo", paging.getFirstPageNo());
			jObject.put("prevPageNo", paging.getPrevPageNo());
			jObject.put("currentPageNo", paging.getCurrentPageNo());
			jObject.put("nextPageNo", paging.getNextPageNo());
			jObject.put("paging", paging);
	
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel List OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/channelEtcList.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void addChannelCost(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			int inputChannelAdType = req.getParameter("inputChannelAdType") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelAdType").toString())) : 0;
			int inputChannelCostPrice = req.getParameter("inputChannelCostPrice") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelCostPrice").toString())) : 0;
			Calendar calendar = Calendar.getInstance();
			Timestamp inputCurrentDate = new java.sql.Timestamp(calendar.getTime().getTime());

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputChannelNo);
			parameterList.add(inputChannelAdType);
			parameterList.add(inputChannelCostPrice);

			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Join member 
			int check = AdminDAO.addChannelCost(inputChannelNo, inputChannelAdType, inputChannelCostPrice, inputCurrentDate);

			if(check != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add Channel Fail", map);
				jObject.put("outputResult", "-6");
				res.getWriter().write(jObject.toString());
				return;
			}			

			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "Channel Add OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addChannelAdUrl(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			int inputPageNo = req.getParameter("inputPageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputPageNo").toString())) : 1;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			String[] inputChannelAdUrls = req.getParameterValues("inputChannelAdUrls");
			ArrayList<String> channeAdUrls = new ArrayList<String>();
			for(int i=0; i<inputChannelAdUrls.length;i++) {
				if(!inputChannelAdUrls[i].equals(""))
					channeAdUrls.add(CommonUtil.commonCleanXSS(inputChannelAdUrls[i]));
			}
			
			String[] inputChannelAdCategorys = req.getParameterValues("inputChannelAdCategory");
			ArrayList<Integer> channeAdCategorys = new ArrayList<Integer>();
			for(int i=0; i<inputChannelAdCategorys.length;i++) {
				if(!inputChannelAdCategorys[i].equals("0"))
					channeAdCategorys.add(Integer.parseInt(CommonUtil.commonCleanXSS(inputChannelAdCategorys[i])));
			} 
			
			String[] inputChannelAdTypes = req.getParameterValues("inputChannelAdType");
			ArrayList<Integer> channeAdTypes= new ArrayList<Integer>();
			for(int i=0; i<inputChannelAdTypes.length;i++) {
				if(!inputChannelAdTypes[i].equals("0"))
					channeAdTypes.add(Integer.parseInt(CommonUtil.commonCleanXSS(inputChannelAdTypes[i])));
			} 
			
			Calendar calendar = Calendar.getInstance();
			Timestamp inputCurrentDate = new java.sql.Timestamp(calendar.getTime().getTime());



			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(channeAdUrls);

			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Channel Ad Video  
			for(int i=0; i<channeAdUrls.size();i++) {
				String url= "https://www.youtube.com/watch?v=" + channeAdUrls.get(i);
				Document doc = Jsoup.parse(new URL(url).openStream(), "utf-8", url);
				
				String viewsContent = doc.select(".watch-view-count").toString().substring(35, doc.select(".watch-view-count").toString().length()-8).replace(",", "");
				String nameContent = doc.select("#eow-title").first().attr("title");
				String thumbContent = doc.select("#watch7-content link[itemprop='thumbnailUrl']").first().attr("href");
				String dateContent = doc.select("#watch7-content meta[itemprop='datePublished']").first().attr("content") + " 00:00:00";
				int check = AdminDAO.addChannelAdUrl(inputChannelNo, channeAdUrls.get(i), nameContent, viewsContent, thumbContent, channeAdTypes.get(i), channeAdCategorys.get(i), Timestamp.valueOf(dateContent), inputCurrentDate);
				if(check != 1) {
					CommonUtil.commonPrintLog("FAIL", className, "Add  Channel Ad Url :" + inputChannelAdUrls[i], map);
				}			
			}
		
			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "Channel Ad Url Add OK", map);
			jObject.put("outputResult", "성공하였습니다.");
			req.getRequestDispatcher("/admin?action=getChannelList&page="+inputChannelNo+"&size=30").forward(req, res);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addChannelInfo(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			int inputCategoryNo = req.getParameter("inputCategoryNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputCategoryNo").toString())) : 0;
			int inputCategoryNo2 = req.getParameter("inputCategoryNo2") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputCategoryNo2").toString())) : 0;
			int inputCategoryNo3 = req.getParameter("inputCategoryNo3") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputCategoryNo3").toString())) : 0;
			int inputMcnNo = req.getParameter("inputMcnNo") != "" ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputMcnNo").toString())) : 0;
			String inputChannelRegion = req.getParameter("inputChannelRegion") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputChannelRegion").toString()) : "";

			Calendar calendar = Calendar.getInstance();
			Timestamp inputCurrentDate = new java.sql.Timestamp(calendar.getTime().getTime());

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputChannelNo);
			parameterList.add(inputCategoryNo);

			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			String category = "";
			
			category = inputCategoryNo + ";";
			if(inputCategoryNo2 != 1) category += inputCategoryNo2 + ";";
			if(inputCategoryNo3 != 1) category += inputCategoryNo3 + ";";

			
			Channel channel = ChannelDAO.getChannelByNo(inputChannelNo);			
			int check = AdminDAO.setChannelInfo(inputChannelNo, category, inputMcnNo, inputChannelRegion, inputCurrentDate);
			if(check != 1) {
				CommonUtil.commonPrintLog("FAIL", className, "Add  Channel Info", map);
			}		
			
			if(ChannelDAO.checkRankTop(inputChannelNo)>0) {
				int check2 = AdminDAO.setRankTopCategory(inputChannelNo, category);
				if(check2 != 1)
					CommonUtil.commonPrintLog("FAIL", className, "Add  RANK TOP Info", map);

			}
			
			Date date = new Date();
			SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd");
			formatType.setTimeZone(TimeZone.getTimeZone("GMT+9"));
			date.setHours(0);
			Timestamp currentTime = new Timestamp(date.getTime());

			if(ChannelDAO.checkRankCategory(inputChannelNo, currentTime)>0) {
				int check2 = AdminDAO.setRankCategoryCategory(inputChannelNo, category, currentTime);
				if(check2 != 1)
					CommonUtil.commonPrintLog("FAIL", className, "Add  RANK CATEGORY Info", map);			
			}
			
			/// 카테고리 기존 카테고리와 비교
			ArrayList<String> originalCategory = CommonUtil.commonSpiltBySemicolon(channel.getRacChannelCategory());
			if(originalCategory.size() == 1) {
				if(Integer.parseInt(originalCategory.get(0)) != inputCategoryNo) { 
					AdminDAO.deleteChannelCategory(inputChannelNo, Integer.parseInt(originalCategory.get(0)));
					if(inputCategoryNo != 1)
						AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo);
				}
				
				if(inputCategoryNo2 != 1)
					AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo2);
				if(inputCategoryNo3 != 1)
					AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo3);
				
			} else if(originalCategory.size() == 2) {
				if(Integer.parseInt(originalCategory.get(0)) != inputCategoryNo) { 
					AdminDAO.deleteChannelCategory(inputChannelNo, Integer.parseInt(originalCategory.get(0)));
					if(inputCategoryNo != 1)
						AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo);
				}
				if(Integer.parseInt(originalCategory.get(1)) != inputCategoryNo2) { 
					AdminDAO.deleteChannelCategory(inputChannelNo, Integer.parseInt(originalCategory.get(1)));
					if(inputCategoryNo2 != 1)
						AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo2);
				}
				
				if(inputCategoryNo3 != 1)
					AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo3);
				
			} else if(originalCategory.size() == 3) {
				if(Integer.parseInt(originalCategory.get(0)) != inputCategoryNo) { 
					AdminDAO.deleteChannelCategory(inputChannelNo, Integer.parseInt(originalCategory.get(0)));
					if(inputCategoryNo != 1)
						AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo);
				}
				if(Integer.parseInt(originalCategory.get(1)) != inputCategoryNo2) { 
					AdminDAO.deleteChannelCategory(inputChannelNo, Integer.parseInt(originalCategory.get(1)));
					if(inputCategoryNo2 != 1)
						AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo2);
				}
				if(Integer.parseInt(originalCategory.get(2)) != inputCategoryNo3) { 
					AdminDAO.deleteChannelCategory(inputChannelNo, Integer.parseInt(originalCategory.get(2)));
					if(inputCategoryNo3 != 1)
						AdminDAO.addChannelCategory(inputChannelNo, inputCategoryNo3);
				}		
				
				
			}
			
			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "Channel Info Add OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void getChannelInfo(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			int inputPageNo = req.getParameter("inputPageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputPageNo").toString())) : 0;
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			/// Check Admin Member 


			Channel channel = AdminDAO.getChannel(inputChannelNo);
			ArrayList<ChannelCategory> categoryList = AdminDAO.getChannelCategory(inputChannelNo);
			for(int i=0; i<categoryList.size();i++) {
				switch(i) {
					case 0:
						jObject.put("outputCategoryNo", categoryList.get(i).getRacCategoryNo());
						break;
					case 1:
						jObject.put("outputCategoryNo2", categoryList.get(i).getRacCategoryNo());
						break;
					case 2:
						jObject.put("outputCategoryNo3", categoryList.get(i).getRacCategoryNo());
						break;
				}
			}
			
			if(categoryList.size() == 1) {
				jObject.put("outputCategoryNo2", 1);
				jObject.put("outputCategoryNo3", 1);

			} else if(categoryList.size() == 2) {
				jObject.put("outputCategoryNo3", 1);	
			}
			
			jObject.put("outputChannelNo", channel.getRacChannelNo());
			jObject.put("outputChannelTitle", channel.getRacChannelTitle());
			jObject.put("outputChannelUrl", channel.getRacChannelUrl());
			jObject.put("outputChannelCategory", CommonUtil.getChannelCategoryList(channel.getRacChannelCategory()));
			jObject.put("outputChannelRegion", channel.getRacChannelRegion());
			jObject.put("pageNo", inputPageNo);
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel info OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/info.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getChannelAdUrl(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			int inputPageNo = req.getParameter("inputPageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputPageNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			/// Check Admin Member 


			// 현재 대출 가능한 도서(book_lending_possible이 true인 목록만 가져옴)
			Channel channel = AdminDAO.getChannel(inputChannelNo);

			jObject.put("outputChannelNo", channel.getRacChannelNo());
			jObject.put("outputChannelTitle", channel.getRacChannelTitle());
			jObject.put("outputChannelUrl", channel.getRacChannelUrl());
			jObject.put("pageNo", inputPageNo);

			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel ad url OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/adUrl.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getChannelCost(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputChannelNo = req.getParameter("inputChannelNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputChannelNo").toString())) : 0;
			int inputPageNo = req.getParameter("inputPageNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputPageNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			/// Check Admin Member 


			// 현재 대출 가능한 도서(book_lending_possible이 true인 목록만 가져옴)
			Channel channel = AdminDAO.getChannel(inputChannelNo);

			jObject.put("outputChannelNo", channel.getRacChannelNo());
			jObject.put("outputChannelTitle", channel.getRacChannelTitle());
			jObject.put("outputChannelUrl", channel.getRacChannelUrl());
			jObject.put("pageNo", inputPageNo);

			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel cost OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/cost.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchAdmin(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {			
			HttpSession session = req.getSession();
			
			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			String inputChannelName = req.getParameter("inputChannelName") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputChannelName").toString()) : null;
			
			int page = req.getParameter("page") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("page").toString())) : 1;
			int size = req.getParameter("size") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("size").toString())) : 10;
			
			if(page==0) page=1;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			Paging paging = new Paging(page, size);
			int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();
			
			ArrayList<Channel> channelList = ChannelDAO.searchChannelList(inputChannelName);
			JSONArray jChannelArray = new JSONArray();

			paging.setNumberOfRecords(channelList.size());
			paging.makePaging();
			
			for(int i=0; i<channelList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				// channel
				jTempObject.put("outputChannelNo", channelList.get(i).getRacChannelNo());
				jTempObject.put("outputChannelTitle", channelList.get(i).getRacChannelTitle());
				jTempObject.put("outputChannelUrl", channelList.get(i).getRacChannelUrl());
				jTempObject.put("outputChannelFollowers", channelList.get(i).getRacChannelFollowers());
				jTempObject.put("outputChannelViews", channelList.get(i).getRacChannelViews());
				jTempObject.put("outputChannelCategory", channelList.get(i).getRacChannelCategory());
				// 후기 가져오기
				jTempObject.put("outputPostscriptCount", 0);
				// 광고 영상에 대하여 
				jTempObject.put("outputChannelAdCount", AdminDAO.countChannelAd(channelList.get(i).getRacChannelNo()));
				// 단가에 대하여  
				int costCount = AdminDAO.countChannelCost(channelList.get(i).getRacChannelNo());
				if(costCount != 0) {
					jTempObject.put("outputChannelCostCount",costCount);
					jTempObject.put("outputChannelCostEvenPrice", AdminDAO.getChannelCostPrice(channelList.get(i).getRacChannelNo())/costCount);

				} else {
					jTempObject.put("outputChannelCostCount","미등록");
					jTempObject.put("outputChannelCostEvenPrice", "0");

				}

				jChannelArray.add(jTempObject);
			}

			jObject.put("outputChannelList", jChannelArray);
			jObject.put("firstPageNo", paging.getFirstPageNo());
			jObject.put("prevPageNo", paging.getPrevPageNo());
			jObject.put("currentPageNo", paging.getCurrentPageNo());
			jObject.put("nextPageNo", paging.getNextPageNo());
			jObject.put("paging", paging);
			
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Channel List OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/channelList.jsp").forward(req, res);

			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getMemberList(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int page = req.getParameter("page") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("page").toString())) : 1;
			int size = req.getParameter("size") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("size").toString())) : 10;
			
			if(page==0) page=1;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			/// Check Admin Member 
			JSONArray jChannelArray = new JSONArray();
			Paging paging = new Paging(page, size);
			int memberStatus=2;
			int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();

			ArrayList<Member> memberList = AdminDAO.getMemberList(memberStatus, offset, paging.getRecordsPerPage());

			// bookList 전체 갯수 구하여 numberOfRecords 메소드에 셋팅함 
			paging.setNumberOfRecords(AdminDAO.countTotalChannel());
			paging.makePaging();
			
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			for(int i=0; i<memberList.size();i++) {
				JSONObject jTempObject = new JSONObject();
				// channel
				jTempObject.put("outputMemberNo", memberList.get(i).getRacMemberNo());
				jTempObject.put("outputMemberStatus", memberList.get(i).getRacMemberStatus());
				jTempObject.put("outputMemberType", memberList.get(i).getRacMemberType());
				jTempObject.put("outputMemberEmail", EncryptUtil.AES_Decode(memberList.get(i).getRacMemberEmail(), aesKey));
				Company company = AdminDAO.getCompany(memberList.get(i).getRacMemberNo());
				jTempObject.put("outputCompanyName", EncryptUtil.AES_Decode(company.getRacCompanyName(), aesKey));
				jTempObject.put("outputCompanyBusinessNo", EncryptUtil.AES_Decode(company.getRacCompanyBusinessNo(), aesKey));
				
				jChannelArray.add(jTempObject);
			}

			jObject.put("outputMemberList", jChannelArray);
			jObject.put("firstPageNo", paging.getFirstPageNo());
			jObject.put("prevPageNo", paging.getPrevPageNo());
			jObject.put("currentPageNo", paging.getCurrentPageNo());
			jObject.put("nextPageNo", paging.getNextPageNo());
			jObject.put("paging", paging);
	
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Member List OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/memberList.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getAdminMain(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Admin main OK", map);
			req.setAttribute("adminToken", "129");
			req.getRequestDispatcher("/02_page/Admin/view.jsp").forward(req, res);
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getPageDom(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 1;
			String inputUrl = req.getParameter("inputUrl") != null ? CommonUtil.commonCleanXSS(req.getParameter("inputUrl").toString()) : "";
			
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			// Parameter check
			ArrayList<Object> parameterList = new ArrayList<Object>();
			parameterList.add(inputUrl);

			if(!CommonUtil.commonParameterCheck(parameterList)) {
				CommonUtil.commonPrintLog("FAIL", className, "Parameter Missing", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
		
			// URL 크롤링 
			String url= inputUrl;
			Document doc = Jsoup.parse(new URL(url).openStream(), "utf-8", url);

			switch(mode) {
			case 1:   // Video Detail (Video)
				String viewsContent = doc.select(".watch-view-count").toString().substring(35, doc.select(".watch-view-count").toString().length()-8).replace(",", "");
				String nameContent = doc.select("#eow-title").first().attr("title");
				String thumbContent = doc.select("#watch7-content link[itemprop='thumbnailUrl']").first().attr("href");
				String dateContent = doc.select("#watch7-content meta[itemprop='datePublished']").first().attr("content") + " 00:00:00";

				break; 
			case 2:   // Recent Video List (Channel/video)
				String test = doc.select(".feed-item-container").toString();
				System.out.println(test);
				if (test.equals("")) System.out.println("ok");
				else System.out.println(doc.select(".about-stats"));
				break;
			}

			System.out.println(doc.select(".about-stats"));
			// 완료 colArr = $('.about-stat','.about-stats');
			CommonUtil.commonPrintLog("SUCCESS", className, "Get URL DOM OK;", map);
			jObject.put("outputResult", doc.select(".about-stats"));
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getReviewList(HttpServletRequest req, HttpServletResponse res) {
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			// 1 - 미승인, 2 - 승인
			int mode = req.getParameter("mode") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("mode").toString())) : 1;
			int page = req.getParameter("page") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("page").toString())) : 1;
			int size = req.getParameter("size") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("size").toString())) : 10;
			
			if(page==0) page=1;
			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}

			/// Check Admin Member 
			JSONArray outputReviewArray = new JSONArray();
			Paging paging = new Paging(page, size);
			int memberStatus=2;
			int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();

			ArrayList<Review> reviewList = AdminDAO.getReviewList(mode, offset, paging.getRecordsPerPage());

			// bookList 전체 갯수 구하여 numberOfRecords 메소드에 셋팅함 
			paging.setNumberOfRecords(AdminDAO.countTotalChannel());
			paging.makePaging();
			
			// AES Encrypt
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");
			for(int i=0; i<reviewList.size();i++) {
				HashMap<String,Object> tempObejct = new HashMap<String,Object>();
				tempObejct.put("outputReviewNo", reviewList.get(i).getRacReviewNo());
				tempObejct.put("outputReviewStatus", CommonUtil.getReviewStatus(reviewList.get(i).getRacReviewStatus()));
				tempObejct.put("outputChannelNo", reviewList.get(i).getRacChannelNo());
				Channel channel = ChannelDAO.getChannelByNo(reviewList.get(i).getRacChannelNo());
				tempObejct.put("outputChannelTitle", channel.getRacChannelTitle());
				tempObejct.put("outputChannelAdNo", reviewList.get(i).getRacChannelAdNo());
				ChannelAd channelAd = ChannelDAO.getChannelAd(reviewList.get(i).getRacChannelAdNo());
				tempObejct.put("outputVideoId", channelAd.getRacVideoId());
				if(channelAd.getRacVideoTitle().length()>20) 
					tempObejct.put("outputVideoTitle", channelAd.getRacVideoTitle().substring(0, 20));
				else 
					tempObejct.put("outputVideoTitle", channelAd.getRacVideoTitle());
				tempObejct.put("outputChannelAdType", CommonUtil.getReviewAdType(channelAd.getRacChannelAdType()));
				tempObejct.put("outputChannelCostNo", ChannelDAO.getChannelCostByCostNo(reviewList.get(i).getRacChannelCostNo()).getRacChannelCostPrice());
				tempObejct.put("outputReviewSatisfy", CommonUtil.getReviewSatisfy5(reviewList.get(i).getRacReviewSatisfy()));
				tempObejct.put("outputReviewTargetReach", CommonUtil.getReviewTarget(reviewList.get(i).getRacReviewTargetReach()));
				tempObejct.put("outputReviewTargetConversion", CommonUtil.getReviewTarget(reviewList.get(i).getRacReviewTargetConversion()));
				tempObejct.put("outputReviewTargetGender", CommonUtil.getGender(reviewList.get(i).getRacReviewTargetGender()));
				tempObejct.put("outputReviewTargetAge", CommonUtil.getAge(reviewList.get(i).getRacReviewTargetAge()));
				tempObejct.put("outputReviewRecomand", CommonUtil.getRecomand(reviewList.get(i).getRacReviewRecomand()));
				tempObejct.put("outputReviewAdAgain", CommonUtil.getRecomand(reviewList.get(i).getRacReviewAdAgain()));
				tempObejct.put("outputReviewDetail", reviewList.get(i).getRacReviewDetail());						
				tempObejct.put("outputReviewCreateDate", CommonUtil.getChannelDetailDate(reviewList.get(i).getRacReviewCreateDate()));

				outputReviewArray.add(tempObejct);
			}

			jObject.put("outputReviewList", outputReviewArray);
			jObject.put("firstPageNo", paging.getFirstPageNo());
			jObject.put("prevPageNo", paging.getPrevPageNo());
			jObject.put("currentPageNo", paging.getCurrentPageNo());
			jObject.put("nextPageNo", paging.getNextPageNo());
			jObject.put("paging", paging);
			jObject.put("mode", mode);

			CommonUtil.commonPrintLog("SUCCESS", className, "Get Review List OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/reviewList.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getReview(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputReviewNo = req.getParameter("inputReviewNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputReviewNo").toString())) : 0;

			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			
			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			/// Check Admin Member 


			// Get Review
			Review review = AdminDAO.getReview(inputReviewNo);
			String aesKey = EncryptUtil.AES_getKey(req.getRealPath("") + File.separator + "META-INF" + File.separator + "keys.xml");

			Member member = MemberDAO.getMemberByMemberNo(review.getRacMemberNo());
			jObject.put("outputMemberName", EncryptUtil.AES_Decode(member.getRacMemberEmail(), aesKey));
			Company company = AdminDAO.getCompany(review.getRacMemberNo());
			jObject.put("outputCompanyName", EncryptUtil.AES_Decode(company.getRacCompanyName(), aesKey));

			jObject.put("outputReviewNo", review.getRacReviewNo());
			jObject.put("outputReviewStatus", CommonUtil.getReviewStatus(review.getRacReviewStatus()));
			jObject.put("outputChannelNo", review.getRacChannelNo());
			Channel channel = ChannelDAO.getChannelByNo(review.getRacChannelNo());
			jObject.put("outputChannelTitle", channel.getRacChannelTitle());
			jObject.put("outputChannelUrl", channel.getRacChannelUrl());
			jObject.put("outputChannelAdNo", review.getRacChannelAdNo());
			ChannelAd channelAd = ChannelDAO.getChannelAd(review.getRacChannelAdNo());
			jObject.put("outputVideoId", channelAd.getRacVideoId());
			jObject.put("outputVideoTitle", channelAd.getRacVideoTitle());
			jObject.put("outputChannelAdType", CommonUtil.getReviewAdType(channelAd.getRacChannelAdType()));
			jObject.put("outputChannelCostNo", ChannelDAO.getChannelCostByCostNo(review.getRacChannelCostNo()).getRacChannelCostPrice());
			jObject.put("outputReviewSatisfy", CommonUtil.getReviewSatisfy5(review.getRacReviewSatisfy()));
			jObject.put("outputReviewTargetReach", CommonUtil.getReviewTarget(review.getRacReviewTargetReach()));
			jObject.put("outputReviewTargetConversion", CommonUtil.getReviewTarget(review.getRacReviewTargetConversion()));
			jObject.put("outputReviewTargetGender", CommonUtil.getGender(review.getRacReviewTargetGender()));
			jObject.put("outputReviewTargetAge", CommonUtil.getAge(review.getRacReviewTargetAge()));
			jObject.put("outputReviewRecomand", CommonUtil.getRecomand(review.getRacReviewRecomand()));
			jObject.put("outputReviewAdAgain", CommonUtil.getRecomand(review.getRacReviewAdAgain()));
			jObject.put("outputReviewDetail", review.getRacReviewDetail());						
			jObject.put("outputReviewCreateDate", review.getRacReviewCreateDate());

			CommonUtil.commonPrintLog("SUCCESS", className, "Get Review OK", map);
			req.setAttribute("result", jObject);
			req.getRequestDispatcher("/02_page/Admin/review.jsp").forward(req, res);

			return;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void setReviewStatus(HttpServletRequest req, HttpServletResponse res) {

		HashMap<String, String> map = new HashMap<String, String>();

		try {
			HttpSession session = req.getSession();

			int sessionMemberNo = session.getAttribute("racMemberNo") != null ? Integer.parseInt(session.getAttribute("racMemberNo").toString()) : 0;
			int inputReviewNo = req.getParameter("inputReviewNo") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputReviewNo").toString())) : 0;
			int inputReviewStatus = req.getParameter("inputReviewStatus") != null ? Integer.parseInt(CommonUtil.commonCleanXSS(req.getParameter("inputReviewStatus").toString())) : 0;

			
			JSONObject jObject = new JSONObject();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");

			if(!(sessionMemberNo>0) || sessionMemberNo>10) {
				CommonUtil.commonPrintLog("FAIL", className, "No Admin Member", map);
				jObject.put("outputResult", "-1");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			int check = AdminDAO.setReviewStatus(inputReviewNo, inputReviewStatus);
			if(check!=1) {
				CommonUtil.commonPrintLog("ERROR", className, "SET REVIEW StATUS EErrrorr", map);
				jObject.put("outputResult", "-2");
				res.getWriter().write(jObject.toString());
				return;
			}
			
			
			// 완료 
			CommonUtil.commonPrintLog("SUCCESS", className, "Get Admin main OK", map);
			jObject.put("outputResult", "1");
			res.getWriter().write(jObject.toString());
			return;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
