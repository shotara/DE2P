<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/02_page/commonHeader.jsp" flush="true" />

<script type="text/javascript" src="/03_include/js/rancre.Admin.js"></script>

<style>
.col1 {
	width: 300px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.col2 {
	width: 300px;
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
	width: 100px;
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
	width: 300px;
	float: left;
	text-align: center;
	border-right: 1px solid;
	border-bottom: 1px solid;
}

.content {
	text-align: left;
	display: inline-block;
	padding-left: 30px;
}

.admin-top-row {
	padding-left : 30px;
}

.page {
	float: left;
	width: 1000px;
	text-align: center;
	margin: 30px;
}

.admin-top {
	height : 50px;
	padding-left : 30px;
}

.ipt-search-box {
	width : 100px;
}

.ipt-search {
	width : 30%;
}

</style>

</head>
<body>

	<div class="admin-top">
		<div class="ipt-search-box">
			<form action="/admin?action=searchAdmin" method="POST"
				id="searchAdmin">
				<input class="ipt-search" id="ipt-Search" type="text"
					placeholder="다음으로 Rancre 검색"
					onkeyup="javascript:  Admin.search(2);" /> <input type="hidden"
					name="inputChannelName" id="inputChannelName" />
			</form>
		</div>

	</div>

	<div class="admin-main">
		<div class="admin-top-row">
			<div class="col1">채널명</div>
			<div class="col5">카테고리</div>
			<div class="col3">조회수</div>
			<div class="col4">등록 후기 수</div>
			<div class="col5">식별광고 영상 수</div>
			<div class="col6">단가등록 수</div>
			<div class="col7">평균단가</div>
			<div class="col8"></div>
		</div>
		<br />

		<c:set var="channels" value="${result.outputChannelList}" />
		<c:set var="paging" value="${result.paging}" />
		<div class="content">
			<c:forEach var="item" items="${channels}">
				<div class="col1">${item.outputChannelTitle}</div>
				<div class="col5">${item.outputChannelCategory}</div>
				<div class="col3">${item.outputChannelViews}</div>
				<div class="col4">${item.outputPostscriptCount}</div>
				<div class="col5">${item.outputChannelAdCount}</div>
				<div class="col6">${item.outputChannelCostCount}</div>
				<div class="col7">${item.outputChannelCostEvenPrice}</div>
				<div class="col8">
					<button
						onclick="location.href='/admin?action=getChannelCost&inputChannelNo=${item.outputChannelNo}&inputPageNo=${paging.currentPageNo}'">단가등록</button>
					<button
						onclick="location.href='/admin?action=getChannelInfo&inputChannelNo=${item.outputChannelNo}&inputPageNo=${paging.currentPageNo}'">정보등록</button>
					<button
						onclick="location.href='/admin?action=getChannelAdUrl&inputChannelNo=${item.outputChannelNo}&inputPageNo=${paging.currentPageNo}'">광고영상등록</button>
				</div>
				<br />
			</c:forEach>
		</div>
		<br /> <br />
		<div class="page" id="page">
			<input id="finalPageNo" type="hidden" value="${paging.finalPageNo}" />
			<input id="currentNo" type="hidden" value="${paging.currentPageNo}" />
		</div>
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
												"<a href='/admin?action=getChannelEtcList&page=1&size=30'>이전</a> ");
							else
								$("#page").append(
										"<a href='/admin?action=getChannelEtcList&page="
												+ (start - 10)
												+ "&size=30'>이전</a> ");
						}

						if (start == 0) {
							for (var i = start; i < total && i < finalPage; i++) {
								var input = ""
								if ((i + 1) != current) {
									input = "<a href='/admin?action=getChannelEtcList&page="
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
									input = "<a href='/admin?action=getChannelEtcList&page="
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
									"<a href='/admin?action=getChannelEtcList&page="
											+ total + "&size=30'>다음</a> ");

					});
</script>
</html>