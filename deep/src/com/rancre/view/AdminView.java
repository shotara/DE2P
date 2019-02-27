package com.rancre.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rancre.controller.AdminController;
import com.rancre.controller.FeedController;
import com.rancre.util.CommonUtil;

public class AdminView extends HttpServlet{
	
	private static final String className = "AdminView";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		process(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		process(req,res);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			String action = req.getParameter("action") != null ? CommonUtil.commonCleanXSS(req.getParameter("action").toString()) : "";
			
			switch(action) {
			case "getChannelList":
				map.put("ACTION", "getChannelList");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getChannelList(req,res);
				break;	
			case "addChannelCost":
				map.put("ACTION", "addChannelCost");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.addChannelCost(req,res);
				break;				
			case "getChannelCost":
				map.put("ACTION", "getChannelCost");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getChannelCost(req,res);
				break;	
			case "addChannelAdUrl":
				map.put("ACTION", "addChannelAdUrl");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.addChannelAdUrl(req,res);
				break;	
			case "getChannelAdUrl":
				map.put("ACTION", "getChannelAdUrl");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getChannelAdUrl(req,res);
				break;	
			case "addChannelInfo":
				map.put("ACTION", "addChannelInfo");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.addChannelInfo(req,res);
				break;	
			case "getChannelInfo":
				map.put("ACTION", "getChannelInfo");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getChannelInfo(req,res);
				break;	
			case "searchAdmin":
				map.put("ACTION", "searchAdmin");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.searchAdmin(req,res);
				break;	
			case "getMemberList":
				map.put("ACTION", "getMemberList");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getMemberList(req,res);
				break;			
			case "getAdminMain":
				map.put("ACTION", "getAdminMain");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getAdminMain(req,res);
				break;			
			case "getPageDom":
				map.put("ACTION", "getPageDom");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getPageDom(req,res);
				break;	
			case "getReviewList":
				map.put("ACTION", "getReviewList");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getReviewList(req,res);
				break;	
			case "getReview":
				map.put("ACTION", "getReview");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.getReview(req,res);
				break;	
			case "setReviewStatus":
				map.put("ACTION", "setReviewStatus");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				AdminController.setReviewStatus(req,res);
				break;
			}
			
		} catch (Exception e) {
			//에러처리
		}
	}
}
