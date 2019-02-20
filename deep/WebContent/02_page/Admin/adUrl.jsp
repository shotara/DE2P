<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<script type="text/javascript">

</script>

</head>
<body>

<section class="rancre-admin-adurl">
	<form method="post" action="/admin?action=addChannelAdUrl">
	<div class="content">
		<h1>광고 영상 등록(식별 광고 영상)</h1>
		<div class="adurl-channel-title">
			<div class="left">채널명</div>
			<div class="right">${result.outputChannelTitle}</div>
		</div>
		<div class="adurl-channel-url">
			<div class="left">채널아이디</div>
			<div class="right">${result.outputChannelUrl}</div>
		</div>
		<div class="adurl-channel-url">
			<div class="left">광고 url</div>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="hidden" name="inputChannelNo" value="${result.outputChannelNo}"/>
			<input type="hidden" name="inputPageNo" value="${result.pageNo}"/>
		</div>
	</div>

	<select class="ipt-Select-CommercialType" id="commercial-Type" name="inputChannelAdType" >
		<option value="0" selected >없음</option>
		<option value="2">영상 콘텐츠</option>
		<option value="3">배너 광고</option>
		<option value="4">물품협찬</option>
		<option value="5">섭외</option>
		<option value="6">True View</option>
		<option value="1">기타</option>
	</select>
	<select class="ipt-Select-CommercialType" id="commercial-Type" name="inputChannelAdType" >
		<option value="0" selected >없음</option>
		<option value="2">영상 콘텐츠</option>
		<option value="3">배너 광고</option>
		<option value="4">물품협찬</option>
		<option value="5">섭외</option>
		<option value="6">True View</option>
		<option value="1">기타</option>
	</select>
	<select class="ipt-Select-CommercialType" id="commercial-Type" name="inputChannelAdType" >
		<option value="0" selected >없음</option>
		<option value="2">영상 콘텐츠</option>
		<option value="3">배너 광고</option>
		<option value="4">물품협찬</option>
		<option value="5">섭외</option>
		<option value="1">기타</option>
	</select>
	<select class="ipt-Select-CommercialType" id="commercial-Type" name="inputChannelAdType" >
		<option value="0" selected >없음</option>
		<option value="2">영상 콘텐츠</option>
		<option value="3">배너 광고</option>
		<option value="4">물품협찬</option>
		<option value="5">섭외</option>
		<option value="6">True View</option>
		<option value="1">기타</option>
	</select>
	<select class="ipt-Select-CommercialType" id="commercial-Type" name="inputChannelAdType" >
		<option value="0" selected >없음</option>
		<option value="2">영상 콘텐츠</option>
		<option value="3">배너 광고</option>
		<option value="4">물품협찬</option>
		<option value="5">섭외</option>
		<option value="6">True View</option>
		<option value="1">기타</option>
	</select>

	
	<select class="ipt-Select-Reach" id="success-itemType" name="inputChannelAdCategory">
		<option value="0" selected >없음</option>
		<option value="1">서비스</option>
		<option value="2">제조/화학</option>
		<option value="3">의료/제약/복지</option>
		<option value="4">유통/무역/운송</option>
		<option value="5">교육업</option>
		<option value="6">건설업</option>
		<option value="7">IT/웹/통신</option>
		<option value="8">미디어/디자인</option>
		<option value="9">은행/금융업</option>
		<option value="10">기관/협회</option>
		<option value="11">기타</option>
	</select>
	<select class="ipt-Select-Reach" id="success-itemType" name="inputChannelAdCategory">
		<option value="0" selected >없음</option>
		<option value="1">서비스</option>
		<option value="2">제조/화학</option>
		<option value="3">의료/제약/복지</option>
		<option value="4">유통/무역/운송</option>
		<option value="5">교육업</option>
		<option value="6">건설업</option>
		<option value="7">IT/웹/통신</option>
		<option value="8">미디어/디자인</option>
		<option value="9">은행/금융업</option>
		<option value="10">기관/협회</option>
		<option value="11">기타</option>
	</select>
	<select class="ipt-Select-Reach" id="success-itemType" name="inputChannelAdCategory">
		<option value="0" selected >없음</option>
		<option value="1">서비스</option>
		<option value="2">제조/화학</option>
		<option value="3">의료/제약/복지</option>
		<option value="4">유통/무역/운송</option>
		<option value="5">교육업</option>
		<option value="6">건설업</option>
		<option value="7">IT/웹/통신</option>
		<option value="8">미디어/디자인</option>
		<option value="9">은행/금융업</option>
		<option value="10">기관/협회</option>
		<option value="11">기타</option>
	</select>
	<select class="ipt-Select-Reach" id="success-itemType" name="inputChannelAdCategory">
		<option value="0" selected >없음</option>
		<option value="1">서비스</option>
		<option value="2">제조/화학</option>
		<option value="3">의료/제약/복지</option>
		<option value="4">유통/무역/운송</option>
		<option value="5">교육업</option>
		<option value="6">건설업</option>
		<option value="7">IT/웹/통신</option>
		<option value="8">미디어/디자인</option>
		<option value="9">은행/금융업</option>
		<option value="10">기관/협회</option>
		<option value="11">기타</option>
	</select>
	<select class="ipt-Select-Reach" id="success-itemType" name="inputChannelAdCategory">
		<option value="0" selected >없음</option>
		<option value="1">서비스</option>
		<option value="2">제조/화학</option>
		<option value="3">의료/제약/복지</option>
		<option value="4">유통/무역/운송</option>
		<option value="5">교육업</option>
		<option value="6">건설업</option>
		<option value="7">IT/웹/통신</option>
		<option value="8">미디어/디자인</option>
		<option value="9">은행/금융업</option>
		<option value="10">기관/협회</option>
		<option value="11">기타</option>
	</select>
	
		<div class="btn">
			<input type="submit" value="정보입력"/>
			<button>취소</button>
		</div>
	</form>
</section>


</body>
</html>