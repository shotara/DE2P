package com.deep.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deep.controller.FeedController;
import com.deep.util.CommonUtil;

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
			}
			
		} catch (Exception e) {
			//에러처리
		}
	}
}
