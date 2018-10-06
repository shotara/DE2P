package com.rancre.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rancre.controller.FeedController;
import com.rancre.util.CommonUtil;

public class FeedView extends HttpServlet{
	
	private static final String className = "FeedView";

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
			case "getFeed":
				map.put("ACTION", "getFeed");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.getFeed(req,res);
				break;	
			case "getFeedReadyList":
				map.put("ACTION", "getFeedReadyList");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.getFeedReadyList(req,res);
				break;					
			case "writeFeed":
				map.put("ACTION", "writeFeed");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.writeFeed(req,res);
				break;		
			case "listFeed":
				map.put("ACTION", "listFeed");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.listFeed(req,res);
				break;					
			case "setFeed":
				map.put("ACTION", "setFeed");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.setFeed(req,res);
				break;	
			case "searchFeed":
				map.put("ACTION", "searchFeed");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.searchFeed(req,res);
				break;	
			case "writeFeedComment":
				map.put("ACTION", "writeFeedComment");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.writeFeedComment(req,res);
				break;
			case "getFeedCommentList":
				map.put("ACTION", "getFeedCommentList");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.getFeedCommentList(req,res);
				break;
			case "addFeedLike":
				map.put("ACTION", "addFeedLike");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.addFeedLike(req,res);
				break;
			case "cancelFeedLike":
				map.put("ACTION", "cancelFeedLike");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.cancelFeedLike(req,res);
				break;
			case "addFeedCommentLike":
				map.put("ACTION", "addFeedCommentLike");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.addFeedCommentLike(req,res);
				break;	
			case "cancelFeedCommentLike":
				map.put("ACTION", "cancelFeedCommentLike");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.cancelFeedCommentLike(req,res);
				break;				
			case "addFeedShare":
				map.put("ACTION", "addFeedShare");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				FeedController.addFeedShare(req,res);
				break;				
			}
			
		} catch (Exception e) {
			//에러처리
		}
	}
}
