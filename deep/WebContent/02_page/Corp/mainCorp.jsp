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

				<div class="w100 display-block">

					<div class="corp-Row inline-block float-left">기업명</div>
					<div class="corp-Row inline-block float-left">아이디</div>
					<div class="corp-Row inline-block float-left">리뷰 등록 수</div>

					<div class="pTop3"></div>

					<div class="corp-Name inline-block float-left">(주)롯데정보통신</div>
					<div class="corp-Id inline-block float-left">admin-123</div>
					<div class="corp-ReviewCnt inline-block float-left">10개</div>

				</div>



				<div class="pTop4 mTop4 inline-block">
					<div class="corp-headerTitle">나의 리뷰 (15건)</div>
				</div>

				<div class="pTop3 row">
					<div class="col float-left">채널명</div>
					<div class="col float-left">종합 만족도</div>
					<div class="col float-left">등록일자</div>
					<div class="col float-left">상태</div>
				</div>
				<hr>

				<!-- if channel review exist -->
				<div class="corp-MyReview-Contents">

					<div class="corp-MyReview row">
						<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
						<div class="col float-left corp-ChnSatisfy">매우 만족</div>
						<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
						<div class="col float-left corp-ChnReivew-Accept">승인</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="corp-MyReview row">
						<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
						<div class="col float-left corp-ChnSatisfy">매우 만족</div>
						<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
						<div class="col float-left corp-ChnReivew-Wait">미승인</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="corp-MyReview row">
						<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
						<div class="col float-left corp-ChnSatisfy">매우 만족</div>
						<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
						<div class="col float-left corp-ChnReivew-Unaccept">거절</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="corp-MyReview row">
						<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
						<div class="col float-left corp-ChnSatisfy">매우 만족</div>
						<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
						<div class="col float-left corp-ChnReivew-Unaccept">거절</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="corp-MyReview row">
						<div class="col float-left corp-ChnName">와썹맨Wassup-Man</div>
						<div class="col float-left corp-ChnSatisfy">매우 만족</div>
						<div class="col float-left corp-ChnReview-Date">2018-12-24</div>
						<div class="col float-left corp-ChnReivew-Unaccept">거절</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">



					<div class="pagination-area pTop3">
						<ul class="common-pagination">
							<li class="common-page-pre display-none">이전</li>
							<li class="common-page-link active">1</li>
							<li class="common-page-link">2</li>
							<li class="common-page-link">3</li>
							<li class="common-page-link">4</li>
							<li class="common-page-link">5</li>
							<li class="common-page-next go-review-list"><a
								class="common-A" href="#">다음<img style="margin-bottom: 2px;"
									src="/01_image/commonImg/right-arrow.png"></a></li>
						</ul>
					</div>

				</div>


				<!-- end channel review exist -->

				<!-- if non-channel review -->

				<div class="none-MyReivew">
					<div>
						등록한 채널 리뷰가 없습니다. </br>
						지금 리뷰를 등록하고 다른 리뷰를 확인하겠습니다!
					</div>
				</div>

				<!-- end non-channel review -->

				<div class="pTop4 inline-block subNav-tabs">
					<div class="corp-headerTitle subNav-tab">
						<a class="subnav-link active" data-tab="myViewContent"
							href="#myViewContent" onclick="">최근 본 채널</a>
					</div>
					<div class="corp-headerTitle subNav-tab">
						<a class="subnav-link" data-tab="myLikeContent"
							href="#myLikeContent" onclick="">나의 관심 채널</a>
					</div>
				</div>

				<div class="pTop3 w100 inline-block">
					<div class="corp-View-Row">채널명</div>
					<div class="corp-View-Row">카테고리</div>
					<div class="corp-View-Row">총 구독자수</div>
					<div class="corp-View-Row-Right">총 조회수</div>
					<hr>
				</div>

				<div class="subNav-content active corp-MyView-Contents"
					id="myViewContent">

					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Btn" onclick="">관심채널 등록</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Btn" onclick="">관심채널 등록</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Btn" onclick="">관심채널 등록</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Btn" onclick="">관심채널 등록</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Btn" onclick="">관심채널 등록</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


				</div>

				<div class="subNav-content corp-MyLike-Contents" id="myLikeContent">

					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


					<div class="corp-MyView w100">
						<div class="corp-View-Row-ChnImg">
							<img id="corp-View-Row-ThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
						</div>
						<div class="corp-View-Row-ChnName">도티 TV</div>
						<div class="corp-View-Row-Category">#게임, 엔터</div>
						<div class="corp-View-Row-Subscribe">123,232,232</div>
						<div class="corp-View-Row-TotalView">232,123,232,232</div>
						<div class="corp-View-Row-Like">
							<button class="common-Small-Reverse-Btn" onclick="">관심채널
								취소</button>
						</div>
						<div class="corp-View-Row-DetailGo">
							<button class="common-Small-Btn">
								<a href="#">채널정보 보기</a>
							</button>
						</div>

					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">


				</div>

				<div class="pagination-area pTop3">
					<ul class="common-pagination">
						<li class="common-page-pre display-none">이전</li>
						<li class="common-page-link active">1</li>
						<li class="common-page-link">2</li>
						<li class="common-page-link">3</li>
						<li class="common-page-link">4</li>
						<li class="common-page-link">5</li>
						<li class="common-page-next go-review-list"><a
							class="common-A" href="#">다음<img style="margin-bottom: 2px;"
								src="/01_image/commonImg/right-arrow.png"></a></li>
					</ul>
				</div>


			</div>
		</div>
	</div>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

</body>
</html>