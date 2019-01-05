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

			<!-- search input area -->

			<div class="txt-center search-Keyword pTop4">
				<div class="ipt-search-box">
					<input class="ipt-search" id="ipt-Search" type="text"
						placeholder="다음으로 Rancre 검색" onkeyup="Common.search(1)" />
				</div>
				<button id ="clear-btn" class="clear-Btn" onclick="Common.search(2)">
					<img style="width: 20px;" src="/01_image/commonImg/cancel.png">
				</button>
			</div>


			<!-- search input area finish -->

			<div class="pTop3 w-100 display-block"></div>


			<!-- search result area -->


			<div class="col searchResult">

				<!-- none result area start -->
				<div class="non-result txt-center">
					<span>검색 결과가 없습니다. 다른 검색어를 입력해보세요!</span>
				</div>

				<!-- none result area finished -->

				<!-- channel result area start -->

				<div class="videoResult">
					<div class=""></div>
				</div>



				<!-- channel result area finished -->


			</div>

		</div>
	</div>

	</section>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />
</body>
</html>