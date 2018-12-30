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

	<div class="container pTop2">
		<div class="row">
			<div class="col">
			
				<div class="w100 display-block">
				
					<div class="corp-Row inline-block float-left">기업명</div>
					<div class="corp-Row inline-block float-left">아이디</div>
					<div class="corp-Row inline-block float-left">리뷰 등록 수</div>
				
				</div>
				
				<div class="pTop3 w100 display-block">
				
					<div class="corp-Name inline-block float-left">(주)롯데정보통신</div>
					<div class="corp-Id inline-block float-left">admin-123</div>
					<div class="corp-ReviewCnt inline-block float-left">10개</div>
				
				</div>
				
				<div class="pTop4 mTop4">
					<div class="float-left corp-headerTitle">나의 리뷰 (3건)</div>
					<div class="float-right go-review-list"><button class="common-Small-Btn"><a href="#">나의 리뷰 더 보기</a></button></div>
				</div>
				
				<div class="pTop3 mTop3 row">
					<div class="col float-left">채널명</div>
					<div class="col float-left">종합 만족도</div>
					<div class="col float-left">등록일자</div>
					<div class="col float-left">상태</div>
				</div>
				<hr>
				
				<!-- if channel review exist -->
				
				<div class="corp-MyReview row">
					<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
					<div class="col float-left corp-ChnSatisfy">매우 만족</div>
					<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
					<div class="col float-left corp-ChnReivew-Accept">승인</div>
				</div>
				
				<hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				
				<div class="corp-MyReview row">
					<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
					<div class="col float-left corp-ChnSatisfy">매우 만족</div>
					<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
					<div class="col float-left corp-ChnReivew-Wait">미승인</div>
				</div>
				
				<hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				
				<div class="corp-MyReview row">
					<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
					<div class="col float-left corp-ChnSatisfy">매우 만족</div>
					<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
					<div class="col float-left corp-ChnReivew-Unaccept">거절</div>
				</div>
				
				<hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				
				<div class="corp-MyReview row">
					<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
					<div class="col float-left corp-ChnSatisfy">매우 만족</div>
					<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
					<div class="col float-left corp-ChnReivew-Unaccept">거절</div>
				</div>
				
				<hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				
				<div class="corp-MyReview row">
					<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
					<div class="col float-left corp-ChnSatisfy">매우 만족</div>
					<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
					<div class="col float-left corp-ChnReivew-Unaccept">거절</div>
				</div>
				
				<hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				
				<!-- end channel review exist -->
				
				<!-- if non-channel review -->
				
				<div class=""></div>
				
				<!-- end non-channel review -->
				
				<div class="pTop4">
					<div class="float-left corp-headerTitle">최근 본 채널</div>
					<div class="float-right go-review-list"><button class="common-Small-Btn"><a href="#">최근 본 채널 더 보기</a></button></div>
				</div>
				
				<div class="pTop3 mTop3 row">
					<div class="col float-left">채널명</div>
					<div class="col float-left">종합 만족도</div>
					<div class="col float-left">등록일자</div>
					<div class="col float-left">상태</div>
				</div>
				<hr>
			</div>
		</div>
	</div>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />
	
</body>
</html>