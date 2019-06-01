<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section id="mHeader">

	<div class="rac_m_header">
		<div class="rac_m_headBrand">
			<a class="w100 commonA" href="/07_Mpage/main.jsp"><span
				class="color-primary rac-brand">RANCRE</span></a>
		</div>
		<a href="/07_Mpage/Search/commonSearch.jsp" class="rac_m_search">
			<i class="icon-search"></i>
		</a> <i class="icon-menu rac_m_sideMenu" onclick="CommonM.m_clk_s_menu(1)"></i>

	</div>

	<div class="rac_m_side_menu" id="rac_m_Side_menu">
		<div class="rac_m_side_dimmed" onclick="CommonM.m_clk_s_menu(2)"></div>
		<div class="rac_m_side_domain" id="rac_m_Side_domain">
			<i class="icon-cancel rac_m_top_exit" id="rac_m_Side_close"
				onclick="CommonM.m_clk_s_menu(2)"></i>
			<div class="rac_m_side_user commonMBorder">
				<div class="rac_m_non_login">
					<p class="color-primary">RANCRE</p>
					<a class="commonA" href="/07_Mpage/Auth/MLogin.jsp"><p class="w100">로그인</p></a>
				</div>
			</div>
			<ul class="rac_m_side_menu_ul">
				<li class="rac_m_side_menu_li" onclick="CommonM.move_m_List(1)">채널 100</li>
				<li class="rac_m_side_menu_li" onclick="CommonM.move_m_List(2)">모든 채널</li>
				<li class="rac_m_side_menu_li" onclick="CommonM.move_m_List(3)">새로운 채널</li>
				<li class="rac_m_side_menu_li" onclick="CommonM.move_m_List(4)">검색</li>
			</ul>

		</div>
	</div>

</section>