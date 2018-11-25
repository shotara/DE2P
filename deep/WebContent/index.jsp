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
			
			<!-- 채널 100 페이지 상단 설명영역 -->
				<div class="w-auto ml-auto">
					<h3>채널 100</h3>
				</div>
				<div>
					<span>채널 종합 순위입니다.</span>
				</div>
				
			<!--컬럼 구분 영 -->
				
				<div class="w-auto pt-4"></div>
				
				<div class="rankMainRowCnt">순위</div>
				<div class="rankMainRowImg"></div>
				<div class="rankMainRow">채널명</div>
				<div class="rankMainRow">카테고리</div>
				<div class="rankMainRow">총구독자수</div>
				<div class="rankMainRow">총조회수</div>
				<div class="rankMainRow2">영상수</div>
				<div class="rankMainRowBtn"></div>

				<hr>
				
				<div class="pt-2"></div>
				
			<!-- 채널별 스탯 영역1 -->
				
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">1위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img id="chnListThumbNail" style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
	
			<!-- 채널별 스탯 영역1 -->	
					
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">2위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">3위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">4위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">5위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">6위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">7위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">8위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">9위</div><div class="d-inline-block rankMainDif">-</div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankMainRowCnt">
						<div class="d-inline-block rankMainCnt">100위</div><div class="d-inline-block"><span class="glyphicon glyphicon-triangle-bottom">1</span></div>
					</div>
					<div class="rankMainRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankMainRow">WassupMan</div>
					<div class="rankMainRow">#스튜디오</div>
					<div class="rankMainRow">1,232,232</div>
					<div class="rankMainRow">232,232,213</div>
					<div class="rankMainRow2">20</div>
					<div class="rankMainRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-4"></div>
				<div class="rankBottom txt-center">
					<button class="btnListGo">더보기</button>
				</div>

			</div>
		</div>

	</div>

	</section>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

	<section class="indexRecommend"> </section>
	<c:forEach var="i" items="${requestScope.outputFeedList}">
		<div class="row<c:if test="${i.outputPostType == 1}"> notice</c:if>"
			onclick="Feed.goView('${i.outputFeedNo}')"></div>
	</c:forEach>
</body>
</html>