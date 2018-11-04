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

	<jsp:include page="/02_page/Corp/commonCorpNav.jsp" flush="false" />

	<section class="section" data-type="feed">
	<div class="container">
		<div class="row">
			<div class="col pt-3">
				<div class="w-auto ml-auto"><h3>Top 100</h3></div>
				<div><span>채널 종합 순위입니다.</span></div>
				<div class="pt-4">
					<ul class="nav nav-pills nav-fill">
						<li class="nav-item">순위</li>
						<li class="nav-item">채널명</li>
						<li class="nav-item">총구독자수</li>
						<li class="nav-item">총조회수</li>
						<li class="nav-item">업로드한 영상수</li>
					</ul>
				</div>
				<div class="hr"></div>
			</div>
		</div>
	</div>

	</section>

	<section class="indexRecommend"> </section>
   <c:forEach var="i" items="${requestScope.outputFeedList}">
			        <div class="row<c:if test="${i.outputPostType == 1}"> notice</c:if>" onclick="Feed.goView('${i.outputFeedNo}')">
			         </div>
	</c:forEach>
</body>
</html>