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
				<li class="nav-item active"><a class="nav-link" href="/index.jsp">채널100
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/02_page/Channel/allChannel.jsp">모든채널</a></li>
				<li class="nav-item"><a class="nav-link" href="/02_page/Channel/newChannel.jsp">새로운채널</a></li>
				<li class="nav-item"><a class="nav-link" href="/02_page/Search/ChannelSearch.jsp">검색</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
						href="../02_page/Review/review.jsp" onclick="Auth.loginCheck()">리뷰등록</a></li>
				<c:if test="${empty sessionScope.racMemberNo}">
					<li class="nav-item active"><a class="nav-link"
						href="/02_page/Auth/login.jsp">로그인</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="/02_page/Auth/join.jsp">회원가입</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.racMemberNo}">
					<li class="nav-item active"><a class="nav-link" href="/02_page/Corp/mainCorp.jsp">기업홈</a></li>
					<li class="nav-item active"><a class="nav-link" href="#"
						onclick="Auth.logout()">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
