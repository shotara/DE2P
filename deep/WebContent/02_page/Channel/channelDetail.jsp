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
	<div class="container">
		<div class="row">
			<div class="col pt-3">

				<!-- 채널 상세 페이지 상단 영역 시작  -->

				<div class="chnDtlTop w-auto ml-auto">
					<!-- 채널 썸네일 영역 시작  -->
					<div class="chnDtlImg d-inline-block">
						<img id="chnDtlThumbNail"
							style="width: 80px; border-radius: 80px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<!-- 채널 썸네일 영역 끝  -->

					<!-- 채널 이름 및 카테고리 시작 -->

					<div class="d-inline-block">
						<div class="w-auto ml-auto">
							<span class="chnDtlName">WassupMan</span>
						</div>
						<div class="chnDtlCategory w-auto ml-auto">
							<span>#스튜디오</span>
						</div>
					</div>
					<!-- 채널 이름 및 카테고리 끝 -->
				</div>

				<!-- 채널 상세 페이지 상단 영역 끝  -->


				<!-- 채널 스탯 상세 영역 시작  -->

				<div class="pt-3"></div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

				<!-- 채널 스텟 - 종합순위/총구독자수/차주대비/총조회수/최근평균조회수 시작 -->

				<div class="row w-auto ml-auto">
					<div class="col w-auto d-inline-block text-center">종합 순위</div>
					<div class="col w-auto d-inline-block text-center">총 구독자 수</div>
					<div class="col w-auto d-inline-block text-center">지난주 대비
						구독자수</div>
					<div class="col w-auto d-inline-block text-center">총 조회수</div>
					<div class="col w-auto d-inline-block text-center">최근 영상 평균
						조회수</div>
				</div>
				<div class="pt-3"></div>

				<div class="row w-auto ml-auto">
					<div class="col w-auto d-inline-block text-center">
						<span>1위 </span><span>-</span>
					</div>
					<div class="col w-auto d-inline-block text-center">1,223,232</div>
					<div class="col w-auto d-inline-block text-center">+ 123,232</div>
					<div class="col w-auto d-inline-block text-center">123,232,232,232</div>
					<div class="col w-auto d-inline-block text-center">12,232,232</div>
				</div>

				<!-- 채널 스텟 - 종합순위/총구독자수/차주대비/총조회수/최근평균조회수 끝 -->

				<!-- 채널 스탯 - 광고만족도/광고평균조회수/단가/카테고리 시작 -->

				<div class="pt-3"></div>

				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

				<div class="row chnDtlRow w-auto ml-auto">
					<div class="col w-auto d-inline-block text-center"><span>광고 만족도</span></div>
					<div class="col w-auto d-inline-block text-center"><span>광고 영상 평균 조회수</span></div>
					<div class="col w-auto d-inline-block text-center"><span>최저 광고 단가</span></div>
					<div class="col w-auto d-inline-block text-center"><span>평균 광고 단가</span></div>
					<div class="col w-auto d-inline-block text-center"><span>최고 광고 단가</span></div>
				</div>

				<div class="pt-3"></div>

				<div class="row chnDtlStat w-auto ml-auto">
					<div class="col w-auto d-inline-block text-center">
						<span>1위 </span><span>-</span>
					</div>
					<div class="col w-auto d-inline-block text-center">1,223,232</div>
					<div class="col w-auto d-inline-block text-center">+ 123,232</div>
					<div class="col w-auto d-inline-block text-center">123,232,232,232</div>
					<div class="col w-auto d-inline-block text-center">12,232,232</div>
				</div>

				<div class="pt-3"></div>

				<!-- 채널 스탯 - 광고만족도/광고평균조회수/단가/카테고리 끝 -->


				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

				<div class="pt-3"></div>

				<!-- 채널 상세 탭 영역 -->

				<div class="w-auto ml-auto">
					<div class="col d-inline">
						<a href="#">최근 업로드 영상</a>
					</div>
					<div class="col d-inline">
						<a href="#">이 채널의 광고 영상</a>
					</div>
					<div class="col d-inline">
						<a href="#">이 채널의 광고 리뷰</a>
					</div>
					<div class="col d-inline">
						<a href="#">이 채널의 광고 단가</a>
					</div>
				</div>

				<div class="pt-4"></div>

				<!-- 탭별 콘텐츠 영역 -->
				<div>
					<iframe width="560" height="315"
						src="https://www.youtube.com/embed/dN44xpHjNxE" frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>


			</div>
		</div>
	</div>
	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

</body>
</html>