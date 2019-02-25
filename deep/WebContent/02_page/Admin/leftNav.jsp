<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<div class="left-nav" style="margin:30px;">
		<div class="rancre-admin-logo">rancre</div>
		<ul>
			<li><a href="/admin?action=getChannelList&page=1&size=10" target="right">랭크리 전체 통계</a></li>	
			<li><a href="/admin?action=getMemberList&page=1&size=10" target="right">회원 리스트</a></li>	
			<li><a href="/admin?action=getReviewList&mode=1&page=1&size=10" target="right">광고 후기 - 미승인</a></li>	
			<li><a href="/admin?action=getReviewList&mode=2&page=1&size=10" target="right">광고 후기 - 승인완료</a></li>	
			<li><a href="/admin/props.cp" target="right">채널 정보 등록</a></li>	
			<li><a href="/admin/props.cp" target="right">회원검색(채널검색)</a></li>	
			<li><a href="#" target="right">list</a></li>	
		</ul>
	</div>
