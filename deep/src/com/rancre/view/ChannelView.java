package com.rancre.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rancre.controller.ChannelController;
import com.rancre.controller.CommonController;
import com.rancre.util.CommonUtil;


public class ChannelView extends HttpServlet {
		
	private static final String className = "CommonView";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		process(req, res);
	}

	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
			
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("USER-IP", req.getRemoteAddr());

		try {
//			// 점검 페이지 이동 give me the donation z
//			if(!Boolean.parseBoolean(AdminDAO.getAdminFlag(1).getHbiAdminFlagValue())) {
//				req.setAttribute("outputDowntimeTime", AdminDAO.getAdminVariable(1).getHbiAdminVariableValue());
//				req.setAttribute("outputDowntimeContent", AdminDAO.getAdminVariable(2).getHbiAdminVariableValue());
//				CommonUtil.commonPrintLog("FAIL", this.getClass().getSimpleName(), "Service Down Time", map);
//				req.getRequestDispatcher("/02_page/common/downtime.jsp").forward(req, res);	
//				return;
//			}

			String action = req.getParameter("action") != null ? CommonUtil.commonCleanXSS(req.getParameter("action").toString()) : "";

			switch(action) {				
				case "getRankingList":
					map.put("ACTION", "getRankingList");
					CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
					ChannelController.getRankingList(req,res);
					break;				
				case "getChannelDetail":
					map.put("ACTION", "getChannelDetail");
					CommonUtil.commonPrintLog("REQUEST", this.getClass().getSimpleName(), "User Request In", map);
					ChannelController.getChannelDetail(req,res);
					break;		
				default:
					CommonUtil.commonPrintLog("ERROR", this.getClass().getSimpleName(), "Incorrect Action Parameter (action : " + action + ")", map);
			}
		}  catch(Exception e) {
//			ErrorController.catchError(className, "process", 2, req, res);
		}
	}
}