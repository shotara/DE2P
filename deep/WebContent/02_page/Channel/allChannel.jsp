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
				<div class="pt-4"></div>
				<div class="w-auto ml-auto">
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link active" href="#">스튜디오</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">엔터</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">여행</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">노래 댄스</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">테크</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">교육(어학)</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">뷰티</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">일상</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">게임</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">스포츠</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">먹방</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">키즈</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">반려동물</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">운동</a></div>
						<div class="subNavRow col w-auto ml-auto d-inline-block"><a class="subnav-link" href="#">취미</a></div>
				</div>
				<div class="pt-4"></div>
				<div class="rankRowImg"></div>
				<div class="rankRow">채널명</div>
				<div class="rankRow">카테고리</div>
				<div class="rankRow">총구독자수</div>
				<div class="rankRow">총조회수</div>
				<div class="rankRow2">영상수</div>
				<div class="rankRowBtn"></div>
				<hr>
				<div class="pt-2"></div>

				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-2"></div>
				<div id="newChnContents" class="w-auto ml-auto">
					<div class="rankRowImg">
						<img style="width: 48px; border-radius: 48px;"
							src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
					</div>
					<div class="rankRow">WassupMan</div>
					<div class="rankRow">#스튜디오</div>
					<div class="rankRow">1,232,232</div>
					<div class="rankRow">232,232,213</div>
					<div class="rankRow2">20</div>
					<div class="rankRowBtn">
						<button class="btnChnGo"><a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보 보기</a></button>
					</div>
				</div>
				<hr
					style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				<div class="pt-4"></div>
				<div class="rankBottom text-center">
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