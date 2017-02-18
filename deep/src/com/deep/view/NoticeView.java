package com.deep.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deep.controller.MemberController;
import com.deep.util.CommonUtil;

public class NoticeView extends HttpServlet {
	
	private static final String className = "NoticeView";
	
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
			case "listNotice":
				map.put("ACTION", "listNotice");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.listNotice(req,res);
				break;
			case "setNotice":
				map.put("ACTION", "setNotice");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.setNotice(req,res);
				break;
			case "getNotice":
				map.put("ACTION", "getNotice");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.getNotice(req,res);
				break;
				
			}
			
		} catch (Exception e) {
			
		}
		
	}
	

}
