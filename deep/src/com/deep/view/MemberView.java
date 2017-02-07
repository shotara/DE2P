package com.deep.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deep.controller.MemberController;
import com.deep.util.CommonUtil;

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
				MemberController.JoinMember(req,res);
				break;
			case "logoutMember":
				map.put("ACTION", "logoutMember");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.logoutMember(req,res);
				break;		
			case "changeMemberImg":
				map.put("ACTION", "changeMemberImg");
				CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
				MemberController.changeMemberImg(req,res);
				break;					
			}
			
			
		} catch (Exception e) {
			
		}
		
	}
}
