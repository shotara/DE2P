<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />

</head>
<body>

	<jsp:include page="/02_page/commonNav.jsp" flush="false" />

	<section class="section" data-type="feed">
	<div class="container">
		<div class="row">
			<div class="col pt-3">
				<div class="w-auto ml-auto">
					<h3>모든 채널</h3>
				</div>
				<div>
					<span>랭크리에서 수집한 전체 채널입니다.</span>
				</div>
				<div class="w-auto pt-4">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item active"><a class="nav-link2" href="#">스튜디오
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">엔터</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">여행</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">노래 댄스</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">테크</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">교육(어학)</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">뷰티</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">일상</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">게임</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">스포츠</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">먹방</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">키즈</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">반려동물</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">운동</a></li>
						<li class="nav-item"><a class="nav-link2" href="#">취미</a></li>
					</ul>
				</div>
				<div class="pt-4">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">채널명</li>
						<li class="nav-item">카테고리</li>
						<li class="nav-item">총구독자수</li>
						<li class="nav-item">총조회수</li>
						<li class="nav-item">업로드한 영상수</li>
					</ul>
				</div>
				<hr>
				<div></div>
			</div>
		</div>
	</div>

	</section>

	<section class="indexRecommend"> </section>
	<c:forEach var="i" items="${requestScope.outputFeedList}">
		<div class="row<c:if test="${i.outputPostType == 1}"> notice</c:if>"
			onclick="Feed.goView('${i.outputFeedNo}')"></div>
	</c:forEach>
</body>
</html>