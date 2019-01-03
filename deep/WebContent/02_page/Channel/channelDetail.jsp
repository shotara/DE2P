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
	<div class="container pTop2">
		<div class="row">
			<div class="col">

				<!-- 채널 상세 페이지 상단 영역 시작  -->

				<div class="display-flex w-auto ml-auto">
					<!-- 채널 썸네일 영역 시작  -->
					<div class="chnDtlImg d-inline-block">
						<img id="chnDtlThumbNail"
							style="width: 80px; border-radius: 80px;"
							src="${requestScope.outputChannelThumbnail }">
					</div>
					<!-- 채널 썸네일 영역 끝  -->

					<!-- 채널 이름 및 카테고리 시작 -->

					<div class="pTop d-inline-block">
						<div class="w-auto ml-auto">
							<span class="chnDtlName">${requestScope.outputChannelTitle }</span>
						</div>
						<div class="chnDtlCategory w-auto ml-auto">

							<span class="chnCategory">${requestScope.outputChannelCategory }</span>
						</div>
					</div>
					<!-- 채널 이름 및 카테고리 끝 -->
				</div>

				<!-- 채널 상세 페이지 상단 영역 끝  -->


				<!-- 채널 스탯 상세 영역 시작  -->

				<div class="pt-3"></div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

				<!-- 채널 스텟 - 종합순위/총구독자수/차주대비/총조회수/최근평균조회수 시작 기본노출정보 -->

				<div class="row w-auto ml-auto">
					<div class="col w-auto d-inline-block txt-center">
						<span class="font-weight-bold">종합 순위</span>
					</div>
					<div class="col w-auto d-inline-block txt-center">
						<span class="font-weight-bold">총 구독자 수</span>
					</div>
					<div class="col w-auto d-inline-block txt-center">
						<span class="font-weight-bold">지난주 대비 구독자수</span>
					</div>
					<div class="col w-auto d-inline-block txt-center">
						<span class="font-weight-bold">총 조회수</span>
					</div>
					<div class="col w-auto d-inline-block txt-center">
						<span class="font-weight-bold">최근 영상 평균 조회수</span>
					</div>
				</div>
				<div class="pt-3"></div>

				<div class="row w-auto ml-auto">
					<div id="" class="col w-auto d-inline-block txt-center">
						<span>1위 </span><span>-</span>
					</div>
					<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputChannelFollowers }</div>
					<div id="" class="col w-auto d-inline-block txt-center">+
						${requestScope.outputChannelBeforeFollowers }</div>
					<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputChannelViews }</div>
					<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputChannelRecentViews }</div>
				</div>

				<!-- 채널 스텟 - 종합순위/총구독자수/차주대비/총조회수/최근평균조회수 끝 -->

				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

				<c:if test="${not empty sessionScope.racMemberNo}">
					<!-- 채널 스탯 - 광고만족도/광고평균조회수/단가/카테고리 시작 로그인시 노출 정보  -->

					<div class="chnDtlInfo">

						<div class="row chnDtlRow w-auto ml-auto">
							<div class="col w-auto d-inline-block txt-center">
								<span class="font-weight-bold">광고 만족도</span>
							</div>
							<div class="col w-auto d-inline-block txt-center">
								<span class="font-weight-bold">광고 영상 평균 조회수</span>
							</div>
							<div class="col w-auto d-inline-block txt-center">
								<span class="font-weight-bold">최저 광고 단가</span>
							</div>
							<div class="col w-auto d-inline-block txt-center">
								<span class="font-weight-bold">평균 광고 단가</span>
							</div>
							<div class="col w-auto d-inline-block txt-center">
								<span class="font-weight-bold">최고 광고 단가</span>
							</div>
						</div>

						<div class="pt-3"></div>

						<div class="row w-auto ml-auto">
							<div id="" class="col w-auto d-inline-block txt-center">
								<span>${requestScope.outputAdSatisfyRank }</span><span>-</span>
							</div>
							<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputAdViews }</div>
							<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputAdMinPrice }</div>
							<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputAdEvenPrice }</div>
							<div id="" class="col w-auto d-inline-block txt-center">${requestScope.outputAdMaxPrice }</div>
						</div>

					</div>

					<!-- 채널 스탯 - 광고만족도/광고평균조회수/단가/카테고리 끝 -->
				</c:if>
				<c:if test="${empty sessionScope.racMemberNo}">
					<!-- 비로그인 시 채널 스텟 가리기 -->
					<div class="chnDtlCover w-100">
						<div class="pTop3 pBottom">
							<div class="txt-center inline-block">이 채널의 광고 만족도, 광고 가격,
								후기가 궁금하신가요?</div>
							<div class="txt-center inline-block">기업회원으로 로그인하면 이 채널의
								비즈니스 정보를 확인할 수 있습니다.</div>
							<div class="pTop txt-center">
								<button class="commonBtn">
									<a href="/02_page/Auth/login.jsp">기업회원으로 로그인하기</a>
								</button>
							</div>
						</div>

					</div>
					<!-- 비로그인 시 채널 스텟 가리기 -->
				</c:if>


				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

				<div class="pt-1"></div>

				<!-- 채널 상세 탭 영역 -->
				<div class="detail-tab inline-flex">
					<div class="detail-tab float-left">
						<ul id="myTab" class="sub-tabs">
							<li><a data-tab="upload" href="#upload" class="active">최근
									업로드 영상</a></li>
							<li><a data-tab="comercial" href="#comercial">이 채널의 광고
									영상</a></li>
							<li><a data-tab="review" href="#review">이 채널의 광고 리뷰</a></li>
							<!-- 							<li><a data-tab="price" href="#price">이 채널의 광고 단가</a></li>
 -->
						</ul>
					</div>
				</div>

				<!-- rancre.common.js sub-nav -->

				<div id="myTabContent" class="row inline-block tab-content">
					<div class="sub-tabcontent active w-auto" id="upload">

						<div class="pTop"></div>

						<div class="subtab-title inline-block">최근 이 채널에 업로드 된 영상입니다.</div>

						<div class="pTop2"></div>

						<div class="upload-Videos inline-block">
							<c:forEach var="item"
								items="${requestScope.outputRecentVideoList}">
								<div class="upload-Video pBottom float-left">
									<div class="videoThumb">
										<img style="width: 210px" src="${item.outputVideoThumbnail}"
											onclick="window.open('https://www.youtube.com/watch?v=${item.outputVideoId}')">
									</div>
									<div class="detail">
										<div class="title inline-block">${item.outputVideoTitle }</div>
										<div class="count inline">
											<div class="float-left pRight">조회수</div>
											<div class="float-left">${item.outputVideoViews }</div>
											<div class="float-right">${item.outputVideoCreateDate }</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>


					<div class="sub-tabcontent w-100" id="comercial">

						<div class="pTop"></div>

						<div class="subtab-title inline-block">이 채널을 통해 진행된 광고
							영상입니다. 채널과 제품, 브랜드의 컨셉이 맞는지 확인해보세요!</div>

						<div class="pTop2"></div>

						<!--  Non-Login Member -->
						<c:if test="${empty sessionScope.racMemberNo}">
							<div class="pTop5 txt-center inline-block">이 채널에서 진행된 광고 영상이 궁금하신가요?</div>
							<div class="txt-center inline-block">기업회원으로 로그인하면 이 채널의 광고 영상을 확인할 수 있습니다.</div>
							<div class="pTop txt-center">
								<button class="commonBtn">
									<a href="/02_page/Auth/login.jsp">기업회원으로 로그인하기</a>
								</button>
							</div>
						</c:if>

						<c:if test="${not empty sessionScope.racMemberNo}">
							<!--  Non-Login Member finished-->

							<!-- Login Member -->
							<!-- comercialVideo start -->
							<c:if test="${not empty requestScope.outputAdVideoList}">
								<div class="comercialVideos inline-block">
									<c:forEach var="item" items="${requestScope.outputAdVideoList}">
										<div class="comercialVideo float-left">
											<div class="videoThumb">
												<img style="width: 210px" src="${item.outputVideoThumbnail}"
													onclick="window.open('https://www.youtube.com/watch?v=${item.outputVideoId}')">
											</div>
											<div class="detail">
												<div class="title inline-block">${item.outputVideoTitle }</div>
												<div class="count inline">
													<div class="float-left pRight">조회수</div>
													<div class="float-left">${item.outputVideoViews }</div>
													<div class="float-right">1개월 전</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</c:if>
							<!-- comercialVideo finished -->

							<!-- non-comercialVideo start -->
							<c:if test="${empty requestScope.outputAdVideoList}">

								<div class="non-comercials txt-center">

									<div class="v30"></div>

									<div class="txt-center">
										<span>아직 이 채널에서 진행한 광고 영상이 없습니다. 혹시 이 채널에서 광고를 집행하였나요?
										</span>
									</div>

									<div class="pTop2"></div>

									<button class="commonBtn">
										<a class="" href="#">광고 리뷰 쓰기</a>
									</button>

								</div>
							</c:if>
						</c:if>
						<!-- non-comercialVideo finished -->
						<!-- Login Member finished-->
					</div>

					<div class="sub-tabcontent w-100" id="review">

						<div class="pTop"></div>

						<div class="subtab-title inline-block">이 채널을 이용한 광고주들의
							후기입니다. 채널에 내 광고를 집행하기 전 체크해보세요!</div>

						<div class="pTop2"></div>

						<!--  Non-Login Member -->
						<c:if test="${empty sessionScope.racMemberNo}">
							<div class="pTop5 txt-center inline-block">이 채널을 이용한 다른 광고주의 리뷰가 궁금하신가요?</div>
							<div class="txt-center inline-block">기업회원으로 로그인하면 이 채널의 리뷰를 확인할 수 있습니다.</div>
							<div class="pTop txt-center">
								<button class="commonBtn">
									<a href="/02_page/Auth/login.jsp">기업회원으로 로그인하기</a>
								</button>
							</div>
						</c:if>

						<c:if test="${not empty sessionScope.racMemberNo}">
							<!--  Non-Login Member finished-->

							<!-- Login Member -->
							<!-- channel reivew start -->
							<c:if test="${not empty requestScope.outputReivewList}">
								<div class="reviews">
									<c:forEach var="item" items="${requestScope.outputReivewList}">
										<div class="review">
											<div class="review-top">
												<div class="date float-left">최근 1년 이내, 실제 집행된 광고에 대한
													리뷰입니다.</div>
											</div>

											<div class="pTop2 w-100 display-flex"></div>

											<div class="review-detail">
												<div class="review-row float-left">
													<div class="idx">광고 만족도</div>
													<div class="idx">광고 타입</div>
													<div class="idx">목표 도달률</div>
													<div class="idx">목표 전환률</div>
													<div class="idx">타깃 성별</div>
													<div class="idx">타깃 연령</div>
												</div>
												<div class="review-stat float-left">
													<div class="stat">${item.outputReviewSatisfy }</div>
													<div class="stat">${item.outputChannelAdType }</div>
													<div class="stat">${item.outputReviewTargetReach }</div>
													<div class="stat">${item.outputReviewTargetConversion }</div>
													<div class="stat">${item.outputReviewTargetGender }</div>
													<div class="stat">${item.outputReviewTargetAge }</div>
												</div>
												<div class="review-text w-auto float-left">
													<div class="txt">
														<span>${item.outputReviewDetail }</span>
													</div>

													<div class="pTop2 display-flex"></div>

													<div class="bottom-txt row w-100">
														<div class="col-6 recommend float-left">이 채널을 다른
															마케터에게도 추천하나요?</div>
														<div class="col answer float-left">${item.outputReviewAdAgain }</div>
													</div>
												</div>
											</div>

										</div>

										<div class="pTop2"></div>

									</c:forEach>
								</div>
							</c:if>
							<!-- channel review finished -->

							<!-- non review start -->
							<c:if test="${empty requestScope.outputReivewList}">
								<div class="non-reviews txt-center">

									<div class="v30"></div>

									<div class="txt-center">
										<span>아직 이 채널의 광고 리뷰가 없습니다. 이 채널의 광고 리뷰를 작성하시겠어요? </span>
									</div>

									<div class="pTop2"></div>

									<button class="commonBtn">
										<a class="" href="#">광고 리뷰 쓰기</a>
									</button>

								</div>
							</c:if>
						</c:if>
						<!-- non review finished -->
						<!-- Login Member finished-->
					</div>

					<!-- 
					<div class="sub-tabcontent w-100" id="price">

						<div class="pTop"></div>

						<div class="subtab-title inline-block">이 채널에서 집행된 광고 단가입니다.
							예산에 맞는 채널인지 미리 확인해보세요.</div>

						<div class="pTop2"></div>

						<div class=""></div>


					</div> -->
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

</body>
</html>