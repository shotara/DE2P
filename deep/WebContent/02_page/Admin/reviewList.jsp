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

		<script type ="text/javascript" src="/03_include/js/rancre.Admin.js"></script>

<style>
.col1 {
	width: 100px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.col2 {
	width: 200px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.col3 {
	width: 200px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.col4 {
	width: 300px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.col5 {
	width: 130px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.col6 {
	width: 100px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.col7 {
	width: 100px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.col8 {
	width: 580px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.content {
	float: left;
}

.page {
	float: left;
	width: 1000px;
	text-align: center;
	margin: 30px;
}
</style>

	<div class="col1">리뷰넘버</div>
	<div class="col5">리뷰상태</div>
	<div class="col3">채널명</div>
	<div class="col4">영상명</div>
	<div class="col5">광고타입</div>
	<div class="col5">광고단가</div>
	<div class="col8">후기내용</div>

	<br />

	<c:set var="reviews" value="${result.outputReviewList}" />
	<c:set var="paging" value="${result.paging}" />
	<div class="content">
		<c:forEach var="item" items="${reviews}">
			<div class="col1"><a href="/admin?action=getReview&inputReviewNo=${item.outputReviewNo}">${item.outputReviewNo}</a></div>
			<div class="col5">${item.outputReviewStatus}</div>
			<div class="col3"><a href="/channel?action=getChannelDetail&inputChannelNo=${item.outputChannelNo}"  target="_blank">${item.outputChannelTitle}</a></div>
			<div class="col4"><a href="https://www.youtube.com/watch?v=${item.outputVideoId}"  target="_blank">${item.outputVideoTitle}</a></div>
			<div class="col5">${item.outputChannelAdType}</div>
			<div class="col5">${item.outputChannelCostNo}</div>
			<div class="col8">${item.outputReviewDetail}</div>
			<br />
		</c:forEach>
	</div>
	<br />
	<br />
	<div class="page" id="page">
		<input id="finalPageNo" type="hidden" value="${paging.finalPageNo}" />
		<input id="currentNo" type="hidden" value="${paging.currentPageNo}" />
	</div>
</body>

<script>
	$(document)
			.ready(
					function() {
						var current = $("#currentNo").val();
						var total = parseInt((current) / 10) * 10 + 10;
						var start = parseInt((current) / 10) * 10;
						var finalPage = $("#finalPageNo").val();

						if (start > 0) {
							if ((start - 10) == 0)
								$("#page")
										.append(
												"<a href='/admin?action=getChannelList&page=1&size=30'>이전</a> ");
							else
								$("#page").append(
										"<a href='/admin?action=getChannelList&page="
												+ (start - 10)
												+ "&size=30'>이전</a> ");
						}

						if (start == 0) {
							for (var i = start; i < total && i < finalPage; i++) {
								var input = ""
								if ((i + 1) != current) {
									input = "<a href='/admin?action=getChannelList&page="
											+ (i + 1)
											+ "&size=30'>"
											+ (i + 1)
											+ "</a> ";
								} else {
									input = (i + 1) + " ";
								}
								$("#page").append(input);
							}
						} else {
							for (var i = start; i < total + 1
									&& i + 1 < finalPage; i++) {
								var input = ""
								if ((i) != current) {
									input = "<a href='/admin?action=getChannelList&page="
											+ (i)
											+ "&size=30'>"
											+ (i)
											+ "</a> ";
								} else {
									input = (i) + " ";
								}
								$("#page").append(input);
							}
						}

						if (total < finalPage)
							$("#page").append(
									"<a href='/admin?action=getChannelList&page="
											+ total + "&size=30'>다음</a> ");

					});
</script>
</html>