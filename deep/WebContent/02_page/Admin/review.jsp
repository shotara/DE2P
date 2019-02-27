<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/03_include/js/rancre.Admin.js"></script>

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
</head>
<body>

<section class="rancre-admin-cost">
	<div class="content">
		<h1>리뷰 승인</h1>
		<div class="review-member-name">
			<div class="left">회원메일 : ${result.outputMemberName}</div>
		</div>
		<div class="review-company-name">
			<div class="left">회사이름 : ${result.outputCompanyName}</div>
		</div>		
		<div class="review-no">
			<div class="left">리뷰넘버 : ${result.outputReviewNo}</div>
		</div>
		<div class="review-status">
			<div class="left">리뷰상태 : ${result.outputReviewStatus}</div>
		</div>
		<div class="review-channel-title">
			<div class="left">채널명 : <a href="/channel?action=getChannelDetail&inputChannelNo=${item.outputChannelNo}"  target="_blank">${result.outputChannelTitle}</a></div>
		</div>
		<div class="review-channel-url">
			<div class="left">채널아이디 : ${result.outputChannelUrl}</div>
		</div>
		<div class="review-video-title">
			<div class="left">비디오타이틀 : <a href="https://www.youtube.com/watch?v=${item.outputVideoId}"  target="_blank">${result.outputVideoTitle}</a></div>
		</div>
		<div class="review-ad-type">
			<div class="left">광고 타입 : ${result.outputChannelAdType}</div>
		</div>
		<div class="review-channel-price">
			<div class="left">광고 단가 : ${result.outputChannelCostNo}원</div>
		</div>
		<div class="review-satisfy">
			<div class="left">만족도 : ${result.outputReviewSatisfy}</div>
		</div>
		<div class="review-target-reach">
			<div class="left">도달률 : ${result.outputReviewTargetReach}</div>
		</div>
		<div class="review-target-conversion">
			<div class="left">전환율 : ${result.outputReviewTargetConversion}</div>
		</div>
		<div class="review-target-gender">
			<div class="left">타겟성별 : ${result.outputReviewTargetGender}</div>
		</div>
		<div class="review-target-age">
			<div class="left">타겟연령대 : ${result.outputReviewTargetAge}</div>
		</div>
		<div class="review-recomand">
			<div class="left">추천 : ${result.outputReviewRecomand}</div>
		</div>
		<div class="review-ad-again">
			<div class="left">한번더광고 : ${result.outputReviewAdAgain}</div>
		</div>
		<div class="review-creata-date">
			<div class="left">리뷰생성날짜 : ${result.outputReviewCreateDate}</div>
		</div>
		<div class="review-detail">
			<div class="left">내용</div>
			<div class="right">${result.outputReviewDetail}</div>
		</div>
		
		<div class="btn">
			<button onclick="Admin.review(2,${result.outputReviewNo})">리뷰승인</button>
			<button onclick="Admin.review(3,${result.outputReviewNo})">리뷰반려</button>
			<button onclick="Admin.review(-1,${result.outputReviewNo})">리뷰삭제</button>
		</div>
	</div>
</section>
</body>
</html>