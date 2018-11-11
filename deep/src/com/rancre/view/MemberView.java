package com.rancre.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rancre.controller.MemberController;
import com.rancre.util.CommonUtil;

public class MemberView extends HttpServlet {
	
	private static final String className = "MemberView";
	
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
			case "checkMember":
				map.put("ACTION", "checkMember");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.checkMember(req,res);
				break;
			case "loginMember":
				map.put("ACTION", "loginMember");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.loginMember(req,res);
				break;
			case "joinMember":
				map.put("ACTION", "joinMember");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.joinMember(req,res);
				break;
			case "setMember":
				map.put("ACTION", "setMember");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.setMember(req,res);
				break;				
			case "logoutMember":
				map.put("ACTION", "logoutMember");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.logoutMember(req,res);
				break;		
			case "loginCheck":
				map.put("ACTION", "loginCheck");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.loginCheck(req,res);
				break;				
			}
			
		} catch (Exception e) {
//			에러처리 
		}
	}
}