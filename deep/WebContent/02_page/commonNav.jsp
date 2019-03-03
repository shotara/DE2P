<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/index.jsp">Rancre</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/index.jsp">채널100 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/02_page/Channel/allChannel.jsp">모든채널</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/02_page/Channel/newChannel.jsp">새로운채널</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/channel?action=searchChannel&inputChannelName=">검색</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="#"
					onclick="Common.search(3)">채널수집요청</a></li>
				<c:if test="${empty sessionScope.racMemberNo}">
					<li class="nav-item active"><a class="nav-link"
						href="/02_page/Auth/login.jsp" onclick="Auth.loginCheck()">리뷰등록</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/02_page/Auth/login.jsp">로그인</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/02_page/Auth/join.jsp">회원가입</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.racMemberNo}">
					<li class="nav-item active"><a class="nav-link"
						href="/channel?action=getReviewPage">리뷰등록</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/member?action=getMypage">기업홈</a></li>
					<li class="nav-item active"><a class="nav-link" href="#"
						onclick="Auth.logout()">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>

<!-- Request Search Channel Area Start -->
<div class="req-search-modal" id="req-Search-Modal">

	<!-- Modal content -->
	<div class="req-search-modal-content" id="req-Search-Modal-Content">
		<span class="req-modal-close" onclick="Common.search(4)">&times;</span>

		<div class="req-input-area">
			<span class="req-search-modal-title">채널 수집 요청하기</span>
			<hr style="margin-top: 5px; border-color: #f11834;">

			<div>

				<span class="display-block ">궁금한 채널 정보가 나오지 않았나요?</span> <span
					class="display-block">채널 URL을 입력하면 랭크리에서 관련 정보 수집을 시작합니다.</span>
			</div>

			<div class="pTop">
				<span>채널 URL </span><span class="primary-color">*</span> <input
					class="ipt-req-search-channel" id="ipt-Req-Search-Channel"
					placeholder="https://www.youtube.com/user/example" type="email" />

			</div>

			<div class="text-center pTop3">
				<button class="common-wide-Reverse-Btn" onclick="Common.search(5)">채널
					수집 요청</button>
			</div>
		</div>
	</div>

</div>

<!-- Request Search Channel Area finished -->

