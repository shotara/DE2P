<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/02_page/commonContactUs.jsp" flush="true" />

<footer class="ranFooter">
	<div class="container">
		<div class="pt-3"></div>
		<div class="w-auto">
			<div class="float-left">
				<a class="footer-brand" href="/index.jsp">Rancre</a>
			</div>
			<div class="float-right mTop">
				<a class="common-white-A" href="#" onclick="Common.contactUs(1)">contact
					us</a>
			</div>
			<div class="txt-center pTop4">
				<span class="footer-detail">Rancre 는 채널 추천 서비스로 여러분에게 새로운 채널을
					추천해주고 싶어 만들었어요! <br/> 더 많은 채널을 보여주도록 노력할게요!
				</span>
			</div>
		</div>
	</div>
</footer>
